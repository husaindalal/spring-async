package hello.repo;

import hello.model.User;
import hello.model.UserCalc;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCalcRepo  extends JpaRepository<UserCalc, Long>{

}
