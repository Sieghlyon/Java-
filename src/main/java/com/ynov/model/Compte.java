package com.ynov.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="compte")
public class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	private  String libelle;
	private int numero ;
	
	@OneToMany(mappedBy="compte", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	List<Transaction> transactions;
	
	@ManyToOne
	@JoinColumn(name="clientID")
	private Client client ;
	
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
	
}