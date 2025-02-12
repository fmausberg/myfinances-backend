package net.mausberg.myfinancesbackend.service;

import net.mausberg.myfinancesbackend.model.Account;
import net.mausberg.myfinancesbackend.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // Create a new account
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    // Retrieve an account by ID
    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    // Retrieve all accounts
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Retrieve accounts by parent in order
    public List<Account> getAccountsByParent(Account parent) {
        return accountRepository.findByParentOrderByDisplayOrderAsc(parent);
    }

    // Update an existing account
    public Account updateAccount(Long id, Account updatedAccount) {
        return accountRepository.findById(id)
                .map(account -> {
                    account.setName(updatedAccount.getName());
                    account.setDescription(updatedAccount.getDescription());
                    account.setType(updatedAccount.getType());
                    account.setParent(updatedAccount.getParent());
                    account.setChildren(updatedAccount.getChildren());
                    account.setUser(updatedAccount.getUser());
                    account.setDisplayOrder(updatedAccount.getDisplayOrder());
                    return accountRepository.save(account);
                })
                .orElseThrow(() -> new IllegalArgumentException("Account not found with id: " + id));
    }

    // Delete an account by ID
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}