package hello.config;

//import java.util.Collection;
//import java.util.List;
//
//import hello.model.Role;
//import hello.model.User;
//import hello.repo.UserRepo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;

//@Service
public class CustomUserDetailsService { 
//	implements UserDetailsService {
//
//
//	private UserRepo repo;
//
//	@Autowired
//	public CustomUserDetailsService(UserRepo repo) {
//		this.repo = repo;
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = repo.findByName(username);
//		if (user == null) {
//			return null;
//		}
//		
//		StringBuffer rolesBuf = new StringBuffer();
//		for(Role role : user.getRoles()) {
//			rolesBuf.append(role.getRole()).append(",") ;
//		}
//		List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList(rolesBuf.toString());
//		
//		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), auth);
//	}

}
