package Servlet;

import java.io.IOException;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Dao.Report_Logic;
import Model.Member;
import Model.Report;

/**
 * Servlet implementation class Report_Servlet
 */
@WebServlet("/Report_Servlet")
public class Report_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String forward = "";

		HttpSession session = request.getSession();
	    Member mem = (Member) session.getAttribute("loginMember");

		String action = request.getParameter("action");

		
		if("next_B".equals(action)) {
			
			//Report.javaをインスタンス化↓
			Report report = new Report();
			
			//Page010_Aで受け取った内容をBeansにセット↓
			
			
			//セッションに保存↓
			session.setAttribute("report_info", report);
			
			forward = "010_B";
			
		} else if ("next_C".equals(action)) {
			
			//セッションを取得
			Report report = (Report) session.getAttribute("report_info");
			
			//Page010_Bで受け取った内容をBeansにセット↓
			
			
			//セッションに保存↓
			session.setAttribute("report_info", report);
			
			forward = "010_C";

		}if ("report_register".equals(action)) {
			
			//セッションを取得↓
			Report report = (Report) session.getAttribute("report_info");
			
			//Page010_Cで受け取った内容をBeansにセット↓
			
			
			//セッションに保存↓
			session.setAttribute("report_info", report);
			
			forward = "011";

		} else if ("report_register_comit".equals(action)) {
			
			//Report report = (Report) session.getAttribute("report_info");

			//DBに保存する↓
			Report_Logic report_logic = new Report_Logic();
			Report report = new Report();
			
			Date d = new Date();
			
			report.setReport_subject_type_id(request.getParameter("activity-content"));
			report.setReport_menber_id(mem.getMember_id());
			report.setReport_deadline(d.toString());
			report.setReport_implement(request.getParameter("activity-report"));
			report.setReport_location(request.getParameter("activity-location"));
			report.setReport_starttime(request.getParameter("activity-starttime"));
			report.setReport_finishtime(request.getParameter("activity-finishtime"));
			report.setReport_txt(request.getParameter("activity-report"));
			report.setReport_flag("0");
			
			boolean isSubmit = report_logic.execute(report);
			
			if(isSubmit) {
				System.out.println("OK");
			}else {
				System.out.println("NG");
			}
			forward = "012";

		} else if ("back_top".equals(action)) {
			
			//report_infoのセッションを削除↓
			session.removeAttribute("report_info");
			
			forward = "005";

		}
		
		session.setAttribute("loginMember", mem);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Page_" + forward + ".jsp");
		dispatcher.forward(request, response);
	}

}
