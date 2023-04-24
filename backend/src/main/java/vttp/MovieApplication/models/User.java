package vttp.MovieApplication.models;

import java.util.Date;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class User {
    
    private String id;
    private String username;
    private String email;
    private String password;
    private Date dateCreated;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", email=" + email + ", password="+ password +", dateCreated=" + dateCreated + "]";
    }

    public static User createUser(SqlRowSet rs) {

        User user = new User();
        user.setId(rs.getString("id"));
        user.setUsername(rs.getString("username"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setDateCreated(rs.getDate("date_created"));

        return user;
    }
    
    
}
