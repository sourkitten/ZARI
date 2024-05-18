package myy803.springboot.sb_tutorial_7_signup_signin.service;

import myy803.springboot.sb_tutorial_7_signup_signin.model.Notification;
import myy803.springboot.sb_tutorial_7_signup_signin.model.User;

import java.util.List;

public interface NotificationService {
    void saveNotification(User user, String message);
    List<Notification> getNotificationsByUserId(int userId);
}
