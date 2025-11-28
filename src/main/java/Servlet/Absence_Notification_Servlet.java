package Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Model.Menber;

/**
 * Servlet implementation class Absence_Notification_Servlet
 */
@WebServlet("/Absence_Notification_Servlet")
public class Absence_Notification_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String forward = "";
		Menber men = (Menber) request.getAttribute("loginMenber");
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		// JSPのフォームから値を受け取る
		
		String action = request.getParameter("action");
		
		if ("adsence_register".equals(action)) {
			forward = "017";

		} else if ("adsence_register_comit".equals(action)) {
			
			forward = "018";

		} else if ("back_top".equals(action) || "005".equals(action)) {

			forward = "005";

		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Page_" + forward + ".jsp");
		dispatcher.forward(request, response);
		
	}

}
