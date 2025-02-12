package net.mausberg.myfinancesbackend.repository;

import net.mausberg.myfinancesbackend.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    // You can define company-specific query methods here if needed
}
