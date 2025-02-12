package net.mausberg.myfinancesbackend.repository;

import net.mausberg.myfinancesbackend.model.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
    // Common repository methods can go here
}
