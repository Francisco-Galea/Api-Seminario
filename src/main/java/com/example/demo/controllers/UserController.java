package com.example.demo.controllers;
import com.example.demo.dto.request.UserRequestDTO;
import com.example.demo.models.UserModel;
import com.example.demo.models.UserModel;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping
    public UserModel saveUser(@RequestBody UserRequestDTO user) {
        UserModel userModel = new UserModel();
        userModel.setFirstName(user.getFirstName());
        userModel.setLastName(user.getLastName());
        userModel.setEmail(user.getEmail());
        return this.userService.saveUser(userModel);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id")Long id){
        return  this.userService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public  UserModel updateUserById(@RequestBody UserRequestDTO request, @PathVariable("id") Long id){
        UserModel userModel = new UserModel();
        userModel.setFirstName(request.getFirstName());
        userModel.setLastName(request.getLastName());
        userModel.setEmail(request.getEmail());
        return this.userService.updateById(userModel, id);
    }

    @DeleteMapping(path = "/{id}")
    public  String deleteById(@PathVariable("id") Long id){
        boolean ok = this.userService.deleteUser(id);

        if (ok){
            return "User with id " + id + "deleted";
        } else {
            return "User with id " + id + "could not be deleted";
        }
    }
}