package myy803.springboot.sb_tutorial_7_signup_signin.service;

import myy803.springboot.sb_tutorial_7_signup_signin.model.User;

public interface UserService {
    void saveUser(User user);
    boolean isUserPresent(User user);
    User getCurrentUser();
    void updateUserProfile(User updatedUser);
    
}
