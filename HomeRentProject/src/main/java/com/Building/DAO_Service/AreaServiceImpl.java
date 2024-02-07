package com.Building.DAO_Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.master.model.Area;
import com.master.model.RoomType;

@Service("areaServiceInterface")
@Transactional
public class AreaServiceImpl implements AreaServiceInterface {
	
	@Autowired
	AreaDaoInterface areaDaoInterface;

	@Override
	public void saveArea(Area area) {
		// TODO Auto-generated method stub
		areaDaoInterface.saveArea(area);
	}

	@Override
	public List<String> fetchAreaList() {
		// TODO Auto-generated method stub
		return areaDaoInterface.fetchAreaList();
	}

	@Override
	public void updateArea(int aId, String area1,String address) {
		// TODO Auto-generated method stub
		areaDaoInterface.updateArea(aId, area1,address);
	}

	@Override
	public void saveRoomType(RoomType roomType) {
		// TODO Auto-generated method stub
		areaDaoInterface.saveRoomType(roomType);
	}

	@Override
	public List<String> fetchRoomTypeList() {
		// TODO Auto-generated method stub
		return areaDaoInterface.fetchRoomTypeList();
	}

	@Override
	public void updateRoomType(int rTypeId, String typeRoom) {
		// TODO Auto-generated method stub
		areaDaoInterface.updateRoomType(rTypeId, typeRoom);
	}

	@Override
	public Area findAreaId(int aId) {
		return areaDaoInterface.findAreaId(aId);
	}

	@Override
	public RoomType findRoomTypeId(int rTypeId) {
		return areaDaoInterface.findRoomTypeId(rTypeId);
	}

}
