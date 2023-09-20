package com.geupjo.koreantiger.service;

import com.geupjo.koreantiger.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentLmsService {
    private final MemberRepository memberRepository;
}
