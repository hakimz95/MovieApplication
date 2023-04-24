package vttp.MovieApplication.repositories;

public class Queries {

    //User
    public static final String SQL_INSERT_USER = "INSERT INTO user(id,username,email,password) VALUES(?, ?, ?, sha(?))";
    public static final String SQL_GET_USER_USERNAME = "SELECT * FROM user WHERE username = ? and password = sha(?)";
    
}
