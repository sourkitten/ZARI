package myy803.springboot.sb_tutorial_7_signup_signin.dao;

import myy803.springboot.sb_tutorial_7_signup_signin.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestDAO extends JpaRepository<Request, Integer> {
    List<Request> findByBookOfferId(int bookOfferId);
}
