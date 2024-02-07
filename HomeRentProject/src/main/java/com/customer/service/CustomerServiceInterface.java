package com.customer.service;

import java.util.HashMap;
import java.util.List;

import com.master.model.RoomsMasterModel;
import com.model.customer.Customer;
import com.rent.model.RentModel;

public interface CustomerServiceInterface {

	
	public HashMap<String, String> getRoomList();	
	public void saveCustomer(Customer customer,int roomId);
	public List<String> fetchCustomerList();
	public List<String> getRoomDetails(String roomId);
	public void updateCustomer(int cId, String cName, String cContact, String adharNo, int roomId, int roomRent,
			int maintenance, int deposite, int d_paid, int d_remaining, String joinDate, int meter);
	public Customer getDuplicateName(String adharNo,String cPAN);
	
	public List<String> searchCustomerName(String keyword);
	public List<String> getCustomerDetails(String cName);
	public void saveRent(RentModel rentModel);
	public List<String> fetchRentList();
	public Customer findCustomerId(int cId);
	
	public RentModel getDuplicateNameFromRent(String cName);
	public List<String> getCustomerDetailsFromRent(String cName);
	public void deleteCustomer(String cName,String leaveDate,String returnD,String roomNo);
	public List<String> getC_Details(String cName);

}
