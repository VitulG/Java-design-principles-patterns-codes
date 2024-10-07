package com.example.personal.bookmyshow.services;

import com.example.personal.bookmyshow.exceptions.UserAlreadyExistException;
import com.example.personal.bookmyshow.exceptions.UserNotFoundException;
import com.example.personal.bookmyshow.models.User;
import com.example.personal.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User signUp(String name, String email, String password) throws UserAlreadyExistException {
        Optional<User> optionalUser = userRepository.findByEmail(email);

        if(optionalUser.isPresent()) {
            throw new UserAlreadyExistException("user already exists");
        }

        User user = new User();
        user.setUsername(name);
        user.setEmail(email);
        user.setCreatedAt(LocalDateTime.now());
        user.setPassword(bCryptPasswordEncoder.encode(password));

        return userRepository.save(user);
    }

    @Override
    public User login(String username, String email, String password) throws UserNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("user does not exist"));

        if(!bCryptPasswordEncoder.matches(password, user.getPassword())) {
            throw new UserNotFoundException("invalid password");
        }
        return user;
    }
}
