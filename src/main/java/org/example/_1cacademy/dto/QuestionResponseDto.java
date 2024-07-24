package org.example._1cacademy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example._1cacademy.model.enums.EQuestionType;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponseDto {
    private int id;
    private String question;
    private EQuestionType questionType;
    private List<AnswerResponseDto> answers;
}
