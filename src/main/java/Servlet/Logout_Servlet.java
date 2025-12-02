package Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Logout_Servlet")
public class Logout_Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 今のセッションを取得
        HttpSession session = request.getSession(false);

        if (session != null) {
            // ログイン情報などを削除
            session.invalidate();
        }

        // ログアウト後は001（ログインページ）へ飛ばす
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Page_001.jsp");
		dispatcher.forward(request, response);
      
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
