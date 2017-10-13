package com.ynov.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	private String libelle ;
	
	@ManyToOne
	@JoinColumn(name="commpteID")
	private Compte compte ;
	
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	private int origine ;
	
	private int destinaiton ;
	
	private double montant ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getOrigine() {
		return origine;
	}
	public void setOrigine(int origine) {
		this.origine = origine;
	}
	public int getDestinaiton() {
		return destinaiton;
	}
	public void setDestinaiton(int destinaiton) {
		this.destinaiton = destinaiton;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	
}