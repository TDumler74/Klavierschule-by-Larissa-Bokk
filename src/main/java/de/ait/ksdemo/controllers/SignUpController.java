package de.ait.ksdemo.controllers;

import de.ait.ksdemo.controllers.api.SignUpApi;
import de.ait.ksdemo.dto.NewUserDto;
import de.ait.ksdemo.dto.UserDto;
import de.ait.ksdemo.services.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * 05.11.2023
 * ks-demo
 *
 * @author Tatjana Dumler
 **/
@RequiredArgsConstructor
@RestController
public class SignUpController implements SignUpApi {

    private final SignUpService signUpService;

    @Override
    public ResponseEntity<UserDto> signUp(NewUserDto newUser) {
        return ResponseEntity
                .status(201)
                .body(signUpService.signUp(newUser));
    }
}
