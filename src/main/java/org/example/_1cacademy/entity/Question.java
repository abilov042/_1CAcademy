package org.example._1cacademy.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "questions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "question")
    private String question;

    @Column(name = "count_true_answers")
    private int countTrueAnswers;

}
