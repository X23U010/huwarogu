package Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Dao.Login_Logic;
import Model.Menber;

@WebServlet("/Login_Servlet")
public class Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//リクエストパラメータの取得
		String id = request.getParameter("student_id");
		String pass = request.getParameter("password");
		String role = "";

		//パスワードをSHA256でハッシュ化する
		//String hash = DigestUtils.sha256Hex(pass);

		System.out.println(id);
		System.out.println(pass);

		//JavaBeansを生成する
		Menber menber = new Menber(id,pass);

		Login_Logic login_logic = new Login_Logic();

		//ログイン認証をする
		boolean isLogin = login_logic.execute(menber);

		//フォワード先
		String forward = "";
		System.out.println(isLogin);

		System.out.println(menber.getMenber_id());
		System.out.println(menber.getMenber_name());
		System.out.println(menber.getMenber_password());
		System.out.println(menber.getMenber_month());

		if (isLogin) {
			//認証OKの場合

			String idStr = menber.getMenber_id();
			if (idStr.startsWith("x")) {
				role = "student";
			} else if (idStr.startsWith("t")) {
				role = "teacher";
			} else {
				role = "unknown";
			}
			System.out.println(role);
			//セッションを開始する
			HttpSession session = request.getSession();
			//セッションスコープにユーザ情報を保存する
			session.setAttribute("loginMenber", menber);
			
			session.setAttribute("userRole", role); 

			forward = "005";

		} else {

			forward = "004";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Page_" + forward + ".jsp");
		dispatcher.forward(request, response);
	}

}
