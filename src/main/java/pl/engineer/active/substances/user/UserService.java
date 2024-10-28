package pl.tanielazienki.tanielazienki.user;

import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.tanielazienki.tanielazienki.entity.UserEntity;
import pl.tanielazienki.tanielazienki.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(UserRegistrationDTO userRegisterationDto) {
        userRepository.saveAndFlush(
                new UserEntity()
                        .setUsername(userRegisterationDto.getUsername())
                        .setPassword(passwordEncoder.encode(userRegisterationDto.getPassword())));
    }
}