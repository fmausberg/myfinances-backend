package net.mausberg.myfinancesbackend.service;

import net.mausberg.myfinancesbackend.model.Currency;
import net.mausberg.myfinancesbackend.model.Transaction;
import net.mausberg.myfinancesbackend.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionService transactionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTransaction() {
        Transaction transaction = new Transaction();
        transaction.setValue(BigDecimal.valueOf(-50.00));
        transaction.setTimestamp(LocalDateTime.now());
        transaction.setSource("Test");
        transaction.setCurrency(Currency.EUR);

        when(transactionRepository.save(transaction)).thenReturn(transaction);

        Transaction createdTransaction = transactionService.createTransaction(transaction);

        assertNotNull(createdTransaction);
        assertEquals(BigDecimal.valueOf(-50.00), createdTransaction.getValue());
    }

    @Test
    void testGetTransactionById() {
        Transaction transaction = new Transaction();
        transaction.setId(1L);

        when(transactionRepository.findById(1L)).thenReturn(Optional.of(transaction));

        Optional<Transaction> foundTransaction = transactionService.getTransactionById(1L);

        assertTrue(foundTransaction.isPresent());
        assertEquals(1L, foundTransaction.get().getId());
    }
}