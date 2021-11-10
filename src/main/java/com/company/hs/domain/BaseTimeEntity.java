package com.company.hs.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass  // JPA Entity 클래스들이 BaseTumeEntity를 상속할 경우 필드와 칼럼을 인식하도록 처리.
@EntityListeners(AuditingEntityListener.class) // Auditing 기능 포함 (Audit은 감시하다, 감사하다라는 뜻으로 Spring Data JPA에서 시간에 대해서 자동으로 값을 넣어주는 기능)
public class BaseTimeEntity {

    @CreatedDate  //Entity가 생성되어 저장될때 시간이 자동 저장.
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회한 Entity의 값이 변경될때 시간이 자동 저장.
    private LocalDateTime modifiedDate;
}
