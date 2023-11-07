package de.ait.ksdemo.repositories;


import de.ait.ksdemo.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface LessonsRepository extends JpaRepository<Lesson, Long> {
        List<Lesson> findAllByUser_Id(Long userId);
}
