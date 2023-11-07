package de.ait.ksdemo.services.impl;

import de.ait.ksdemo.dto.LessonDto;
import de.ait.ksdemo.dto.LessonsPage;
import de.ait.ksdemo.dto.NewLessonDto;
import de.ait.ksdemo.exceptions.RestException;
import de.ait.ksdemo.models.Lesson;
import de.ait.ksdemo.models.User;
import de.ait.ksdemo.repositories.LessonsRepository;
import de.ait.ksdemo.repositories.UsersRepository;
import de.ait.ksdemo.services.LessonsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static de.ait.ksdemo.dto.LessonDto.from;

/**
 * 05.11.2023
 * ks-demo
 *
 * @author Tatjana Dumler
 **/
@RequiredArgsConstructor
@Service
public class LessonsServiceImpl implements LessonsService {

    private final LessonsRepository lessonsRepository;

    private final UsersRepository usersRepository;


    @Override
    public LessonsPage getAll() {
        return LessonsPage.builder()
                .lessons(from(lessonsRepository.findAll()))
                .build();
    }

    @Override
    public LessonDto getById(Long lessonId) {
        Lesson lesson = lessonsRepository.findById(lessonId).orElseThrow(
                () -> new RestException(HttpStatus.NOT_FOUND, "Задача <" + lessonId + "> не найдена"));

        return from(lesson);
    }

    @Override
    public void deleteLesson(Long lessonId) {
        if (lessonsRepository.existsById(lessonId)) {
            lessonsRepository.deleteById(lessonId);
        } else {
            throw new RestException(HttpStatus.NOT_FOUND, "Задача <" + lessonId + "> не найдена");
        }
    }

    @Override
    public LessonDto addLesson(Long currentUserId, NewLessonDto lesson) {
        User user = usersRepository.findById(currentUserId)
                .orElseThrow(() -> new RestException(HttpStatus.NOT_FOUND, "Пользователь <" + currentUserId + "> не найден"));

        Lesson newLesson = Lesson.builder()
                .name(lesson.getName())
                .user(user)
                .build();

        lessonsRepository.save(newLesson);

        return from(newLesson);
    }
}
