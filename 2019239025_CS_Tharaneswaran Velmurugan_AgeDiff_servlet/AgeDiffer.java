package com.msc.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/**
 * Servlet implementation class AgeDiff
 */
@WebServlet("/AgeDiffer")
public class AgeDiffer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgeDiffer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 String title = "Age Difference";
	     String Name = request.getParameter("name");
	     String DOB = request.getParameter("dob");
	     
	     try {
	    	 SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	    	 Date date = formatter.parse(DOB);
	    	 Instant instant = date.toInstant();
	         ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
	         LocalDate givenDate = zone.toLocalDate();
	         Period diff = Period.between(givenDate, LocalDate.now());
	     
	      String docType =
	         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
	         
	      out.println(docType +
	         "<html>\n" +
	            "<head><title>" + title + "</title></head>\n" +
	            "<body bgcolor = \"#f0f0f0\">\n" +
	               "<h1 align = \"center\">" + title + "</h1>\n" +
	               "<ul>\n" +
	                  "  <b>Name</b>: "+ Name + "<br>"+"\n<br>"
	                  + "  <li><b>Date Of Birth</b>: "+" "+DOB+"<br>"+"\n<br>"
	                  +"<li><b>Current Date</b>: "+" "+ LocalDate.now() +"<br>"+"\n<br>"
	                  +"  <li><b>Current Age</b>: "+ " " +"<br>"+ diff.getYears() +"  "+"<b>Years</b> "+" , "+ diff.getMonths() +" "+ "  <b>Months</b> "+" , "+ diff.getDays()+" "+"<b>Days</b> "
	                 + "\n" +
	               "</ul>\n" +
	            "</body>" +
	         "</html>"
	      );
	      out.flush();
	      out.close();
	     	} 
	     catch (ParseException e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 	}
   
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
