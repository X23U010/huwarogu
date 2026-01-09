package Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Model.Member;

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
			forward = "022";

		} else if ("025".equals(action)) {
			//公欠・欠席一覧
			forward = "025";

		} else if ("setting_A".equals(action)){
			//設定
			forward = "Setting_A";
		}

		session.setAttribute("loginMember", mem);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Page_" + forward + ".jsp");
		dispatcher.forward(request, response);
	}

}
