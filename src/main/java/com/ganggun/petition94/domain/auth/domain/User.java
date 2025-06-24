package com.ganggun.petition94.domain.auth.domain;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String nickname;

    // 생략 가능: posts, reactions 양방향 매핑
}
