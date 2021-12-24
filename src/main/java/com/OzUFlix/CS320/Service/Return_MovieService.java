package com.OzUFlix.CS320.Service;

import com.OzUFlix.CS320.DTO.Return_MovieDTO;
import com.OzUFlix.CS320.Model.*;
import com.OzUFlix.CS320.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class Return_MovieService {
    @Autowired
    Return_MovieRepository return_movieRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RentRepository rentRepository;

    @Autowired
    AvailableRepository availableRepository;

    @Autowired
    MovieRepository movieRepository;

    public Return_Movie save(Return_Movie return_movie){ return return_movieRepository.save(return_movie);}

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

    public Return_MovieDTO saveReturnMovie(Return_Movie returnMovie, int rentId){
        returnMovie.setDate(new Date());
        Rent rent = rentRepository.findById(rentId);
        returnMovie.setRent(rent);
        User user = userRepository.findById(rent.getUser().getId());
        returnMovie.setUser(user);

        return_movieRepository.save(returnMovie);
        Return_MovieDTO return_movieDTO = new Return_MovieDTO(returnMovie.getId(), returnMovie.getUser(),returnMovie.getDate(),returnMovie.getRent(),returnMovie.getPenalty());

        List<Return_Movie> listUser = new ArrayList<>();
        listUser.addAll(user.getReturn_movies());
        listUser.add(returnMovie);
        user.setReturn_movies(listUser);
        userRepository.save(user);

        rent.setReturn_movie(returnMovie);
        rentRepository.save(rent);

        Movie movie = rent.getMovie();
        Available available = availableRepository.findById(1);
        movie.setAvailable(available);
        List<Movie> listA = available.getMovies();
        listA.add(movie);
        available.setMovies(listA);

        Available notAvailable = availableRepository.findById(2);
        List<Movie> listN = notAvailable.getMovies();
        listN.remove(movie);
        notAvailable.setMovies(listN);

        movieRepository.save(movie);
        availableRepository.save(available);
        availableRepository.save(notAvailable);

        long difference_In_Time = rent.getDate().getTime() - returnMovie.getDate().getTime();

        long difference_In_Days
                = (difference_In_Time
                / (1000 * 60 * 60 * 24))
                % 365;

        if(difference_In_Days>20){
            Penalty penalty = new Penalty(user, rent, returnMovie);

            List<Penalty> penalties = user.getPenalties();
            penalties.add(penalty);
            user.setPenalties(penalties);
            userRepository.save(user);

            rent.setPenalty(penalty);
            rentRepository.save(rent);

            returnMovie.setPenalty(penalty);
            return_movieRepository.save(returnMovie);
        }

        return  return_movieDTO;
    }


}