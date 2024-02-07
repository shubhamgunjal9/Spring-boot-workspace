package com.master.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.master.dao.RoomsMasterDao;
import com.master.model.RoomsMasterModel;

@Service
@Transactional
public class RoomsMasterServiceImpl implements RoomsMasterService 
{

	
	@Autowired
	RoomsMasterDao  roomsMasterDao;
	
	@Override
	public void save(RoomsMasterModel roomsMasterModel) 
	{
		 
		roomsMasterDao.save(roomsMasterModel);
	}

	@Override
	public List<String> fetchRoomList() {
		// TODO Auto-generated method stub
		return roomsMasterDao.fetchRoomList();
	}

	@Override
	public RoomsMasterModel findRoomId(int roomId) {
		// TODO Auto-generated method stub
		return roomsMasterDao.findRoomId(roomId);
	}

	@Override
	public void updateRoom(int roomId, String roomNo, int RoomRent,String RoomType,String Area) {
		roomsMasterDao.updateRoom(roomId, roomNo, RoomRent,RoomType,Area);
		
	}

	@Override
	public RoomsMasterModel getDuplicateRoomNumber(String roomNo) {
		// TODO Auto-generated method stub
		return roomsMasterDao.getDuplicateRoomNumber(roomNo);
	}

	@Override
	public HashMap<String, String> getAreaList() {
		// TODO Auto-generated method stub
		return roomsMasterDao.getAreaList();
	}

	@Override
	public HashMap<String, String> getTypeRoomList() {
		// TODO Auto-generated method stub
		return roomsMasterDao.getTypeRoomList();
	}

}
