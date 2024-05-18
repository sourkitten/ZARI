package myy803.springboot.sb_tutorial_7_signup_signin.dao;

import myy803.springboot.sb_tutorial_7_signup_signin.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationDAO extends JpaRepository<Notification, Integer> {
    List<Notification> findByUserId(int userId);
}
