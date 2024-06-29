package org.example._1cacademy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseResponseDto {
    private String message;
    private BigDecimal score;
}
