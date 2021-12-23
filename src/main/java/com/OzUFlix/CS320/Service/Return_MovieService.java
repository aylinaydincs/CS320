package com.OzUFlix.CS320.Service;

import com.OzUFlix.CS320.DTO.RentDTO;
import com.OzUFlix.CS320.DTO.Return_MovieDTO;
import com.OzUFlix.CS320.Model.Rent;
import com.OzUFlix.CS320.Model.Return_Movie;
import com.OzUFlix.CS320.Repository.Return_MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Return_MovieService {
    @Autowired
    Return_MovieRepository return_movieRepository;

    public Return_Movie save(Return_Movie return_Movie){ return return_movieRepository.save(return_Movie); }

    public List<Return_MovieDTO> findAll(){
        List<Return_Movie> return_movies = return_movieRepository.findAll();
        List<Return_MovieDTO> return_movieDTOS = new ArrayList<>();
        for (Return_Movie return_movie: return_movies) {
            return_movieDTOS.add(new Return_MovieDTO(return_movie.getId(), return_movie.getUser(),return_movie.getDate(),return_movie.getRent(),return_movie.getPenalty()));
        }
        return return_movieDTOS;
    }

    public Return_MovieDTO findById(int id){
        Return_Movie return_movie = return_movieRepository.findById(id);
        Return_MovieDTO return_movieDTO = new Return_MovieDTO(return_movie.getId(), return_movie.getUser(),return_movie.getDate(),return_movie.getRent(),return_movie.getPenalty());
        return  return_movieDTO;
    }

    public void deleteById(int id){ return_movieRepository.deleteById(id); }
}