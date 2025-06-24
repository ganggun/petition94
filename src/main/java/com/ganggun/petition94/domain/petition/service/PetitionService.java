package com.ganggun.petition94.domain.petition.service;

import com.ganggun.petition94.domain.petition.domain.Petition;
import com.ganggun.petition94.domain.petition.presentation.dto.PetitionReq;
import com.ganggun.petition94.domain.petition.presentation.dto.PetitionRes;
import com.ganggun.petition94.domain.petition.repo.PetitionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional(rollbackOn = Exception.class)
public class PetitionService {

    private final PetitionRepository petitionRepository;

    public PetitionRes createPetition(PetitionReq req) {
        Petition petition = Petition.builder()
                .authorId(req.authorId())
                .title(req.title())
                .content(req.content())
                .build();
        petitionRepository.save(petition);
        return PetitionRes.of(petition);
    }
}
