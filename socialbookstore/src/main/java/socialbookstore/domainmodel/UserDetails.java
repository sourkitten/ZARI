package socialbookstore.domainmodel;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public interface UserDetails {

	Collection<? extends GrantedAuthority> getAuthorities();
	boolean isAccountNonExpired();
	boolean isAccountNonLocked();
	boolean isCredentialsNonExpired();
	boolean isEnabled();

}
