package de.ait.ksdemo.services;



import de.ait.ksdemo.dto.LessonsPage;
import de.ait.ksdemo.dto.ProfileDto;

/**
 * 05.11.2023
 * ks-demo
 *
 * @author Tatjana Dumler
 **/
public interface UsersService {

    ProfileDto getProfile(Long currentUserId);

    LessonsPage getLessonByUser(Long currentUserId);


    LessonsPage getLessonsByUser(Long currentUserId);
}
