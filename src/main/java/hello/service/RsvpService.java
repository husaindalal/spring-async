package hello.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Future;

import javax.transaction.Transactional;

import hello.controller.UserController;
import hello.json.DayPojo;
import hello.json.UserPojo;
import hello.json.WeekPojo;
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
import hello.service.util.DateUtils;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
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

	@Autowired
	private DateUtils dateUtil;

	@Transactional
	public void createDays(LocalDate dateUpto) throws Exception {
		long start = System.currentTimeMillis();

		LocalDate date = new LocalDate();
		while (date.isBefore(dateUpto)) {
			LOG.info("");
			Day day = dayRepo.findByDay(date);
			if (day == null) {
				day = new Day();
				day.setDay(date);

				day.setRsvps(getFutureRsvps(day));

				dayRepo.save(day);

				// add rsvp entry for each user
			}

			date = date.plusDays(1);
		}

		LOG.info("Calc time: " + (System.currentTimeMillis() - start));
	}

	private List<Rsvp> getFutureRsvps(Day day) {
		List<Rsvp> rsvps = new ArrayList<Rsvp>();
		List<User> users = userRepo.findAll();
		for (User user : users) {
			Rsvp rsvp = new Rsvp();
			rsvp.setUser(user);
			rsvp.setDay(day);
			rsvps.add(rsvp);
		}
		return rsvps;
	}

	@Transactional
	public List<WeekPojo> getDays() throws Exception {
		long start = System.currentTimeMillis();

		List<WeekPojo> weeks = new ArrayList<WeekPojo>();

		LocalDate date = new LocalDate();
		for (int i = 0; i < 4; i++) {
			LocalDate weekStart = dateUtil.startOfWeek(date);
			LocalDate weekEnd = dateUtil.endOfWeek(date);

			WeekPojo weekPojo = new WeekPojo();
			weekPojo.setWeekId(dateUtil.weekToId(weekStart));
			weekPojo.setWeek(dateUtil.weekToString(weekStart, weekEnd));

			weekPojo.setDays(getDayPojos(weekStart, weekEnd));

			weeks.add(weekPojo);
			date = date.plusWeeks(1);
		}

		// LocalDate weekStart= today.dayOfWeek().withMinimumValue();
		// LocalDate weekEnd = today.dayOfWeek().withMaximumValue();
		//
		// LOG.error("Week : "+dayFormat2.print(weekStart)+" - "+dayFormat2.print(weekEnd));
		//
		// weekPojo.setWeekId(weekFormat.print(today));
		// weekPojo.setWeek("Week : "+dayFormat.print(weekStart)+" - "+dayFormat.print(weekEnd));
		//
		// today = new LocalDate().plusDays(1);
		// weekStart= today.dayOfWeek().withMinimumValue();
		// weekEnd = today.dayOfWeek().withMaximumValue();
		//
		// LOG.error("Week+1 : "+dayFormat.print(weekStart)+" - "+dayFormat.print(weekEnd));
		//
		// today = new LocalDate().plusDays(2);
		// weekStart= today.dayOfWeek().withMinimumValue();
		// weekEnd = today.dayOfWeek().withMaximumValue();
		//
		// LOG.error("Week+2 : "+dayFormat.print(weekStart)+" - "+dayFormat.print(weekEnd));
		//
		//
		LOG.info("Calc time: " + (System.currentTimeMillis() - start));
		return weeks;
	}

	List<DayPojo> getDayPojos(LocalDate weekStart, LocalDate weekEnd) {
		List<DayPojo> dayPojos = new ArrayList<DayPojo>();

		List<Day> days = dayRepo.findDaysBetween(weekStart, weekEnd);
		for (Day day : days) {
			DayPojo dayPojo = new DayPojo();
			dayPojo.setDayId(day.getDayId());
			dayPojo.setDay(dateUtil.dayToLongString(day.getDay()));
			dayPojo.setLocked(day.getLocked());
			dayPojo.setOccasionType(day.getOccasionType());
			dayPojo.setMenu(day.getMenu());

			dayPojos.add(dayPojo);
		}

		return dayPojos;
	}

}
