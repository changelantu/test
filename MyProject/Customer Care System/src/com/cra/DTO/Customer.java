package com.cra.DTO;

import java.util.List;

public interface Customer {
	
	public abstract List<Customer> viewAllCustomer();
	public abstract List<Complaint> viewComplaintsById(int id);
	public abstract Complaint viewComplaintStatus(int id);
	public abstract boolean launchComplaintWithExistingUser(Person p);
	public abstract boolean launchComplaintWithOldUser(Person p);

}
