package com.sp.fc.web.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String index(){
        return "homePage";
    }

    // 사용자가 어떤 권한으로 접근했는지를 확인하는 메서드
    @RequestMapping("/auth")
    public Authentication authentication(){
        return SecurityContextHolder.getContext()
                .getAuthentication();
    }

    // 개인정보에 해당하는 resource를 핸들링

    // @PreAuthorize는 hasAuthority 메서드를 통해 해당 권한이 있는 유저만 접근을 가능케 합니다.
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @RequestMapping("/user")
    public SecurityMessage user() {
        return SecurityMessage.builder()
                .auth(SecurityContextHolder.getContext().getAuthentication())
                .message("User 정보")
                .build();
    }

    // @PreAuthorize는 hasAuthority 메서드를 통해 해당 권한이 있는 유저만 접근을 가능케 합니다.
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping("/admin")
    public SecurityMessage admin() {
        return SecurityMessage.builder()
                .auth(SecurityContextHolder.getContext().getAuthentication())
                .message("Admin 정보")
                .build();
    }

}
