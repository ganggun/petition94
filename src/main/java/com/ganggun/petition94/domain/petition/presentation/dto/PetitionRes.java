package com.ganggun.petition94.domain.petition.presentation.dto;

import com.ganggun.petition94.domain.petition.domain.Petition;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public record PetitionRes(
    Long authorId,
    String title,
    String content,
    LocalDateTime createdAt
) {
    public static PetitionRes of(Petition petition) {
        return new PetitionRes(petition.getAuthorId(), petition.getTitle(), petition.getContent(), petition.getCreatedAt());
    }
}
