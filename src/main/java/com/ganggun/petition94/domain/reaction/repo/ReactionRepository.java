package com.ganggun.petition94.domain.reaction.repo;
import com.ganggun.petition94.domain.reaction.domain.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactionRepository extends JpaRepository<Reaction, Long> {
    boolean existsByPetitionPetitionIdAndUserId(Long petitionId, Long userId);
}
