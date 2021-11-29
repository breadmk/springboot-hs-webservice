package com.company.hs.web.dto;

import com.company.hs.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;
    private int hit;

    @Builder
    public PostsSaveRequestDto(String title,String content,String author,int hit){
        this.title = title;
        this.content = content;
        this.author = author;
        this.hit = hit;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .hit(hit)
                .build();
    }
}
