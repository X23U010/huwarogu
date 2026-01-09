package Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Dao.Divination_Logic;
import Dao.Setting_Dao;
import Model.Divination;
import Model.Member;

@WebServlet("/Setting_Servlet")
public class Setting_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String forward = "";
		String message = ""; // 処理結果メッセージ
		
		HttpSession session = request.getSession();
		Member mem = (Member) session.getAttribute("loginMember");

		String action = request.getParameter("action");

		if ("setting_B".equals(action)) {

			forward = "Setting_B";
		} else if ("setting_C".equals(action)) {

			forward = "Setting_C";
		} else if ("setting_D".equals(action)) {

			forward = "Setting_D";
		} else if ("setting_E_password".equals(action)) {
			
			String password = mem.getMember_password();
			
			
			mem.setMember_password(request.getParameter("password"));
			

			Setting_Dao setting_dao = new Setting_Dao();

			if (!(password.equals(mem.getMember_password()))) {
				setting_dao.Member_Update(mem);
				System.out.println(mem.getMember_password());
				
				System.out.println("パスワード更新");
				
			} else {
				System.out.println("該当処理なし");	
			}

			Divination_Logic dlogic = new Divination_Logic();
            Divination d = dlogic.divination_execute();
            request.setAttribute("divinationResult", d);
            request.setAttribute("message", message);
            
			forward = "Setting_E";
			
		} else if ("setting_E_teacher_id".equals(action)) {
			

			

			

			forward = "Setting_E";
			
		} else if ("setting_E_sub_teacher_id".equals(action)) {
			
			

			forward = "Setting_E";
			
		} else if ("back_top".equals(action)) {

			forward = "005";
		}

		session.setAttribute("loginMember", mem);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Page_" + forward + ".jsp");
		dispatcher.forward(request, response);
	}

}
