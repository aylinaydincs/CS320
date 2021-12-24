package com.OzUFlix.CS320.Controller;

import com.OzUFlix.CS320.DTO.DirectorDTO;
import com.OzUFlix.CS320.DTO.RentDTO;
import com.OzUFlix.CS320.DTO.UserDTO;
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
    public List<UserDTO> findAll(){ return userService.findAll(); }

    @GetMapping("/{user-id}")
    public UserDTO getUserById(@PathVariable("user-id") int id) {return userService.findById(id); }

    @GetMapping("/{user-id}/rent")
    public List<RentDTO> getUserRent(@PathVariable("user-id") int id) {return userService.getUserRent(id); }

    @DeleteMapping("/{user-id}")
    public void deleteById(@PathVariable("user-id") int id){ userService.deleteById(id); }

    @PostMapping
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/signin")
    public boolean getUserById(@RequestBody String body) {
        String[] result = body.split("\\s+");
        return userService.validateUser(result[0], result[1]);
    }

    /*
    @PostMapping("/{user-id}/rent/{rent-id}")
    public UserDTO saveUserRent(@PathVariable("user-id") int userId, @PathVariable("rent-id") int rentId) {
        return userService.saveRent(userId, rentId);
    }

    @PostMapping("/{user-id}/returnmovie/{rent-id}/{returnmovie-id}")
    public UserDTO saveUserReturnMovie(@PathVariable("user-id") int userId, @PathVariable("rent-id") int rentId, @PathVariable("rent-id") int returnMovieId) {
        return userService.saveReturnMovie(userId, rentId, returnMovieId);
    }
    */

}