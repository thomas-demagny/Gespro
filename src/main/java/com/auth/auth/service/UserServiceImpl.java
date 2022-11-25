package com.auth.auth.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.auth.auth.entity.User;
import com.auth.auth.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
        }

    @Override
    public User findById(int id) {
        return userRepository.findByIdOrThrow(id);
    }

    @Override
    public User findByUsername(String username) {

        return userRepository.findByUsername(username);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    public User getById(int id) {
        return userRepository.findByIdOrThrow(id);
    }

    public void delete(int id) {
        User user = userRepository.findByIdOrThrow(id);
        
            userRepository.delete(user);
        }

         

    }

