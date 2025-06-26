package com.ganggun.petition94.domain.reaction.presentation;

import com.ganggun.petition94.domain.reaction.presentation.dto.ReactionReq;
import com.ganggun.petition94.domain.reaction.service.ReactionService;
import com.ganggun.petition94.global.common.dto.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/reaction")
@RequiredArgsConstructor
public class ReactionController {

    private final ReactionService  reactionService;

    @PostMapping("/upvote")
    public ResponseEntity<BaseResponse<String>> upvote(@RequestBody ReactionReq req, @SessionAttribute(name = "userId", required = false) Long userId) {
        reactionService.upvote(req, userId);
        return BaseResponse.of("개추 성공");
    }

    @PostMapping(value = "/downvote")
    public ResponseEntity<BaseResponse<String>> downvote(@RequestBody ReactionReq req, @SessionAttribute(name = "userId", required = false) Long userId) {
        reactionService.downvote(req, userId);
        return BaseResponse.of("비추 성공");
    }
}
