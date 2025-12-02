package Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Model.Menber;

@WebServlet("/HuwaLog_Servlet")
public class HuwaLog_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";

		Menber men = (Menber) request.getAttribute("loginMenber");

		// 文字化け対策
		request.setCharacterEncoding("UTF-8");

		// JSPのフォームから値を受け取る
		String action = request.getParameter("action");

		if ("007".equals(action)) {
			//公欠申請
			forward = "007";

		} else if ("006".equals(action)) {
			//お知らせ
			forward = "006";

		} else if ("010".equals(action)) {
			//報告書提出
			forward = "010";

		} else if ("013".equals(action)) {
			//授業出席
			forward = "013";

		} else if ("016".equals(action)) {
			//欠席届提出
			forward = "016";

		} else if ("019".equals(action)) {
			//欠席設定
			forward = "019";

		} else if ("022".equals(action)) {
			//公欠申請一覧
			forward = "022";

		} else if ("025".equals(action)) {
			//公欠・欠席一覧
			forward = "025";

		} else if ("026".equals(action)) {
			//各種授業出席率
			forward = "026";

		}else if ("Setting".equals(action)){
			//設定
			forward = "Setting";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Page_" + forward + ".jsp");
		dispatcher.forward(request, response);
	}

}
