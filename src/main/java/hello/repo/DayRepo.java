package hello.repo;

import java.util.Calendar;

import hello.model.Day;
import hello.model.User;

import org.joda.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface DayRepo extends JpaRepository<Day, Long>{
	Day findByDay(LocalDate day);
}
