package hello.service;

import hello.json.UserPojo;
import hello.model.Day;
import hello.model.Role;
import hello.model.Rsvp;
import hello.model.User;
import hello.model.UserDefault;
import hello.repo.DayRepo;
import hello.repo.UserRepo;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private DayRepo dayRepo;

	
//	@Autowired
//	private UserAudRepo userAudRepo;
//
//	@Autowired
//	private UserDefaultRepo userDefaultRepo;
//
//	@Autowired
//	private RoleRepo roleRepo;
//
//	@Autowired
//	private UserCalcService userCalcSvc;

	@Transactional
	public User createUser(UserPojo userPojo) throws Exception {
		long start = System.currentTimeMillis();
		
		User user = new User();
		user.setName(userPojo.getName());
		user.setEmail(userPojo.getEmail());
		//user.setPassword("welcome1"); //Set in entity
		
		user.addRole(new Role());
		
		UserDefault def = new UserDefault();
		def.setUser(user);
		user.setUserDefault(def);

		List<Day> days = dayRepo.findDaysGreaterThan(LocalDate.now());
		List<Rsvp> rsvps = new ArrayList<Rsvp>();
		for(Day day : days) {
			Rsvp rsvp = new Rsvp();
			rsvp.setUser(user);
			rsvp.setDay(day);
			rsvps.add(rsvp);
		}
		user.setRsvps(rsvps); //All days from this week

		userRepo.save(user);

		//async calcUser
		//userCalcSvc.calcUser(user);
		LOG.info("Calc time: " + (System.currentTimeMillis() - start));
		return user;
	}
	

}
