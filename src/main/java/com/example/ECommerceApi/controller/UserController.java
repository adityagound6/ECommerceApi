package com.example.ECommerceApi.controller;

import com.example.ECommerceApi.entity.User;
import com.example.ECommerceApi.helper.ResponseMessage;
import com.example.ECommerceApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    private UserService userService;
    //private BCryptPasswordEncoder

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/createUser")
    public ResponseMessage<User> createUser(@RequestBody User user){
        ResponseMessage<User> result = new ResponseMessage<User>();
        try{
            if(userService.createUser(user)){
                result.setMessage("User Created Success " + user.getUsername());
                result.setSuccess(true);
                //result.setUser(user);
            }
            else{
                result.setSuccess(false);
                result.setMessage("User is already exit " + user.getUsername());
            }
        }
        catch (Exception ex){
            result.setSuccess(false);
            result.setMessage("Server error " + ex.getMessage());
        }
        return result;
    }
    @GetMapping("/getAllUsers")
    public ResponseMessage<List<User>> getAllUsers(){
        ResponseMessage<List<User>> result = new ResponseMessage<>();
        try{
            result.setMessage("Success");
            result.setSuccess(true);
            result.setUser(userService.getAllUsers());
        }
        catch (Exception ex){
            result.setSuccess(false);
            result.setMessage("Server error "+ex.getMessage());
        }
        return result;
    }
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseMessage<User> deleteUser(@PathVariable("userId") Long userId){
        ResponseMessage<User> result = new ResponseMessage<>();
        try {
            if(userService.deleteUser(userId)){
                result.setSuccess(true);
                result.setMessage("User is deleted ");
            }
            else{
                result.setSuccess(false);
                result.setMessage("User is not exit ");
            }
        }
        catch (Exception ex){
            result.setSuccess(false);
            result.setMessage("Server error "+ ex.getMessage());
        }

        return result;
    }
    @PostMapping("updateUser/{username}")
    public ResponseMessage<User> updateUser(@PathVariable("username") String username,@RequestBody User user){
        ResponseMessage<User> result = new ResponseMessage<>();
        try {
            User model = userService.getUserByUsername(username);
            if (model != null) {
                user.setUsername(username);
                userService.UpdateUser(user);
                result.setSuccess(true);
                result.setMessage("Success update "+ username);
                result.setUser(user);
            }
            else {
                result.setSuccess(false);
                result.setMessage("Not updated user "+ username+" not exit");
                result.setUser(user);
            }
        }
        catch (Exception ex){
            result.setSuccess(false);
            result.setMessage("Not updated user server error "+ex.getMessage());
            result.setUser(user);
        }
        return result;
    }
    @GetMapping("/getUserByUsername/{username}")
    public ResponseMessage<User> getUserByUsername(@PathVariable("username") String username){
        ResponseMessage<User> result = new ResponseMessage<>();
        try {
            result.setSuccess(true);
            result.setMessage("Success");
            result.setUser(userService.getUserByUsername(username));
        }
        catch (IllegalStateException ex){
            result.setSuccess(false);
            result.setMessage("Server error "+ex.getMessage());
        }
        return result;
    }
    @GetMapping("/getStudentById/{userId}")
    public ResponseMessage<User> getUserById(@PathVariable("userId") Long userId){
        ResponseMessage<User> result = new ResponseMessage<>();
        User user = userService.getUserById(userId);
        result.setUser(user);
        return result;
    }
}
