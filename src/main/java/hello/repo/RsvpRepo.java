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
	
	@Query(nativeQuery = true, value = "SELECT r.* FROM rsvp r, DAYs d WHERE r.day_id = d.day_id and d.day >= :weekStart AND d.day <= :weekEnd AND r.user_id = :currentUserId")
	List<Rsvp> findMyRsvpBetween(@Param("weekStart") LocalDate weekStart, @Param("weekEnd") LocalDate weekEnd,  @Param("currentUserId") Long currentUserId);

	@Query(nativeQuery = true, value = "SELECT r.* FROM rsvp r, DAYs d WHERE r.day_id = d.day_id and d.day >= :weekStart AND d.day <= :weekEnd AND r.user_id = :currentUserId")
	List<Rsvp> findMyRsvpBetween(@Param("weekStart") String weekStart, @Param("weekEnd") String weekEnd,  @Param("currentUserId") Long currentUserId);

	@Query("SELECT d FROM Rsvp d WHERE d.day >= :weekStart and d.day <= :weekEnd")
	List<Rsvp> findAllRsvpBetween(@Param("weekStart") Day weekStart, @Param("weekEnd") Day weekEnd);

}
