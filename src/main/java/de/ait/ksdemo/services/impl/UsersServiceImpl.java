package de.ait.ksdemo.services.impl;


import de.ait.ksdemo.dto.LessonsPage;
import de.ait.ksdemo.dto.ProfileDto;

import de.ait.ksdemo.models.Lesson;
import de.ait.ksdemo.models.User;
import de.ait.ksdemo.repositories.LessonsRepository;
import de.ait.ksdemo.repositories.UsersRepository;
import de.ait.ksdemo.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import static de.ait.ksdemo.dto.LessonDto.from;



/**
 * 05.11.2023
 * ks-demo
 *
 * @author Tatjana Dumler
 **/

@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final LessonsRepository lessonsRepository;

    @Override
    public ProfileDto getProfile(Long currentUserId) {
        User user = usersRepository.findById(currentUserId)
                .orElseThrow(IllegalArgumentException::new);

        return ProfileDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .role(user.getRole().name())
                .build();
    }




    @Override
    public LessonsPage getLessonByUser(Long currentUserId) {
        List<Lesson> lessons = lessonsRepository.findAllByUser_Id(currentUserId);
        return LessonsPage.builder()
                .lessons(from(lessons))
                .build();

    }

    @Override
    public LessonsPage getLessonsByUser(Long currentUserId) {
        return null;
    }
}
