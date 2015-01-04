package hello.repo;

import hello.model.User;
import hello.model.UserDefault;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDefaultRepo extends JpaRepository<UserDefault, Long>{
}
