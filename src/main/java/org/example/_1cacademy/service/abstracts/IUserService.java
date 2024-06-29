package org.example._1cacademy.service.abstracts;

import org.example._1cacademy.dto.ExerciseRequestDto;
import org.example._1cacademy.dto.ExerciseResponseDto;
import org.example._1cacademy.dto.UserSaveDto;
import org.example._1cacademy.model.result.DataResult;
import org.example._1cacademy.model.result.Result;

import java.util.List;

public interface IUserService {
    Result save(UserSaveDto userSaveDto);
    DataResult<ExerciseResponseDto> doExercise(List<ExerciseRequestDto> exerciseRequestDtoList);
}
