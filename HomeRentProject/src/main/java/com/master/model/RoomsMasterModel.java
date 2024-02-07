package com.master.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class RoomsMasterModel 
{
	@Id
	@GeneratedValue
    private int roomId;
    private String roomNo;
    private int RoomRent;
    private String Status="Available";// or Booked
    
    @OneToOne
    @JoinColumn(name="aId")
    private Area area;
    
    @OneToOne
    @JoinColumn(name="rTypeId")
    private RoomType roomType;
    
    
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	public int getRoomId() {
		return roomId;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public int getRoomRent() {
		return RoomRent;
	}
	public void setRoomRent(int roomRent) {
		RoomRent = roomRent;
	}
	/*public int getMaintenance() {
		return Maintenance;
	}
	public void setMaintenance(int maintenance) {
		Maintenance = maintenance;
	}*/

   
}
