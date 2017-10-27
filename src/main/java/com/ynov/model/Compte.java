package com.ynov.model;

import java.util.List;

import javax.persistence.*;

import com.google.gson.annotations.Expose;

@Entity
@Table(name="compte")
public class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Expose(serialize = true, deserialize = false)
	private int id ;
	
	@Expose(serialize = true, deserialize = false)
	private  String libelle;
	
	@Expose(serialize = true, deserialize = false)
	private int numero ;
	
	@Expose(serialize = true, deserialize = false)
	private double montant;
	
	@Expose(serialize = false, deserialize = false)
	@OneToMany(mappedBy="compte", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	List<Transaction> transactions;
	
	@Expose(serialize = false, deserialize = false)
	@ManyToOne
	@JoinColumn(name="clientID")
	private Client client ;
	
	public void ajouter(int trans) {
		this.montant += trans;
	}
	
	public void enlever(int trans) {
		this.montant -= trans;
	}
	
	/**
	 * @return the montant
	 */
	public double getMontant() {
		return montant;
	}
	/**
	 * @param montant the montant to set
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		String line = "montant : " + this.montant + " id "+ this.id + "numero : " + this.numero ;
		return line;
	}
	
}
