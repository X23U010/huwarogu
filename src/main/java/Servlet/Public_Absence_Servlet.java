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

		} else if ("official_leave_request_register_comit".equals(action) || "back_B".equals(action)) {
			//セッションの取得↓
			Public_Absence public_absence = (Public_Absence) session.getAttribute("public_Absence_info");

			if ("official_leave_request_register_comit".equals(action)) {

				boolean hasError = (public_absence == null) || isEmpty(
						public_absence.getActivity_date(), // 開始日
						public_absence.getActivity_end_date(), // 終了日
						public_absence.getStart_time(), // 開始時間
						public_absence.getEnd_time(), // 終了時間
						public_absence.getCompany_name(), // 企業名
						public_absence.getLocation(), // 活動場所
						public_absence.getReason(), // 理由
						public_absence.getSelection_details() // 選考詳細
				);

				boolean time_error = (public_absence == null) || isTime(public_absence.getStart_time())
						|| isTime(public_absence.getEnd_time());

				String error_msg = "";

				if (hasError || time_error) {
					
					if (hasError) {
						error_msg = error_msg + "未入力項目あり ";
					}
					
					if (time_error) {
						error_msg = error_msg + "時間入力不正 ";

					}
					
					System.out.println(error_msg);
					
					request.setAttribute("errorMsg", error_msg);
					
					forward = "008";
					
				} else {

					//DBに追加
					Public_Absence_Dao public_absence_dao = new Public_Absence_Dao();

					Date nowDate = new Date();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String strDate = dateFormat.format(nowDate);

					public_absence.setPublic_absence_id(public_absence_logic.Public_Absence_Create_id());
					public_absence.setApplication_date(strDate);
					public_absence.setReview_status(false);
					public_absence.setStudent_id(mem.getMember_id());

					if (public_absence_dao.Public_Absence_Submit(public_absence)) {

						System.out.println("成功");
						session.removeAttribute("public_Absence_info");
						forward = "009";

					} else {

						System.out.println("失敗");
						forward = "008";

					}

				}
			} else if ("back_B".equals(action)) {

				session.setAttribute("public_Absence_info", public_absence);
				forward = "007_B";

			}

		} else if ("back_top".equals(action)) {

			//report_infoのセッションを削除↓
			session.removeAttribute("public_Absence_info");

			forward = "005";

		}

		//セッションスコープにユーザ情報を保存する
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

	private boolean isTime(String values) {
		String timePattern = "^([01][0-9]|2[0-3]):[0-5][0-9]$";

		if (!values.matches(timePattern)) {
			return true;
		}

		return false;
	}
}
