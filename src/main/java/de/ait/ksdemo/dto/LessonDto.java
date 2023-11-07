package de.ait.ksdemo.dto;

import de.ait.ksdemo.models.Lesson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 05.11.2023
 * ks-demo
 *
 * @author Tatjana Dumler
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonDto {

    private Long id;
    private String name;
    private String description;
    private String startTime;
    private String finishTime;
    private String dayOfWeek;
    private Long lessonId;

    public static LessonDto from(Lesson lesson) {
        return  LessonDto.builder()
                .id(lesson.getId())
                .name(lesson.getName())
                .description(lesson.getDescription())
                .startTime(lesson.getStartTime().toString())
                .finishTime(lesson.getFinishTime().toString())
                .dayOfWeek(lesson.getDayOfWeek().toString())
                .build();


    }

    public static List<LessonDto> from(List<Lesson> lessons) {
        return lessons.stream()
                .map(LessonDto::from)
                .collect(Collectors.toList());
    }
}
