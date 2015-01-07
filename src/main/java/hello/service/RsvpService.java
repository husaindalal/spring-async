package hello.service;

import hello.json.DayPojo;
import hello.json.RsvpPojo;
import hello.json.TotalRsvpPojo;
import hello.json.WeekDayPojo;
import hello.json.WeekRsvpPojo;
import hello.model.Day;
import hello.model.Rsvp;
import hello.model.TotalRsvp;
import hello.model.User;
import hello.repo.DayRepo;
import hello.repo.RsvpRepo;
import hello.repo.TotalRsvpRepo;
import hello.repo.UserRepo;
import hello.service.util.DateUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	private TotalRsvpRepo totalRsvpRepo;

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
	public List<WeekDayPojo> getDays() throws Exception {
		long start = System.currentTimeMillis();

		List<WeekDayPojo> weeks = new ArrayList<WeekDayPojo>();

		LocalDate date = new LocalDate();
		for (int i = 0; i < 4; i++) {
			LocalDate weekStart = dateUtil.startOfWeek(date);
			LocalDate weekEnd = dateUtil.endOfWeek(date);

			WeekDayPojo weekPojo = new WeekDayPojo();
			weekPojo.setWeekId(dateUtil.weekToId(weekStart));
			weekPojo.setWeek(dateUtil.weekToString(weekStart, weekEnd));

			weekPojo.setDays(getDayPojos(weekStart, weekEnd));

			weeks.add(weekPojo);
			date = date.plusWeeks(1);
		}

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

	public List<WeekRsvpPojo> getMyRsvp() {

		long start = System.currentTimeMillis();

		List<WeekRsvpPojo> weeks = new ArrayList<WeekRsvpPojo>();

		LocalDate date = new LocalDate();
		for (int i = 0; i < 4; i++) {
			LocalDate weekStart = dateUtil.startOfWeek(date);
			LocalDate weekEnd = dateUtil.endOfWeek(date);

			WeekRsvpPojo weekPojo = new WeekRsvpPojo();
			weekPojo.setWeekId(dateUtil.weekToId(weekStart));
			weekPojo.setWeek(dateUtil.weekToString(weekStart, weekEnd));

			weekPojo.setRsvps(getMyRsvpPojos(weekStart, weekEnd));

			weeks.add(weekPojo);
			date = date.plusWeeks(1);
		}

		LOG.info("Calc time: " + (System.currentTimeMillis() - start));
		return weeks;
	}

	List<RsvpPojo> getMyRsvpPojos(LocalDate weekStart, LocalDate weekEnd) {
		List<RsvpPojo> rsvpPojos = new ArrayList<RsvpPojo>();

		// User currentUser = userRepo.findOne(5L);
		Long currentUserId = 5L; // TODO: get from security

		List<Rsvp> rsvps = rsvpRepo.findMyRsvpBetween(dateUtil.dayToDBString(weekStart),
				dateUtil.dayToDBString(weekEnd), currentUserId);
		LOG.info("rsvpRepo string " + rsvps.size() + "  " + dateUtil.dayToDBString(weekStart) + "  "
				+ dateUtil.dayToDBString(weekEnd) + "  " + currentUserId);

		for (Rsvp rsvp : rsvps) {
			RsvpPojo rsvpPojo = new RsvpPojo();
			rsvpPojo.setRsvpId(rsvp.getRsvpId());
			rsvpPojo.setDay(dateUtil.dayToLongString(rsvp.getDay().getDay()));
			rsvpPojo.setMenu(rsvp.getDay().getMenu());
			rsvpPojo.setThaliCount(rsvp.getThaliCount());
			rsvpPojo.setLargeThaliCount(rsvp.getLargeThaliCount());
			rsvpPojo.setThaliSize(rsvp.getThaliSize());
			rsvpPojo.setLocation(rsvp.getLocation());
			rsvpPojo.setThaliPicked(rsvp.getThaliPicked());

			rsvpPojos.add(rsvpPojo);
		}

		return rsvpPojos;
	}

	public List<WeekRsvpPojo> getAllRsvp() {
		long start = System.currentTimeMillis();

		List<WeekRsvpPojo> weeks = new ArrayList<WeekRsvpPojo>();

		LocalDate date = new LocalDate();
		for (int i = 0; i < 4; i++) {
			LocalDate weekStart = dateUtil.startOfWeek(date);
			LocalDate weekEnd = dateUtil.endOfWeek(date);

			WeekRsvpPojo weekPojo = new WeekRsvpPojo();
			weekPojo.setWeekId(dateUtil.weekToId(weekStart));
			weekPojo.setWeek(dateUtil.weekToString(weekStart, weekEnd));

			List<TotalRsvp> totalRsvps = totalRsvpRepo.findAllRsvpForDay(dateUtil.dayToDBString(weekStart),
					dateUtil.dayToDBString(weekEnd));
			List<TotalRsvpPojo> totalRsvpPojos = new ArrayList<TotalRsvpPojo>();
			for (TotalRsvp totalRsvp : totalRsvps) {
				TotalRsvpPojo totalRsvpPojo = new TotalRsvpPojo();
				totalRsvpPojo.setDay(totalRsvp.getDay());
				totalRsvpPojo.setMenu(totalRsvp.getMenu());
				totalRsvpPojo.setLocation(totalRsvp.getLocation());
				totalRsvpPojo.setThaliCount(totalRsvp.getThaliCount());
				totalRsvpPojo.setLargeThaliCount(totalRsvp.getLargeThaliCount());
				totalRsvpPojos.add(totalRsvpPojo);
			}

			weekPojo.setTotalRsvps(totalRsvpPojos);

			weeks.add(weekPojo);
			date = date.plusWeeks(1);
		}

		LOG.info("Calc time: " + (System.currentTimeMillis() - start));
		return weeks;

	}

	// public List<WeekRsvpPojo> getAllRsvp() {
	//
	// long start = System.currentTimeMillis();
	//
	// List<WeekRsvpPojo> weeks = new ArrayList<WeekRsvpPojo>();
	//
	// LocalDate date = new LocalDate();
	// for (int i = 0; i < 4; i++) {
	// LocalDate weekStart = dateUtil.startOfWeek(date);
	// LocalDate weekEnd = dateUtil.endOfWeek(date);
	//
	// WeekRsvpPojo weekPojo = new WeekRsvpPojo();
	// weekPojo.setWeekId(dateUtil.weekToId(weekStart));
	// weekPojo.setWeek(dateUtil.weekToString(weekStart, weekEnd));
	//
	// weekPojo.setTotalRsvps(getAllRsvpPojos(weekStart, weekEnd));
	//
	// weeks.add(weekPojo);
	// date = date.plusWeeks(1);
	// }
	//
	// LOG.info("Calc time: " + (System.currentTimeMillis() - start));
	// return weeks;
	// }
	//
	// private List<TotalRsvpPojo> getAllRsvpPojos(LocalDate weekStart,
	// LocalDate weekEnd) {
	// List<TotalRsvpPojo> rsvpPojos = new ArrayList<TotalRsvpPojo>();
	// LocalDate day = new LocalDate(weekStart);
	//
	// while (day.isBefore(weekEnd)) {
	//
	// List<Rsvp> rsvps =
	// rsvpRepo.findAllRsvpForDay(dateUtil.dayToDBString(day));
	// LOG.info("rsvpRepo string " + rsvps.size() + "  " +
	// dateUtil.dayToDBString(day) + "  " + rsvps);
	//
	// // Map<String, Counts> locationCounts = new HashMap<String,
	// // Counts>();
	// String currLocation = rsvps.get(0).getLocation();
	// String oldLocation = rsvps.get(0).getLocation();
	// short totalThaliCount = 0;
	// short totalLargeThaliCount = 0;
	// String dayStr = dateUtil.dayToLongString(rsvps.get(0).getDay().getDay());
	// String menu = rsvps.get(0).getDay().getMenu();
	//
	// for (Rsvp rsvp : rsvps) {
	// currLocation = rsvp.getLocation();
	// if (!oldLocation.equals(currLocation)) {
	// TotalRsvpPojo rsvpPojo = new TotalRsvpPojo();
	// rsvpPojo.setDay(dayStr);
	// rsvpPojo.setMenu(menu);
	// rsvpPojo.setLocation(oldLocation);
	// rsvpPojo.setThaliCount(totalThaliCount);
	// rsvpPojo.setLargeThaliCount(totalLargeThaliCount);
	//
	// rsvpPojos.add(rsvpPojo);
	//
	// totalThaliCount = 0;
	// totalLargeThaliCount = 0;
	// }
	// totalThaliCount += rsvp.getThaliCount();
	// totalLargeThaliCount += rsvp.getThaliCount();
	//
	// oldLocation = currLocation;
	// }
	//
	// }
	//
	// return rsvpPojos;
	// }
	//
	//
	// List<Person> allPeople; // your list of all people
	// Map<String, List<Person>> map = new HashMap<String, List<Person>>();
	// for (Person person : allPeople) {
	// String key = person.getName();
	// if (map.get(key) == null) {
	// map.put(key, new ArrayList<Person>());
	// }
	// map.get(key).add(person);
	// }

}
