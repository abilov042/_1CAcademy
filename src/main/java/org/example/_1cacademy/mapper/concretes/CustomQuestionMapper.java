package org.example._1cacademy.mapper.concretes;

import org.example._1cacademy.dto.QuestionSaveDto;
import org.example._1cacademy.entity.Question;
import org.example._1cacademy.mapper.abstracts.ICustomQuestionMapper;
import org.example._1cacademy.model.enums.EQuestionType;
import org.springframework.stereotype.Component;

@Component
public class CustomQuestionMapper implements ICustomQuestionMapper {
    @Override
    public Question questionSaveDtoToQuestion(QuestionSaveDto questionSaveDto) {
        Question question = new Question();
        question.setQuestion(questionSaveDto.getQuestion());

        switch (questionSaveDto.getQuestionType()) {
            case "single": question.setQuestionType(EQuestionType.SINGLE_ANSWER);
            case "multiple": question.setQuestionType(EQuestionType.MULTIPLE_ANSWER);
        }
        return question;
    }
}
