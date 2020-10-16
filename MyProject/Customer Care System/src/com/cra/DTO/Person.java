package com.cra.DTO;

import java.util.List;

import com.cra.DAO.UserDAO;

public class Person implements Customer {
	
	
	public int id;
	public String name;
	public Complaint c;
	
	

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}


	UserDAO udao = new UserDAO();

	public Person(int id, String name, Complaint c) {
		super();
		this.id = id;
		this.name = name;
		this.c = c;
	}



	@Override
	public List<Customer> viewAllCustomer() {
		// TODO Auto-generated method stub
		List<Customer> list= udao.viewAllCustomer();
		return list;
	}




	@Override
	public List<Complaint> viewComplaintsById(int id) {
		// TODO Auto-generated method stub
		System.out.println("here");
		List<Complaint> list= udao.viewComplaintsById(id);
		return list;
	}




	@Override
	public Complaint viewComplaintStatus(int id) {
		// TODO Auto-generated method stub
		Complaint comp = udao.viewComplaintStatus(id);
		return comp;
	}




	@Override
	public boolean launchComplaintWithExistingUser(Person p) {
		// TODO Auto-generated method stub
		boolean b = udao.registerNewComplaint(p);
		return b;
	}




	@Override
	public boolean launchComplaintWithOldUser(Person p) {
		// TODO Auto-generated method stub
		boolean b = udao.registerComplaintWithOldUser(p);
		return b;
	}



	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", c=" + c ;
	}
	
	

}
