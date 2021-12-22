package com.OzUFlix.CS320.Service;

import com.OzUFlix.CS320.Model.User;
import com.OzUFlix.CS320.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User save(User user){ return userRepository.save(user); }

    public List<User> findAll(){ return userRepository.findAll();}

    public User findById(int id){ return userRepository.findById(id); }

    public void deleteById(int id){
        userRepository.deleteById(id);
    }
}
