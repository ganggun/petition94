package com.ganggun.petition94.domain.reaction.presentation.dto;

import com.ganggun.petition94.domain.petition.domain.Petition;
import com.ganggun.petition94.domain.reaction.domain.Reaction;

public record ReactionRes(
        Long userId,
        Long petitionId,
        int type
) {
    public static ReactionRes of(Reaction reaction) {
        return new ReactionRes(reaction.getUserId(), reaction.getPetition().getPetitionId(), reaction.getType());
    }
}
