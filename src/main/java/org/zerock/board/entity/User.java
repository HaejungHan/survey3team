package org.zerock.board.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name ="tbl_user")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Status status;  // 학부생/기타 (Enum)

    @Enumerated(EnumType.STRING)
    private Major major;  // 전공 (Enum)

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Survey1 survey1;

    public User (Status status, Major major) {
        this.status = status;
        this.major = major;
    }


}