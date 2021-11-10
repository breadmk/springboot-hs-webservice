package com.company.hs.domain.posts;

import com.company.hs.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity // 테이블과 링크될 클래스 라는 의미. 보통 SaleManager.java = > sales_manager table ||| Entity 클래스에서는 절대 setter를 생성하지 않음.
public class Posts extends BaseTimeEntity {

    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk의 생성규칙을 나타냄. {GenerationType.IDENTITY} = auto increment
    private Long id;

    @Column(length = 500,nullable = false) //굳이 선언하지 않아도 모두 컬럼이 되나, 기본값 외 변경시 필요.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title,String content,String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public void update(String title,String content){
        this.title = title;
        this.content = content;
    }
}
