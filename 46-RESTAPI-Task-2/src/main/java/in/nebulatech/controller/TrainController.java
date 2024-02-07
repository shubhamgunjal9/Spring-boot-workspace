package in.nebulatech.controller;

import java.util.function.Consumer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.nebulatech.bindings.PassengerData;
import in.nebulatech.bindings.TrainData;

@RestController
public class TrainController {
	
	@GetMapping("/book/{id}")
	public ResponseEntity<String> getTrainData(@PathVariable("id") Integer id)
	{
		System.out.println(id);
		//logic to delete mapping
		return new ResponseEntity<>("get Mapping Successfull",HttpStatus.OK);
	}
	
	@PostMapping(value="/book",
			produces = { "application/json"},
			consumes = {"application/json"}
			)
	public ResponseEntity<TrainData> getTrainDetails(@RequestBody PassengerData passengerData)
	{
		System.out.println(passengerData);
		TrainData data=new TrainData();
		data.setTrainId(101);
		data.setPrn("TR78SFHDJ");
		data.setTrainNo("636272");
		return new ResponseEntity<>(data,HttpStatus.CREATED);
	}
	
	@PutMapping("/book")
	public ResponseEntity<String> putTrainData(@RequestBody PassengerData passengerData)
	{
		System.out.println(passengerData);
		//logic to put mapping
		return new ResponseEntity<>("put mapping",HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/book/{id}")
	public ResponseEntity<String> deleteTrainData(@PathVariable("id") Integer id)
	{
		System.out.println(id);
		//logic to delete mapping
		return new ResponseEntity<>("delete Mapping Successfull",HttpStatus.OK);
	}

}
