package org.example._1cacademy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponseDto {
    private int id;
    private String question;
    private int countTrueQuestions;
    private List<AnswerResponseDto> answers;
}
