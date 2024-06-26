package socialbookstore.domainmodel;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;

public class User implements UserDetails {

    private String username;
    private String password;
    private Role role;

    // Getters and setters for username, password, and role
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String encodedPassword) {
        this.password = encodedPassword;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    public User findById(String userName) {
    	// TODO retrieve from database, how?
    	return this;
    }
    
    // UserDetails interface methods
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(() -> "ROLE_" + role.name());
    }
    
    @Override
    public boolean isAccountNonExpired() {
        // Logic to determine if the account is non-expired
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Logic to determine if the account is non-locked
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Logic to determine if the credentials are non-expired
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Logic to determine if the user is enabled
        return true;
    }

    
}