package com.report;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.customer.service.CustomerServiceInterface;
import com.master.service.RoomsMasterService;
import com.rent.model.RentModel;
import com.util.PrintJasperReport;

import net.sf.jasperreports.engine.JRException;

@Controller
public class ReportController {
	
	@Autowired
	RoomsMasterService roomsMasterService;
	
	@Autowired
	CustomerServiceInterface customerServiceInterface;
	
	@RequestMapping(value = "monthlyCustomerReport")
	public String monthlyCustomerReport(Model model) {
		
		//dropdown area		
				HashMap<String, String> areaTypeList;
				areaTypeList = roomsMasterService.getAreaList();
				model.addAttribute("areaTypeList", areaTypeList);
				System.out.println("inside list controller" + areaTypeList);
		return "monthlyCustomerReportView";
	}
	
	@RequestMapping(value = "generateMonthlyReport")
	public String generateMonthlyReport(Model model,HttpServletRequest request,HttpServletResponse response) throws ParseException, JRException, NamingException, SQLException, IOException {
		System.out.println("IN SIDE CustomerWiseReportGenrate");
		
		String month=request.getParameter("month"); 
		System.out.println(month);
		String Area=request.getParameter("Area"); 
		System.out.println(Area);
		String year=request.getParameter("year"); 
		System.out.println(year);
		// use for jasper page report 
		
				
				String filename1 = "AllCustomerReport";
				HashMap<String, Object> hm = new HashMap<>();
				hm.put("month", month);
				hm.put("Area", Area);
				hm.put("year", year);
				
				System.out.println(hm);
				PrintJasperReport.printreport(filename1, request, response, hm);
				//	end
				
				//dropdown area		
				HashMap<String, String> areaTypeList;
				areaTypeList = roomsMasterService.getAreaList();
				model.addAttribute("areaTypeList", areaTypeList);
				System.out.println("inside list controller" + areaTypeList);
		return "monthlyCustomerReportView";
	}

	@RequestMapping(value = "cusomerWiseDetails")
	public String getcusomerWiseDetails() {
		
		return "getcusomerWiseDetailsView";
	}
	
	
	
	@RequestMapping(value = "generateCustomerWiseReport")
	public String customerWiseReportGenrate(HttpServletRequest request,HttpServletResponse response) throws ParseException, JRException, NamingException, SQLException, IOException {
		System.out.println("IN SIDE CustomerWiseReportGenrate");
		
		String cName=request.getParameter("cName"); 
		System.out.println(cName);
		// use for jasper page report 
		
				
				String filename1 = "CustomerReportNew";
				HashMap<String, Object> hm = new HashMap<>();
				hm.put("cName", cName);
				
				System.out.println(hm);
				PrintJasperReport.printreport(filename1, request, response, hm);
				//	end
				
		
		return "getcusomerWiseDetailsView";
	}
	
	@RequestMapping(value = "pendingPayment")
	public String pendingPayment(HttpServletRequest request,HttpServletResponse response) throws JRException, NamingException, SQLException, IOException  {
		System.out.println("IN SIDE OF CONTROLLER OF Pending Payments REPORT===========");
		
		//query latest record without balance 0
		
		//SELECT  * from(select * from rentmodel where status='active' order by cId,rId desc)x group by cId


		// use for jasper page report 
		
				
				String filename1 = "PendingPaymentNew";
				HashMap<String, Object> hm = new HashMap<>();
			
				
				System.out.println(hm);
				PrintJasperReport.printreport(filename1, request, response, hm);
				//	end
		
				return "HomePageView";
	}
	
	
	@RequestMapping(value = "deactivatedCustomer")
	public String deactivatedCustomer(HttpServletRequest request,HttpServletResponse response) throws JRException, NamingException, SQLException, IOException  {
		System.out.println("IN SIDE OF CONTROLLER OF deactivated Customer  REPORT===========");
		
		//query latest record without balance 0
		
	//	select * from customer where status='deactive'


		// use for jasper page report 
		
				
				String filename1 = "DeactiveCustomerNew";
				HashMap<String, Object> hm = new HashMap<>();
			
				
				System.out.println(hm);
				PrintJasperReport.printreport(filename1, request, response, hm);
				//	end
		
				return "HomePageView";
	}
	
	@RequestMapping(value = "deactivatedAllRecords")
	public String deactivatedAllRecords(HttpServletRequest request,HttpServletResponse response) throws JRException, NamingException, SQLException, IOException  {
		System.out.println("IN SIDE OF CONTROLLER OF deactivated Customer  REPORT===========");
		
		//query latest record without balance 0
		
	//	select * from customer where status='deactive'


		// use for jasper page report 
		
				
				String filename1 = "DeactiveCustomerDetails";
				HashMap<String, Object> hm = new HashMap<>();
			
				
				System.out.println(hm);
				PrintJasperReport.printreport(filename1, request, response, hm);
				//	end
		
				return "HomePageView";
	}
	
	@RequestMapping(value = "totalRoomRent")
	public String totalRoomRent(Model model) {
		HashMap<String, String> roomTypeList;
		roomTypeList = customerServiceInterface.getRoomList();
		model.addAttribute("roomTypeList", roomTypeList);
		System.out.println("inside list controller" + roomTypeList);

		return "totalRoomRentView";
	}
	
	@RequestMapping(value = "generateTotalRoomRentReport")
	public String generateTotalRoomRentReport(HttpServletRequest request,HttpServletResponse response) throws ParseException, JRException, NamingException, SQLException, IOException {
		System.out.println("IN SIDE generateTotalRoomRentReport");
		
		String roomId=request.getParameter("roomId"); 
		System.out.println(roomId);
	
		// use for jasper page report 
		
				String filename1 = "TotalRoomRent";
				HashMap<String, Object> hm = new HashMap<>(); 
				hm.put("roomId", roomId);
				
		 
				System.out.println(hm); 
				PrintJasperReport.printreport(filename1, request,response, hm);
		
				return "totalRoomRentView";
	}
	
	@RequestMapping(value = "getPaymentSheet")
	public String getPaymentSheet(Model model) {
		System.out.println("IN SIDE getPaymentSheet Page");
		
		//dropdown area		
		HashMap<String, String> areaTypeList;
		areaTypeList = roomsMasterService.getAreaList();
		model.addAttribute("areaTypeList", areaTypeList);
		System.out.println("inside list controller" + areaTypeList);
		return "getPaymentSheetView";
	}
	
	@RequestMapping(value = "getPaymentSheetReport")
	public String getPaymentSheetReport(Model model,HttpServletRequest request,HttpServletResponse response) throws ParseException, JRException, NamingException, SQLException, IOException {
		System.out.println("IN SIDE generateTotalRoomRentReport");
		
		String month=request.getParameter("month"); 
		System.out.println(month);
		String year=request.getParameter("year"); 
		System.out.println(year);
		String Area=request.getParameter("Area"); 
		System.out.println(Area);
		// use for jasper page report 
		
				
				String filename1 = "PaymentShit";
				HashMap<String, Object> hm = new HashMap<>();
				hm.put("month", month);
				hm.put("year", year);
				hm.put("Area", Area);
				
				System.out.println(hm);
				PrintJasperReport.printreport(filename1, request, response, hm);
				//	end
			
				//dropdown area		
				HashMap<String, String> areaTypeList;
				areaTypeList = roomsMasterService.getAreaList();
				model.addAttribute("areaTypeList", areaTypeList);
				System.out.println("inside list controller" + areaTypeList);
				
				return "totalRoomRentView";
	}
}
