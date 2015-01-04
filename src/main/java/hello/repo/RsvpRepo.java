package hello.repo;

import hello.model.Rsvp;
import hello.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface RsvpRepo extends JpaRepository<Rsvp, Long>{
	//User findByName(String name);
}
