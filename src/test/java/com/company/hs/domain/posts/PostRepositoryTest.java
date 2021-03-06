package com.company.hs.domain.posts;

import org.apache.tomcat.jni.Local;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest  //H2  데이터베이스 자동 실행.
public class PostRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After  // 단위테스트 끝날때마다 수행되는 메소드
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()  //  postsRepository.save 테이블 posts에 insert/update 쿼리 실행 || id 값이 있다면 update _ id 값이 없다면 insert
                .title(title)
                .content(content)
                .author("minvita9999@naver.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();  // posts 테이블에 있는 모든 데이터 조회

        //then
        Posts post = postsList.get(0);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록(){
        //given
        LocalDateTime now = LocalDateTime.of(2021,11,10,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>>>> createDate"+posts.getCreatedDate()+", modifiedDate="+posts.getModifiedDate());
        System.out.println(">>>>>>>>>>>> now"+now);

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
