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

	// Method defined in Spring Security UserDetailsService interface
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// orElseThrow method of Optional container that throws an exception if Optional result  is null
		return userDAO.findByUsername(username).orElseThrow(
	                ()-> new UsernameNotFoundException(
	                        String.format("USER_NOT_FOUND %s", username)
	                ));
	}
	

    @Override
    public User getCurrentUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @Override
    public void updateUserProfile(User updatedUser) {
        // Retrieve the current user details
        UserDetails currentUserDetails = getCurrentUser();

        // Check if the current user details are available
        if (currentUserDetails != null) {
            // Retrieve the user entity from the database based on the username
            Optional<User> optionalUser = userDAO.findByUsername(currentUserDetails.getUsername());
            if (optionalUser.isPresent()) {
                // Update the user profile information with the provided changes
                User existingUser = optionalUser.get();
                existingUser.setFullName(updatedUser.getFullName());
                existingUser.setAddress(updatedUser.getAddress());
                existingUser.setAge(updatedUser.getAge());
                existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
                existingUser.setPreferredCategories(updatedUser.getPreferredCategories());
                existingUser.setFavoriteAuthors(updatedUser.getFavoriteAuthors());

                // Save the updated user profile information back to the database
                userDAO.save(existingUser);
            } else {
                throw new UsernameNotFoundException("User not found");
            }
        } else {
            throw new IllegalStateException("Current user details not available");
        }
    }
}
