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
import Model.Menber;
import Model.Report;

/**
 * Servlet implementation class Report_Servlet
 */
@WebServlet("/Report_Servlet")
public class Report_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String forward = "";
		Menber men = (Menber) request.getAttribute("loginMenber");
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		
		String action = request.getParameter("action");

		if ("report_register".equals(action)) {
			forward = "011";

		} else if ("report_register_comit".equals(action)) {
			Report_Logic report_logic = new Report_Logic();
			Report report = new Report();
			HttpSession session = request.getSession();
			Menber member = (Menber)session.getAttribute("loginMenber");
			Date d = new Date();
			
			report.setReport_subject_type_id(request.getParameter("activity-content"));
			report.setReport_menber_id(member.getMenber_id());
			report.setReport_deadline(d.toString());
			report.setReport_implement(request.getParameter("activity-report"));
			report.setReport_location(request.getParameter("activity-location"));
			report.setReport_starttime(request.getParameter("activity-starttime"));
			report.setReport_finishtime(request.getParameter("activity-finishtime"));
			report.setReport_txt(request.getParameter("activity-report"));
			report.setReport_flag(false);
			
			boolean isSubmit = report_logic.execute(report);
			
			if(isSubmit) {
				System.out.println("OK");
			}else {
				System.out.println("NG");
			}
			forward = "012";

		} else if ("back_top".equals(action) || "005".equals(action)) {

			forward = "005";

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Page_" + forward + ".jsp");
		dispatcher.forward(request, response);
	}

}
