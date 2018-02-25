package com.webtracker.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class TestDb
 */
@WebServlet("/TestDb")
public class TestDb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = "springstudent";
		String pass = "springstudent";
		String jdbcUrl = "jdbc:mysql://localhost:3306/crm_customer_tracker?useSSL=false";
		String driverClass = "com.mysql.jdbc.Driver";
		
		try{
			PrintWriter out = response.getWriter();
			out.print("Connecting to database "+jdbcUrl);
			Class.forName(driverClass);
			Connection dbCon = DriverManager.getConnection(jdbcUrl, user, pass);
			out.println("\nSuccessfull.");
			dbCon.close();
		}catch(Exception exc){
			exc.printStackTrace();
		}

	}

}
