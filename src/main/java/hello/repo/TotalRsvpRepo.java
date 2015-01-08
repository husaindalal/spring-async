package hello.repo;

import java.util.List;

import hello.model.Rsvp;
import hello.model.TotalRsvp;
import hello.model.UserAud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TotalRsvpRepo extends JpaRepository<TotalRsvp, Long>{
	
	@Query(value = "SELECT d.day, d.menu, r.location, SUM(r.thali_count) thali_count, SUM(r.large_thali_count) large_thali_count "+ 
					" FROM rsvp r, DAYs d WHERE r.day_id = d.day_id AND d.day >= :weekStart AND d.day <= :weekEnd "+
					" GROUP BY d.day, d.menu, r.location ORDER BY d.day, r.location"
		 , nativeQuery = true)
	List<TotalRsvp> findAllRsvpForDay(@Param("weekStart") String weekStart, @Param("weekEnd") String weekEnd);

}
