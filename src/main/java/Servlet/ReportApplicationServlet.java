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
import Model.Report;

@WebServlet("/ReportApplicationServlet")
public class ReportApplicationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		
		HttpSession session = request.getSession();
		Member mem = (Member) session.getAttribute("loginMember");
		
		if(action.equals("Indetail")) {
			
			Application_Logic app_logic = new Application_Logic();
			Report report = new Report();
			report = app_logic.Report_Search(id);
			
			session.setAttribute("report_info", report);
			session.setAttribute("report_name", app_logic.Name_Search(report.getStudent_id()));
		}

		session.setAttribute("loginMember", mem);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Page_Report.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action"); // 承認 or 却下
		String[] ids = request.getParameterValues("reportIds");
		HttpSession session = request.getSession();
		Application_Dao app = new Application_Dao();
		
		System.out.println("報告書処理");

		if (ids != null) {
			if ("報告書承認".equals(action)) {
				// 承認処理
				app.PermissionReport(ids);
				
				System.out.println("承認");
				
			} else if ("報告書却下".equals(action)) {
				// 却下処理
				app.DenyPublicReport(ids);
				
				System.out.println("却下");
			}
		}

		ArrayList<Report> reportList = app.getReportList();
		session.setAttribute("reportList",reportList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Page_022.jsp");
		dispatcher.forward(request, response);
	}
}
