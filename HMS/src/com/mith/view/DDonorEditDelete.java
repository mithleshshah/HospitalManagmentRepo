package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.DAppointmentDao;
import com.mith.dao.DDonorDao;
import com.mith.model.DDonor;

/**
 * Servlet implementation class DDonorEditDelete
 */
@WebServlet("/DDonorEditDelete")
public class DDonorEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DDonorEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String btn=request.getParameter("btn");
		if(btn.equalsIgnoreCase("Delete"))
		{
			String doid=request.getParameter("doid");
			boolean st=DDonorDao.deleteById(doid);
		}
		else if(btn.equalsIgnoreCase("Edit"))
		{
			 DDonor d=new DDonor();
			  d.setDonorid(request.getParameter("doid"));
			  d.setDonorname(request.getParameter("dname"));
			  d.setDonorage(request.getParameter("dage"));
			  d.setDonorsex(request.getParameter("gend"));
			  d.setBloodgroup(request.getParameter("dgrp"));
			  d.setLastdonationdate(request.getParameter("ldate"));
			  
			  DDonorDao.editRecord(d);
		}
		response.sendRedirect("DDonorList");
		}

}
