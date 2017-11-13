package be.steformations.pc.ticketmaster.jpa.entities;

import be.steformations.pc.ticketmaster.common.beans.Booking;
import be.steformations.pc.ticketmaster.common.beans.Client;
import be.steformations.pc.ticketmaster.common.beans.Show;

@javax.persistence.Entity(name="Booking")
@javax.persistence.Table(name="reservations")
@javax.persistence.Access(javax.persistence.AccessType.PROPERTY)
public class BookingEntity extends Booking {
	private static final long serialVersionUID = -6277350642507980230L;

	public BookingEntity() {
		super();
	}
	
	public BookingEntity(ClientEntity client, ShowEntity show) {
		super();
		this.setClient(client);
		this.setShow(show);
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
	@javax.persistence.ManyToOne(targetEntity=ShowEntity.class)
	@javax.persistence.JoinColumn(name="evenement")
	public Show getShow() {
		return super.getShow();
	}

	@Override
	@javax.persistence.ManyToOne(targetEntity=ClientEntity.class)
	@javax.persistence.JoinColumn(name="client")
	public Client getClient() {
		return super.getClient();
	}
}
