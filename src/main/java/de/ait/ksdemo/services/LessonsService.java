package de.ait.ksdemo.services;

import de.ait.ksdemo.dto.LessonDto;
import de.ait.ksdemo.dto.LessonsPage;
import de.ait.ksdemo.dto.NewLessonDto;


/**
 * 05.11.2023
 * ks-demo
 *
 * @author Tatjana Dumler
 **/
public interface LessonsService {


    LessonsPage getAll();

    LessonDto getById(Long lessonId);

    void deleteLesson(Long lessonId);

    LessonDto addLesson(Long currentUserId, NewLessonDto lesson);
}
