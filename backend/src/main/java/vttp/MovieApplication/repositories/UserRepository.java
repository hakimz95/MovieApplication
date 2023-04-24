package vttp.MovieApplication.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp.MovieApplication.models.User;

import static vttp.MovieApplication.repositories.Queries.*;

@Repository
public class UserRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean registerUser(User user) {
        return jdbcTemplate.update(SQL_INSERT_USER, user.getId(), user.getUsername(), user.getEmail(), user.getPassword()) > 0;
    }

    public boolean checkUserCredentials(User user) {
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_GET_USER_USERNAME, user.getUsername(), user.getPassword());
        return rs.next();
    }

    public User getUserDetails(User user) {
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_GET_USER_USERNAME, user.getUsername(), user.getPassword());
        while (rs.next()) {
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
        }
        return user;
    }
}
