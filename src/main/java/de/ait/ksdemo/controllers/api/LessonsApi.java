package de.ait.ksdemo.controllers.api;

import de.ait.ksdemo.dto.LessonDto;
import de.ait.ksdemo.dto.LessonsPage;
import de.ait.ksdemo.dto.NewLessonDto;
import de.ait.ksdemo.security.details.AuthenticatedUser;
import de.ait.ksdemo.validation.dto.ValidationErrorsDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 05.11.2023
 * ks-demo
 *
 * @author Tatjana Dumler
 **/
@Tags(value = {
        @Tag(name = "Lessons")})
@RequestMapping("/api/lessons")
@ApiResponse(responseCode = "403", description = "Пользователь не аутентифицирован",
        content = {
                @Content(mediaType = "application/json",
                        schema = @Schema(ref = "StandardResponseDto"))
        }
)
public interface LessonsApi {

    @Operation(summary = "Получение списка всех уроков", description = "Доступно только администратору")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Страница уроков",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = LessonsPage.class))
                    }
            ),
            @ApiResponse(responseCode = "401", description = "Пользователь не авторизован",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "StandardResponseDto"))
                    }
            ),
            @ApiResponse(responseCode = "403", description = "Запрещено",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "StandardResponseDto"))
                    }
            )
    })
    @GetMapping
    ResponseEntity<LessonsPage> getAll();

    @Operation(summary = "Получение ", description = "Доступно только администратору")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lesson",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = LessonDto.class))
                    }
            ),
            @ApiResponse(responseCode = "404", description = "Не найдено",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "StandardResponseDto"))
                    }
            ),
            @ApiResponse(responseCode = "401", description = "Пользователь не авторизован",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "StandardResponseDto"))
                    }
            ),
            @ApiResponse(responseCode = "403", description = "Запрещено",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "StandardResponseDto"))
                    }
            )
    })
    @GetMapping("/{lesson-id}")
    ResponseEntity<LessonDto> getById(@Parameter(description = "идентификатор  ") @PathVariable("lesson-id") Long lessonId);


    @Operation(summary = "Удаление", description = "Доступно только администратору")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "удалена"
            ),
            @ApiResponse(responseCode = "404", description = "Не найдено",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "StandardResponseDto"))
                    }
            ),
            @ApiResponse(responseCode = "401", description = "Пользователь не авторизован",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "StandardResponseDto"))
                    }
            ),
            @ApiResponse(responseCode = "403", description = "Запрещено",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(ref = "StandardResponseDto"))
                    }
            )
    })
    @DeleteMapping("/{lesson-id}")
    void deleteLesson(@PathVariable("lesson-id") Long lessonId);

    @Operation(summary = "Добавление  ", description = "Доступно только пользователю")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Созданная  ",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = LessonDto.class))
                    }
            ),
            @ApiResponse(responseCode = "400", description = "Ошибка валидации",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ValidationErrorsDto.class))
                    })
    })
    @PostMapping
    ResponseEntity<LessonDto> addLesson(@Parameter(hidden = true) @AuthenticationPrincipal AuthenticatedUser user,
                                    @RequestBody @Valid NewLessonDto lesson);
}