package org.example._1cacademy.mapper.concretes;

import org.example._1cacademy.dto.QuestionSaveDto;
import org.example._1cacademy.entity.Question;
import org.example._1cacademy.mapper.abstracts.ICustomQuestionMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomQuestionMapper implements ICustomQuestionMapper {
    @Override
    public Question questionSaveDtoToQuestion(QuestionSaveDto questionSaveDto) {
        Question question = new Question();
        question.setQuestion(questionSaveDto.getQuestion());
        question.setCountTrueAnswers(questionSaveDto.getCountTrueAnswers());
        return question;
    }
}
