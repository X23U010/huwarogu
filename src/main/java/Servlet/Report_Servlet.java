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

import Dao.Report_Logic;
import Model.Member;
import Model.Report;

@WebServlet("/Report_Servlet")
public class Report_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String forward = "";

		HttpSession session = request.getSession();
		Member mem = (Member) session.getAttribute("loginMember");
		Report_Logic report_logic = new Report_Logic(); // 処理の中で使用するため定義

		String action = request.getParameter("action");

		if ("next_B".equals(action)) {
			//010A内
			Report report = (Report) session.getAttribute("report_info");

			//Report.javaをインスタンス化↓
			if (report == null) {
				report = new Report();
				report.setReport_id(report_logic.Report_Create_id()); // IDの初期化はここで行う
			}

			//Page010_Aで受け取った内容をBeansにセット↓
			report.setCompany_name(request.getParameter("company_name"));
			report.setLocation(request.getParameter("activity_location"));

			//セッションに保存↓
			session.setAttribute("report_info", report);

			forward = "010_B";

		} else if ("next_C".equals(action) || "back_A".equals(action)) {
			//010B内
			//セッションを取得
			Report report = (Report) session.getAttribute("report_info");

			//Page010_Bで受け取った内容をBeansにセット↓
			report.setActivity_date(request.getParameter("activity_date"));
			report.setStart_time(request.getParameter("start_time"));
			report.setEnd_time(request.getParameter("finish_time"));

			//セッションに保存↓
			session.setAttribute("report_info", report);

			if ("next_C".equals(action)) {
				forward = "010_C";
			} else if ("back_A".equals(action)) {
				forward = "010_A";
			}

		} else if ("report_register".equals(action) || "back_B".equals(action)) {
			//010C内
			//セッションを取得↓
			Report report = (Report) session.getAttribute("report_info");

			//Page010_Cで受け取った内容をBeansにセット↓
			report.setReason(request.getParameter("activity_content_code"));
			report.setReport_details(request.getParameter("activity_report"));

			System.out.println(report.getReport_details());

			//セッションに保存↓
			session.setAttribute("report_info", report);

			if ("report_register".equals(action)) {
				forward = "011";
			} else if ("back_B".equals(action)) {
				forward = "010_B";
			}

		} else if ("report_register_comit".equals(action) || "back_C".equals(action)) {

			Report report = (Report) session.getAttribute("report_info");

			if ("report_register_comit".equals(action)) {
				// 変換した日付文字列をセット

				String error_msg = "";

				boolean hasError = (report == null) || isEmpty(
						report.getCompany_name(),
						report.getLocation(),
						report.getActivity_date(),
						report.getStart_time(),
						report.getEnd_time(),
						report.getReason(),
						report.getReport_details());

				boolean time_error = (report == null) || isTime(report.getStart_time())
						|| isTime(report.getEnd_time());

				if (hasError || time_error) {

					if (hasError) {
						error_msg = error_msg + "未入力項目あり ";
					}

					if (time_error) {
						error_msg = error_msg + "時間入力不正 ";

					}

					System.out.println(error_msg);
					
					request.setAttribute("errorMsg", error_msg);
					forward = "011";

				} else {

					LocalDate today = LocalDate.now();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
					String applicationDateString = today.format(formatter);

					report.setApplication_date(applicationDateString);
					report.setReview_status(false);
					report.setStudent_id(mem.getMember_id());
					report.setSubmission_status("S001");

					//DBに保存する↓
					boolean isSubmit = report_logic.execute(report);

					if (isSubmit) {
						System.out.println("OK");
						forward = "012";
					} else {
						System.out.println("NG");
						forward = "011";
					}

				}

			} else if ("back_C".equals(action)) {

				session.setAttribute("report_info", report);
				forward = "010_C";

			}

		} else if ("back_top".equals(action)) {

			//report_infoのセッションを削除↓
			session.removeAttribute("report_info");

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

	private boolean isTime(String values) {
		String timePattern = "^([01][0-9]|2[0-3]):[0-5][0-9]$";

		if (!values.matches(timePattern)) {
			return true;
		}

		return false;
	}

}