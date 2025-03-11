package net.mausberg.myfinancesbackend.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime timestamp;

    @Column(precision = 10, scale = 2)
    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    private Currency currency;

    private String source;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ElementCollection
    @CollectionTable(name = "transaction_attributes", joinColumns = @JoinColumn(name = "transaction_id"))
    @MapKeyColumn(name = "attribute_key")
    @Column(name = "attribute_value")
    private Map<String, String> attributes;
}