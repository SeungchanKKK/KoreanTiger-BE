package com.geupjo.koreantiger.service;

import com.geupjo.koreantiger.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StudentLmsService {
    private final MemberRepository memberRepository;

}
