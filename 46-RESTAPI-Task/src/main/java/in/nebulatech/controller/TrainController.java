package in.nebulatech.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nebulatech.entity.TrainReservation;

@RestController
public class TrainController {
	
	@PostMapping("/postdata")
	public ResponseEntity<TrainReservation> trainData()
	{
		TrainReservation reservation = new TrainReservation();
		System.out.println("posted data from frontend");
		return new ResponseEntity<>(reservation,HttpStatus.CREATED);
	}
	
	@GetMapping(value="/getdata", produces = {"application/json"},consumes = {"application/json"})
	public ResponseEntity<TrainReservation> getData(TrainReservation reservation)
	{
		System.out.println("data fetched successfull.."+reservation);
		return new ResponseEntity<>(reservation,HttpStatus.OK);
	}

}
