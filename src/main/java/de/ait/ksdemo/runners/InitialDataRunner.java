package de.ait.ksdemo.runners;


import de.ait.ksdemo.models.Lesson;
import de.ait.ksdemo.models.User;
import de.ait.ksdemo.repositories.LessonsRepository;
import de.ait.ksdemo.repositories.UsersRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@RequiredArgsConstructor
@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class InitialDataRunner implements CommandLineRunner {

    UsersRepository usersRepository;

    LessonsRepository lessonsRepository;

    @Override
    public void run(String... args) {

        User alisher = null;

        if (!usersRepository.existsById(1L)) {
            User admin = User.builder()
                    .email("admin@ait-tr.de")
                    .role(User.Role.ADMIN)
                    .hashPassword("$2a$10$YijmlwvWMcfIhT2qQOQ7EeRuMiByNjPtKXa78J7Y8z7XZWJJQTDa.") // admin
                    .build();

            alisher = User.builder()
                    .email("alisher@ait-tr.de")
                    .role(User.Role.USER)
                    .hashPassword("$2a$10$RVSHTssubxIkoAl3rQ58UedU8sPMM6FZRxg1icrJg07f.MQAMRpDy") // alisher
                    .build();
            usersRepository.save(admin);
            usersRepository.save(alisher);
        }

        if (lessonsRepository.count() == 0) {
            lessonsRepository.saveAll(Arrays.asList(
                    Lesson.builder().name("Name 1").description("Description 1").user(alisher).build(),
                    Lesson.builder().name("Name 2").description("Description 2").user(alisher).build(),
                    Lesson.builder().name("Name 3").description("Description 3").user(alisher).build(),
                    Lesson.builder().name("Name 4").description("Description 4").user(alisher).build()
            ));
        }


    }
}