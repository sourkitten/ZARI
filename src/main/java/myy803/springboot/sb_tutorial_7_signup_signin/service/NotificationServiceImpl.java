package myy803.springboot.sb_tutorial_7_signup_signin.service;

import myy803.springboot.sb_tutorial_7_signup_signin.dao.NotificationDAO;
import myy803.springboot.sb_tutorial_7_signup_signin.model.Notification;
import myy803.springboot.sb_tutorial_7_signup_signin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationDAO notificationDAO;

    @Override
    public void saveNotification(User user, String message) {
        Notification notification = new Notification();
        notification.setUser(user);
        notification.setMessage(message);
        notification.setTimestamp(new Date());
        notificationDAO.save(notification);
    }

    @Override
    public List<Notification> getNotificationsByUserId(int userId) {
        return notificationDAO.findByUserId(userId);
    }
}
