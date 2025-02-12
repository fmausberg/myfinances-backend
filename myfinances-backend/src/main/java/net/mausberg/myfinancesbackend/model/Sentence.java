package net.mausberg.myfinancesbackend.model;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Sentence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Date timestamp;

    @ManyToMany
    @JoinTable(
        name = "sentence_transaction",
        joinColumns = @JoinColumn(name = "sentence_id"),
        inverseJoinColumns = @JoinColumn(name = "transaction_id")
    )
    private Set<Transaction> transactions;

    @OneToMany(mappedBy = "sentence", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Word> words;
}