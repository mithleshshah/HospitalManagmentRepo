package com.mith.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mith.model.Admin;

public class AdminDao {

	static String provider="jdbc:mysql://localhost:3306/hms";
	static String uid="root";
	static String pwd="monalisa";
	
	public static Admin checkPassword(String uname,String pwd)
	{ try{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();	
	  Connection cn=DriverManager.getConnection(provider,uid,pwd);
	  String query="select * from admin where name='"+uname+"' and password='"+pwd+"'";
	  ResultSet rs=DBHelper.executeQuery(query, cn);
	  if(rs.next())
	  {Admin A=new Admin();
	   A.setAdminid(rs.getString(1));
	   A.setAdminname(rs.getString(2));
	   A.setPassword(rs.getString(3));
	   return(A);
	     
	  }
	  return(null);
	  
	}catch(Exception e){
		System.out.println(e);
		return null;
	 }
	}	
}
