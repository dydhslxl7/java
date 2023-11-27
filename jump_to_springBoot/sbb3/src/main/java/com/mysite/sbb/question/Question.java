package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.user.SiteUser;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter // 롬복의 애너테이션
@Setter // 롬복의 애너테이션
@Entity // JPA로 인식하게 만듦
public class Question {
    @Id // 고유키
    // @GeneratedValue : 자동 + 1
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Column의 세부 설정을 위해 사용
    @Column(length = 200)
    private String subject;

    // columnDefinition은 컬럼의 속성을 정의할 때 사용
    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    // Answer : Question = 1 : N
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
    
    @ManyToOne
    private SiteUser author;
    
    private LocalDateTime modifyDate;
    
    @ManyToMany
    Set<SiteUser> voter;
}