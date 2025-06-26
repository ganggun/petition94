package com.ganggun.petition94.domain.petition.repo;

import com.ganggun.petition94.domain.petition.domain.Petition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Period;
import java.util.List;
import java.util.Optional;

public interface PetitionRepository extends JpaRepository<Petition, Long> {
    @Query(value = """
    SELECT reaction.petition_id FROM reaction WHERE reaction.type = 1 GROUP BY reaction.petition_id HAVING COUNT(*) >= 10
    """, nativeQuery = true)
    List<Long> findPetitionIdsWithAtLeastTenPositiveReactions();
}
