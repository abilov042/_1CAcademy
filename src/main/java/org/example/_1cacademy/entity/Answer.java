package org.example._1cacademy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "answer")
    private String answer;

    @Column(name = "correct")
    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
