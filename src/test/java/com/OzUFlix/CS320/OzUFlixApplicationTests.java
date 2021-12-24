package com.OzUFlix.CS320;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.OzUFlix.CS320.Model.*;
import com.OzUFlix.CS320.Service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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




		/*assertEquals(directorService.findById(1).getId(),director.getId());
		assertEquals(availableService.findById(1).getMovies(),available.getMovies());
		assertTrue(availableService.findById(1).getId()==available.getId());
		assertTrue(availableService.findById(1).getInfo()==available.getInfo());
		assertTrue(availableService.findById(2).equals(notAvailable));
		assertTrue(topicService.findById(1).equals(topic));
		assertTrue(movieService.findById(1).equals(movie));
		assertTrue(userService.findById(1).equals(manager));
		assertTrue(userService.findById(2).equals(user));
		assertTrue(rentService.findById(1).equals(rent));
		assertTrue(return_movieService.findById(1).equals(returnM));
		assertTrue(penaltyService.findById(1).equals(penalty));*/




	}

}
