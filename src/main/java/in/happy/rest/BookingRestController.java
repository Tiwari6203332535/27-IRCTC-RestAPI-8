package in.happy.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.happy.request.Passenger;
import in.happy.response.Ticket;
import in.happy.service.BookingService;

@RestController
public class BookingRestController {
	@Autowired
	private BookingService service;

	// Not reqire consumer/produces by default it wiil take json and provide json
	
	@PostMapping(value = "/ticket", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Ticket> ticketBooking(@RequestBody Passenger passenger) {
	
		Ticket ticket = service.bookTicket(passenger);
		return new ResponseEntity<>(ticket, HttpStatus.CREATED);
	}

	@GetMapping(value = "/ticket/{ticketNum}", produces = {"application/json"})
	public Ticket getTicketByNum(@PathVariable  Integer ticketNum) {
		return service.getTicket(ticketNum);
	}
}
