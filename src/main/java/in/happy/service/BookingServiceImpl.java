package in.happy.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import in.happy.request.Passenger;
import in.happy.response.Ticket;
@Service
public class BookingServiceImpl implements BookingService {
	private Integer ticketNum =1;
	private Map<Integer, Ticket> ticketsMap = new HashMap<>();

	@Override
	public Ticket bookTicket(Passenger passenger) {
		//logic
		 Ticket t = new Ticket();
		BeanUtils.copyProperties(passenger, t);
		t.setCoast(550.00);
		t.setStatus("confirmed");
		t.setTicketNum(ticketNum);
		ticketsMap.put(ticketNum, t);
		ticketNum++;
		
		
		return  t;
	}

	@Override
	public Ticket getTicket(Integer ticketNumber) {
		if(ticketsMap.containsKey(ticketNumber)) {
			return ticketsMap.get(ticketNumber);
		}
		

		return null;
	}

}
