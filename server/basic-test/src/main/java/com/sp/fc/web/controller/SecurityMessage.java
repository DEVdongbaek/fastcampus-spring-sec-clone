package com.sp.fc.web.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.Authentication;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SecurityMessage {
    // 접근한 유저의 권한과 해당 페이지를 설명하는 메시지
    private Authentication auth;
    private String message;

}
