package hello.controller;

import java.util.List;

import hello.json.UserPojo;
import hello.json.WeekPojo;
import hello.model.User;
import hello.repo.UserRepo;
import hello.service.RsvpService;
import hello.service.UserService;

import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RsvpController {

	private static final Logger LOG = LoggerFactory.getLogger(RsvpController.class);

	@Autowired
	private RsvpService rsvpSvc;

	// ==============
	// PUBLIC METHODS
	// ==============

	/**
	 * Create a new user and save it in the database. mvn spring-boot:run
	 * http://localhost:8080/create?name=husain&email=husain@gmail.com
	 * 
	 * @param email
	 *            user email
	 * @param name
	 *            use name
	 * @return a string describing if the user is successfully created or not.
	 */
	@RequestMapping("/createdays")
	@ResponseBody
	public String createDays() {
		long start = System.currentTimeMillis();

		try {
			rsvpSvc.createDays((new LocalDate()).plusMonths(4));
		} catch (Exception ex) {
			LOG.error("Error creating the days: ", ex );
			return "Error creating days: " + ex.toString();
		}
		LOG.info("Total time: " + (System.currentTimeMillis() - start));

		return "Days succesfully created! " ;
	}

	@RequestMapping("/getdays")
	@ResponseBody
	public List<WeekPojo> get() {
		long start = System.currentTimeMillis();

		List<WeekPojo> weeks;
		try {
			weeks = rsvpSvc.getDays();
		} catch (Exception ex) {
			LOG.error("Error creating the days: ", ex );
			return null;
		}
		LOG.info("Total time: " + (System.currentTimeMillis() - start));

		return weeks ;
	}
}
