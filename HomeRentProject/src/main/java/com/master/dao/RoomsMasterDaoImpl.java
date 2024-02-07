package com.master.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.master.model.RoomsMasterModel;
import com.rent.model.RentModel;


@Repository
public class RoomsMasterDaoImpl implements RoomsMasterDao
{
   @Autowired
   SessionFactory sessionfactory;
   
	@Override
	public void save(RoomsMasterModel roomsMasterModel) 
	{
		 Session session=sessionfactory.openSession();	
		 session.save(roomsMasterModel);
		 session.beginTransaction().commit();		 
		 session.close();		
	}

	@Override
	public List<String> fetchRoomList() {
		System.out.println("inside Room list dao");
		List<String> listOfRoom = new ArrayList<String>();
		Session session=sessionfactory.openSession();
		SQLQuery query =session.createSQLQuery("SELECT rm.roomId,rm.roomNo,rm.RoomRent,rm.Status,ar.area,rt.typeRoom FROM RoomsMasterModel rm inner join Area ar on ar.aId=rm.aId inner join roomtype rt on rm.rTypeId=rt.rTypeId");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		listOfRoom = query.list();
		System.out.println("listOfRoom "+listOfRoom);
		session.close();
		return listOfRoom;
	}

	@Override
	public RoomsMasterModel findRoomId(int roomId) {
		RoomsMasterModel roomsMasterModel=new RoomsMasterModel();
		Session session=sessionfactory.openSession();
		roomsMasterModel=(RoomsMasterModel)session.get(RoomsMasterModel.class, roomId);
		session.close();
		return roomsMasterModel;
	}

	@Override
	public void updateRoom(int roomId, String roomNo, int RoomRent,String RoomType,String Area) {
		System.out.println("inside updateRoom daoImpl");
		Session session=sessionfactory.openSession();
		SQLQuery query = session.createSQLQuery("update roomsmastermodel rm set rm.roomNo='" + roomNo + "', rm.roomRent='" + RoomRent + "',rm.rTypeId='" + RoomType + "',rm.aId='" + Area + "' where rm.roomId='" + roomId + "' ");
		query.executeUpdate();
		session.close();
	}

	@Override
	public RoomsMasterModel getDuplicateRoomNumber(String roomNo) {
		System.out.println("inside roomNumber duplicate dao");
		Criteria criteria = null;
		Session session = sessionfactory.openSession();
		criteria = session.createCriteria(RoomsMasterModel.class);
		Criterion cr1 = Restrictions.eq("roomNo", roomNo);
		criteria.add(cr1);

		RoomsMasterModel roomsMasterModel = (RoomsMasterModel) criteria.setMaxResults(1).uniqueResult();
		System.out.println("inside roomNumber duplicate dao");
		session.close();
		return roomsMasterModel;
	}

	@Override
	public HashMap<String, String> getAreaList() {
		List<HashMap> list = new ArrayList<HashMap>();
		@SuppressWarnings("rawtypes")
		HashMap mapOfarea = new HashMap();
		Session session = sessionfactory.openSession();
		SQLQuery query = session.createSQLQuery("SELECT a.aId,a.area FROM  Area a ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		list = query.list();

		System.out.println("get area table: " + list);

		for (HashMap map : list) {
			mapOfarea.put(map.get("aId"), map.get("area"));
		}
		session.close();
		return mapOfarea;
	}

	@Override
	public HashMap<String, String> getTypeRoomList() {
		
		List<HashMap> list = new ArrayList<HashMap>();
		@SuppressWarnings("rawtypes")
		HashMap mapOftypeRomm = new HashMap();
		Session session = sessionfactory.openSession();
		SQLQuery query = session.createSQLQuery("SELECT rt.rTypeId,rt.typeRoom FROM  RoomType rt ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		list = query.list();

		System.out.println("get area table: " + list);

		for (HashMap map : list) {
			mapOftypeRomm.put(map.get("rTypeId"), map.get("typeRoom"));
		}
		session.close();
		return mapOftypeRomm;
	}

}
