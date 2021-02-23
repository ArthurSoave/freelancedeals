package com.soave.freelancerdeals.repository;

import com.soave.freelancerdeals.domain.model.User;
import com.soave.freelancerdeals.repository.rowmapper.UserCompleteRowMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository{

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserRepositoryImpl(@Qualifier("postgresNamedJdbcTemplate") NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void addUser(User user) {
        //first we add the address to have the FK
        String sqlAddr = "INSERT INTO freelance_deal.free_location (                        \n" +
                        "  location_id_location,                                            \n" +
                        "  location_latitude,                                               \n" +
                        "  location_longitude,                                              \n" +
                        "  location_address,                                                \n" +
                        "  location_city,                                                   \n" +
                        "  location_state,                                                  \n" +
                        "  location_zipcode)                                                \n" +
                        "VALUES (                                                           \n" +
                        "  nextval('freelance_deal.free_location_location_id_location_seq'),\n" +
                        "  :latitude,                                                       \n" +
                        "  :longitude,                                                      \n" +
                        "  :address,                                                        \n" +
                        "  :city,                                                           \n" +
                        "  :state,                                                          \n" +
                        "  :zipcode) returning location_id_location;                          ";
        int addressId = this.namedParameterJdbcTemplate.queryForObject(sqlAddr, new MapSqlParameterSource()
                .addValue("latitude", user.getLocation().getLat())
                .addValue("longitude", user.getLocation().getLng())
                .addValue("address", user.getLocation().getAddress())
                .addValue("city", user.getLocation().getCity())
                .addValue("state", user.getLocation().getState())
                .addValue("zipcode", user.getLocation().getZipCode()) , Integer.class);

        String sqlUser = "INSERT INTO freelance_deal.free_user (                \n" +
                        "  user_id,                                             \n" +
                        "  user_name,                                           \n" +
                        "  user_email,                                          \n" +
                        "  user_username,                                       \n" +
                        "  user_password,                                       \n" +
                        "  user_location_id,                                    \n" +
                        "  user_birthday_date,                                  \n" +
                        "  user_active)                                         \n" +
                        "VALUES (                                               \n" +
                        "  nextval('freelance_deal.free_user_user_id_seq'),     \n" +
                        "  :name,                                               \n" +
                        "  :email,                                              \n" +
                        "  :username,                                           \n" +
                        "  :password,                                           \n" +
                        "  :locationId,                                         \n" +
                        "  :birthdayDate,                                       \n" +
                        "  :active);                                              ";
        this.namedParameterJdbcTemplate.update(sqlUser, new MapSqlParameterSource()
                .addValue("name", user.getName())
                .addValue("email", user.getEmail())
                .addValue("username", user.getLogin())
                .addValue("password", user.getPassword())
                .addValue("locationId", addressId)
                .addValue("birthdayDate", user.getUserBirthdayDate())
                .addValue("active", user.isUserIsActive()));
    }

    @Override
    public Optional<User> getUserById(int userId) {
        String sql = queryGetUserComplete() +
                "     where us.user_id = :userId; ";
        return this.namedParameterJdbcTemplate.query(sql, new MapSqlParameterSource()
                .addValue("userId", userId), new UserCompleteRowMapper()).stream().findFirst();
    }

    @Override
    public List<User> getAllUsers() {
        String sql = queryGetUserComplete();
        return this.namedParameterJdbcTemplate.query(sql, new UserCompleteRowMapper());
    }

    @Override
    public void changeUserStatus(int idUser, boolean isActive) {
        String sql = "update freelance_deal.free_user set user_active = :isActive where user_id = :idUser;";
        this.namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource()
                .addValue("isActive", isActive)
                .addValue("idUser", idUser));
    }

    @Override
    public List<User> getUsersByLogin(String userLogin) {
        String sql = queryGetUserComplete() +
                " where us.user_username like %:userLogin%";
        return this.namedParameterJdbcTemplate.query(sql, new MapSqlParameterSource()
                .addValue("userLogin", userLogin),
                new UserCompleteRowMapper());
    }

    @Override
    public void deleteUser(int userId) {
        //first we get the location id
        String sqlLocationId = "select user_location_id from freelance_deal.free_user where user_id = :userId";
        int locationId = this.namedParameterJdbcTemplate.queryForObject(sqlLocationId, new MapSqlParameterSource("userId", userId), Integer.class);

        // second, we delete user register
        String sqlUser = "delete from freelance_deal.free_user where user_id = :userId";
        this.namedParameterJdbcTemplate.update(sqlUser, new MapSqlParameterSource().addValue("userId", userId));

        //then delete user location
        String sql = "delete from freelance_deal.free_location where location_id_location = :locationId;";
        this.namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource().addValue("locationId", locationId));
    }

    //Select Query with all user information
    private String queryGetUserComplete(){
        return "    select us.user_id,                                                                   " +
                "           us.user_name,                                                                      " +
                "           us.user_email,                                                                     " +
                "           us.user_username,                                                                  " +
                "           us.user_birthday_date,                                                             " +
                "           us.user_active,                                                                    " +
                "           lc.location_latitude,                                                              " +
                "           lc.location_longitude,                                                             " +
                "           lc.location_address,                                                               " +
                "           lc.location_city,                                                                  " +
                "           lc.location_state,                                                                 " +
                "           lc.location_zipcode                                                                " +
                "      from freelance_deal.free_user us                                                        " +
                "      join freelance_deal.free_location lc on lc.location_id_location = us.user_location_id   " ;
    }
}
