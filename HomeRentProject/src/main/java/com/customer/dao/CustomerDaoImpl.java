 package com.customer.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;

import com.master.model.RoomsMasterModel;
import com.model.customer.Customer;
import com.rent.model.RentModel;

@Repository("customerDaoInterface")
public class CustomerDaoImpl implements CustomerDaoInterface {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void saveCustomer(Customer customer,int roomId) {

		Session session = sessionFactory.openSession();
		session.save(customer);
		SQLQuery query = session.createSQLQuery("update roomsmastermodel r set r.Status='Booked' where r.roomId='" + roomId + "' ");
		query.executeUpdate();
		session.beginTransaction().commit();
		session.close();
	}

	// room dropdown
	@Override
	public HashMap<String, String> getRoomList() {

		List<HashMap> list = new ArrayList<HashMap>();
		@SuppressWarnings("rawtypes")	
		HashMap mapOfRoom = new HashMap();
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("SELECT r.roomId,r.roomNo FROM  RoomsMasterModel r");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		list = query.list();

		System.out.println("get room table: " + list);

		for (HashMap map : list) {
			mapOfRoom.put(map.get("roomId"), map.get("roomNo"));
		}
		session.close();
		return mapOfRoom;
	}

	@Override
	public List<String> fetchCustomerList() {
		List<String> customerinfo = new ArrayList<String>();
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("SELECT  * from(select cId,cName,otherCustomers,cContact,cContact2,cPAN,cAddress,returnD,adharNo,rm.roomId,roomNo,rm.roomRent,joinDate,leaveDate,deposite,d_paid,d_remaining,meter,cm.status,cArea,cRoomType,dPaidDate from customer cm inner join roomsmastermodel rm on rm.roomId=cm.roomId where cm.status='active'order by cId desc)x group by cName");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		customerinfo = query.list();
		System.out.println("customerinfo=" + customerinfo);
		session.close();
		return customerinfo;
	}

	//customer page json
	@Override
	public List<String> getRoomDetails(String roomId) {
		System.out.println("inside json dao");
		Session session = sessionFactory.openSession();
		SQLQuery query =session.createSQLQuery("SELECT r.RoomRent,rt.typeRoom,ar.area FROM roomsmastermodel r inner join roomType rt on r.rTypeId=rt.rTypeId inner join area ar on r.aId=ar.aId where roomId=" + roomId + "");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		System.out.println(query);
		List list = query.list();
		System.out.println(list.size());
		session.close();
		return list;
	}

	@Override
	public void updateCustomer(int cId, String cName, String cContact, String adharNo, int roomId, int roomRent,
			int maintenance, int deposite, int d_paid, int d_remaining, String joinDate, int meter) {
		System.out.println("inside updateCustomer daoImpl");
		Session session = sessionFactory.openSession();
		SQLQuery query = session
				.createSQLQuery("update customer c set c.cName='" + cName + "',c.cContact='" + cContact
						+ "',c.adharNo='" + adharNo + "',c.roomId='" + roomId + "',c.roomRent='" + roomRent
						+ "',c.deposite='" + deposite + "',c.d_paid='" + d_paid
						+ "',c.d_remaining='" + d_remaining + "',c.joinDate='" + joinDate + "',c.meter='" + meter + "' where c.cId='" + cId + "' ");

		query.executeUpdate();
		session.close();
	}

	//msg- getDuplicate adhar
	@Override
	public Customer getDuplicateName(String adharNo,String cPAN) {
		System.out.println("inside msg dao");
		Criteria criteria = null;
		Session session = sessionFactory.openSession();
		criteria = session.createCriteria(Customer.class);
		Criterion cr1 = Restrictions.eq("adharNo", adharNo);
		Criterion cr2 = Restrictions.eq("cPAN", cPAN);
		criteria.add(cr1);
		criteria.add(cr2);
		Customer customer = (Customer) criteria.setMaxResults(2).uniqueResult();
		System.out.println("inside msg dao");
		session.close();
		return customer;
	}

//rent page autocomplete
	@Override
	public List<String> searchCustomerName(String keyword) {
		List<String> result = new ArrayList<String>();
		Session session = sessionFactory.openSession();
		Query query = session
				.createQuery("select distinct(c.cName) from Customer c where c.cName like :keyword  and c.status='active' ");
		query.setString("keyword", "%" + keyword + "%");
		System.out.println("query: " + query);
		result = query.list();
		System.out.println("result: " + result);
		session.close();
		return result;
	}

//json for new customer rent 1st time
	@Override
	public List<String> getCustomerDetails(String cName) {
		System.out.println("inside json dao");
		Session session = sessionFactory.openSession();
		SQLQuery query =session.createSQLQuery("SELECT rm.roomNo,c.roomRent,c.meter,c.cId,c.status FROM customer c inner join roomsmastermodel rm on rm.roomId=c.roomId where cName='" + cName + "' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		System.out.println(query);
		List list = query.list();
		System.out.println(list.size());
		session.close();
		return list;
	}

	@Override
	public void saveRent(RentModel rentModel) {
		Session session = sessionFactory.openSession();
		session.save(rentModel);
		session.beginTransaction().commit();
		session.close();		
	}

	@Override
	public List<String> fetchRentList() {
		List<String> rentinfo = new ArrayList<String>();
		Session session = sessionFactory.openSession();
//		SQLQuery query = session.createSQLQuery("select rId,r.cName,date,r.roomNo,r.roomRent,r_paid,r_remaining,r.meter,current_meter,unitPrice,lightBill,total,balance,r.status,r.cId,r.month, r.joinDate from RentModel r inner join customer c on c.cId=r.cId where c.status='active' ");
		SQLQuery query = session.createSQLQuery("SELECT  * from(select * from rentmodel where status='active' order by cId,rId desc)x group by cId");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		rentinfo = query.list();
		System.out.println("rentinfo=" + rentinfo);
		session.close();
		return rentinfo;
	}

	@Override
	public Customer findCustomerId(int cId) {
		Customer customer=new Customer();
		Session session=sessionFactory.openSession();
		customer=(Customer)session.get(Customer.class, cId);
		session.close();
		return customer;
	}

//	rent page getDuplicateNameFromRent for json
	@Override
	public RentModel getDuplicateNameFromRent(String cName) {
		System.out.println("inside cname duplicate dao");
		Criteria criteria = null;
		Session session = sessionFactory.openSession();
		criteria = session.createCriteria(RentModel.class);
		Criterion cr1 = Restrictions.eq("cName", cName);
		criteria.add(cr1);

		RentModel rentModel = (RentModel) criteria.setMaxResults(1).uniqueResult();
		System.out.println("inside cname duplicate dao");
		session.close();
		return rentModel;
	}

//json for customer rent next month	
	@Override
	public List<String> getCustomerDetailsFromRent(String cName) {
		System.out.println("inside getCustomerDetailsFromRent dao");
		Session session = sessionFactory.openSession();
		SQLQuery query =session.createSQLQuery("SELECT r.rId,r.roomNo,r.roomRent,r.current_meter,r.cId,r.r_remaining,r.balance ,r.status FROM rentmodel r inner join customer c on r.cId=c.cId where r.cName='" + cName + "' ORDER BY r.rId DESC");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		System.out.println(query);
		List list = query.list();
		System.out.println(list.size());
		session.close();
		return list;
	}

//set customer status = deactive	
	@Override
	public void deleteCustomer(String cName,String leaveDate,String returnD,String roomNo) {
		System.out.println("inside delete customer daoImpl");
		Session session = sessionFactory.openSession();
		SQLQuery query1 = session.createSQLQuery("update customer c set c.status='deactive', c.leaveDate='"+leaveDate+"', c.returnD='"+returnD+"' where c.cName='" + cName + "' ");
		SQLQuery query2 = session.createSQLQuery("update rentmodel r set r.status='deactive' where r.cName='" + cName + "' ");
		SQLQuery query3 = session.createSQLQuery("update roomsmastermodel r set r.Status='Available' where r.roomNo='" + roomNo + "'");
		
		query1.executeUpdate();
		query2.executeUpdate();
		query2.executeUpdate();
		query3.executeUpdate();
		session.close();
	}

	@Override
	public List<String> getC_Details(String cName) {
		System.out.println("inside json dao");
		Session session = sessionFactory.openSession();
		SQLQuery query =session.createSQLQuery("SELECT * FROM customer where cName='" + cName + "'and status='active' ");
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		System.out.println(query);
		List list = query.list();
		System.out.println(list.size());
		session.close();
		return list;
	}

}
