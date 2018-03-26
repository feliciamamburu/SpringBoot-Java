/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netflorist.RestController;

import com.netflorist.Model.Users;
import com.netflorist.Service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 
 */
@RestController
public class UserController {
    
    @Autowired
    public  UserService useService;
    
    public List<Users> useAvailable = new ArrayList<>();
    
    @RequestMapping(value="/register",method=RequestMethod.POST)
    public void registerUser(@RequestBody Users use,String registerStatus ){
        useService.addUser(use);
        registerStatus = "Congradulations" + " " + use.getFirstname() + " " + "You have successfully registered";
    }
    
    @RequestMapping(value="/login/user", produces ={MediaType.APPLICATION_JSON_VALUE})
    public Users login(@RequestParam String username,String password ){
        return useService.login(username, password);
    }
    
    @RequestMapping(value="/users/all",method=RequestMethod.GET)
    public List allUsers(){
        return useService.getUsers();
    }
}
