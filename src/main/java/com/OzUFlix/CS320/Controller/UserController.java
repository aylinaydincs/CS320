package com.OzUFlix.CS320.Controller;

import com.OzUFlix.CS320.Model.User;
import com.OzUFlix.CS320.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> findAll(){ return userService.findAll(); }

    @GetMapping("/{user-id}")
    public User getUserById(@PathVariable("user-id") int id) {return userService.findById(id); }

    @DeleteMapping("/{user-id}")
    public void deleteById(@PathVariable("user-id") int id){ userService.deleteById(id); }

    @PostMapping
    public User saveUser(@RequestBody User user){
        return userService.save(user);
    }
}