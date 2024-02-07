package com.master.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Building.DAO_Service.AreaServiceInterface;
import com.master.model.Area;
import com.master.model.RoomType;
import com.master.model.RoomsMasterModel;
import com.master.service.RoomsMasterService;
import com.rent.model.RentModel;

@Controller
public class RoomsMasterController
{ 
	@Autowired
	AreaServiceInterface areaServiceInterface;
	
	@Autowired
	RoomsMasterService roomsMasterService;

		@RequestMapping(value="roomsMaster")
		public ModelAndView getHomePage(Model model)
		{
			System.out.println("Roomsmaster()...");
			RoomsMasterModel roomsMasterModel=new RoomsMasterModel();
			model.addAttribute("room", roomsMasterModel);
			
			List<String> listofRoom;
			listofRoom = roomsMasterService.fetchRoomList();
			model.addAttribute("listofRoom", listofRoom);
			
			//dropdown area		
			HashMap<String, String> areaTypeList;
			areaTypeList = roomsMasterService.getAreaList();
			model.addAttribute("areaTypeList", areaTypeList);
			System.out.println("inside list controller" + areaTypeList);
			
			//dropdown roomType	
			HashMap<String, String> TypeRoomList;
			TypeRoomList = roomsMasterService.getTypeRoomList();
			model.addAttribute("TypeRoomList", TypeRoomList);
			System.out.println("inside list controller" + TypeRoomList);
			
			return new ModelAndView("roomPageView");
		}
		
/*		@RequestMapping(value="saveRooms")
		public ModelAndView saveRooms(@RequestParam("aId") int aId, @RequestParam("rTypeId") int rTypeId, Model model, @ModelAttribute("room") RoomsMasterModel roomsMasterModel,BindingResult result){
			
			Area area =new Area();
//			get area id  from selected dropdown list and set to room master model
			area = areaServiceInterface.findAreaId(aId);
			roomsMasterModel.setArea(area);
			
			RoomType roomType =new RoomType();
//			get area id  from selected dropdown list and set to room master model
			roomType = areaServiceInterface.findRoomTypeId(rTypeId);
			roomsMasterModel.setRoomType(roomType);
			
			roomsMasterService.save(roomsMasterModel);
			
			List<String> listofRoom;
			listofRoom = roomsMasterService.fetchRoomList();
			model.addAttribute("listofRoom", listofRoom);
			
			//dropdown area		
			HashMap<String, String> areaTypeList;
			areaTypeList = roomsMasterService.getAreaList();
			model.addAttribute("areaTypeList", areaTypeList);
			System.out.println("inside list controller" + areaTypeList);
			
			//dropdown roomType	
			HashMap<String, String> TypeRoomList;
			TypeRoomList = roomsMasterService.getTypeRoomList();
			model.addAttribute("TypeRoomList", TypeRoomList);
			System.out.println("inside list controller" + TypeRoomList);
			
			return new ModelAndView("roomPageView");
		}*/

		@RequestMapping(value="saveRooms")
		public ModelAndView saveRooms(@RequestParam("aId") int aId, @RequestParam("rTypeId") int rTypeId,Model model, @ModelAttribute("room") RoomsMasterModel roomsMasterModel,BindingResult result,HttpServletRequest request)
		{
			System.out.println("inside saveStarter Method...");
			
			String roomNo = request.getParameter("roomNo");
			System.out.println("roomNo=" + roomNo);
			
			RoomsMasterModel roomsMasterModel1 = roomsMasterService.getDuplicateRoomNumber(roomsMasterModel.getRoomNo());	
			
			if (roomsMasterModel1 == null) {
				Area area =new Area();
//				get area id  from selected dropdown list and set to room master model
				area = areaServiceInterface.findAreaId(aId);
				roomsMasterModel.setArea(area);
				
				RoomType roomType =new RoomType();
//				get area id  from selected dropdown list and set to room master model
				roomType = areaServiceInterface.findRoomTypeId(rTypeId);
				roomsMasterModel.setRoomType(roomType);	
				
			roomsMasterService.save(roomsMasterModel);
			List<String> listofRoom;
			listofRoom = roomsMasterService.fetchRoomList();
			model.addAttribute("listofRoom", listofRoom);
			
			//dropdown area		
			HashMap<String, String> areaTypeList;
			areaTypeList = roomsMasterService.getAreaList();
			model.addAttribute("areaTypeList", areaTypeList);
			System.out.println("inside list controller" + areaTypeList);
			
			//dropdown roomType	
			HashMap<String, String> TypeRoomList;
			TypeRoomList = roomsMasterService.getTypeRoomList();
			model.addAttribute("TypeRoomList", TypeRoomList);
			System.out.println("inside list controller" + TypeRoomList);
			}
			else
			{
				model.addAttribute("errorMsg", "Room is already register");
				
				List<String> listofRoom;
				listofRoom = roomsMasterService.fetchRoomList();
				model.addAttribute("listofRoom", listofRoom);
				
				//dropdown area		
				HashMap<String, String> areaTypeList;
				areaTypeList = roomsMasterService.getAreaList();
				model.addAttribute("areaTypeList", areaTypeList);
				System.out.println("inside list controller" + areaTypeList);
				
				//dropdown roomType	
				HashMap<String, String> TypeRoomList;
				TypeRoomList = roomsMasterService.getTypeRoomList();
				model.addAttribute("TypeRoomList", TypeRoomList);
				System.out.println("inside list controller" + TypeRoomList);
				
				return new ModelAndView("roomPageView");
			}
			
					
			return new ModelAndView("roomPageView");
		}
		
		@RequestMapping(value="saveRooms", params="roomMasterupdate")
		public ModelAndView update(Model model, @ModelAttribute("room") RoomsMasterModel roomsMasterModel,HttpServletRequest request)
		{
			
			int roomId=Integer.parseInt(request.getParameter("roomId"));
			String roomNo = request.getParameter("roomNo");
			int RoomRent = Integer.parseInt(request.getParameter("RoomRent"));
			String RoomType = request.getParameter("rTypeId");
			String Area = request.getParameter("aId");
			System.out.println("roomId "+roomId+" roomNo "+roomNo+" RoomRent "+RoomRent+" RoomType "+RoomType+" Area "+Area);
			
			roomsMasterService.updateRoom(roomId,roomNo,RoomRent,RoomType,Area);

			List<String> listofRoom;
			listofRoom = roomsMasterService.fetchRoomList();
			model.addAttribute("listofRoom", listofRoom);
			
			//dropdown area		
			HashMap<String, String> areaTypeList;
			areaTypeList = roomsMasterService.getAreaList();
			model.addAttribute("areaTypeList", areaTypeList);
			System.out.println("inside list controller" + areaTypeList);

			//dropdown roomType	
			HashMap<String, String> TypeRoomList;
			TypeRoomList = roomsMasterService.getTypeRoomList();
			model.addAttribute("TypeRoomList", TypeRoomList);
			System.out.println("inside list controller" + TypeRoomList);
			
			return new ModelAndView("roomPageView");
		}
		
		
}
