package Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Dao.Lesson_Logic;
import Model.Menber;

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

			forward = "009";

		} else if ("back_top".equals(action) || "005".equals(action)) {

			forward = "005";

		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Page_" + forward + ".jsp");
		dispatcher.forward(request, response);
		
	}

}
