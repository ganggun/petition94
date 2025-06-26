package com.ganggun.petition94.domain.petition.domain;

import com.ganggun.petition94.global.common.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "petitions")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder

public class Petition extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long petitionId;

    @NotNull
    private Long authorId;

    @NotNull
    @Size(max = 50)
    private String title;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String content;
}
