package com.ganggun.petition94.domain.reaction.domain;

import com.ganggun.petition94.domain.petition.domain.Petition;
import com.ganggun.petition94.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Reaction extends BaseEntity {

    @Id
    @GeneratedValue
    private Long reactionId;

    @NotNull
    private Long userId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "petitiqon_id")
    private Petition petition;

    @NotNull
    private int type;
    // -1: 비추천
    // 1: 추천
}
