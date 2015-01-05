package hello.service;

import hello.model.User;
import hello.model.UserCalc;
import hello.repo.UserCalcRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class UserCalcService {

	private static final Logger LOG = LoggerFactory.getLogger(UserCalcService.class);

	@Autowired
	private UserCalcRepo userCalcRepo;


	@Async
	//Future<UserCalc>
    public void calcUser(User user) throws InterruptedException {
        LOG.info("begin calc user");
        UserCalc userCalc = new UserCalc() ;
        userCalc.setNameEmail(user.toString());
        userCalcRepo.save( userCalc);
        
        Thread.sleep(5000L);
        LOG.info("end calc user");
        //return new AsyncResult<UserCalc>(userCalc);
    }
}
