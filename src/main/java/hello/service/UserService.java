package hello.service;

import javax.transaction.Transactional;

import hello.json.UserPojo;
import hello.model.User;
import hello.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	@Transactional
	public User create(UserPojo userPojo) throws Exception {
		User user = createUser(userPojo);
		//UserAud userAud = createUserAud(user);
		//async calcUser
		return user;
	}
	
	private User createUser(UserPojo userPojo) throws Exception  {
		User user = new User();
		user.setName(userPojo.getName());
		user.setEmail(userPojo.getEmail());
		userRepo.save(user);

		return user;
	}
	
//	private UserAud createUserAud(User newUser) {
//		UserAud userAud = new UserAud();
//
//		User oldUser = userRepo.findOne(newUser.getId());
//		if(oldUser != null) {
//			userAud.setNameB(oldUser.getName()) ;
//			userAud.setEmailB(oldUser.getEmail()) ;
//		}
//
//		userAud.setNameA(newUser.getName()) ;
//		userAud.setEmailA(newUser.getEmail()) ;
//
//	}

}
