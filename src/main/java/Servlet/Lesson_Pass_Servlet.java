package Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Model.Menber;

@WebServlet("/Lesson_Pass_Servlet")
public class Lesson_Pass_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		Menber men = (Menber) request.getAttribute("loginMenber");
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		// JSPのフォームから値を受け取る
		String lesson_pass = request.getParameter("lesson-pass");
		String action = request.getParameter("action");

		// デバッグ用出力（後で削除OK)
		System.out.println("パスワード: " + lesson_pass);
		System.out.println("アクション: " + action);
		
		if ("lesson_pass_register_comit".equals(action)) {

			forward = "005";

		}else if ("back_top".equals(action)) {

			forward = "005";

		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Page_" + forward + ".jsp");
		dispatcher.forward(request, response);
		
	}

}
