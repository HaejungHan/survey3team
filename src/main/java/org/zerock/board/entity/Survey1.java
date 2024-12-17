package org.zerock.board.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name ="tbl_survey")
@NoArgsConstructor
public class Survey1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String question;
    @Enumerated(EnumType.STRING)
    private VisitFrequency visitFrequency;

    public Survey1(User user,VisitFrequency visitFrequency) {
        this.user = user;
        this.question = Question.도서관_사용빈도.toString();
        this.visitFrequency = visitFrequency;
    }

}
