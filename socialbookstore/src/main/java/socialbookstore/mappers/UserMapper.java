package socialbookstore.mappers;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import socialbookstore.domainmodel.Role;

public interface UserMapper {
	
	// Getters and setters for username, password, and role
	String getUsername();

	void setUsername(String username);

	String getPassword();

	void setPassword(String encodedPassword);

	Role getRole();

	void setRole(Role role);

	// UserDetails interface methods
	Collection<? extends GrantedAuthority> getAuthorities();

	boolean isAccountNonExpired();

	boolean isAccountNonLocked();

	boolean isCredentialsNonExpired();

	boolean isEnabled();
}
