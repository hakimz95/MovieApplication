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

    public void registerUser(User user) {
        jdbcTemplate.update(SQL_INSERT_USER, user.getId(), user.getUsername(), user.getEmail(), user.getPassword(), user.getDateCreated());
    }

    public void deleteUser(String username) {
        jdbcTemplate.update(SQL_DELETE_USER, username);
    }

    public User getUserDetails(String username) {
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_GET_USER_USERNAME, username);
        User user = new User();
        while (rs.next()) {
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setDateCreated(rs.getDate("date_created"));
        }
        return user;
    }
}
