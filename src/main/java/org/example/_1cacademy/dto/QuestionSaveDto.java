package org.example._1cacademy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionSaveDto {
    private String question;
    private String questionType;
    private List<AnswerSaveDto> answersSaveDto;
}
