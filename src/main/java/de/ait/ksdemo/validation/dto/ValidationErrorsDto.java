package de.ait.ksdemo.validation.dto;

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
@Schema(name = "ValidationErrors", description = "информация об ошибках валидации")
public class ValidationErrorsDto {

    @Schema(description = "список ошибок валидации")
    private List<ValidationErrorDto> errors;
}
