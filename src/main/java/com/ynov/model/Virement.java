package com.ynov.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name="virement")
public class Virement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose(serialize = true, deserialize = false)
	private int id ;
	
	private String libelle ;
	
	private Date date ;
	
	

	@ManyToOne
	@JoinColumn(name="origine")
	private Compte compte ;
	
	@ManyToOne
	@JoinColumn(name="destination")
	private Compte destination ;
	
	private double montant ;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Compte getCompte() {
		return compte;
	}
	
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	/**
	 * @return the destination
	 */
	public Compte getDestination() {
		return destination;
	}
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(Compte destination) {
		this.destination = destination;
	}
	
	public double getMontant() {
		return montant;
	}
	
	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
}
