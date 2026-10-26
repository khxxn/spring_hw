package com.likelion.springsession.comment.entity;

import com.likelion.springsession.post.entity.Post;
import com.likelion.springsession.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String content;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    public Comment(Post post,User author ,String content) {
        this.post = post;
        this.author = author;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        post.getComments().add(this);
    }
    @ManyToOne(fetch = FetchType.LAZY)              // ← 추가
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    public void update(String content) {
        this.content = content;
    }

    public void removeFromPost() {
        this.post.getComments().remove(this);
        this.post = null;
    }

    public boolean isAuthor(Long userId) {          // ← 추가 (과제에서 씁니다)
        return this.author.getId().equals(userId);
    }
}
