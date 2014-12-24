package hello.service;

import java.util.concurrent.Future;

import javax.transaction.Transactional;

import hello.controller.UserCtrl;
import hello.json.UserPojo;
import hello.model.User;
import hello.model.UserAud;
import hello.model.UserCalc;
import hello.repo.UserAudRepo;
import hello.repo.UserCalcRepo;
import hello.repo.UserRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserService {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserAudRepo userAudRepo;

	@Autowired
	private UserCalcService userCalcSvc;

	@Transactional
	public User create(UserPojo userPojo) throws Exception {
		long start = System.currentTimeMillis();
		User user = createUser(userPojo);
		LOG.info("User time: " + (System.currentTimeMillis() - start));
		createUserAud(user);
		LOG.info("Aud time: " + (System.currentTimeMillis() - start));
		//async calcUser
		userCalcSvc.calcUser(user);
		LOG.info("Calc time: " + (System.currentTimeMillis() - start));
		return user;
	}
	
	private User createUser(UserPojo userPojo) throws Exception  {
		User user = new User();
		user.setName(userPojo.getName());
		user.setEmail(userPojo.getEmail());
		userRepo.save(user);

		return user;
	}
	
	private UserAud createUserAud(User newUser) {
		UserAud userAud = new UserAud();

		User oldUser = userRepo.findOne(newUser.getId());
		if(oldUser != null) {
			userAud.setNameB(oldUser.getName()) ;
			userAud.setEmailB(oldUser.getEmail()) ;
		}

		userAud.setNameA(newUser.getName()) ;
		userAud.setEmailA(newUser.getEmail()) ;

		userAudRepo.save(userAud);
		
		return userAud;
	}
	
	


}
