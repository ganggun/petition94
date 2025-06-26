package com.ganggun.petition94.domain.reaction.service;

import com.ganggun.petition94.domain.petition.error.PetitionError;
import com.ganggun.petition94.domain.petition.repo.PetitionRepository;
import com.ganggun.petition94.domain.reaction.domain.Reaction;
import com.ganggun.petition94.domain.reaction.error.ReactionError;
import com.ganggun.petition94.domain.reaction.presentation.dto.ReactionReq;
import com.ganggun.petition94.domain.reaction.repo.ReactionRepository;
import com.ganggun.petition94.global.common.dto.BaseResponse;
import com.ganggun.petition94.global.exception.CustomException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
@RequiredArgsConstructor
public class ReactionService {

    private final PetitionRepository petitionRepository;
    private final ReactionRepository reactionRepository;

    public ResponseEntity<BaseResponse<String>> upvote(@RequestBody @Valid ReactionReq req, Long userId) {
        if (reactionRepository.existsByPetitionPetitionIdAndUserId(req.petitionId(), userId)) {
            throw new CustomException(ReactionError.REACTION_ALREADY_EXIST);
        }

        Reaction reaction = Reaction.builder()
                .userId(userId)
                .petition(petitionRepository.findById(req.petitionId()).orElseThrow(() -> new CustomException(PetitionError.PETITION_NOT_FOUND)))
                .type(1)
                .build();
        reactionRepository.save(reaction);
        return BaseResponse.of("개추 성공");
    }

    public void downvote(@RequestBody @Valid ReactionReq req, Long userId) {
        if (userId==null){
            System.out.println("f");
            System.out.println(userId);
        }
        if (reactionRepository.existsByPetitionPetitionIdAndUserId(req.petitionId(), userId)) {
            throw new CustomException(ReactionError.REACTION_ALREADY_EXIST);
        }


        Reaction reaction = Reaction.builder()
                .userId(userId)
                .petition(petitionRepository.getReferenceById(req.petitionId()))
                .type(-1)
                .build();
        reactionRepository.save(reaction);
    }
}
