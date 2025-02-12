package net.mausberg.myfinancesbackend.service;

import net.mausberg.myfinancesbackend.model.Transaction;
import net.mausberg.myfinancesbackend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    // Create a new transaction
    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // Retrieve a transaction by ID
    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    // Retrieve all transactions
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // Update an existing transaction
    public Transaction updateTransaction(Long id, Transaction updatedTransaction) {
        return transactionRepository.findById(id)
                .map(transaction -> {
                    transaction.setTimestamp(updatedTransaction.getTimestamp());
                    transaction.setValue(updatedTransaction.getValue());
                    transaction.setCurrency(updatedTransaction.getCurrency());
                    transaction.setSource(updatedTransaction.getSource());
                    transaction.setPerson(updatedTransaction.getPerson());
                    transaction.setCompany(updatedTransaction.getCompany());
                    transaction.setAttributes(updatedTransaction.getAttributes());
                    return transactionRepository.save(transaction);
                })
                .orElseThrow(() -> new IllegalArgumentException("Transaction not found with id: " + id));
    }

    // Delete a transaction by ID
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}