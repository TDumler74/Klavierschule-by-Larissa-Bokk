package de.ait.ksdemo.services.impl;


import de.ait.ksdemo.dto.NewUserDto;
import de.ait.ksdemo.dto.UserDto;
import de.ait.ksdemo.models.User;
import de.ait.ksdemo.repositories.UsersRepository;
import de.ait.ksdemo.services.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import static de.ait.ksdemo.dto.UserDto.from;
/**
 * 05.11.2023
 * ks-demo
 *
 * @author Tatjana Dumler
 **/
@RequiredArgsConstructor
@Service
public class SignUpServiceImpl implements SignUpService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto signUp(NewUserDto newUser) {

        User user = User.builder()
                .email(newUser.getEmail())
                .hashPassword(passwordEncoder.encode(newUser.getPassword()))
                .role(User.Role.USER)
                .build();

        usersRepository.save(user);

        return from(user);
    }
}
