package security;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import models.Cliente;
import repository.ClienteRepository;

@Component
public class ClienteSecurityServiceImpl implements UserDetailsService {

	private final ClienteRepository userRepository;

	@Autowired
	public ClienteSecurityServiceImpl(ClienteRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
		Cliente user = Optional.ofNullable(this.userRepository.findByCpf(cpf))
				.orElseThrow(() -> new UsernameNotFoundException("User not found for cpf: " + cpf));

		List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
		List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				user.isAdmin() ? authorityListAdmin : authorityListUser);
	}
}