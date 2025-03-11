package net.mausberg.myfinancesbackend.repository;

import net.mausberg.myfinancesbackend.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByParentOrderByDisplayOrderAsc(Account parent);
}