package com.m0omoo.demo.controller;

import com.m0omoo.demo.dto.SignUpRequest;
import com.m0omoo.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 회원 관련 HTTP 요청을 처리하는 컨트롤러 클래스
 * 클라이언트의 요청을 받아 서비스 로직을 호출한 뒤, 응답을 반환하는 역할
 */
@RestController // 해당 클래스가 REST API 요청을 처리하는 컨트롤러임을 선언
@RequiredArgsConstructor // final 필드를 자동으로 생성자 주입하는 Lombok 어노테이션
@RequestMapping("/api/v1/users") // 이 컨트롤러 내 모든 요청의 기본 경로 설정
public class UserController {

    // 회원 관련 비즈니스 로직을 처리하는 서비스 의존성
    private final UserService userService;

    /**
     * 회원가입 요청 처리 핸들러
     * HTTP POST 방식으로 /signup 경로에 들어온 요청을 처리
     * 요청 본문에는 SignUpRequest 형태의 JSON 데이터 포함
     *
     * @param request 클라이언트로부터 받은 회원가입 요청 DTO
     * @return 성공 메시지를 담은 HTTP 응답
     */
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest request) {
        userService.register(request); // 회원가입 처리 수행
        return ResponseEntity.ok("회원가입 성공"); // 성공 메시지 반환
    }
}
