package org.example._1cacademy.service.concretes;

import lombok.RequiredArgsConstructor;
import org.example._1cacademy.dto.AnswerResponseDto;
import org.example._1cacademy.dto.QuestionResponseDto;
import org.example._1cacademy.dto.QuestionSaveDto;
import org.example._1cacademy.entity.Answer;
import org.example._1cacademy.entity.Question;
import org.example._1cacademy.mapper.abstracts.ICustomAnswerMapper;
import org.example._1cacademy.mapper.abstracts.ICustomQuestionMapper;
import org.example._1cacademy.model.result.DataResult;
import org.example._1cacademy.model.result.Result;
import org.example._1cacademy.model.result.SuccessDataResult;
import org.example._1cacademy.model.result.SuccessResult;
import org.example._1cacademy.repository.AnswerRepository;
import org.example._1cacademy.repository.QuestionRepository;
import org.example._1cacademy.service.abstracts.IQuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService implements IQuestionService {
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final ICustomQuestionMapper customQuestionMapper;
    private final ICustomAnswerMapper customAnswerMapper;

    @Override
    public Result saveQuestion(QuestionSaveDto questionSaveDto) {
        Question question = customQuestionMapper.questionSaveDtoToQuestion(questionSaveDto);
        List<Answer> answers = customAnswerMapper.answersSaveDtoToAnswers(questionSaveDto.getAnswersSaveDto(), question);
        this.questionRepository.save(question);
        this.answerRepository.saveAll(answers);
        return new SuccessResult("Question saved successfully");
    }

    @Override
    public DataResult<List<QuestionResponseDto>> getAllQuestions() {
        List<Question> questions = questionRepository.findAll();
        List<QuestionResponseDto> questionResponsesDto = new ArrayList<>();
        for (Question question : questions) {
            QuestionResponseDto questionResponseDto = new QuestionResponseDto();
            questionResponseDto.setId(question.getId());
            questionResponseDto.setQuestion(question.getQuestion());
            questionResponseDto.setCountTrueQuestions(question.getCountTrueAnswers());


            List<AnswerResponseDto> answerResponsesDto = new ArrayList<>();
            for (Answer answer : answerRepository.findByQuestionId(question.getId())){
                AnswerResponseDto answerResponseDto = new AnswerResponseDto();
                answerResponseDto.setId(answer.getId());
                answerResponseDto.setAnswer(answer.getAnswer());
                answerResponsesDto.add(answerResponseDto);
            }
            questionResponseDto.setAnswers(answerResponsesDto);
            questionResponsesDto.add(questionResponseDto);
        }
        return new SuccessDataResult<>(questionResponsesDto, "Questions found");
    }
}
