package net.mausberg.myfinancesbackend.repository;

import net.mausberg.myfinancesbackend.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
    // You can define word-specific query methods here if needed
}