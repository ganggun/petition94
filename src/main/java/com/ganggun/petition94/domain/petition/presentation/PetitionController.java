package com.ganggun.petition94.domain.petition.presentation;

import com.ganggun.petition94.domain.petition.presentation.dto.PetitionReq;
import com.ganggun.petition94.domain.petition.presentation.dto.PetitionRes;
import com.ganggun.petition94.domain.petition.service.PetitionService;
import com.ganggun.petition94.global.common.dto.BaseResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/petition")
@RequiredArgsConstructor
public class PetitionController {

    private final PetitionService petitionService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<BaseResponse<PetitionRes>> getPetition(@PathVariable Long id) {
        return BaseResponse.of(petitionService.getPetition(id));
    }

    @PostMapping()
    public ResponseEntity<BaseResponse<PetitionRes>> createPetition(@RequestBody @Valid PetitionReq req) {
        return BaseResponse.of(petitionService.createPetition(req));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<String>> deletePetition(@PathVariable Long id) {
        petitionService.deletePetition(id);
        return BaseResponse.of("청원 삭제 성공");
    }
}
