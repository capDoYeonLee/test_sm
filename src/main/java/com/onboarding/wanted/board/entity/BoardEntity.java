package com.onboarding.wanted.board.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "board")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;
    private Long writerId;
    private String title;
    private String content;
    private Timestamp createdDate;
    private Timestamp updatedDate;

    @Builder
    public BoardEntity(Long boardId, Long writerId, String title, String content) {
        this.boardId = boardId;
        this.writerId = writerId;
        this.title = title;
        this.content = content;
        this.createdDate = new Timestamp(System.currentTimeMillis());
    }
}