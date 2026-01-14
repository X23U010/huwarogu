package Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Dao.Application_Dao;

@WebServlet("/AbApplicationServlet")
public class AbApplicationServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action"); // 承認 or 却下
		String[] ids = request.getParameterValues("absenceIds");
		Application_Dao app = new Application_Dao();
		
		System.out.println("欠席届処理");

		
		if (ids != null) {
		        if ("欠席承認".equals(action)) {
		            // 承認処理
		        	app.PermissionAbsence(ids);
		    		System.out.println("承認");

		        } else if ("欠席却下".equals(action)) {
		            // 却下処理
		        	app.DenyAbsence(ids);
		    		System.out.println("却下");

		        }
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Page_005.jsp");
		dispatcher.forward(request, response);
	}

}
