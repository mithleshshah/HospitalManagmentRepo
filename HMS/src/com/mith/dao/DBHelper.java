package com.mith.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBHelper {

public static boolean executeUpdate(String query, Connection cn)
{
	try{
Statement smt=cn.createStatement();
smt.executeUpdate(query);
return(true);
	}
	catch(Exception e)
	{
		System.out.println(e);
		return(false);
		
	}
}

public static ResultSet executeQuery(String query, Connection cn)
{
	try{
		Statement smt=cn.createStatement();
		ResultSet rs=smt.executeQuery(query);
		return(rs);
	} 
	catch(Exception e)
	{
		System.out.println(e);
		return(null);	
	}


}





}
