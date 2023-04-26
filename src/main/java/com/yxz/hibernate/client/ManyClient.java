package com.yxz.hibernate.client;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yxz.hibernate.model.AccountModel;
import com.yxz.hibernate.model.AddressModel;
import com.yxz.hibernate.model.PatientModel;
import com.yxz.hibernate.utils.HibernateUtil;

public class ManyClient {
	
	public static void main(String args[]) {
		Session session = HibernateUtil.getSessionFactoryCurrentSession();
		
		//one to one
		/*
		 * AccountModel account = new AccountModel(); AddressModel address = new
		 * AddressModel(); address.setCity("new york"); address.setStreet("abc");
		 * account.setUserName("arnold_schwarzeneger");
		 * account.setAddressModel(address);
		 * 
		 * Transaction tx = session.beginTransaction(); session.save(account);
		 * tx.commit();
		 */
		
		//one to many
		AccountModel account = new AccountModel();
		PatientModel patient1 = new PatientModel();
		PatientModel patient2 = new PatientModel();
		
		patient1.setPatientName("Syvester Stallone");
		patient2.setPatientName("jean claude van damme");
		ArrayList<PatientModel> patientList = new ArrayList<PatientModel>();
		patientList.add(patient1);
		patientList.add(patient2);
		
		account.setUserName("dark darth");
		account.setPatients(patientList);
		
		session.beginTransaction();
		session.saveOrUpdate(account);
		session.beginTransaction().commit();
		
	}

}
