package socialbookstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import socialbookstore.domainmodel.User;
import socialbookstore.mappers.UserMapper;

@Service
public class UserServiceimpl implements UserService,UserDetailsService{
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserMapper userDAO;  // Assuming UserMapper is an interface for data access
    
    // TODO this doesn't update the database. Where update?
    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDAO.setUsername(user.getUsername());
        userDAO.setRole(user.getRole());
        userDAO.setPassword(user.getPassword());
    }

    @Override
    public boolean isUserPresent(User user) {
        //return userDAO.findByUsername(user.getUsername()) != null;
    	return false;
    }

    // TODO How actually pull data?
    @Override
    public User findById(String username) {
        return userDAO.findById(username);
    }

	@Override
	public UserDetails loadUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
