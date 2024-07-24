package org.example._1cacademy.controller;

import lombok.RequiredArgsConstructor;
import org.example._1cacademy.dto.ExerciseDto;
import org.example._1cacademy.dto.ExerciseRequestDto;
import org.example._1cacademy.dto.ExerciseResponseDto;
import org.example._1cacademy.dto.UserSaveDto;
import org.example._1cacademy.model.result.DataResult;
import org.example._1cacademy.model.result.Result;
import org.example._1cacademy.service.abstracts.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final IUserService userService;

    @PostMapping
    public ResponseEntity<Result> createUser(@RequestBody UserSaveDto userSaveDto) {
        return ResponseEntity.ok(userService.save(userSaveDto));
    }

    @PostMapping("/doExercise")
    public ResponseEntity<DataResult<ExerciseResponseDto>> doExercise(@RequestBody ExerciseRequestDto exerciseRequestsDto) {
        return ResponseEntity.ok(this.userService.doExercise(exerciseRequestsDto));
    }

}
