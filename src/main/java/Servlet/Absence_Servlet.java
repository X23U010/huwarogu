package Servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Dao.Absence_Dao;
import Dao.Absence_Logic;
import Model.Absence;
import Model.Member;

@WebServlet("/Absence_Servlet")
public class Absence_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String forward = "";

		HttpSession session = request.getSession();
		Member mem = (Member) session.getAttribute("loginMember");
		Absence_Logic absence_logic = new Absence_Logic();

		String action = request.getParameter("action");

		if ("adsence_register".equals(action)) {

			Absence absence = (Absence) session.getAttribute("absence_info");

			//Report.javaをインスタンス化↓
			if (absence == null) {
				absence = new Absence();
				absence.setAbsence_id(absence_logic.Absence_Create_id());
			}

			absence.setAbsence_date(request.getParameter("absence-date"));
			absence.setAbsence_txt(request.getParameter("absence-reason"));

			/*System.out.println(absence.getAbsence_id());
			System.out.println(absence.getAbsence_date());
			System.out.println(absence.getAbsence_txt());*/

			session.setAttribute("absence_info", absence);

			forward = "017";

		} else if ("adsence_register_comit".equals(action)||"back_016".equals(action)) {

			Absence absence = (Absence) session.getAttribute("absence_info");

			if("adsence_register_comit".equals(action)){
				
				if (absence == null || isEmpty(absence.getAbsence_date(), absence.getAbsence_txt())) {
			        request.setAttribute("errorMsg", "入力情報が不足しています。最初から入力し直してください。");
			        forward = "017";
			    }else {
			    	
			    	Absence_Dao absence_dao = new Absence_Dao();

					LocalDate today = LocalDate.now();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					String applicationDateString = today.format(formatter);
					
					absence.setAbsence_application_date(applicationDateString);
					absence.setAbsence_member_id(mem.getMember_id());
					absence.setAbsence_flag("0");

					if (absence_dao.Absence_Submit(absence)) {

						System.out.println("成功");
						forward = "018";

					} else {
						System.out.println("失敗");
						forward = "017";
					}
			    }
			}else if("back_016".equals(action)) {
				
				session.setAttribute("absence_info", absence);
				forward = "016";
				
			}
			
		} else if ("back_top".equals(action)) {

			//report_infoのセッションを削除↓
			session.removeAttribute("absence_info");

			forward = "005";

		}

		session.setAttribute("loginMember", mem);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Page_" + forward + ".jsp");
		dispatcher.forward(request, response);

	}

	private boolean isEmpty(String... values) {
		for (String val : values) {
			if (val == null || val.trim().isEmpty()) {
				return true;
			}
		}
		return false;
	}
}
