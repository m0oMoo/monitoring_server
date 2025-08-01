package com.m0omoo.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
/**
 * 회원가입 요청 데이터를 담는 DTO 클래스
 * 클라이언트가 전달한 이메일, 비밀번호, 닉네임 정보를 담는 용도
 * 컨트롤러 → 서비스로 데이터를 전달할 때 사용하는 중간 객체
 */
@Getter // 각 필드에 대한 Getter 메서드 자동 생성 (예: getEmail())
@Setter // 각 필드에 대한 Setter 메서드 자동 생성 (예: setEmail())
public class SignUpRequest {

    // 사용자 이메일 정보
    @NotBlank(message = "이메일은 필수 입력입니다.")
    @Email(message = "올바른 이메일 형식이 아닙니다.")
    private String email;

    // 사용자 비밀번호 정보
    @NotBlank(message = "비밀번호는 필수 입력입니다.")
    private String password;

    // 사용자 닉네임 정보
    @NotBlank(message = "닉네임은 필수 입력입니다.")
    private String nickname;
}
