package Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import Dao.Login_Logic;
import Model.Menber;


@WebServlet("/Login_Servlet")
public class Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward = null;

		HttpSession session = request.getSession();

		if (session.getAttribute("loginMenber") == null) {
			forward = "index.jsp";
		} else {
			forward = "loginResult.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/" + forward);
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");
		
		//リクエストパラメータの取得
		String id = request.getParameter("manber_id");
		String pass = request.getParameter("menber_password");
		
		//パスワードをSHA256でハッシュ化する
		String hash = DigestUtils.sha256Hex(pass);
		
		//JavaBeansを生成する
				Menber menber = new Menber(id, hash);
				
				Login_Logic login_logic = new Login_Logic();
				
				//ログイン認証をする
				boolean isLogin = login_logic.execute(menber);
				
				//フォワード先
				String save = "";

				if (isLogin) {
					//認証OKの場合

					//セッションを開始する
					HttpSession session = request.getSession();

					//セッションスコープにユーザ情報を保存する
					session.setAttribute("loginMenber", menber);
					
					save = "";
					
				} else {
					//認証NGの場合

					//リクエストスコープエラーメッセージを設定
					request.setAttribute("errorMessage", "入力に誤りがあります。");


					save = "";
				}

				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Page" + save + ".jsp");
				dispatcher.forward(request, response);
	}

}
