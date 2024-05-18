package myy803.springboot.sb_tutorial_7_signup_signin.dao;

import myy803.springboot.sb_tutorial_7_signup_signin.model.BookOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookOfferDAO extends JpaRepository<BookOffer, Integer> {
    List<BookOffer> findByUserId(int userId);
    List<BookOffer> findByUserIdNot(int userId);
}
