package com.OzUFlix.CS320.Service;

import com.OzUFlix.CS320.DTO.MovieDTO;
import com.OzUFlix.CS320.DTO.PenaltyDTO;
import com.OzUFlix.CS320.DTO.RentDTO;
import com.OzUFlix.CS320.Model.*;
import com.OzUFlix.CS320.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RentService {
    @Autowired
    RentRepository rentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    PenaltyRepository penaltyRepository;

    @Autowired
    AvailableRepository availableRepository;

    public Rent save(Rent rent){
        return rentRepository.save(rent);
    }

    public List<RentDTO> findAll(){
        List<Rent> rents = rentRepository.findAll();
        List<RentDTO> rentDTOS = new ArrayList<>();
        for (Rent rent: rents) {
            rentDTOS.add(new RentDTO(rent.getId(),rent.getUser(),rent.getMovie(),rent.getDate(), rent.getPenalty(),rent.getReturn_movie()));
        }
        return rentDTOS;
    }

    public RentDTO findById(int id){
        Rent rent = rentRepository.findById(id);
        RentDTO rentDTO = new RentDTO(rent.getId(),rent.getUser(),rent.getMovie(),rent.getDate(), rent.getPenalty(),rent.getReturn_movie());
        return  rentDTO;
    }

    public void deleteById(int id){ rentRepository.deleteById(id); }

    public RentDTO saveRent(Rent rent, int userId, int movieId){
        Movie movie = movieRepository.findById(movieId);

        if (movie.getAvailable().getInfo()!=0) {

            rent.setDate(new Date());
            User user = userRepository.findById(userId);

            rent.setUser(user);
            rent.setMovie(movie);

            rentRepository.save(rent);
            RentDTO rentDTO = new RentDTO(rent.getId(),rent.getUser(),rent.getMovie(),rent.getDate(), rent.getPenalty(),rent.getReturn_movie());

            List<Rent> listUser = new ArrayList<>();
            listUser.addAll(user.getRents());
            listUser.add(rent);
            user.setRents(listUser);
            userRepository.save(user);

            List<Rent> listMovie = new ArrayList<>();
            listMovie.addAll(movie.getRents());
            listMovie.add(rent);
            movie.setRents(listMovie);
            movieRepository.save(movie);

            Available notAvailable = availableRepository.findById(2);
            movie.setAvailable(notAvailable);
            notAvailable.getMovies().add(movie);
            availableRepository.save(notAvailable);

            Available available = availableRepository.findById(1);
            available.getMovies().remove(movie);
            availableRepository.save(available);


            return  rentDTO;
        }

        return null;
    }


    public MovieDTO getMost(){
        int max = 0;
        int maxIndex = 0;
        List<Rent> rents = rentRepository.findAll();
        int[] counts = new int[rents.size()];
        for(Rent rent: rents){
            counts[rent.getMovie().getId()-1] += 1;
        }
        for(int i = 0; i<counts.length;i++){
            if (max<counts[i]){
                max=counts[i];
                maxIndex = i+1;
            }
        }

        Movie movie = movieRepository.findById(maxIndex);
        MovieDTO movieDTO = new MovieDTO(movie.getId(), movie.getName(), movie.getDirector(),movie.getTopic(),movie.getAvailable(),movie.getRents());

        return movieDTO;
    }
}