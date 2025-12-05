package Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Dao.Add_Member_Dao;
import Model.Menber;

@WebServlet("/New_Registration_Servlet")
public class New_Registration_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String msg = "入力してください。";
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		String action = request.getParameter("action");

		
		
		if ("new_registretion_register".equals(action)) {
			
			Menber menber = new Menber();
			menber.setMenber_id(request.getParameter("student_id"));
			menber.setMenber_name(request.getParameter("name"));
			menber.setMenber_month(request.getParameter("birth_month"));
			menber.setMenber_password(request.getParameter("password"));
			
			HttpSession session = request.getSession();
			session.setAttribute("member_info", menber); 
			
			forward = "003";

		} else if ("new_registretion_register_comit".equals(action)) {	
			
	        HttpSession session = request.getSession(false);
	        Menber member = (Menber) session.getAttribute("member_info");
	        		Add_Member_Dao AMD = new Add_Member_Dao();
	       
	        if(AMD.AddMember(member)) {
	        	forward = "004";
	        	session.invalidate();
	        }else {
	        	msg = "学籍番号が重複しています。";
				session.setAttribute("message",msg); 
	        	forward = "003";
	        	
	        }
	        
		

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Page_" + forward + ".jsp");
		dispatcher.forward(request, response);
	}

}
