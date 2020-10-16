package com.cra.ui;

import java.util.List;
import java.util.Scanner;

import com.cra.DTO.Complaint;
import com.cra.DTO.Customer;
import com.cra.DTO.Person;

public class User {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Customer per = new Person();
		Scanner sc = new Scanner(System.in);
		char h;
		char cr;
		do {
			System.out.println("Welcome to customer care system");
			System.out.println("1.View all customers\n2.Select a customer by keyid to view all complaints");
			System.out.println("3.Select a complaint to view status\n4.Register a new complaint with new user");
			System.out.println("5.Regidter a new complaint with existinguser");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				List<Customer> clist = per.viewAllCustomer();
				for(Customer c:clist) {
					System.out.println(((Person)c).id+" "+((Person)c).name);
				}
				break;
				
			case 2:
				System.out.println("enter the keyid");
				int id = sc.nextInt();
				List<Complaint> list=per.viewComplaintsById(id);
				for(Complaint com: list) {
					System.out.println(com.cid+" "+com.title+" "+com.description+" "+com.status+" "+com.customerId);
				}
				break;
			case 3:
				System.out.println("enter the complaint id");
				int cid=sc.nextInt();
				Complaint comp=per.viewComplaintStatus(cid);
				if(comp.status==0) {
					System.out.println("your complaint title is"+comp.title+"and your complaint status is"+comp.status);
				}
				else {
					System.out.println("your complaint title is"+comp.title+"and your complaint status is"+comp.status);
				}
				break;
			case 4:
				System.out.println("enter the id");
				int id2 =sc.nextInt();
				System.out.println("enter customer name");
				String name = sc.next();
				System.out.println("enter the complaint id");
				int cid1=sc.nextInt();
				System.out.println("enter title");
				String title = sc.next();
				System.out.println("enter description");
				String description =sc.next();
				Complaint com = new Complaint(cid1,title,description,1,id2);
				Person p = new Person(id2,name,com);
				boolean b = per.launchComplaintWithExistingUser(p);
				if(b) {
					System.out.println("complaint registered");
				}else {
					System.out.println("some peoblem");
				}
				break;
			case 5:
				System.out.println("enter the id");
				int oid =sc.nextInt();
				System.out.println("enter customer name");
				String oname = sc.next();
				System.out.println("enter the complaint id");
				int ocid1=sc.nextInt();
				System.out.println("enter title");
				String otitle = sc.next();
				System.out.println("enter description");
				String odescription =sc.next();
				Complaint ocom = new Complaint(ocid1,otitle,odescription,1,oid);
				Person op = new Person(oid,oname,ocom);
				boolean b1 = per.launchComplaintWithOldUser(op);
				if(b1) {
					System.out.println("complaint registered");
				}else {
					System.out.println("some peoblem");
				}
				break;
			default:
				break;
			}
			System.out.println("press y for main menu");
			cr=sc.next().charAt(0);
		}while(cr=='Y'||cr=='y');
	}

}