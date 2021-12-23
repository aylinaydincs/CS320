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
	PenaltyService penaltyService;}