package net.mausberg.myfinancesbackend.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Entity
public class Company {
	
	private String name;
	private LocalDate dob;
	private String mail;
	
}
