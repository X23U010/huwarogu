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
import Model.Public_Absence;

/**
 * Servlet implementation class Official_Leave_Request_Servlet
 */
@WebServlet("/Official_Leave_Request_Servlet")
public class Official_Leave_Request_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String forward = "";
		
		HttpSession session = request.getSession();
	    Member mem = (Member) session.getAttribute("loginMember");

		String action = request.getParameter("action");
		
		if("next_B".equals(action)) {
			//Public_Absence.javaをインスタンス化↓
			Public_Absence public_absence = new Public_Absence();
			
			//Page_007_Aで受けっとった内容をBeansにセット↓
			
			
			//セッションを保存↓
			//session.setAttribute("official_leave_request_info", official_leave_request);
			
			forward = "007_B";
		}else if("official_leave_request_register".equals(action)) {
			//セッションの取得↓
		    //Official_Leave_Request official_leave_request = (Official_Leave_Request) session.getAttribute("official_leave_request_info");
			
			//Page_007_Bで受けっとった内容をBeansにセット↓
			
			
			//セッションを保存↓
			//session.setAttribute("official_leave_request_info", official_leave_request);
			
			forward = "008";

		} else if ("official_leave_request_register_comit".equals(action)) {
			//セッションの取得↓
		    //Official_Leave_Request official_leave_request = (Official_Leave_Request) session.getAttribute("official_leave_request_info");
			
			//DBに追加
			Request officalRequest = new Request();
			Absence_Logic absence_logic = new Absence_Logic();
			Date nowDate = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = dateFormat.format(nowDate);

			
			officalRequest.setRequest_day(strDate);
			officalRequest.setRequest_flag(false);
			officalRequest.setRequest_implement(request.getParameter("date"));
			officalRequest.setRequest_menber_id(mem.getMember_id());
			officalRequest.setRequest_request_type_id("RT02");
			officalRequest.setRequest_txt(request.getParameter("reason"));
			
			absence_logic.execute(officalRequest);
			
			forward = "009";

		} else if ("back_top".equals(action) || "005".equals(action)) {
			
			//report_infoのセッションを削除↓
			//session.removeAttribute("official_leave_request_info");
			
			forward = "005";

		}
		
		
		
		
		//セッションスコープにユーザ情報を保存する
		session.setAttribute("loginMember", mem);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Page_" + forward + ".jsp");
		dispatcher.forward(request, response);
		
	}

}
