package pl.tanielazienki.tanielazienki.config;

import jakarta.transaction.Transactional;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.tanielazienki.tanielazienki.user.UserEntity;
import pl.tanielazienki.tanielazienki.user.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserEntity> userEntityOptional = userRepository.findByUsername(username);

        if (userEntityOptional.isEmpty()) {
            throw new UsernameNotFoundException("Benutzer konnte nicht gefunden werden");
        }

        UserEntity user = userEntityOptional.get();

        // ROLE_ADMIN ..
        List<SimpleGrantedAuthority> roles =
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName())).toList();

        return new User(username, user.getPassword(), roles);
    }
}