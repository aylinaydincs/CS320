package com.OzUFlix.CS320.Service;

import com.OzUFlix.CS320.DTO.TopicDTO;
import com.OzUFlix.CS320.DTO.UserDTO;
import com.OzUFlix.CS320.Model.Topic;
import com.OzUFlix.CS320.Model.User;
import com.OzUFlix.CS320.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User save(User user){ return userRepository.save(user); }

    public List<UserDTO> findAll(){
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user: users) {
            userDTOS.add(new UserDTO(user.getId(),user.getName(),user.getPassword(),user.getUserType(),user.getRents(),user.getReturn_movies(),user.getPenalties()));
        }
        return userDTOS;
    }

    public UserDTO findById(int id){
        User user = userRepository.findById(id);
        UserDTO userDTO = new UserDTO(user.getId(),user.getName(),user.getPassword(),user.getUserType(),user.getRents(),user.getReturn_movies(),user.getPenalties());
        return  userDTO;
    }

    public void deleteById(int id){
        userRepository.deleteById(id);
    }

    public boolean validateUser(String username, String password){
        User user = userRepository.findUserByNameAndPassword(username, password);
        boolean count=false;
        if (user!=null){
            count=true;
        }
        return  count;
    }
}
