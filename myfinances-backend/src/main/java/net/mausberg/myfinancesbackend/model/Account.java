package net.mausberg.myfinancesbackend.model;

import jakarta.persistence.*;
import lombok.*;
import net.mausberg.authentication_framework_backend.model.AppUser;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Account parent;

    @OneToMany(mappedBy = "parent")
    @OrderBy("order ASC")
    private List<Account> children;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

    @Column(nullable = false)
    private Integer displayorder;
}