package socialbookstore.service;
import org.springframework.stereotype.Service;

import socialbookstore.domainmodel.User;

@Service
public interface UserService {
    void saveUser(User user);
    boolean isUserPresent(User user);
    User findById(String username);
}
