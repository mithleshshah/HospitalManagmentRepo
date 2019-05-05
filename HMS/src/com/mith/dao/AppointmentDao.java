package com.mith.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mith.model.Appointment;


public class AppointmentDao {

		public static String provider="jdbc:mysql://localhost:3306/hms";	
		public static String uid="root";
		public static String pwd="monalisa";


		public static boolean addNewRecord(Appointment a)
		{
			try{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection cn=DriverManager.getConnection(provider,uid,pwd);
				String query="insert into dappointment values('"+a.getAid()+"','"+a.getName()+"','"+a.getEmail()+"','"+a.getAdress()+"','"+a.getPhone()+"','"+a.getDepartment()+"','"+a.getDate()+"','"+a.getIcon()+"')";
				boolean st=DBHelper.executeUpdate(query, cn);
				System.out.println();
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
		  String query="select * from dappointment";
		  ResultSet rs=DBHelper.executeQuery(query, cn);
		  return(rs);
		  
		}catch(Exception e){
			System.out.println(e);
			return null;
		 }
			
		}

		public static Appointment displayById(String aid)
		{ try{
		  Class.forName("com.mysql.jdbc.Driver").newInstance();	
		  Connection cn=DriverManager.getConnection(provider,uid,pwd);
		  String query="select * from dappointment where aid='"+aid+"'";
		  ResultSet rs=DBHelper.executeQuery(query, cn);
		  if(rs.next())
		  {Appointment a=new Appointment();
		  a.setAid(rs.getString(1));
		  a.setName(rs.getString(2));
		  a.setEmail(rs.getString(3));
		  a.setAdress(rs.getString(5));
		  a.setPhone(rs.getString(6));
		  a.setDepartment(rs.getString(7));
		  a.setDate(rs.getString(8));
		  a.setIcon(rs.getString(9));
		  return(a);
			  
		  }
		  return(null);
		  
		}
		catch(Exception e){
			System.out.println(e);
			return null;
		 }
			
		}	
}
