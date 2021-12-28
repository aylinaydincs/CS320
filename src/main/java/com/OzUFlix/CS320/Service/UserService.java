package com.OzUFlix.CS320.Service;

import com.OzUFlix.CS320.DTO.MovieDTO;
import com.OzUFlix.CS320.DTO.RentDTO;
import com.OzUFlix.CS320.DTO.TopicDTO;
import com.OzUFlix.CS320.DTO.UserDTO;
import com.OzUFlix.CS320.Model.*;
import com.OzUFlix.CS320.Repository.PenaltyRepository;
import com.OzUFlix.CS320.Repository.RentRepository;
import com.OzUFlix.CS320.Repository.Return_MovieRepository;
import com.OzUFlix.CS320.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RentRepository rentRepository;

    @Autowired
    Return_MovieRepository return_movieRepository;

    @Autowired
    PenaltyRepository penaltyRepository;

    public User save(User user){
        if(user.getUserType()!=1){
            user.setUserType(0);
        }
        return userRepository.save(user); }

    public List<UserDTO> findAll(){
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user: users) {
            userDTOS.add(new UserDTO(user.getId(),user.getName(),user.getPassword(),user.getUserType(),user.getRents(),user.getPenalties()));
        }
        return userDTOS;
    }

    public UserDTO findById(int id){
        User user = userRepository.findById(id);
        UserDTO userDTO = new UserDTO(user.getId(),user.getName(),user.getPassword(),user.getUserType(),user.getRents(),user.getPenalties());
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

    public List<RentDTO> getUserRent(int userId){
        User user = userRepository.findById(userId);
        List<Rent> rents = new ArrayList<>();
        if(userRepository.getUserByUsertype(userId)!=null){
            rents = rentRepository.findAll();
        }else{
            rents = userRepository.getRent(userId);
        }
        List<RentDTO> DTOs= new ArrayList<>();
        for (Rent rent : rents){
            RentDTO rentDTO = new RentDTO(rent.getId(),rent.getUser(),rent.getMovie(),rent.getDate(), rent.getPenalty(),rent.getReturn_movie());
            DTOs.add(rentDTO);
        }

        return  DTOs;
    }

/*
    public UserDTO saveRent(int userId, int rentId){
        Rent rent = rentRepository.findById(rentId);
        User user = userRepository.findById(userId);
        List<Rent> list = new ArrayList<>();
        list.addAll(user.getRents());
        list.add(rent);
        user.setRents(list);
        UserDTO userDTO = new UserDTO(user.getId(),user.getName(),user.getPassword(),user.getUserType(),user.getRents(),user.getReturn_movies(),user.getPenalties());

        rent.setUser(user);
        rentRepository.save(rent);

        return  userDTO;
    }

    public UserDTO saveReturnMovie(int userId, int rentId, int returnMovieId){
        Return_Movie return_movie = return_movieRepository.findById(returnMovieId);
        User user = userRepository.findById(userId);
        List<Return_Movie> list = new ArrayList<>();
        list.addAll(user.getReturn_movies());
        list.add(return_movie);
        user.setReturn_movies(list);

        Rent rent = rentRepository.findById(rentId);
        rent.setReturn_movie(return_movie);

        long difference_In_Time = rent.getDate().getTime() - return_movie.getDate().getTime();
        long difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;

        if(difference_In_Days>20){
            Penalty penalty = new Penalty();
            penalty.setUser(user);
            penalty.setRent(rent);
            penalty.setReturn_movie(return_movie);
            penaltyRepository.save(penalty);

            List<Penalty> listPenalty = new ArrayList<>();
            listPenalty.addAll(user.getPenalties());
            listPenalty.add(penalty);
            user.setPenalties(listPenalty);
            rent.setPenalty(penalty);
        }

        return_movie.setUser(user);
        return_movieRepository.save(return_movie);
        rentRepository.save(rent);

        userRepository.save(user);
        UserDTO userDTO = new UserDTO(user.getId(),user.getName(),user.getPassword(),user.getUserType(),user.getRents(),user.getReturn_movies(),user.getPenalties());

        return  userDTO;
    }



*/
}
