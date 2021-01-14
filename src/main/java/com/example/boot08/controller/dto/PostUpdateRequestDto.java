package com.example.boot08.controller.dto;

import com.example.boot08.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public PostUpdateRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
    }
}
