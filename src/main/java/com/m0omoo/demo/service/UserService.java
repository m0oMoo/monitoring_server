package com.m0omoo.demo.service;

import com.m0omoo.demo.domain.User;
import com.m0omoo.demo.dto.SignUpRequest;
import com.m0omoo.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 사용자 관련 비즈니스 로직을 처리하는 서비스 클래스
 * 회원가입 로직을 중심으로 구현
 */
@Service
@RequiredArgsConstructor
public class UserService {

    // User 엔티티에 접근하기 위한 JPA 리포지토리 의존성 주입
    private final UserRepository userRepository;

    /**
     * 회원가입 처리 로직
     * 이메일 중복 여부 확인 후 사용자 엔티티 저장
     */
    public void register(SignUpRequest dto) {
        // 이메일 중복 여부 확인
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 이메일");
        }

        // 전달받은 DTO를 기반으로 User 엔티티 생성
        User user = User.builder()
                .email(dto.getEmail())
                .password(dto.getPassword()) // 추후 비밀번호 암호화 필요
                .nickname(dto.getNickname())
                .build();

        // DB에 사용자 정보 저장
        userRepository.save(user);
    }
}
