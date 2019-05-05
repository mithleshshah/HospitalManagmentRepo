package com.mith.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import com.mith.dao.NurseDao;
import com.mith.dao.ReportDao;
import com.mith.model.Report;

/**
 * Servlet implementation class ReportSubmit
 */
@WebServlet("/ReportSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)
public class ReportSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		 Report r=new Report();
		  r.setReportNo(request.getParameter("rno"));
		  r.setType(request.getParameter("typ"));
		  r.setRdesc(request.getParameter("rdesc"));
		  r.setRdate(request.getParameter("rdate"));
		  r.setDocname(request.getParameter("dname"));
		  r.setPatname(request.getParameter("pname"));
		  
		  try{
				Part part=request.getPart("rpt");
				String savepath="C:/Users/Mithlesh Shah/Documents/Workspace1/HMS/WebContent/report";
				FileUpload F=new FileUpload(part,savepath);
				r.setReport(F.filename);
			}catch(Exception e){
				System.out.println(e);
			}
			
			out.println("<html>");
			boolean st=ReportDao.addNewRecord(r);
			if(st)
			{ out.println("<h4><font color=green>Report Added...<br><a href=ReportView>Click Here to Add More Report</a></font></h4>");
			}
			else
			{
				out.println("<h4><font color=red>Fail to Add Report.....</font></h4>");	
			}
		 	out.flush();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
