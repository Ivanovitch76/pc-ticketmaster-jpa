package be.steformations.pc.ticketmaster.jpa.entities;

import be.steformations.pc.ticketmaster.common.beans.Venue;

@javax.persistence.Entity(name="Venue")
@javax.persistence.Table(name="salles")
@javax.persistence.Access(javax.persistence.AccessType.PROPERTY)
public class VenueEntity extends Venue {
	private static final long serialVersionUID = -807809007947735258L;

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
	@javax.persistence.Column(name="capacite")
	public Integer getCapacity() {
		return super.getCapacity();
	}
}
