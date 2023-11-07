package de.ait.ksdemo.controllers;


import de.ait.ksdemo.controllers.api.LessonsApi;
import de.ait.ksdemo.dto.LessonDto;
import de.ait.ksdemo.dto.LessonsPage;
import de.ait.ksdemo.dto.NewLessonDto;
import de.ait.ksdemo.security.details.AuthenticatedUser;
import de.ait.ksdemo.services.LessonsService;
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
@RequiredArgsConstructor
@RestController
public class LessonsController implements LessonsApi {

    private final LessonsService lessonsService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @Override
    public ResponseEntity<LessonsPage> getAll() {
        return ResponseEntity
                .ok(lessonsService.getAll());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Override
    public ResponseEntity<LessonDto> getById(Long lessonId) {
        return ResponseEntity.ok(lessonsService.getById(lessonId));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Override
    public void deleteLesson(Long lessonId) {
        lessonsService.deleteLesson(lessonId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @Override
    public ResponseEntity<LessonDto> addLesson(AuthenticatedUser authenticatedUser, NewLessonDto lesson) {
        Long currentUserId = authenticatedUser.getUser().getId();
        return ResponseEntity.status(201)
                .body(lessonsService.addLesson(currentUserId, lesson));
    }
}