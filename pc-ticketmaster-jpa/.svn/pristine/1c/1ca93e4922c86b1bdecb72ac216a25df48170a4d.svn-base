package be.steformations.pc.ticketmaster.jpa.entities;

import be.steformations.pc.ticketmaster.common.beans.Client;

@javax.persistence.Entity(name="Client")
@javax.persistence.Table(name="clients")
@javax.persistence.Access(javax.persistence.AccessType.PROPERTY)
public class ClientEntity extends Client {
	private static final long serialVersionUID = -2114978986997468414L;
	
	@Override
	@javax.persistence.Id
	@javax.persistence.Column(name="id")
	@javax.persistence.GeneratedValue(
		strategy=javax.persistence.GenerationType.IDENTITY)
	public Integer getId() {
		return super.getId();
	}

	@Override
	@javax.persistence.Basic
	@javax.persistence.Column(name="nom")
	public String getName() {
		return super.getName();
	}

	@Override
	@javax.persistence.Basic
	@javax.persistence.Column(name="iban")
	public String getIban() {
		return super.getIban();
	}

	@Override
	@javax.persistence.Basic
	@javax.persistence.Column(name="email")
	public String getEmail() {
		return super.getEmail();
	}
}
