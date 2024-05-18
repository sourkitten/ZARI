package myy803.springboot.sb_tutorial_7_signup_signin.dao;

import myy803.springboot.sb_tutorial_7_signup_signin.model.BookRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRequestDAO extends JpaRepository<BookRequest, Integer> {
    List<BookRequest> findByBookOfferUserId(int userId);
}