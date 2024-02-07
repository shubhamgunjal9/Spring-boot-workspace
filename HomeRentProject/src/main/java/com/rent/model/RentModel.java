package com.rent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.model.customer.Customer;

@Entity
public class RentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rId;
	private String cName;
	private String roomNo;
	private String fromDate;
	private String toDate;
	private String date;
	private String year;
	private int roomRent;
	private int r_paid;
	private int r_remaining;
	private int balance;

	private int meter;
	private int current_meter;
	private double unitPrice;
	private int lightBill;
	
	
	private String status;
	private int total;
	private String month;
	private String description;
	
	
	@OneToOne
	@JoinColumn(name="cId")
	private Customer customer;
	
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getrId() {
		return rId;
	}
	public void setrId(int rId) {
		this.rId = rId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getRoomRent() {
		return roomRent;
	}
	public void setRoomRent(int roomRent) {
		this.roomRent = roomRent;
	}
	public int getR_paid() {
		return r_paid;
	}
	public void setR_paid(int r_paid) {
		this.r_paid = r_paid;
	}
	public int getR_remaining() {
		return r_remaining;
	}
	public void setR_remaining(int r_remaining) {
		this.r_remaining = r_remaining;
	}
	public int getMeter() {
		return meter;
	}
	public void setMeter(int meter) {
		this.meter = meter;
	}
	public int getCurrent_meter() {
		return current_meter;
	}
	public void setCurrent_meter(int current_meter) {
		this.current_meter = current_meter;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public int getLightBill() {
		return lightBill;
	}
	public void setLightBill(int lightBill) {
		this.lightBill = lightBill;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
