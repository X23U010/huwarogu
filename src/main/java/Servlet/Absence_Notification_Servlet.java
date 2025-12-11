package Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Dao.Absence_Logic;
import Model.Member;
import Model.Request;

/**
 * Servlet implementation class Absence_Notification_Servlet
 */
@WebServlet("/Absence_Notification_Servlet")
public class Absence_Notification_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 文字化け対策
		request.setCharacterEncoding("UTF-8");
		String forward = "";
		
		HttpSession session = request.getSession();
	    Member men = (Member) session.getAttribute("loginMember");
		

		// JSPのフォームから値を受け取る
		String action = request.getParameter("action");

		if ("absence_register".equals(action)) {
			
			//Absence.javaをインスタンス化↓
			//Absence_Notification absence_notification = new Absence_Notification();
			
			//Page_016で受けっとった内容をBeansにセット↓
			
			
			//セッションを保存↓
			//session.setAttribute("absence_notification_info", absence_notification);

			forward = "017";
		} else if ("absence_register_comit".equals(action)) {
			//セッションの取得↓
		    //Absence_Notification absence_notification = (absence_notification) session.getAttribute("absence_notification_info");

			//logicに飛ぶ処理

			Request absencerequest = new Request();

			Date nowDate = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = dateFormat.format(nowDate);

			absencerequest.setRequest_day(strDate);
			absencerequest.setRequest_flag(false);
			absencerequest.setRequest_implement(request.getParameter("display-date"));
			absencerequest.setRequest_menber_id(men.getMember_id());
			absencerequest.setRequest_request_type_id("RT01");
			absencerequest.setRequest_txt(request.getParameter("display-reason"));

			Absence_Logic absence_logic = new Absence_Logic();
			absence_logic.execute(absencerequest);

			//jspから入力内容をもらってabに代入していく
			//jspに入力した内容はここでしか処理できない

			forward = "018";

		} else if ("back_top".equals(action) || "005".equals(action)) {

			//report_infoのセッションを削除↓
			//session.removeAttribute("absence_notification_info");
			
			forward = "005";

		}

		session.setAttribute("loginMember", men);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Page_" + forward + ".jsp");
		dispatcher.forward(request, response);

	}

}
