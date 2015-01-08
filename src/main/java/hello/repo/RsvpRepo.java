package hello.repo;

import hello.model.Day;
import hello.model.Rsvp;

import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RsvpRepo extends JpaRepository<Rsvp, Long>{
	
	@Query(nativeQuery = true, value = "SELECT r.* FROM rsvp r, days d WHERE r.day_id = d.day_id and d.day >= :weekStart AND d.day <= :weekEnd AND r.user_id = :currentUserId")
	List<Rsvp> findMyRsvpBetween(@Param("weekStart") String weekStart, @Param("weekEnd") String weekEnd,  @Param("currentUserId") Long currentUserId);

	@Query(nativeQuery = true, value = "SELECT r.* FROM rsvp r, days d WHERE r.day_id = d.day_id and d.day >= :weekStart AND d.day <= :weekEnd order by d.day, r.location ")
	List<Rsvp> findAllRsvpBetween(@Param("weekStart") String weekStart, @Param("weekEnd") String weekEnd);

	@Query(nativeQuery = true, value = "SELECT r.* FROM rsvp r, days d WHERE r.day_id = d.day_id and d.day = :day order by d.day, r.location ")
	List<Rsvp> findAllRsvpForDay(@Param("day") String day);

	@Query(nativeQuery = true, value = "SELECT r.* FROM rsvp r, days d WHERE r.day_id = d.day_id and d.day >= :weekStart AND d.day <= :weekEnd AND r.user_id = :currentUserId")
	List<Rsvp> findMyRsvpByWeek(@Param("weekId") String weekStart, @Param("weekEnd") String weekEnd,  @Param("currentUserId") Long currentUserId);

}
