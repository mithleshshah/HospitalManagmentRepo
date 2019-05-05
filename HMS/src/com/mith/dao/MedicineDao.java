package com.mith.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mith.model.Medicine;


public class MedicineDao {

	public static String provider="jdbc:mysql://localhost:3306/hms";	
	public static String uid="root";
	public static String pwd="monalisa";


	public static boolean addNewRecord(Medicine m)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,uid,pwd);
			String query="insert into medicine values('"+m.getMedNo()+"','"+m.getMName()+"','"+m.getMCategory()+"','"+m.getMdescription()+"','"+m.getMPrice()+"','"+m.getMCName()+"','"+m.getMStatus()+"')";
			boolean st=DBHelper.executeUpdate(query, cn);
			System.out.println(query);
			return(st);
		}
		catch(Exception e)
		{
			
			System.out.println(e);
			return(false);
		}


	}


	public static ResultSet displayAll()
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="select * from medicine";
	  ResultSet rs=DBHelper.executeQuery(query, cn);
	  return(rs);
	  
	}catch(Exception e){
		System.out.println(e);
		return null;
	 }
		
	}

	public static Medicine displayById(String mno)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="select * from medicine where medicineno='"+mno+"'";
	  ResultSet rs=DBHelper.executeQuery(query, cn);
	  if(rs.next())
	  {
		 Medicine m=new Medicine();
		 m.setMedNo(rs.getString(1));
		 m.setMName(rs.getString(2));
		 m.setMCategory(rs.getString(3));
		 m.setMdescription(rs.getString(4));
		 m.setMPrice(rs.getString(5));
		 m.setMCName(rs.getString(6));
		 m.setMStatus(rs.getString(7));
	  return(m);
		  
	  }
	  return(null);
	  
	}
	catch(Exception e){
		System.out.println(e);
		return null;
	 }
		
	}

	public static boolean deleteById(String mno)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="delete from medicine where medicineno='"+mno+"'";
	  boolean st=DBHelper.executeUpdate(query, cn);
	  
	   
	  return(st);
	  
	}catch(Exception e){
		System.out.println(e);
		return false;
	 }

	}

	public static boolean editRecord(Medicine m)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="update medicine set medname='"+m.getMName()+"',medcategory='"+m.getMCategory()+"',meddescription='"+m.getMdescription()+"',medprice='"+m.getMPrice()+"',medcomname='"+m.getMCName()+"',medstatus='"+m.getMStatus()+"' where medicineno='"+m.getMedNo()+"'";
	  System.out.println(query); 
	  boolean st=DBHelper.executeUpdate(query, cn);
	   return(st);
	}catch(Exception e){
		System.out.println(e);
		return false;
	 }
		
	}
}
