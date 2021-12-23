package com.OzUFlix.CS320;

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

		Director director = new Director();
		director.setName("Nolan");

		Topic topic = new Topic();
		topic.setName("scific");

		Movie movie = new Movie();
		movie.setName("Inception");
		movie.setTopic(topic);
		movie.setDirector(director);

		User manager = new User();
		manager.setName("Aylin");
		manager.setPassword("123");
		manager.setUserType(1);

		User user = new User();
		user.setName("Başak");
		user.setPassword("123");
		user.setUserType(0);

		Rent rent = new Rent();
		rent.setUser(user);
		rent.setMovie(movie);
		rent.setDate(new java.util.Date()); //todo: bunu sql date e çevirmek gerekebilir

		Return_Movie returnM = new Return_Movie();
		returnM.setRent(rent);
		returnM.setUser(user);
		returnM.setDate(new java.util.Date());

		Penalty penalty = new Penalty();
		penalty.setRent(rent);
		penalty.setReturn_movie(returnM);

		availableService.save(available);
		availableService.save(notAvailable);
		directorService.save(director);
		topicService.save(topic);
		movieService.save(movie);
		userService.save(manager);
		userService.save(user);
		rentService.save(rent);
		return_movieService.save(returnM);
		penaltyService.save(penalty);
	}
}