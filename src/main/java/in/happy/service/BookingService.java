package in.happy.service;

import in.happy.request.Passenger;
import in.happy.response.Ticket;

public interface BookingService {
	
	public Ticket bookTicket(Passenger passenger);
	
	public Ticket getTicket(Integer ticketNumber);

}
