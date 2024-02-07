package in.nebulatech.bindings;



import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name="BOOKING_RECORDS")
public class Booking {
	
	

	@Id
	private String name;
	
	private String email;
	
	private Long contact;
	
	private String fromLocation;
	
	private Integer count;
	
	private String toLocation;
	
	private String checkInDate;
	
	private String trainPreferences;
	
	private String passengerCatagory;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}

	public String getTrainPreferences() {
		return trainPreferences;
	}

	public void setTrainPreferences(String trainPreferences) {
		this.trainPreferences = trainPreferences;
	}

	public String getPassengerCatagory() {
		return passengerCatagory;
	}

	public void setPassengerCatagory(String passengerCatagory) {
		this.passengerCatagory = passengerCatagory;
	}
	

}
