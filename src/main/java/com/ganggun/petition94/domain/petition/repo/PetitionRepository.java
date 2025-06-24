package com.ganggun.petition94.domain.petition.repo;

import com.ganggun.petition94.domain.petition.domain.Petition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetitionRepository extends JpaRepository<Petition, Long> {
}
