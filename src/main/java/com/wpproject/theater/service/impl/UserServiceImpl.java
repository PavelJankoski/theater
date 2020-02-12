package com.wpproject.theater.service.impl;

import com.wpproject.theater.models.User;
import com.wpproject.theater.models.exceptions.InvalidUserIdException;
import com.wpproject.theater.repositories.UserRepository;
import com.wpproject.theater.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        User u = this.userRepository.findById(user.getId()).orElseThrow(InvalidUserIdException::new);
        u.setId(user.getId());
        u.setEmail(user.getEmail());
        u.setName(user.getName());
        u.setSeats(user.getSeats());
        return this.userRepository.save(u);
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return this.userRepository.findById(id).orElseThrow(InvalidUserIdException::new);
    }

    @Override
    public void deleteUser(long id) {
        User user = this.userRepository.findById(id).orElseThrow(InvalidUserIdException::new);
        this.userRepository.delete(user);
    }
}
