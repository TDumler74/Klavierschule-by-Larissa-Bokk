package de.ait.ksdemo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


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
@Schema(description = "Страница с занятиями")
public class LessonsPage {

    @Schema(description = "Список занятий")
    private List<LessonDto> lessons;
}