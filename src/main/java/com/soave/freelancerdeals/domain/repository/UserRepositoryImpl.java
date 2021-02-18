package com.soave.freelancerdeals.domain.repository;

import com.soave.freelancerdeals.domain.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository{

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User getUserById(int userId) {
        StringBuilder sql = new StringBuilder();
        sql.append("    select us.user_id,                                                                        ");
        sql.append("           us.user_name,                                                                      ");
        sql.append("           us.user_email,                                                                     ");
        sql.append("           us.user_username,                                                                  ");
        sql.append("           us.user_birthday_date,                                                             ");
        sql.append("           us.user_active,                                                                    ");
        sql.append("           lc.location_latitude,                                                              ");
        sql.append("           lc.location_longitude,                                                             ");
        sql.append("           lc.location_address,                                                               ");
        sql.append("           lc.location_city,                                                                  ");
        sql.append("           lc.location_state,                                                                 ");
        sql.append("           lc.location_zipcode                                                                ");
        sql.append("      from freelance_deal.free_user us                                                        ");
        sql.append("      join freelance_deal.free_location lc on lc.location_id_location = us.user_location_id   ");
        sql.append("     where us.user_id = :userId;                                                              ");
        return null;
    }
}
