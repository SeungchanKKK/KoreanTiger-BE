package com.geupjo.koreantiger.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    LOGIN_INVALID("로그인 정보가 잘못되었습니다.", 100),
    PASSWORD_INVALID("비밀번호가 잘못되었습니다.", 101);

    private final String message;
    private final int code;
}
