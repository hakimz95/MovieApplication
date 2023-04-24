package vttp.MovieApplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.MovieApplication.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    
    
}
