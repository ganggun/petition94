package com.ganggun.petition94.domain.petition.presentation.dto;

import com.ganggun.petition94.domain.petition.domain.Petition;

import java.time.LocalDateTime;

public record PetitionReq(
    Long authorId,
    String title,
    String content
) {
}
