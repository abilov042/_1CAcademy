package org.example._1cacademy.mapper.concretes;

import org.example._1cacademy.dto.AnswerSaveDto;
import org.example._1cacademy.entity.Answer;
import org.example._1cacademy.entity.Question;
import org.example._1cacademy.mapper.abstracts.ICustomAnswerMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAnswerMapper implements ICustomAnswerMapper {
    @Override
    public List<Answer> answersSaveDtoToAnswers(List<AnswerSaveDto> answersSaveDto, Question question) {
        List<Answer> answers = new ArrayList<>();
        for (AnswerSaveDto answerSaveDto : answersSaveDto) {
            Answer answer = new Answer();
            answer.setAnswer(answerSaveDto.getAnswer());
            answer.setCorrect(answerSaveDto.isCorrect());
            answer.setQuestion(question);
            answers.add(answer);
        }
        return answers;
    }
}
