package Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Dao.Lesson_Logic;
import Model.Lesson;
import Model.Menber;

@WebServlet("/Lesson_Attendance_Servlet")
public class Lesson_Attendance_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String forward = "";
		Menber men = (Menber) request.getAttribute("loginMenber");
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		// JSPのフォームから値を受け取る
		String lesson_id = request.getParameter("lesson-id");
		String lesson_password = request.getParameter("lesson-password");
		String action = request.getParameter("action");

		// デバッグ用出力（後で削除OK）
		System.out.println("授業ID: " + lesson_id);
		System.out.println("パスワード: " + lesson_password);

		//パスワード認証ロジック

		Lesson lesson = new Lesson();
		lesson.setLesson_id(lesson_id);
		lesson.setLesson_password(lesson_password);

		Lesson_Logic lesson_lgc = new Lesson_Logic();

		if ("register".equals(action)) {

			if (lesson_lgc.execute(lesson)) {
				forward = "014";
			} else {

				forward = "013";
			}

		} else if ("register_comit".equals(action)) {

			forward = "015";

		} else if ("013".equals(action)) {

			forward = "013";

		} else if ("back_top".equals(action) || "005".equals(action)) {

			forward = "005";

		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Page_" + forward + ".jsp");
		dispatcher.forward(request, response);
		
	}

}
