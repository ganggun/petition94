package com.ganggun.petition94.domain.reaction.repo;
import com.ganggun.petition94.domain.petition.domain.Petition;
import com.ganggun.petition94.domain.reaction.domain.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReactionRepository extends JpaRepository<Reaction, Long> {

}
