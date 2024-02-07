package com.customer.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.customer.dao.CustomerDaoInterface;
import com.master.model.RoomsMasterModel;
import com.model.customer.Customer;
import com.rent.model.RentModel;
@Service("customerServiceInterface")
@Transactional(propagation=Propagation.SUPPORTS)
public class CustomerServiceImpl implements CustomerServiceInterface {

	@Autowired
	CustomerDaoInterface customerDaoInterface;


	@Override
	public void saveCustomer(Customer customer,int roomId) {
	
		customerDaoInterface.saveCustomer(customer,roomId);
	}

	@Override
	public HashMap<String, String> getRoomList() {
		// TODO Auto-generated method stub
		return customerDaoInterface.getRoomList();
	}

	@Override
	public List<String> fetchCustomerList() {
		// TODO Auto-generated method stub
		return customerDaoInterface.fetchCustomerList();
	}

	@Override
	public List<String> getRoomDetails(String roomId) {
		// TODO Auto-generated method stub
		return customerDaoInterface.getRoomDetails(roomId);
	}

	@Override
	public void updateCustomer(int cId, String cName, String cContact, String adharNo, int roomId, int roomRent,
			int maintenance, int deposite, int d_paid, int d_remaining, String joinDate,int meter) {
		customerDaoInterface.updateCustomer(cId, cName, cContact, adharNo, roomId, roomRent, maintenance, deposite, d_paid, d_remaining, joinDate, meter);
		
	}

	@Override
	public Customer getDuplicateName(String adharNo,String cPAN) {
		return customerDaoInterface.getDuplicateName(adharNo, cPAN);
	}



	@Override
	public List<String> searchCustomerName(String keyword) {
		return customerDaoInterface.searchCustomerName(keyword);
	}

	@Override
	public List<String> getCustomerDetails(String cName) {
		return customerDaoInterface.getCustomerDetails(cName);
	}

	@Override
	public void saveRent(RentModel rentModel) {
		customerDaoInterface.saveRent(rentModel);
		
	}

	@Override
	public List<String> fetchRentList() {
		// TODO Auto-generated method stub
		return customerDaoInterface.fetchRentList();
	}

	@Override
	public Customer findCustomerId(int cId) {
		return customerDaoInterface.findCustomerId(cId);
	}

	@Override
	public RentModel getDuplicateNameFromRent(String cName) {
		
		return customerDaoInterface.getDuplicateNameFromRent(cName);
	}

	@Override
	public List<String> getCustomerDetailsFromRent(String cName) {
		// TODO Auto-generated method stub
		return customerDaoInterface.getCustomerDetailsFromRent(cName);
	}

	@Override
	public void deleteCustomer(String cName,String leaveDate,String returnD,String roomNo) {
		customerDaoInterface.deleteCustomer(cName,leaveDate,returnD,roomNo);
		
	}

	@Override
	public List<String> getC_Details(String cName) {
		return customerDaoInterface.getC_Details(cName);
	}

	



}
