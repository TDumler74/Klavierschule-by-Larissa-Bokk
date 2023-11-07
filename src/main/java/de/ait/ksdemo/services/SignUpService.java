package de.ait.ksdemo.services;


import de.ait.ksdemo.dto.NewUserDto;
import de.ait.ksdemo.dto.UserDto;

public interface SignUpService {
    UserDto signUp(NewUserDto newUser);
}
