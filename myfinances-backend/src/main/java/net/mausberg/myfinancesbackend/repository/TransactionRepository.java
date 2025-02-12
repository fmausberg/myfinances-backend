package net.mausberg.myfinancesbackend.repository;

import net.mausberg.myfinancesbackend.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // You can define transaction-specific query methods here if needed
}