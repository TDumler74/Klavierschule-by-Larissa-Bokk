package de.ait.ksdemo.controllers;

import de.ait.ksdemo.controllers.api.UsersApi;
import de.ait.ksdemo.dto.LessonsPage;
import de.ait.ksdemo.dto.ProfileDto;
import de.ait.ksdemo.security.details.AuthenticatedUser;
import de.ait.ksdemo.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

/**
 * 05.11.2023
 * ks-demo
 *
 * @author Tatjana Dumler
 **/
@RestController
@RequiredArgsConstructor
public class UsersController implements UsersApi {

    private final UsersService usersService;

    @PreAuthorize("isAuthenticated()")
    @Override
    public ResponseEntity<ProfileDto> getProfile(AuthenticatedUser currentUser) {
        Long currentUserId = currentUser.getUser().getId();
        ProfileDto profile = usersService.getProfile(currentUserId);

        return ResponseEntity.ok(profile);
    }
    @PreAuthorize("hasAuthority('USER')")
    @Override
    public ResponseEntity<LessonsPage> getMyLessons(AuthenticatedUser currentUser) {
        Long currentUserId = currentUser.getUser().getId();
        return ResponseEntity.ok(usersService.getLessonByUser(currentUserId));
    }




}