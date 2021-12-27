package com.OzUFlix.CS320.ServiceTest;

import com.OzUFlix.CS320.Model.*;
import com.OzUFlix.CS320.Service.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class ServiceTest {


    @Autowired
    AvailableService availableService;

    @Autowired
    DirectorService directorService;

    @Autowired
    TopicService topicService;

    @Autowired
    MovieService movieService;

    @Autowired
    UserService userService;

    @Autowired
    RentService rentService;

    @Autowired
    Return_MovieService return_movieService;

    @Autowired
    PenaltyService penaltyService;

    @Test
    public void serviceTest() {

        if(availableService.findAll().size()==0){
            Available available = new Available(1);
            Available notAvailable = new Available(0);

            availableService.save(available);
            availableService.save(notAvailable);
            assertNotNull(availableService.findById(available.getId()));
            assertNotNull(availableService.findById(notAvailable.getId()));
        }

        Topic topic1 = new Topic("Horror");
        Topic topic2 = new Topic("Documentary");

        topicService.save(topic1);
        topicService.save(topic2);
        assertNotNull(topicService.findById(topic1.getId()));
        assertNotNull(topicService.findById(topic2.getId()));


        Director director1 = new Director("Qubic");
        Director director2 = new Director("Bilge");

        directorService.save(director1);
        directorService.save(director2);
        assertNotNull(directorService.findById(director1.getId()));
        assertNotNull(directorService.findById(director2.getId()));


        Movie movie1 = new Movie("Nemo");
        movieService.saveMovie(movie1,director1.getId(), topic1.getId());
        assertNotNull(movieService.findById(movie1.getId()));

        Movie movie2 = new Movie("Coco");
        movieService.saveMovie(movie2,director1.getId(), topic2.getId());
        assertNotNull(movieService.findById(movie2.getId()));

        Movie movie3 = new Movie("Luca");
        movieService.saveMovie(movie3,director2.getId(), topic1.getId());
        assertNotNull(movieService.findById(movie3.getId()));

        Movie movie4 = new Movie("Inception");
        movieService.saveMovie(movie4,director2.getId(), topic2.getId());
        assertNotNull(movieService.findById(movie4.getId()));


        User manager = new User("Aylin", "123");
        manager.setUserType(1);
        User user1 = new User("Başak", "123");
        User user2 = new User("Ekin", "123");

        userService.save(manager);
        userService.save(user1);
        userService.save(user2);

        assertNotNull(userService.findById(manager.getId()));
        assertNotNull(userService.findById(user1.getId()));
        assertNotNull(userService.findById(user2.getId()));


        Rent rent1 = new Rent();
        rentService.saveRent(rent1, user1.getId(), movie1.getId());
        assertNotNull(rentService.findById(rent1.getId()));

        Rent rent2 = new Rent();
        rentService.saveRent(rent2, user2.getId(), movie2.getId());
        assertNotNull(rentService.findById(rent2.getId()));


        Return_Movie returnMovie1 = new Return_Movie();
        return_movieService.saveReturnMovie(returnMovie1,rent1.getId());
        assertNotNull(return_movieService.findById(returnMovie1.getId()));


        Penalty penalty = new Penalty();
        penalty.setUser(user1);
        penalty.setRent(rent1);
        penalty.setReturn_movie(returnMovie1);
        penaltyService.save(penalty);
        assertNotNull(penaltyService.findById(penalty.getId()));

        user1.getPenalties().add(penalty);
        rent1.setPenalty(penalty);
        returnMovie1.setPenalty(penalty);
        userService.save(user1);
        rentService.save(rent1);
        return_movieService.save(returnMovie1);

    }
}
