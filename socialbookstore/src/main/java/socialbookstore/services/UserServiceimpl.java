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

    @Override
    public void saveUser(User user) {
        //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        //userDAO.save(user);
    }

    @Override
    public boolean isUserPresent(User user) {
        //return userDAO.findByUsername(user.getUsername()) != null;
    	return false;
    }

    @Override
    public User findById(String username) {
		return null;
        //return userDAO.findById(username);
    }

	@Override
	public UserDetails loadUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
