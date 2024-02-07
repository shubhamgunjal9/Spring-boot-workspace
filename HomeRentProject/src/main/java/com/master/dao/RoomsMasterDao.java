package com.master.dao;

import java.util.HashMap;
import java.util.List;

import com.master.model.RoomsMasterModel;

public interface RoomsMasterDao {
	
	public RoomsMasterModel findRoomId(int roomId);
	void save(RoomsMasterModel roomsMasterModel);
	public List<String> fetchRoomList();
	public void updateRoom(int roomId, String roomNo, int RoomRent,String RoomType,String Area);
	public RoomsMasterModel getDuplicateRoomNumber(String roomNo);
	public HashMap<String, String> getAreaList();
	public HashMap<String, String> getTypeRoomList();
}
