package com.m0omoo.demo.domain;

// JPA 관련 어노테이션들을 불러
import jakarta.persistence.*;

// Lombok 어노테이션: 반복되는 코드 생성을 줄여
import lombok.*;

/**
 * User 엔티티 클래스
 * 이 클래스는 데이터베이스 테이블과 매핑되는 객체
 */
@Entity // 이 클래스가 JPA의 엔티티임을 나타냄. 즉, DB 테이블로 매핑
@Getter // Lombok: 모든 필드의 Getter 메서드를 자동 생성
@Setter // Lombok: 모든 필드의 Setter 메서드를 자동 생성
@NoArgsConstructor // Lombok: 파라미터가 없는 기본 생성자를 생성
@AllArgsConstructor // Lombok: 모든 필드를 매개변수로 받는 생성자를 생성
@Builder // Lombok: 객체를 쉽게 생성할 수 있는 빌더 패턴을 자동으로 생성
public class User {

    @Id // 이 필드가 테이블의 기본 키(PK)라는 것을 명시
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 기본 키를 DB가 자동으로 생성하게 함 (보통 AUTO_INCREMENT처럼)
    private Long id;

    @Column(nullable = false, unique = true)
    // DB 컬럼: null을 허용하지 않으며, 중복을 허용하지 않음 (이메일은 고유해야 하므로)
    private String email;

    @Column(nullable = false)
    // DB 컬럼: null을 허용하지 않음 (비밀번호는 반드시 입력되어야 함)
    private String password;

    // 닉네임은 null 가능. 특별한 제약 조건이 없기 때문에 @Column 생략
    private String nickname;
}
