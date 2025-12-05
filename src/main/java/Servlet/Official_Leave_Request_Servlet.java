package Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Dao.Absence_Logic;
import Dao.Lesson_Logic;
import Model.Menber;
import Model.Request;

/**
 * Servlet implementation class Official_Leave_Request_Servlet
 */
@WebServlet("/Official_Leave_Request_Servlet")
public class Official_Leave_Request_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		Menber men = (Menber) request.getAttribute("loginMenber");
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		String action = request.getParameter("action");

		Lesson_Logic lesson_lgc = new Lesson_Logic();

		if ("official_leave_request_register".equals(action)) {

			forward = "008";

		} else if ("official_leave_request_register_comit".equals(action)) {
			
			Request officalRequest = new Request();
			Absence_Logic absence_logic = new Absence_Logic();
			Date nowDate = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = dateFormat.format(nowDate);

			
			officalRequest.setRequest_day(strDate);
			officalRequest.setRequest_flag(false);
			officalRequest.setRequest_implement(request.getParameter("date"));
			officalRequest.setRequest_menber_id(men.getMenber_id());
			officalRequest.setRequest_request_type_id("RT02");
			officalRequest.setRequest_txt(request.getParameter("reason"));
			
			absence_logic.execute(officalRequest);
			
			
			

			forward = "009";

		} else if ("back_top".equals(action) || "005".equals(action)) {

			forward = "005";

		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Page_" + forward + ".jsp");
		dispatcher.forward(request, response);
		
	}

}
