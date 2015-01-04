package hello.controller;

import hello.json.UserPojo;
import hello.model.User;
import hello.repo.UserRepo;
import hello.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userSvc;

	// ==============
	// PUBLIC METHODS
	// ==============

	/**
	 * Create a new user and save it in the database. mvn spring-boot:run
	 * http://localhost:8080/createuser?name=husain&email=husain@gmail.com
	 * 
	 * @param email
	 *            user email
	 * @param name
	 *            use name
	 * @return a string describing if the user is successfully created or not.
	 */
	@RequestMapping("/createuser")
	@ResponseBody
	public String create(@RequestParam("name") String name, @RequestParam("email") String email) {
		long start = System.currentTimeMillis();

		User user = null;

		try {
			user = userSvc.createUser(new UserPojo(name, email));
		} catch (Exception ex) {
			LOG.error("Error creating the user: ", ex );
			return "Error creating the user: " + ex.toString();
		}
		LOG.info("Total time: " + (System.currentTimeMillis() - start));

		return "User succesfully created! " + user.getUserId();
	}

	/**
	 * Delete the user having the passed id.
	 * 
	 * @param id
	 *            the id of the user to delete
	 * @return a string describing if the user is succesfully deleted or not.
	 */
	// @RequestMapping("/delete")
	// @ResponseBody
	// public String delete(long id) {
	// try {
	// User user = new User(id);
	// userRepo.delete(user);
	// }
	// catch (Exception ex) {
	// return "Error deleting the user:" + ex.toString();
	// }
	// return "User succesfully deleted!";
	// }

	/**
	 * Return the id for the user having the passed email.
	 * 
	 * @param email
	 *            the email to search in the database.
	 * @return the user id or a message error if the user is not found.
	 */
	// @RequestMapping("/get-by-email")
	// @ResponseBody
	// public String getByEmail(String email) {
	// String userId;
	// try {
	// User user = userRepo.findByEmail(email);
	// userId = String.valueOf(user.getId());
	// }
	// catch (Exception ex) {
	// return "User not found";
	// }
	// return "The user id is: " + userId;
	// }

	/**
	 * Update the email and the name for the user in the database having the
	 * passed id.
	 * 
	 * @param id
	 *            the id for the user to update.
	 * @param email
	 *            the new email.
	 * @param name
	 *            the new name.
	 * @return a string describing if the user is successfully updated or not.
	 */
	// @RequestMapping("/update")
	// @ResponseBody
	// public String updateUser(long id, String email, String name) {
	// try {
	// User user = userRepo.findOne(id);
	// user.setEmail(email);
	// user.setName(name);
	// userRepo.save(user);
	// }
	// catch (Exception ex) {
	// return "Error updating the user: " + ex.toString();
	// }
	// return "User succesfully updated!";
	// }

}
