package socialbookstore.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import socialbookstore.config.WebSecurityConfig;
import socialbookstore.domainmodel.User;
import socialbookstore.mapper.UserMapper;

import java.util.Collections;

@Service
@Component
@Order(2)
@ComponentScan(basePackages = {"socialbookstore.mapper","socialbookstore.config"})

public class UserServiceimpl implements UserService, UserDetailsService {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userMapper.insertUser(user);
    }

    @Override
    public boolean isUserPresent(User user) {
        return userMapper.findByUsername(user.getUsername()) != null;
    }

    @Override
    public User findById(String username) {
        return userMapper.findById(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userMapper.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found for username: " + username);
        }

        // Creating SimpleGrantedAuthority correctly
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getRole());
        
        // Use Collections.singletonList to wrap the authority correctly
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.singletonList(authority) // Ensures it matches expected constructor
        );
    }
}
