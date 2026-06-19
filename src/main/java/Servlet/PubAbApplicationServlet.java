package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Dao.Application_Dao;
import Dao.Application_Logic;
import Model.Member;
import Model.Public_Absence;

@WebServlet("/PubAbApplicationServlet")
public class PubAbApplicationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		
		HttpSession session = request.getSession();
		Member mem = (Member) session.getAttribute("loginMember");
		
		if(action.equals("Indetail")) {
			
			Application_Logic app_logic = new Application_Logic();
			Public_Absence public_absence = new Public_Absence();
			public_absence = app_logic.Public_Absence_Search(id);
			
			session.setAttribute("public_absence_info", public_absence);
			session.setAttribute("public_absence_name", app_logic.Name_Search(public_absence.getStudent_id()));
		}

		session.setAttribute("loginMember", mem);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Page_Public_Absence.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action"); // 承認 or 却下
		String[] ids = request.getParameterValues("publicAbsenceIds");
		HttpSession session = request.getSession();
		Application_Dao app = new Application_Dao();
		
		System.out.println("公欠申請処理");
		
		if (ids != null) {
		        if ("公欠承認".equals(action)) {
		            // 承認処理
		        	app.PermissionPublicAbsence(ids);
		        	
		        	System.out.println("承認");
		        } else if ("公欠却下".equals(action)) {
		            // 却下処理
		        	app.DenyPublicAbsence(ids);
		        	System.out.println("却下");
		        }
		}
		
		ArrayList<Public_Absence> public_absence_list = app.getPublicAbsenceList();
		session.setAttribute("PuAbList",public_absence_list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Page_022.jsp");
		dispatcher.forward(request, response);	}

}
