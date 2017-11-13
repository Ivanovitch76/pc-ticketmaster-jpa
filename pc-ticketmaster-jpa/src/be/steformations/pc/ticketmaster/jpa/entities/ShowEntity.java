package be.steformations.pc.ticketmaster.jpa.entities;

import be.steformations.pc.ticketmaster.common.beans.Show;
import be.steformations.pc.ticketmaster.common.beans.Venue;

@javax.persistence.Entity(name="Show")
@javax.persistence.Table(name="evenements")
@javax.persistence.Access(javax.persistence.AccessType.PROPERTY)
@javax.persistence.NamedQueries(
	@javax.persistence.NamedQuery(name="findAllShowsByDayLowerThan", query="select s from Show s where s.day < ?1")
)
public class ShowEntity extends Show {
	private static final long serialVersionUID = 2385506985172212137L;

	public ShowEntity() {
		super();
	}
	
	public ShowEntity(String title, java.util.Date day, java.util.Date time, VenueEntity venue) {
		super();
		this.setTitle(title);
		this.setDay(day);
		this.setTime(time);
		this.setVenue(venue);
	}
	
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
	public String getTitle() {
		return super.getTitle();
	}

	@Override
	@javax.persistence.Basic
	@javax.persistence.Column(name="jour")
	@javax.persistence.Temporal(javax.persistence.TemporalType.DATE)
	public java.util.Date getDay() {
		return super.getDay();
	}

	@Override
	@javax.persistence.Basic
	@javax.persistence.Column(name="heure")
	@javax.persistence.Temporal(javax.persistence.TemporalType.TIME)	
	public java.util.Date getTime() {
		return super.getTime();
	}

	@Override
	@javax.persistence.ManyToOne(targetEntity=VenueEntity.class)
	@javax.persistence.JoinColumn(name="salle")
	public Venue getVenue() {
		return super.getVenue();
	}
}
