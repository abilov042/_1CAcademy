package org.example._1cacademy.service.concretes;

import lombok.RequiredArgsConstructor;
import org.example._1cacademy.dto.ExerciseRequestDto;
import org.example._1cacademy.dto.ExerciseResponseDto;
import org.example._1cacademy.dto.UserSaveDto;
import org.example._1cacademy.entity.Answer;
import org.example._1cacademy.entity.Question;
import org.example._1cacademy.entity.User;
import org.example._1cacademy.mapper.abstracts.ICustomUserMapper;
import org.example._1cacademy.model.result.DataResult;
import org.example._1cacademy.model.result.Result;
import org.example._1cacademy.model.result.SuccessDataResult;
import org.example._1cacademy.model.result.SuccessResult;
import org.example._1cacademy.repository.AnswerRepository;
import org.example._1cacademy.repository.QuestionRepository;
import org.example._1cacademy.repository.UserRepository;
import org.example._1cacademy.service.abstracts.IUserService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final ICustomUserMapper iCustomUserMapper;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    @Override
    public Result save(UserSaveDto userSaveDto) {
        User user = this.iCustomUserMapper.userSaveDtoToUser(userSaveDto);
        this.userRepository.save(user);
        return new SuccessResult("User saved successfully");
    }

    @Override
    public DataResult<ExerciseResponseDto> doExercise(List<ExerciseRequestDto> exerciseRequestDtoList) {
        BigDecimal totalPoints = BigDecimal.ZERO;
        for (ExerciseRequestDto exerciseRequestDto : exerciseRequestDtoList) {
            Question question = this.questionRepository.findById(exerciseRequestDto.getQuestionId()).orElse(null);
            assert question != null;
            BigDecimal point = new BigDecimal(String.valueOf(new BigDecimal("1").divide(new BigDecimal(question.getCountTrueAnswers()))));
            for (Integer answerId : exerciseRequestDto.getAnswerIds()) {
                Answer answer = this.answerRepository.findById(answerId).orElse(null);
                assert answer != null;
                if(answer.isCorrect()){
                    totalPoints = totalPoints.add(point);
                }
            }
        }
        ExerciseResponseDto exerciseResponseDto = new ExerciseResponseDto();
        exerciseResponseDto.setMessage("Salam");
        exerciseResponseDto.setScore(totalPoints);
        return new SuccessDataResult<>(exerciseResponseDto, "success");
    }
}
