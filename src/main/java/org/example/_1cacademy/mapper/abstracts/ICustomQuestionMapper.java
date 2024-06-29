package org.example._1cacademy.mapper.abstracts;

import org.example._1cacademy.dto.QuestionSaveDto;
import org.example._1cacademy.entity.Question;

public interface ICustomQuestionMapper {
    Question questionSaveDtoToQuestion(QuestionSaveDto questionSaveDto);
}
