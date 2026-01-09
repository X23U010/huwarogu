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

import Dao.Public_Absence_Dao;
import Dao.Public_Absence_Logic;
import Model.Member;
import Model.Public_Absence;

@WebServlet("/Public_Absence")
public class Public_Absence_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String forward = "";

		HttpSession session = request.getSession();
		Member mem = (Member) session.getAttribute("loginMember");
		Public_Absence_Logic public_absence_logic = new Public_Absence_Logic();

		String action = request.getParameter("action");

		if ("next_B".equals(action)) {
			
			// セッションから既存の情報を取得
		    Public_Absence public_absence = (Public_Absence) session.getAttribute("public_Absence_info");
		    
		    // もしセッションになければ（初めての入力なら）新規作成
		    if (public_absence == null) {
		        public_absence = new Public_Absence();
		    }

			//Page_007_Aで受けっとった内容をBeansにセット↓
			public_absence.setActivity_date(request.getParameter("start_date"));
			public_absence.setActivity_end_date(request.getParameter("end_date"));
			public_absence.setStart_time(request.getParameter("start_time"));
			public_absence.setEnd_time(request.getParameter("end_time"));

			session.setAttribute("public_Absence_info", public_absence);

			forward = "007_B";

		} else if ("official_leave_request_register".equals(action) || "back_A".equals(action)) {
			//セッションの取得↓
			Public_Absence public_absence = (Public_Absence) session.getAttribute("public_Absence_info");

			//Page_007_Bで受けっとった内容をBeansにセット↓
			public_absence.setCompany_name(request.getParameter("company_name"));
			public_absence.setLocation(request.getParameter("activity_location_code"));
			public_absence.setReason(request.getParameter("official_leave_reason_code"));
			public_absence.setSelection_details(request.getParameter("screening_method_code"));

			//セッションを保存↓
			session.setAttribute("public_Absence_info", public_absence);
			
			if ("back_A".equals(action)) {
				forward = "007_A";
			} else {
				forward = "008";

			}

		} else if ("official_leave_request_register_comit".equals(action)) {
			//セッションの取得↓
			Public_Absence public_absence = (Public_Absence) session.getAttribute("public_Absence_info");

			//DBに追加
			Public_Absence_Dao public_absence_dao = new Public_Absence_Dao();

			Date nowDate = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = dateFormat.format(nowDate);

			public_absence.setPublic_absence_id(public_absence_logic.Public_Absence_Create_id());
			public_absence.setApplication_date(strDate);
			public_absence.setReview_status(false);
			public_absence.setStudent_id(mem.getMember_id());

			System.out.println("追加内容");
			System.out.println(public_absence.getPublic_absence_id());
			System.out.println(public_absence.getStudent_id());
			System.out.println(public_absence.getApplication_date());
			System.out.println(public_absence.getActivity_date());
			System.out.println(public_absence.getActivity_end_date());
			System.out.println(public_absence.getStart_time());
			System.out.println(public_absence.getEnd_time());
			System.out.println(public_absence.getCompany_name());
			System.out.println(public_absence.getLocation());
			System.out.println(public_absence.getReason());
			System.out.println(public_absence.getSelection_details());
			System.out.println(public_absence.getReview_status());
			System.out.println(public_absence.getSubmission_status());

			if (public_absence_dao.Public_Absence_Submit(public_absence)) {

				System.out.println("追加完了");
				//セッションを保存↓
				session.setAttribute("public_Absence_info", public_absence);

			} else {
				System.out.println("失敗");

			}

			forward = "009";

		} else if ("back_top".equals(action) || "005".equals(action)) {

			//report_infoのセッションを削除↓
			session.removeAttribute("public_Absence_info");

			forward = "005";

		}

		//セッションスコープにユーザ情報を保存する
		session.setAttribute("loginMember", mem);

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Page_" + forward + ".jsp");
		dispatcher.forward(request, response);

	}

}
