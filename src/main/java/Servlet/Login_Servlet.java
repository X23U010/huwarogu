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
import Model.Member;

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

		//JavaBeansを生成する
		Member mem = new Member(id, pass);

		Login_Logic login_logic = new Login_Logic();

		//ログイン認証をする
		boolean isLogin = login_logic.execute(mem);

		//フォワード先
		String forward = "";

		System.out.println(mem.getMember_id());
		System.out.println(mem.getMember_name());
		System.out.println(mem.getMember_password());
		System.out.println(mem.getMember_month());
		System.out.println(mem.getMember_teacher_id());
		System.out.println(mem.getMember_subteacher_id());

		if (isLogin) {
			//認証OKの場合

			String idStr = mem.getMember_id();
			if (idStr.startsWith("x")) {
				role = "student";
			} else if (idStr.startsWith("t")) {
				role = "teacher";
			} else {
				role = "unknown";
			}

			//System.out.println(role);
			//セッションを開始する
			HttpSession session = request.getSession();
			//セッションスコープにユーザ情報を保存する
			session.setAttribute("loginMember", mem);

			session.setAttribute("userRole", role);

			if (role.equals("student") && mem.getMember_teacher_id() == null) {

				forward = "setting_C";

			} else {
				forward = "005";
			}

		} else {

			forward = "004";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Page_" + forward + ".jsp");
		dispatcher.forward(request, response);
	}

}
