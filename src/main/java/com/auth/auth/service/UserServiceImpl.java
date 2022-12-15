package com.auth.auth.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.auth.auth.entity.User;
import com.auth.auth.repository.UserRepository;

/**
 * The type User service.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    /**
     * Instantiates a new User service.
     *
     * @param userRepository the user repository
     */
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
        User userDB = userRepository.findByIdOrThrow(user.getId());

        if (userDB.getId() == 0) {
            userDB.setCreatedAt(LocalDateTime.now());
        } else {
            userDB.setUpdatedAt(LocalDateTime.now());
        }
        user = userDB;
        return userRepository.save(user);
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    public User getById(int id) {
        return userRepository.findByIdOrThrow(id);
    }

    public void delete(int id) {
        User user = userRepository.findByIdOrThrow(id);

        userRepository.delete(user);
    }

}
