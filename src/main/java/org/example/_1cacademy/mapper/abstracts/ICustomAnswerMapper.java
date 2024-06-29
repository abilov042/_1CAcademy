package org.example._1cacademy.mapper.abstracts;

import org.example._1cacademy.dto.AnswerSaveDto;
import org.example._1cacademy.entity.Answer;
import org.example._1cacademy.entity.Question;

import java.util.List;

public interface ICustomAnswerMapper {
    List<Answer> answersSaveDtoToAnswers(List<AnswerSaveDto> answersSaveDto, Question question);
}
