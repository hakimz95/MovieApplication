package vttp.MovieApplication.repositories;

public class Queries {

    //User
    public static final String SQL_INSERT_USER = "INSERT INTO user(id,username,email,password,date_created) VALUES(?, ?, ?, ?, ?)";
    public static final String SQL_GET_USER_USERNAME = "SELECT * FROM user WHERE user = ?";
    public static final String SQL_DELETE_USER = "DELETE FROM user WHERE user = ?";
    
}
