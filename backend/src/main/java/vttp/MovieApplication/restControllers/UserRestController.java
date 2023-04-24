package vttp.MovieApplication.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import vttp.MovieApplication.models.User;
import vttp.MovieApplication.services.UserService;

@RestController
@RequestMapping(path = "/api/user")
public class UserRestController {
    
    @Autowired
    private UserService userService;

    @PostMapping(path = "/register")
    public ResponseEntity<String> registerUser(
        @RequestPart String username,
        @RequestPart String email,
        @RequestPart String password
    ) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);

        boolean success;

        try {
            success = userService.createUser(user);
        } catch (DuplicateKeyException e) {
            JsonObject jobj = Json.createObjectBuilder()
                .add("message", "Username not available")
                .add("error", e.getMessage())
                .build();
            
            return ResponseEntity.badRequest().body(jobj.toString());
        } catch (Exception e) {
            e.printStackTrace();
            JsonObject jobj = Json.createObjectBuilder()
                .add("message", "Error creating user")
                .add("error", e.getMessage())
                .build();
            
            return ResponseEntity.badRequest().body(jobj.toString());
        }

        return ResponseEntity.ok().body(
            Json.createObjectBuilder()
                .add("message", "User registered")
                .build().toString()
        );
    }

    @PostMapping(path = "/login")
    public ResponseEntity<String> checkLogin(
        @RequestPart String username,
        @RequestPart String password
    ) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        try {
            if (userService.checkUser(user)) {
                user = userService.getUserByCredentials(user);
                return ResponseEntity.ok().body(user.toJson().toString());
            } else {
                JsonObject jobj = Json.createObjectBuilder()
                    .add("message", "Incorrect credentials")
                    .build();
                return ResponseEntity.badRequest().body(jobj.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            JsonObject jobj = Json.createObjectBuilder()
                .add("message", "Unsuccessful Login Attempt")
                .add("error", e.getMessage())
                .build();

            return ResponseEntity.badRequest().body(jobj.toString());
        }
    }


}
