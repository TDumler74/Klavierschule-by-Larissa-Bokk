package de.ait.ksdemo.dto;

import de.ait.ksdemo.validation.constraints.DayOfWeek;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * 05.11.2023
 * ks-demo
 *
 * @author Tatjana Dumler
 **/
@Data
public class NewLessonDto {

    @Schema(description = "Идентификатор существующего урока, если задано - остальные поля указывать не нужно")
    private Long existsLessonId;

    @NotNull
    private String name;

    @NotEmpty
    @NotBlank
    private String startTime;

    @NotEmpty
    @NotBlank
    private String finishTime;

    @NotEmpty
    @NotBlank
    @DayOfWeek
    private String dayOfWeek; // мы хотим, чтобы сюда передавали корректный день недели
}
