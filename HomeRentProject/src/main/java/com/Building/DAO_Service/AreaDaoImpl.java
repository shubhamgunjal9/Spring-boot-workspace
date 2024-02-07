package com.Building.DAO_Service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.master.model.Area;
import com.master.model.RoomType;
import com.master.model.RoomsMasterModel;

@Repository("areaDaoInterface")
public class AreaDaoImpl implements AreaDaoInterface {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveArea(Area area) {
	Session session=sessionFactory.openSession();
	session.save(area);
	session.beginTransaction().commit();
	session.close();	
	}

	@Override
	public List<String> fetchAreaList() {
		List<String> areaInfo = new ArrayList<String>();
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("SELECT  * from Area");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		areaInfo = query.list();
		System.out.println("areaInfo=" + areaInfo);
		session.close();
		return areaInfo;
	}

	@Override
	public void updateArea(int aId, String area1,String address) {
		
		System.out.println("inside updateArea daoImpl");
		Session session=sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("update area a set a.area='" + area1 + "',a.address='"+address+"' where a.aId='" + aId + "' ");
		query.executeUpdate();
		session.close();
	}

	@Override
	public void saveRoomType(RoomType roomType) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.save(roomType);
		session.beginTransaction().commit();
		session.close();	
	}

	@Override
	public List<String> fetchRoomTypeList() {
		List<String> roomTypeInfo = new ArrayList<String>();
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("SELECT  * from RoomType");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		roomTypeInfo = query.list();
		System.out.println("roomTypeInfo=" + roomTypeInfo);
		session.close();
		return roomTypeInfo;
	}

	@Override
	public void updateRoomType(int rTypeId, String typeRoom) {
		// TODO Auto-generated method stub
		System.out.println("inside updateRoomType daoImpl");
		Session session=sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("update RoomType rt set rt.typeRoom='" + typeRoom + "' where rt.rTypeId='" + rTypeId + "' ");
		query.executeUpdate();
		session.close();
	}

	@Override
	public Area findAreaId(int aId) {
		Area area =new Area();
		Session session=sessionFactory.openSession();
		area=(Area)session.get(Area.class, aId);
		session.close();
		return area;
	}

	@Override
	public RoomType findRoomTypeId(int rTypeId) {
		RoomType roomType =new RoomType();
		Session session=sessionFactory.openSession();
		roomType=(RoomType)session.get(RoomType.class, rTypeId);
		session.close();
		return roomType;
	}

}
