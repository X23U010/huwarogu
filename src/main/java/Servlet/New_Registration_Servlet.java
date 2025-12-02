package Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Model.Menber;

@WebServlet("/New_Registration_Servlet")
public class New_Registration_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		String action = request.getParameter("action");

		
		
		if ("new_registretion_register".equals(action)) {
			
			Menber menber = new Menber();
			menber.setMenber_id(request.getParameter("student_id"));
			menber.setMenber_name(request.getParameter("name"));
			menber.setMenber_month(request.getParameter("birth_month"));
			menber.setMenber_password(request.getParameter("password"));
			
			System.out.println(menber.getMenber_id());
			System.out.println(menber.getMenber_name());
			System.out.println(menber.getMenber_month());
			System.out.println(menber.getMenber_password());
			
			HttpSession session = request.getSession();
			session.setAttribute("member_info", menber); 
			
			forward = "003";

		} else if ("new_registretion_register_comit".equals(action)) {
	        HttpSession session = request.getSession(false);
	        session.invalidate();
			forward = "004";

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Page_" + forward + ".jsp");
		dispatcher.forward(request, response);
	}

}
