package Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Model.Menber;

@WebServlet("/Top_Servlet")
public class Top_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		Menber men = (Menber) request.getAttribute("loginMenber");
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		// JSPのフォームから値を受け取る
		String action = request.getParameter("action");

		if ("new".equals(action)) {
			forward = "002";
		} else if ("login".equals(action)) {
			forward = "004";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Page_" + forward + ".jsp");
		dispatcher.forward(request, response);
		
	}

}
