package hello.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Future;

import javax.transaction.Transactional;

import hello.controller.UserController;
import hello.json.UserPojo;
import hello.model.Day;
import hello.model.Rsvp;
import hello.model.User;
import hello.model.UserAud;
import hello.model.UserCalc;
import hello.repo.DayRepo;
import hello.repo.RsvpRepo;
import hello.repo.UserAudRepo;
import hello.repo.UserCalcRepo;
import hello.repo.UserRepo;

import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class RsvpService {
	
	private static final Logger LOG = LoggerFactory.getLogger(RsvpService.class);

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private DayRepo dayRepo;

	@Autowired
	private RsvpRepo rsvpRepo;


	@Transactional
	public void createDays(LocalDate dateUpto) throws Exception {
		long start = System.currentTimeMillis();
		
		LocalDate date = new LocalDate();
		while(date.isBefore(dateUpto)) {
			LOG.info("");
			Day day = dayRepo.findByDay(date);
			if(day == null) {
				day = new Day();
				day.setDay(date);
				
				day.setRsvps(getFutureRsvps(day));
				
				dayRepo.save(day);
				
				//add rsvp entry for each user
			}
			
			date = date.plusDays(1);
		}
		
		
		
		LOG.info("Calc time: " + (System.currentTimeMillis() - start));
	}


	private List<Rsvp> getFutureRsvps(Day day) {
		List<Rsvp> rsvps = new ArrayList<Rsvp>();
		List<User> users = userRepo.findAll();
		for(User user : users) {
			Rsvp rsvp = new Rsvp() ;
			rsvp.setUser(user);
			rsvp.setDay(day);
			rsvps.add(rsvp);
		}
		return rsvps;
	}
	

}
