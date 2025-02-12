package net.mausberg.myfinancesbackend.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person extends Partner{
	
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String mail;

}
