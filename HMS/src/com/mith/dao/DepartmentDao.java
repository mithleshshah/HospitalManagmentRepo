package com.mith.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mith.model.Department;

public class DepartmentDao {

public static String provider="jdbc:mysql://localhost:3306/hms";	
public static String uid="root";
public static String pwd="monalisa";


public static boolean addNewRecord(Department d)
{
	try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,uid,pwd);
		String query="insert into department values('"+d.getDeptid()+"','"+d.getDeptName()+"','"+d.getDeptDescription()+"')";
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
  String query="select * from department";
  ResultSet rs=DBHelper.executeQuery(query, cn);
  return(rs);
  
}catch(Exception e){
	System.out.println(e);
	return null;
 }
	
}

public static Department displayById(String deptid)
{ try{
  Class.forName("com.mysql.jdbc.Driver").newInstance();	
  Connection cn=DriverManager.getConnection(provider,uid,pwd);
  String query="select * from department where departmentid='"+deptid+"'";
  ResultSet rs=DBHelper.executeQuery(query, cn);
  if(rs.next())
  {Department d=new Department();
  d.setDeptid(rs.getString(1));
  d.setDeptName(rs.getString(2));
  d.setDeptDescription(rs.getString(3));
  return(d);
	  
  }
  return(null);
  
}
catch(Exception e){
	System.out.println(e);
	return null;
 }
	
}

public static boolean deleteById(String deptid)
{ try{
  Class.forName("com.mysql.jdbc.Driver").newInstance();	
  Connection cn=DriverManager.getConnection(provider,uid,pwd);
  String query="delete from department where departmentId='"+deptid+"'";
  boolean st=DBHelper.executeUpdate(query, cn);
  
   
  return(st);
  
}catch(Exception e){
	System.out.println(e);
	return false;
 }

}

public static boolean editRecord(Department d)
{ try{
  Class.forName("com.mysql.jdbc.Driver").newInstance();	
  Connection cn=DriverManager.getConnection(provider,uid,pwd);
  String query="update department set deptname='"+d.getDeptName()+"',deptdescription='"+d.getDeptDescription()+"' where departmentid='"+d.getDeptid()+"'";
  System.out.println(query); 
  boolean st=DBHelper.executeUpdate(query, cn);
   return(st);
}catch(Exception e){
	System.out.println(e);
	return false;
 }
	
}
}
