package be.steformations.pc.ticketmaster.jpa.repositories;

import be.steformations.pc.ticketmaster.common.service.TicketMasterService;
import be.steformations.pc.ticketmaster.jpa.entities.BookingEntity;
import be.steformations.pc.ticketmaster.jpa.entities.ClientEntity;
import be.steformations.pc.ticketmaster.jpa.entities.ShowEntity;
import be.steformations.pc.ticketmaster.jpa.entities.VenueEntity;

public class JpaTicketMasterService implements TicketMasterService {

	protected javax.persistence.EntityManager em;
	protected java.util.Calendar calendar;
	
	public JpaTicketMasterService(javax.persistence.EntityManager em) {
		super();
		this.em = em;
		this.calendar = java.util.GregorianCalendar.getInstance();
		this.calendar.set(java.util.Calendar.MILLISECOND, 0);
		this.calendar.setLenient(false);
	}

	@Override
	public synchronized ShowEntity createShow(String title, int year, int month, int day, int hour, int minutes, int venueId) {
		ShowEntity show = null;

		try {
			VenueEntity venue = this.em.find(VenueEntity.class, venueId);
			this.calendar.clear();
			this.calendar.set(year, month-1, day, 0, 0, 0);
			java.util.Date date = this.calendar.getTime();
			this.calendar.clear();
			this.calendar.set(java.util.Calendar.HOUR_OF_DAY, hour);
			this.calendar.set(java.util.Calendar.MINUTE, minutes);
			java.util.Date time = this.calendar.getTime();
			show = new ShowEntity(title, date, time, venue);
			if (this.em.isJoinedToTransaction()) {
				this.em.persist(show);
				this.em.flush();
			} else {
				this.em.getTransaction().begin();
				this.em.persist(show);
				this.em.getTransaction().commit();
			}
		} catch(javax.persistence.NoResultException e) {}
		
		return show;
	}

	@Override
	public BookingEntity createBooking(int showId, int clientId) {
		BookingEntity booking = null;
		
		try {
			ShowEntity show = this.em.find(ShowEntity.class, showId);
			ClientEntity client = this.em.find(ClientEntity.class, clientId);
			booking = new BookingEntity(client, show);
			if (this.em.isJoinedToTransaction()) {
				this.em.persist(booking);
				this.em.flush();
			} else {
				this.em.getTransaction().begin();
				this.em.persist(booking);
				this.em.getTransaction().commit();
			}			
		} catch(javax.persistence.NoResultException e) {}
		
		return booking;
	}
	
	public java.util.List<ShowEntity> findAllShowsByDayLowerThan(java.util.Date day) {
		return this.em.createNamedQuery("findAllShowsByDayLowerThan", ShowEntity.class)
				.setParameter(1, day).getResultList();
	}
	
	public void removeShow(int showId) {
		ShowEntity show = this.em.find(ShowEntity.class, showId);
		if (show != null) {
			if (this.em.isJoinedToTransaction()) {
				this.em.remove(show);
			} else {
				this.em.getTransaction().begin();
				this.em.remove(show);
				this.em.getTransaction().commit();
			}
		}
	}

}
