package hello.repo;

import hello.model.UserDefaults;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDefaultsRepo extends JpaRepository<UserDefaults, Long>{
	
	@Query(nativeQuery = true, value = "SELECT d.* FROM user_defaults d WHERE d.user_id = :currentUserId ")
	UserDefaults findByUserId(@Param("currentUserId") Long currentUserId);
}