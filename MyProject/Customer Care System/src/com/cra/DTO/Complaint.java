package com.cra.DTO;

public class Complaint {
	
	public int cid;
	public String title;
	public String description;
	public int status;
	public int customerId;
	public Complaint() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Complaint(int cid, String title, String description, int status, int customerid) {
		super();
		this.cid = cid;
		this.title = title;
		this.description = description;
		this.status = status;
		this.customerId = customerid;
	}
	@Override
	public String toString() {
		return "Complaint [cid=" + cid + ", title=" + title + ", description=" + description + ", status=" + status
				+ ", customerid=" + customerId + "]";
	}
	

}
