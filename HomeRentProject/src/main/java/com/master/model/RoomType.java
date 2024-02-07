package com.master.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RoomType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rTypeId;
	private String typeRoom;
	
	public int getrTypeId() {
		return rTypeId;
	}
	public void setrTypeId(int rTypeId) {
		this.rTypeId = rTypeId;
	}
	public String getTypeRoom() {
		return typeRoom;
	}
	public void setTypeRoom(String typeRoom) {
		this.typeRoom = typeRoom;
	}
	
	

}
