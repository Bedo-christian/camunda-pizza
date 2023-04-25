package com.camunda.camundaclient.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_roles")
	private int idRoles;

	@Column(name="code_role")
	private String codeRole;

	@Column(name="nom_role")
	private String nomRole;

	//bi-directional many-to-many association to Utilisateur
	@ManyToMany(mappedBy="roles")
	private List<Utilisateur> utilisateurs;

	public Role() {
	}

	public int getIdRoles() {
		return this.idRoles;
	}

	public void setIdRoles(int idRoles) {
		this.idRoles = idRoles;
	}

	public String getCodeRole() {
		return this.codeRole;
	}

	public void setCodeRole(String codeRole) {
		this.codeRole = codeRole;
	}

	public String getNomRole() {
		return this.nomRole;
	}

	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}

	public List<Utilisateur> getUtilisateurs() {
		return this.utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

}