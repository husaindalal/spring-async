package hello.controller;

import hello.json.WeekDayPojo;
import hello.json.WeekRsvpPojo;
import hello.service.RsvpService;

import java.util.List;

import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

	
	/**
	 * http://localhost:8080/days
	 * @return
	 */
	@RequestMapping("/days")
	@ResponseBody
	public List<WeekDayPojo> getDays() {
		long start = System.currentTimeMillis();

		List<WeekDayPojo> weeks;
		try {
			weeks = rsvpSvc.getDays();
		} catch (Exception ex) {
			LOG.error("Error creating the days: ", ex );
			return null;
		}
		LOG.info("Total time: " + (System.currentTimeMillis() - start));

		return weeks ;
	}
	
	
	/**
	 * http://localhost:8080/days
	 * @return
	 */
	@RequestMapping("/myrsvp")
	@ResponseBody
	public List<WeekRsvpPojo> getMyRsvp() {
		long start = System.currentTimeMillis();

		List<WeekRsvpPojo> weeks;
		try {
			weeks = rsvpSvc.getMyRsvp();
		} catch (Exception ex) {
			LOG.error("Error creating the days: ", ex );
			return null;
		}
		LOG.info("Total time: " + (System.currentTimeMillis() - start));

		return weeks ;
	}
	
	
	/**
	 * http://localhost:8080/allrsvp
	 * @return
	 */
	@RequestMapping("/allrsvp")
	@ResponseBody
	public List<WeekRsvpPojo> getAllRsvp() {
		long start = System.currentTimeMillis();

		List<WeekRsvpPojo> weeks;
		try {
			weeks = rsvpSvc.getAllRsvp();
		} catch (Exception ex) {
			LOG.error("Error creating the days: ", ex );
			return null;
		}
		LOG.info("Total time: " + (System.currentTimeMillis() - start));

		return weeks ;
	}

	/**
	 * http://localhost:8080/allrsvp
	 * @return
	 */
	@RequestMapping("/applydefaults")
	@ResponseBody
	public String applyDefaultsToRsvp() {
		long start = System.currentTimeMillis();

		try {
			 rsvpSvc.applyDefaultsToRsvp(LocalDate.now());
		} catch (Exception ex) {
			LOG.error("Error creating the days: ", ex );
			return null;
		}
		LOG.info("Total time: " + (System.currentTimeMillis() - start));

		return "Applied to day "+LocalDate.now() ;
	}

	
//	/**
//	 * http://localhost:8080/days
//	 * @return
//	 */
//	@RequestMapping("/allrsvp")
//	@ResponseBody
//	public List<WeekDayPojo> getAllRsvp() {
//		long start = System.currentTimeMillis();
//
//		List<WeekDayPojo> weeks;
//		try {
//			weeks = rsvpSvc.getAllRsvp();
//		} catch (Exception ex) {
//			LOG.error("Error creating the days: ", ex );
//			return null;
//		}
//		LOG.info("Total time: " + (System.currentTimeMillis() - start));
//
//		return weeks ;
//	}
	
	
}
