package com.camunda.camundaclient.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pizza database table.
 * 
 */
@Entity
@NamedQuery(name="Pizza.findAll", query="SELECT p FROM Pizza p")
public class Pizza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_pizza")
	private int idPizza;

	private String description;

	private String image;

	private String nom;

	private String type;

	//bi-directional many-to-one association to Commande
	@OneToMany(mappedBy="pizza")
	private List<Commande> commandes;

	public Pizza() {
	}

	public int getIdPizza() {
		return this.idPizza;
	}

	public void setIdPizza(int idPizza) {
		this.idPizza = idPizza;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Commande> getCommandes() {
		return this.commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Commande addCommande(Commande commande) {
		getCommandes().add(commande);
		commande.setPizza(this);

		return commande;
	}

	public Commande removeCommande(Commande commande) {
		getCommandes().remove(commande);
		commande.setPizza(null);

		return commande;
	}

}