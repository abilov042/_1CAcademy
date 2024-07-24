package org.example._1cacademy.repository;

import org.example._1cacademy.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    List<Answer> findByQuestionId(int questionId);

    @Query("SELECT COUNT(a)  FROM Answer a where a.correct = true AND a.question.id = :questionId")
    int countTrueAnswersByQuestionId(int questionId);
}
