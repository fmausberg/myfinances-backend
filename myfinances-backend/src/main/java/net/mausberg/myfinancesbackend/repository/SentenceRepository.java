package net.mausberg.myfinancesbackend.repository;

import net.mausberg.myfinancesbackend.model.Sentence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SentenceRepository extends JpaRepository<Sentence, Long> {
    // You can define sentence-specific query methods here if needed
}