package net.mausberg.myfinancesbackend.repository;

import net.mausberg.myfinancesbackend.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    // You can define person-specific query methods here if needed
}
