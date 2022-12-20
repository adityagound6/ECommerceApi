package com.example.ECommerceApi.service.impl;

import com.example.ECommerceApi.entity.User;
import com.example.ECommerceApi.repository.UserRepository;
import com.example.ECommerceApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean createUser(User user){
        User local = userRepository.findByUsername(user.getUsername());
        if(local == null){
            userRepository.save(user);
            return true;
        }
        else{
            return false;
        }
        //return null;
    }
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @Override
    public boolean deleteUser(Long userId) {
        boolean user = userRepository.existsById(userId);
        if(user){
            userRepository.deleteById(userId);
            return true;
        }
        else {
            return false;
        }
        //return false;
    }
    @Override
    public User getUserById(Long id) {
        User user = userRepository.findByUserId(id);
        return user;
    }
    @Override
    //@Transactional
    public User UpdateUser(User user) {
        User model = userRepository.findByUsername(user.getUsername());
        if(user.getFirstName() != null && user.getFirstName().length()>0 && !Objects.equals(user.getFirstName()
                ,model.getFirstName())){
            model.setFirstName(user.getFirstName());
        }
        if(user.getLastName() != null && user.getLastName().length()>0 && !Objects.equals(user.getLastName()
                ,model.getLastName())){
            model.setLastName(user.getLastName());
        }
        if(user.getEmail() != null && user.getEmail().length()>0 && !Objects.equals(user.getEmail()
                ,model.getEmail())){
            model.setEmail(user.getEmail());
        }

        return model;
    }
    @Override
    public User getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }
}
