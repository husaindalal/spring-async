package hello.repo;

import hello.model.Day;

import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DayRepo extends JpaRepository<Day, Long>{
	Day findByDay(LocalDate day);
	
	@Query("SELECT d FROM Day d WHERE d.day >= :today")
	List<Day> findDaysGreaterThan(@Param("today") LocalDate today);

	@Query("SELECT d FROM Day d WHERE d.day >= :weekStart and d.day <= :weekEnd")
	List<Day>  findDaysBetween(@Param("weekStart") LocalDate weekStart, @Param("weekEnd") LocalDate weekEnd);
}
