package com.ganggun.petition94.domain.petition.presentation.dto;

import com.ganggun.petition94.domain.petition.domain.Petition;

public record PetitionRes(
        Long authorId,
        String title,
        String content
) {
    public static PetitionRes of(Petition petition) {
        return new PetitionRes(petition.getAuthorId(), petition.getTitle(), petition.getContent());
    }
}
