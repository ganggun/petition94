package com.ganggun.petition94.domain.petition.service;

import com.ganggun.petition94.domain.petition.domain.Petition;
import com.ganggun.petition94.domain.petition.error.PetitionError;
import com.ganggun.petition94.domain.petition.presentation.dto.PetitionReq;
import com.ganggun.petition94.domain.petition.presentation.dto.PetitionRes;
import com.ganggun.petition94.domain.petition.repo.PetitionRepository;
import com.ganggun.petition94.global.exception.CustomException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackOn = Exception.class)
public class PetitionService {

    private final PetitionRepository petitionRepository;

    public PetitionRes getPetition(Long id) {
        Petition petition = petitionRepository.findById(id)
                .orElseThrow(() -> new CustomException(PetitionError.PETITION_NOT_FOUND));
        return PetitionRes.of(petition);
    }

    public PetitionRes createPetition(PetitionReq req) {
        Petition petition = Petition.builder()
                .authorId(req.authorId())
                .title(req.title())
                .content(req.content())
                .build();
        petitionRepository.save(petition);
        return PetitionRes.of(petition);
    }

    public void deletePetition(Long id) {
        Petition petition = petitionRepository.findById(id).orElseThrow(() -> new CustomException(PetitionError.PETITION_NOT_FOUND));
        petitionRepository.delete(petition);
    }
}
