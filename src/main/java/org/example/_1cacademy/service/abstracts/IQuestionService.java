package org.example._1cacademy.service.abstracts;

import org.example._1cacademy.dto.QuestionResponseDto;
import org.example._1cacademy.dto.QuestionSaveDto;
import org.example._1cacademy.model.result.DataResult;
import org.example._1cacademy.model.result.Result;

import java.util.List;

public interface IQuestionService {
    Result saveQuestion(QuestionSaveDto  questionSaveDto);
    DataResult<List<QuestionResponseDto>> getAllQuestions();
}
