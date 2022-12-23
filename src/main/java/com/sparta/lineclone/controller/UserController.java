package com.sparta.lineclone.controller;

import com.sparta.lineclone.dto.LoginRequestDto;
import com.sparta.lineclone.dto.MsgResponseDto;
import com.sparta.lineclone.dto.SignupRequestDto;
import com.sparta.lineclone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<MsgResponseDto> signup(@Valid @RequestBody SignupRequestDto signupRequestDto) {   //(@RequestBody @Valid SignupRequestDto signupRequestDto)?
        userService.signup(signupRequestDto);
        return ResponseEntity.ok(new MsgResponseDto("회원가입 완료", HttpStatus.OK.value()));
    }

    @ResponseBody
    @PostMapping("/login")
    public ResponseEntity<MsgResponseDto> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        userService.login(loginRequestDto, response);
        return ResponseEntity.ok(new MsgResponseDto("로그인 완료",HttpStatus.OK.value()));
    }
}