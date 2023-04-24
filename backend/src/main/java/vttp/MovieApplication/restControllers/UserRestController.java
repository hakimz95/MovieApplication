package vttp.MovieApplication.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

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

        
    }


}
