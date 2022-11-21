package com.auth.auth.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="address")
public class Address {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	private String country;

	private String streetLabel;

	private int streetNumber;

	private int zipCode;

	Address(String country, String streetLabel, int streetNumber, int zipCode) {
		this.country = country;
		this.streetLabel = streetLabel;
		this.streetNumber = streetNumber;
		this.zipCode = zipCode;
	}

	@OneToMany(mappedBy = "address")
	@JsonBackReference
	private Set<User> users = new HashSet<>();
}
