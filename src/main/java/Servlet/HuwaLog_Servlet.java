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
import Dao.List_Dao;
import Dao.Setting_Dao;
import Model.Absence;
import Model.Member;
import Model.Public_Absence;
import Model.Report;

@WebServlet("/HuwaLog_Servlet")
public class HuwaLog_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String forward = "";

		HttpSession session = request.getSession();
	    Member mem = (Member) session.getAttribute("loginMember");
	   
		// JSPのフォームから値を受け取る
		String action = request.getParameter("action");

		if ("007_A".equals(action)) {
			//公欠申請
			forward = "007_A";

		} else if ("010_A".equals(action)) {
			//報告書提出
			forward = "010_A";

		} else if ("016".equals(action)) {
			//欠席届提出
			forward = "016";

		} else if ("022".equals(action)) {
			//公欠申請一覧
			Application_Dao app = new Application_Dao();
			ArrayList<Absence> abList = app.getAbsenceList();
			ArrayList<Public_Absence> PuAbList = app.getPublicAbsenceList();
			ArrayList<Report> reportList = app.getReportList();
			session.setAttribute("abList",abList);
			session.setAttribute("PuAbList",PuAbList);
			session.setAttribute("reportList",reportList);
			
			forward = "022";

		} else if ("025".equals(action)) {
			//公欠・欠席一覧
			List_Dao list_dao = new List_Dao();
			ArrayList<Absence> abList = list_dao.getAbList();
			ArrayList<Public_Absence> PuAbList = list_dao.getPuAbList();
			session.setAttribute("abList",abList);
			session.setAttribute("PuAbList",PuAbList);
						
			forward = "025";

		} else if ("setting_A".equals(action)){
			//設定
			Setting_Dao Setting_dao = new Setting_Dao();
			ArrayList<Member> teacher_list = Setting_dao.Teacher_findAll();
			request.setAttribute("teacher_list", teacher_list);
			
			forward = "Setting_A";
		}

		session.setAttribute("loginMember", mem);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Page_" + forward + ".jsp");
		dispatcher.forward(request, response);
	}

}
