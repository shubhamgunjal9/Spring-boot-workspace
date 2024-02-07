package in.nebulatech.entity;

import lombok.Data;

@Data
public class TrainReservation {
	
	private String passengerName;
	
	private String passengerContact;
	
	private String passengerEmail;
	
	private String currentLocation;
	
	private String nextLocation;
	
	private String trainBlock;
	
	private String trainPNRno;

}
