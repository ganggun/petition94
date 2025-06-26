package com.ganggun.petition94.domain.reaction.presentation;

import com.ganggun.petition94.domain.reaction.presentation.dto.ReactionReq;
import com.ganggun.petition94.domain.reaction.service.ReactionService;
import com.ganggun.petition94.global.common.dto.BaseResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/reaction")
@RequiredArgsConstructor
public class ReactionController {

    private final ReactionService reactionService;

    @PostMapping("/upvote")
    public ResponseEntity<BaseResponse<String>> upvote(@RequestBody ReactionReq req) {
        return reactionService.upvote(req);
    }

    @PostMapping(value = "/downvote")
    public ResponseEntity<BaseResponse<String>> downvote(@RequestBody ReactionReq req) {
        return reactionService.downvote(req);
    }
}
