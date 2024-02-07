package com.customer.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.customer.service.CustomerServiceInterface;
import com.master.model.RoomsMasterModel;
import com.master.service.RoomsMasterService;
import com.message.SendSMS;
import com.model.customer.Customer;
import com.rent.model.RentModel;

@Controller
public class CustomerController {

	@Autowired
	CustomerServiceInterface customerServiceInterface;

	@Autowired
	RoomsMasterService roomsMasterService;

	List<String> keyword = new ArrayList<>();

	@RequestMapping(value = "customerView")
	public ModelAndView getCustomerView(Model model) {
		System.out.println("inside customer view");

		Customer customer = new Customer();
		model.addAttribute("customer", customer);

//dropdown		
		HashMap<String, String> roomTypeList;
		roomTypeList = customerServiceInterface.getRoomList();
		model.addAttribute("roomTypeList", roomTypeList);
		System.out.println("inside list controller" + roomTypeList);

// fetch

		List<String> listofCustomer;
		listofCustomer = customerServiceInterface.fetchCustomerList();
		model.addAttribute("listofCustomer", listofCustomer);

		return new ModelAndView("customerView");
	}

	@RequestMapping(value = "saveCustomer")
	public ModelAndView saveService(Model model, @ModelAttribute("customer") Customer customer, BindingResult result,
			@RequestParam("roomId") int roomId, HttpServletRequest request) throws IOException {

		System.out.println("Room Id:" + roomId);
//save		
		RoomsMasterModel roomsMasterModel = new RoomsMasterModel();

//		get roomId from selected dropdown list and set to customer model
		roomsMasterModel = roomsMasterService.findRoomId(roomId);
		customer.setRoomsMasterModel(roomsMasterModel);

		customerServiceInterface.saveCustomer(customer,roomId);
//fetch

		List<String> listofCustomer;
		listofCustomer = customerServiceInterface.fetchCustomerList();
		model.addAttribute("listofCustomer", listofCustomer);

//dropdown
		HashMap<String, String> roomTypeList;
		roomTypeList = customerServiceInterface.getRoomList();
		model.addAttribute("roomTypeList", roomTypeList);
		System.out.println("inside list controller" + roomTypeList);

		return new ModelAndView("customerView");
	}
	
	@RequestMapping(value = "updateCustomer")
	public ModelAndView updateCustomer(Model model, @ModelAttribute("customer") Customer customer, BindingResult result,
			@RequestParam("roomId") int roomId, HttpServletRequest request) throws IOException {
		
		RoomsMasterModel roomsMasterModel = new RoomsMasterModel();

//		get roomId from selected dropdown list and set to customer model
		roomsMasterModel = roomsMasterService.findRoomId(roomId);
		customer.setRoomsMasterModel(roomsMasterModel);
//save
		customerServiceInterface.saveCustomer(customer,roomId);
//fetch

		List<String> listofCustomer;
		listofCustomer = customerServiceInterface.fetchCustomerList();
		model.addAttribute("listofCustomer", listofCustomer);

//dropdown
		HashMap<String, String> roomTypeList;
		roomTypeList = customerServiceInterface.getRoomList();
		model.addAttribute("roomTypeList", roomTypeList);
		System.out.println("inside list controller" + roomTypeList);

		return new ModelAndView("customerView");
	}

	// Json Customer page room dropdown to get rent and maintenance
	@RequestMapping(value = "getRoomDetails", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getRoomDetails(String roomId) {
		System.out.println("roomId" + roomId);
		List<String> list = new ArrayList<>();
		list = customerServiceInterface.getRoomDetails(roomId);
		System.out.println(list);
		return list;
	}

	// Json Customer page room dropdown to get rent and maintenance
		@RequestMapping(value = "getC_Details", method = RequestMethod.GET)
		@ResponseBody
		public List<String> getC_Details(String cName) {
			System.out.println("cName" + cName);
			List<String> list = new ArrayList<>();
			list = customerServiceInterface.getC_Details(cName);
			System.out.println(list);
			return list;
		}

//customer delete	
	@RequestMapping(value = "customerdelete")
	public ModelAndView deleteCustomer(@RequestParam("cName") String cName,
			@RequestParam("leaveDate") String leaveDate,
			@RequestParam("returnD") String returnD,
			@RequestParam("roomIdDel") String roomNo,
			Model model) {
		System.out.println(cName+" "+leaveDate+" "+returnD+" room No "+roomNo);
		customerServiceInterface.deleteCustomer(cName,leaveDate,returnD,roomNo);
//fetch		
		List<String> listofCustomer;
		listofCustomer = customerServiceInterface.fetchCustomerList();
		model.addAttribute("listofCustomer", listofCustomer);

// dropdown
		HashMap<String, String> roomTypeList;
		roomTypeList = customerServiceInterface.getRoomList();
		model.addAttribute("roomTypeList", roomTypeList);
		System.out.println("inside list controller" + roomTypeList);
		return new ModelAndView("customerView");
	}


//Rent Page	
	@RequestMapping(value = "rentPay")
	public ModelAndView getCustomerRent(Model model) {
		System.out.println("getCustomerRent");

		RentModel rentModel = new RentModel();
		model.addAttribute("rentKey", rentModel);
		
		//dropdown		
				HashMap<String, String> roomTypeList;
				roomTypeList = customerServiceInterface.getRoomList();
				model.addAttribute("roomTypeList", roomTypeList);
				System.out.println("inside list controller" + roomTypeList);

// fetch

		List<String> listofCustomerRent;
		listofCustomerRent = customerServiceInterface.fetchRentList();
		model.addAttribute("listofCustomerRent", listofCustomerRent);

		return new ModelAndView("customerRentView");
	}

	@RequestMapping(value = "saveRent")
	public ModelAndView saveRent(Model model, @ModelAttribute("rent") RentModel rentModel, BindingResult result,
			HttpServletRequest request) {
		System.out.println("inside saveRentModel Method...");

		// Save CustomerId to RentModel
		int cId = Integer.parseInt(request.getParameter("cId"));

		System.out.println(cId);

		Customer customer = new Customer();

		customer = customerServiceInterface.findCustomerId(cId);
		System.out.println("customer Id" + customer);
		rentModel.setCustomer(customer);

		customerServiceInterface.saveRent(rentModel);

		List<String> listofCustomerRent;
		listofCustomerRent = customerServiceInterface.fetchRentList();
		model.addAttribute("listofCustomerRent", listofCustomerRent);

		return new ModelAndView("customerRentView");
	}

	@RequestMapping(value = "SameMonthRentEntery", params="SameMonthRent")
	public ModelAndView SameMonthRentEntery(Model model, @ModelAttribute("rent") RentModel rentModel, BindingResult result,
			HttpServletRequest request) {
		System.out.println("inside saveRentModel Method...");

		// Save CustomerId to RentModel
		int cId = Integer.parseInt(request.getParameter("cId"));

		System.out.println(cId);

		Customer customer = new Customer();

		customer = customerServiceInterface.findCustomerId(cId);
		System.out.println("customer Id" + customer);
		rentModel.setCustomer(customer);

		customerServiceInterface.saveRent(rentModel);

		List<String> listofCustomerRent;
		listofCustomerRent = customerServiceInterface.fetchRentList();
		model.addAttribute("listofCustomerRent", listofCustomerRent);

		return new ModelAndView("customerRentView");
	}
	
// Calling customer Autocomplete	
	@RequestMapping("/searchCustomerName")
	@ResponseBody
	public List<String> autoCustomercomplete(HttpServletRequest requet) {
		keyword = customerServiceInterface.searchCustomerName(requet.getParameter("term")); // Calling Autocomplete
																							// method
		return keyword;
	}

// Json Rent page
	@RequestMapping(value = "getCustomerDetails", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getCustomerDetails(HttpServletRequest request, @ModelAttribute("rent") RentModel rentModel) {

		String cName = request.getParameter("cName");
		System.out.println("cName=" + cName);

		RentModel rentModel1 = customerServiceInterface.getDuplicateNameFromRent(rentModel.getcName());
		List<String> list = new ArrayList<>();

		if (rentModel1 == null) {
			list = customerServiceInterface.getCustomerDetails(cName);
			System.out.println(list);
		} else {
			list = customerServiceInterface.getCustomerDetailsFromRent(cName);
			System.out.println(list);
		}
		return list;
	}
	
	@RequestMapping(value = "updateMonthRent", params = "UpdateInfo")
	public ModelAndView updateMonthRent(@RequestParam("cIdUpdate") int cIdUpdate, Model model,@ModelAttribute("rent") RentModel rentModel1) {
		System.out.println("cIdUpdate "+cIdUpdate);
		
		Customer customer = new Customer();

		customer = customerServiceInterface.findCustomerId(cIdUpdate);
		System.out.println("customer Id -> " + customer);
		rentModel1.setCustomer(customer);
		
		//customerServiceInterface.deleteCustomer(cIdUpdate);
//fetch		
		List<String> listofCustomerRent;
		listofCustomerRent = customerServiceInterface.fetchRentList();
		model.addAttribute("listofCustomerRent", listofCustomerRent);


// dropdown
		HashMap<String, String> roomTypeList;
		roomTypeList = customerServiceInterface.getRoomList();
		model.addAttribute("roomTypeList", roomTypeList);
		System.out.println("inside list controller" + roomTypeList);
		//return new ModelAndView("customerView");
        return new ModelAndView("customerRentView");
	}
}
