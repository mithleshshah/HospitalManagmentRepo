package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mith.dao.BedAllotmentDao;
import com.mith.dao.DDonorDao;
import com.mith.model.DDonor;

/**
 * Servlet implementation class DonorSubmit
 */
@WebServlet("/DonorSubmit")
public class DonorSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonorSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("<a href=DBloodBank.jsp>Click Here to Add More Donors</a>");
		 DDonor d=new DDonor();
		  d.setDonorid(request.getParameter("doid"));
		  d.setDonorname(request.getParameter("dname"));
		  d.setDonorage(request.getParameter("dage"));
		  d.setDonorsex(request.getParameter("gend"));
		  d.setBloodgroup(request.getParameter("dgrp"));
		  d.setLastdonationdate(request.getParameter("ldate"));
		  out.println("<html>");
			boolean st=DDonorDao.addNewRecord(d);
			if(st)
			{ response.sendRedirect("DDonorList");
			}
			else
			{
				out.println("<h4><font color=red>Fail to Register Donor.....</font></h4>");	
			}
		 	out.flush();
	}

}
