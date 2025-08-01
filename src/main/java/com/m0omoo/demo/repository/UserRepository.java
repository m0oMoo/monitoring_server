package com.m0omoo.demo.repository;

import com.m0omoo.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * User 엔티티와 관련된 데이터베이스 접근 기능 정의 인터페이스
 * Spring Data JPA에서 제공하는 JpaRepository를 상속하여 기본적인 CRUD 기능 제공
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 이메일을 기준으로 사용자 정보를 조회하는 메서드
     * 반환값은 Optional<User> 형태로, 값이 없을 경우를 안전하게 처리할 수 있음
     */
    Optional<User> findByEmail(String email);
}
