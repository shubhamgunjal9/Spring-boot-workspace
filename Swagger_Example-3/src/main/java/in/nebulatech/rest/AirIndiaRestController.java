package in.nebulatech.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.nebulatech.bindings.PassengerInfo;
import in.nebulatech.bindings.TicketInfo;

@RestController
public class AirIndiaRestController {
	
	@PostMapping("/bookticket")
	public ResponseEntity<TicketInfo> bookTicket(@RequestBody PassengerInfo passengerInfo) {
		
		TicketInfo ticketInfo=new TicketInfo();
		ticketInfo.setName(passengerInfo.getFname()+" "+passengerInfo.getLname());
		ticketInfo.setFrom(passengerInfo.getFrom());
		ticketInfo.setTo(passengerInfo.getTo());
		ticketInfo.setFlightId(passengerInfo.getFlightId());
		ticketInfo.setJourneyDate(passengerInfo.getJourneyDate());
		ticketInfo.setTicketPrice("50000.00$");
		ticketInfo.setTicketStatus("booked..");
		return new ResponseEntity<>(ticketInfo, HttpStatus.CREATED);
	}

}
