package com.cra.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cra.DTO.Complaint;
import com.cra.DTO.Customer;
import com.cra.DTO.Person;

public class UserDAO {

	Connection con;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	
	
	public UserDAO() {
		super();
		// TODO Auto-generated constructor stub
		con = new DBConnector().getCon();
	}
	
	public List<Customer> viewAllCustomer(){
		try {
			st=con.createStatement();
			rs=st.executeQuery("select*from customer");
			List<Customer> clist= new ArrayList<Customer>();
			while(rs.next()) {
				
				Person p = new Person();
				p.id=rs.getInt(1);
				p.name=rs.getString(2);
				clist.add(p);
				
			}
			return clist;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Complaint> viewComplaintsById(int id){
		try {
			pst=con.prepareStatement("select *from customer where id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			boolean b = rs.next();
			if(b) {
				pst=con.prepareStatement("select *from complaint where customerid=?");
				pst.setInt(1, id);
				rs=pst.executeQuery();
				List<Complaint> clist= new ArrayList<Complaint>();
				while(rs.next()) {
					Complaint c = new Complaint();
					c.cid=rs.getInt(1);
					c.title=rs.getString(2);
					c.description=rs.getString(3);
					c.status=rs.getInt(4);
					c.customerId=rs.getInt(5);
					clist.add(c);
				}
				return clist;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	} 
	public Complaint viewComplaintStatus(int id) {
		try {
			pst=con.prepareStatement("select *from complaint where cid=?");
			pst.setInt(1, id);
			rs=pst.executeQuery();
			while(rs.next()) {
				Complaint c = new Complaint();
				c.cid=rs.getInt(1);
				c.title=rs.getString(2);
				c.description=rs.getString(3);
				c.status=rs.getInt(4);
				c.customerId=rs.getInt(5);
				return c;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			}
		return null;
	} 
	public boolean registerNewComplaint(Person p) {
		try {
			pst=con.prepareStatement("insert into customer values(?,?)");
			pst.setInt(1, p.id);
			pst.setString(2, p.name);
			pst.execute();
			
		PreparedStatement pst1 = con.prepareStatement("insert into complaint values(?,?,?,?,?)");
		pst1.setInt(1, p.c.cid);
		pst1.setString(2, p.c.title);
		pst1.setString(3, p.c.description);
		pst1.setInt(4, 1);
		pst1.setInt(5, p.c.customerId);
		pst1.execute();
		return true;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean registerComplaintWithOldUser(Person p) {
		// TODO Auto-generated method stub
		try {
			pst=con.prepareStatement("select *from complaint where cid=?");
			pst.setInt(1, p.id);
			ResultSet r=pst.executeQuery();
			boolean b=r.next();
			if(b) {
				PreparedStatement pst1=con.prepareStatement("insert into complaint values(?,?,?,?,?)");
				pst1.setInt(1, p.c.cid);
				pst1.setString(2, p.c.title);
				pst1.setString(3, p.c.description);
				pst1.setInt(4, 1);
				pst1.setInt(5, p.c.customerId);
				pst1.execute();
				return true;
			}
			else {
				return false;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	
}