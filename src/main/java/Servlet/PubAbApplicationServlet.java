package Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Dao.Application_Dao;

@WebServlet("/PubAbApplicationServlet")
public class PubAbApplicationServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action"); // 承認 or 却下
		String[] ids = request.getParameterValues("publicAbsenceIds");
		Application_Dao app = new Application_Dao();
		
		System.out.println("公欠申請処理");
		
		if (ids != null) {
		        if ("公欠承認".equals(action)) {
		            // 承認処理
		        	app.PermissionPublicAbsence(ids);
		        	
		        	System.out.println("承認");
		        } else if ("公欠却下".equals(action)) {
		            // 却下処理
		        	app.DenyPublicReport(ids);
		        	System.out.println("却下");
		        }
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Page_005.jsp");
		dispatcher.forward(request, response);	}

}
