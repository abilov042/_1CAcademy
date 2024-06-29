package org.example._1cacademy.repository;

import org.example._1cacademy.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    List<Answer> findByQuestionId(int questionId);
}
