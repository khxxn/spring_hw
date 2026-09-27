package com.likelion.springsession.post.dto;

import com.likelion.springsession.post.entity.Post;
import lombok.Getter;
import lombok.RequiredArgsConstructor; //필수 인자를 받는 생성자

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor // final 필드에 대한 생성자 추가
public class PostDetailResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
}
