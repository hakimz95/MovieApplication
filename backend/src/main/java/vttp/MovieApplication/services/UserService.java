package vttp.MovieApplication.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vttp.MovieApplication.models.User;
import vttp.MovieApplication.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public boolean createUser (User user) {
        UUID userUUID = UUID.randomUUID();
        user.setId(userUUID.toString());
        boolean userCreated = userRepository.registerUser(user);
        return userCreated;
    }

    public boolean checkUser(User user) {
        return userRepository.checkUserCredentials(user);
    }

    public User getUserByCredentials (User user) {
        return userRepository.getUserDetails(user);
    }
    
}
