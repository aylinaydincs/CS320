package com.OzUFlix.CS320;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.OzUFlix.CS320.Model.*;
import com.OzUFlix.CS320.Service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class OzUFlixApplicationTests {

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
	public void testService() {
		Available available = new Available();
		available.setInfo(1);
		Available notAvailable = new Available();
		notAvailable.setInfo(0);

		assertTrue(available.getInfo()==1);
		assertTrue(notAvailable.getInfo()==0);

		Director director = new Director();
		director.setName("Nolan");

		assertTrue(director!=null);
		assertTrue(director.getName()=="Nolan");

		Topic topic = new Topic();
		topic.setName("scific");

		assertTrue(topic!=null);
		assertTrue(topic.getName()=="scific");

		Movie movie = new Movie();
		movie.setName("Inception");
		movie.setTopic(topic);
		movie.setDirector(director);

		available.getMovies().add(movie);

		assertTrue(movie!=null);
		assertTrue(movie.getName()=="Inception");
		assertTrue(movie.getTopic()==topic);
		assertTrue(movie.getDirector()==director);


		User manager = new User();
		manager.setName("Aylin");
		manager.setPassword("123");
		manager.setUserType(1);

		assertTrue(manager!=null);
		assertTrue(manager.getName()=="Aylin");
		assertTrue(manager.getPassword()=="123");
		assertTrue(manager.getUserType()==1);

		User user = new User();
		user.setName("Başak");
		user.setPassword("123");
		user.setUserType(0);

		assertTrue(user!=null);
		assertTrue(user.getName()=="Başak");
		assertTrue(user.getPassword()=="123");
		assertTrue(user.getUserType()==0);

		Rent rent = new Rent();
		rent.setUser(user);
		rent.setMovie(movie);
		java.util.Date date = new java.util.Date();
		rent.setDate(date); //todo: bunu sql date e çevirmek gerekebilir

		assertTrue(rent!=null);
		assertTrue(rent.getUser()==user);
		assertTrue(rent.getMovie()== movie);
		assertTrue(rent.getDate()== date);

		Return_Movie returnM = new Return_Movie();
		returnM.setRent(rent);
		returnM.setUser(user);
		returnM.setDate(date);

		assertTrue(returnM!=null);
		assertTrue(returnM.getRent()==rent);
		assertTrue(returnM.getUser()==user);
		assertTrue(returnM.getDate()==date);

		Penalty penalty = new Penalty();
		penalty.setRent(rent);
		penalty.setReturn_movie(returnM);

		assertTrue(penalty!=null);
		assertTrue(penalty.getRent()==rent);
		assertTrue(penalty.getReturn_movie()==returnM);

		List<Movie>movies=new ArrayList<>();
		movies.add(movie);
		available.setMovies(movies);
		director.setMovies(movies);
		movie.setAvailable(available);
		List<Rent>rents=new ArrayList<>();
		rents.add(rent);
		movie.setRents(rents);
		penalty.setUser(user);

		//availableService.saveMovie(movie.getId(),available.getId());
		movieService.searchMovie(1);
		movieService.searchMovie("Nolan");


		availableService.save(available);
		assertTrue(availableService.findAll()!=null);
		availableService.save(notAvailable);
		assertTrue(availableService.findAll()!=null);
		directorService.save(director);
		assertTrue(directorService.findAll()!=null);
		topicService.save(topic);
		assertTrue(topicService.findAll()!=null);
		movieService.save(movie);
		assertTrue(movieService.findAll()!=null);
		userService.save(manager);
		assertTrue(userService.findAll()!=null);

		userService.save(user);
		assertTrue(userService.findAll()!=null);

		rentService.save(rent);
		assertTrue(rentService.findAll()!=null);

		return_movieService.save(returnM);
		assertTrue(return_movieService.findAll()!=null);

		penaltyService.save(penalty);
		assertTrue(penaltyService.findAll()!=null);


		assertTrue(directorService.findById(director.getId()).getId()==director.getId());

		//assertTrue(availableService.findById(available.getId()).getMovies()==available.getMovies());
		assertTrue(availableService.findById(available.getId()).getId()==available.getId());
		//assertTrue(availableService.findById(available.getId()).getInfo()==available.getInfo());

		//assertTrue(availableService.findById(notAvailable.getId()).getMovies()==notAvailable.getMovies());
		assertTrue(availableService.findById(notAvailable.getId()).getId()==notAvailable.getId());
		assertTrue(availableService.findById(notAvailable.getId()).getInfo()==notAvailable.getInfo());

		assertTrue(topicService.findById(topic.getId()).getId()== topic.getId());
		//assertTrue(topicService.findById(topic.getId()).getMovies()== topic.getMovies());
		//assertTrue(topicService.findById(topic.getId()).getName()== topic.getName());

		assertTrue(movieService.findById(movie.getId()).getId()== movie.getId());
		/*assertTrue(movieService.findById(movie.getId()).getName()== movie.getName());
		assertTrue(movieService.findById(movie.getId()).getDirector()== movie.getDirector());
		assertTrue(movieService.findById(movie.getId()).getTopic()== movie.getTopic());
		assertTrue(movieService.findById(movie.getId()).getAvailable()== movie.getAvailable());
		assertTrue(movieService.findById(movie.getId()).getRents()== movie.getRents());*/

		/*assertTrue(userService.findById(1).equals(manager));
		assertTrue(userService.findById(2).equals(user));
		assertTrue(rentService.findById(1).equals(rent));
		assertTrue(return_movieService.findById(1).equals(returnM));
		assertTrue(penaltyService.findById(1).equals(penalty));*/




	}

}