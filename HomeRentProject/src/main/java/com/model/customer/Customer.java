package com.model.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.master.model.RoomsMasterModel;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cId;
	private String cName;
	private String otherCustomers;
	private String cContact;
	private String cContact2;
	private String adharNo;
	private String cPAN;
	private String cAddress;
	private int roomRent;
	private int deposite;
	private int d_paid;
	private int d_remaining;
	private String dPaidDate;
	private String joinDate;
	private String leaveDate;
	private int meter;
	private String status="active";
	private String returnD;
	private String cRoomType;
	private String cArea;
	
	@OneToOne
	@JoinColumn(name="roomId")
	private RoomsMasterModel roomsMasterModel;
	
	
	public String getcRoomType() {
		return cRoomType;
	}

	public void setcRoomType(String cRoomType) {
		this.cRoomType = cRoomType;
	}

	public String getcArea() {
		return cArea;
	}

	public void setcArea(String cArea) {
		this.cArea = cArea;
	}

	public String getOtherCustomers() {
		return otherCustomers;
	}

	public void setOtherCustomers(String otherCustomers) {
		this.otherCustomers = otherCustomers;
	}

	public String getReturnD() {
		return returnD;
	}

	public void setReturnD(String returnD) {
		this.returnD = returnD;
	}

	public String getcContact2() {
		return cContact2;
	}

	public void setcContact2(String cContact2) {
		this.cContact2 = cContact2;
	}

	public String getcPAN() {
		return cPAN;
	}

	public void setcPAN(String cPAN) {
		this.cPAN = cPAN;
	}

	public String getcAddress() {
		return cAddress;
	}

	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}

	public String getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcContact() {
		return cContact;
	}

	public void setcContact(String cContact) {
		this.cContact = cContact;
	}

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}

	public RoomsMasterModel getRoomsMasterModel() {
		return roomsMasterModel;
	}

	public void setRoomsMasterModel(RoomsMasterModel roomsMasterModel) {
		this.roomsMasterModel = roomsMasterModel;
	}

	public int getRoomRent() {
		return roomRent;
	}

	public void setRoomRent(int roomRent) {
		this.roomRent = roomRent;
	}

	public int getDeposite() {
		return deposite;
	}

	public void setDeposite(int deposite) {
		this.deposite = deposite;
	}

	public int getD_paid() {
		return d_paid;
	}

	public void setD_paid(int d_paid) {
		this.d_paid = d_paid;
	}

	public int getD_remaining() {
		return d_remaining;
	}

	public void setD_remaining(int d_remaining) {
		this.d_remaining = d_remaining;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public int getMeter() {
		return meter;
	}

	public void setMeter(int meter) {
		this.meter = meter;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getdPaidDate() {
		return dPaidDate;
	}

	public void setdPaidDate(String dPaidDate) {
		this.dPaidDate = dPaidDate;
	}

	
	

}
