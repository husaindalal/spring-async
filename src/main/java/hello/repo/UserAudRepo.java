package hello.repo;

import hello.model.UserAud;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAudRepo extends JpaRepository<UserAud, Long> {

}
