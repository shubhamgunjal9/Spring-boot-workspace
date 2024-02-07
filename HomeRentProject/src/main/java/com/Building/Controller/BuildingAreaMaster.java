package com.Building.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Building.DAO_Service.AreaServiceInterface;
import com.master.model.Area;
import com.master.model.RoomType;

@Controller
public class BuildingAreaMaster {

	@Autowired
	AreaServiceInterface areaServiceInterface;

	@RequestMapping(value = "areaMaster")
	public ModelAndView getBuildingAreaPage(Model model) {
		System.out.println("area master()...");
		List<String> listofArea;
		listofArea = areaServiceInterface.fetchAreaList();
		model.addAttribute("listofArea", listofArea);
		return new ModelAndView("areaMasterPageView");
	}

	@RequestMapping(value = "saveArea")
	public ModelAndView saveBuildingArea(@ModelAttribute("area") Area area, BindingResult result, Model model) {
		System.out.println("area save()...");
		areaServiceInterface.saveArea(area);

		List<String> listofArea;
		listofArea = areaServiceInterface.fetchAreaList();
		model.addAttribute("listofArea", listofArea);
		return new ModelAndView("areaMasterPageView");
	}

	@RequestMapping(value = "saveArea", params = "areaUpdate")
	public ModelAndView update(Model model, @ModelAttribute("room") Area area, HttpServletRequest request) {

		int aId = Integer.parseInt(request.getParameter("aId"));
		System.out.println(aId);
		String area1 = request.getParameter("area");
		System.out.println(area1);
		String address = request.getParameter("address");
		System.out.println(address);

		areaServiceInterface.updateArea(aId, area1, address);

		List<String> listofArea;
		listofArea = areaServiceInterface.fetchAreaList();
		model.addAttribute("listofArea", listofArea);

		return new ModelAndView("areaMasterPageView");
	}

	//Room Type
	@RequestMapping(value = "roomTypeMaster")
	public ModelAndView getRoomTypeMaster(Model model) {
		System.out.println("area roomTypeMaster()...");

		List<String> listofRoomType;
		listofRoomType = areaServiceInterface.fetchRoomTypeList();
		model.addAttribute("listofRoomType", listofRoomType);

		return new ModelAndView("roomTypeMasterView");
	}

	@RequestMapping(value = "saveRoomType")
	public ModelAndView saveRoomType(@ModelAttribute("roomT") RoomType roomType, BindingResult result, Model model) {
		System.out.println("area save()...");
		areaServiceInterface.saveRoomType(roomType);

		List<String> listofRoomType;
		listofRoomType = areaServiceInterface.fetchRoomTypeList();
		model.addAttribute("listofRoomType", listofRoomType);

		return new ModelAndView("roomTypeMasterView");
	}
	
	@RequestMapping(value = "saveRoomType", params = "roomTypeUpdate")
	public ModelAndView roomTypeUpdate(Model model, @ModelAttribute("room") RoomType roomType, HttpServletRequest request) {

		int rTypeId = Integer.parseInt(request.getParameter("rTypeId"));
		System.out.println(rTypeId);
		String typeRoom = request.getParameter("typeRoom");
		System.out.println(typeRoom);

		areaServiceInterface.updateRoomType(rTypeId, typeRoom);

		List<String> listofRoomType;
		listofRoomType = areaServiceInterface.fetchRoomTypeList();
		model.addAttribute("listofRoomType", listofRoomType);

		return new ModelAndView("roomTypeMasterView");
	}
}
