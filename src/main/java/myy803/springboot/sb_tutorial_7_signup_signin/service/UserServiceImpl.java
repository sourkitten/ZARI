package myy803.springboot.sb_tutorial_7_signup_signin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import myy803.springboot.sb_tutorial_7_signup_signin.dao.UserDAO;
import myy803.springboot.sb_tutorial_7_signup_signin.model.User;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserDAO userDAO;

    @Override
    public void saveUser(User user) {
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userDAO.save(user);
    }

    @Override
    public boolean isUserPresent(User user) {
        Optional<User> storedUser = userDAO.findByUsername(user.getUsername());
        return storedUser.isPresent();
    }

    @Override
    public User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userDAO.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public void updateUserProfile(User updatedUser) {
        User currentUser = getCurrentUser();
        Optional<User> optionalUser = userDAO.findByUsername(currentUser.getUsername());
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setFullName(updatedUser.getFullName());
            existingUser.setAddress(updatedUser.getAddress());
            existingUser.setAge(updatedUser.getAge());
            existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
            existingUser.setPreferredCategories(updatedUser.getPreferredCategories());
            existingUser.setFavoriteAuthors(updatedUser.getFavoriteAuthors());
            System.out.println("Saving categories: " + updatedUser.getPreferredCategories()); // Debug print
            userDAO.save(existingUser);
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userDAO.findByUsername(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        return user.get();
    }
}
