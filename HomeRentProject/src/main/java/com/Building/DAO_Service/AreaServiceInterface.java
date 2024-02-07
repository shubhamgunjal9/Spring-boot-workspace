package com.Building.DAO_Service;

import java.util.List;

import com.master.model.Area;
import com.master.model.RoomType;

public interface AreaServiceInterface {

	void saveArea(Area area);

	List<String> fetchAreaList();

	void updateArea(int aId, String area1,String address);

	void saveRoomType(RoomType roomType);

	List<String> fetchRoomTypeList();

	void updateRoomType(int rTypeId, String typeRoom);

	Area findAreaId(int aId);

	RoomType findRoomTypeId(int rTypeId);

}
