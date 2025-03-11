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
public class Company extends Partner{
	
	private String name;
	private LocalDate dob;
	private String mail;
	
}
