package com.soave.freelancerdeals.repository.rowmapper;

import com.soave.freelancerdeals.domain.model.Location;
import com.soave.freelancerdeals.domain.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCompleteRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        Location location = new Location(
                rs.getDouble("location_latitude"),
                rs.getDouble("location_longitude"),
                rs.getString("location_address"),
                rs.getString("location_city"),
                rs.getString("location_state"),
                rs.getInt("location_zipcode"));

        User user = new User(
                rs.getInt("user_id"),
                rs.getString("user_name"),
                rs.getString("user_email"),
                rs.getString("user_username"),
                null,
                rs.getDate("user_birthday_date").toLocalDate(),
                rs.getBoolean("user_active"),
                location);
        return user;
    }
}
