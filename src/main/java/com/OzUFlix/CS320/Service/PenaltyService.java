package com.OzUFlix.CS320.Service;

import com.OzUFlix.CS320.DTO.DirectorDTO;
import com.OzUFlix.CS320.DTO.MovieDTO;
import com.OzUFlix.CS320.DTO.PenaltyDTO;
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
public class PenaltyService {
    @Autowired
    PenaltyRepository penaltyRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RentRepository rentRepository;

    @Autowired
    Return_MovieRepository return_movieRepository;

    public Penalty save(Penalty penalty){ return penaltyRepository.save(penalty); }

    public List<PenaltyDTO> findAll(){
        List<Penalty> penalties = penaltyRepository.findAll();
        List<PenaltyDTO> penaltyDTOS = new ArrayList<PenaltyDTO>();
        for (Penalty penalty: penalties) {
            penaltyDTOS.add(new PenaltyDTO(penalty.getId(),penalty.getUser(),penalty.getRent(),penalty.getReturn_movie()));
        }
        return penaltyDTOS;
    }

    public PenaltyDTO findById(int id){
        Penalty penalty = penaltyRepository.findById(id);
        PenaltyDTO penaltyDTO = new PenaltyDTO(penalty.getId(),penalty.getUser(),penalty.getRent(),penalty.getReturn_movie());
        return  penaltyDTO;
    }

    public void deleteById(int id){ penaltyRepository.deleteById(id); }


    public PenaltyDTO saveUser(int penaltyId, int userId){
        User user = userRepository.findById(userId);
        Penalty penalty = penaltyRepository.findById(penaltyId);
        penalty.setUser(user);
        penaltyRepository.save(penalty);
        PenaltyDTO penaltyDTO = new PenaltyDTO(penalty.getId(),penalty.getUser(),penalty.getRent(),penalty.getReturn_movie());

        List<Penalty> list = new ArrayList<>();
        list.addAll(user.getPenalties());
        list.add(penalty);
        user.setPenalties(list);
        userRepository.save(user);

        return  penaltyDTO;
    }

    public PenaltyDTO saveRent(int penaltyId, int rentId){
        Rent rent = rentRepository.findById(rentId);
        Penalty penalty = penaltyRepository.findById(penaltyId);
        penalty.setRent(rent);
        penaltyRepository.save(penalty);
        PenaltyDTO penaltyDTO = new PenaltyDTO(penalty.getId(),penalty.getUser(),penalty.getRent(),penalty.getReturn_movie());

        rent.setPenalty(penalty);
        rentRepository.save(rent);

        return  penaltyDTO;
    }

    public PenaltyDTO saveReturnMovie(int penaltyId, int returnMovieId){
        Return_Movie return_movie = return_movieRepository.findById(returnMovieId);
        Penalty penalty = penaltyRepository.findById(penaltyId);
        penalty.setReturn_movie(return_movie);
        penaltyRepository.save(penalty);
        PenaltyDTO penaltyDTO = new PenaltyDTO(penalty.getId(),penalty.getUser(),penalty.getRent(),penalty.getReturn_movie());

        return_movie.setPenalty(penalty);
        return_movieRepository.save(return_movie);

        return  penaltyDTO;
    }

}