package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import Dao.Divination_Logic;
import Dao.Setting_Dao;
import Model.Divination;
import Model.Member;

@WebServlet("/Setting_Servlet")
public class Setting_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String forward = "";

		HttpSession session = request.getSession();
		Member mem = (Member) session.getAttribute("loginMember");

		String action = request.getParameter("action");

		System.out.println(mem.getMember_teacher_id());
		System.err.println(mem.getMember_subteacher_id());

		if ("setting_B".equals(action)) {

			forward = "Setting_B";
		} else if ("setting_C".equals(action)) {

			Setting_Dao Setting_dao = new Setting_Dao();
			ArrayList<Member> teacher_list = Setting_dao.Teacher_findAll();

			// リクエストスコープに保存
			request.setAttribute("teacher_list", teacher_list);

			forward = "Setting_C";
		} else if ("setting_E_password".equals(action)) {

			mem = (Member) session.getAttribute("loginMember");

			mem.setMember_password(request.getParameter("password"));

			boolean hasError_empty = (mem == null) || isEmpty(mem.getMember_password());
			boolean hasError_length = (mem == null) || isLength(mem.getMember_password().length());

			String empty_msg = "";
			String length_msg = "";

			if (hasError_empty || hasError_length) {

				if (hasError_empty) {
					empty_msg = "未入力 ";
				} else if (hasError_length) {
					length_msg = "文字不足 ";
				}
				
				request.setAttribute("errorMsg", empty_msg + length_msg + "が原因です。");
				
				forward = "Setting_B";

			} else {

				Setting_Dao setting_dao = new Setting_Dao();
				boolean isUpdate = setting_dao.Member_Update(mem);

				System.out.println(mem.getMember_password());

				if (isUpdate) {
					
					System.out.println("成功");
					session.setAttribute("loginMember", mem);
					forward = "Setting_E";
					
				} else {
					
					System.out.println("失敗");
					request.setAttribute("errorMsg", "DB障害 が原因です");
					forward = "Setting_B";
					
				}

				Divination_Logic dlogic = new Divination_Logic();
				Divination d = dlogic.divination_execute();
				request.setAttribute("divinationResult", d);
				
				session.setAttribute("loginMember", mem);

			}


		} else if ("setting_E_teacher".equals(action)) {

			mem = (Member) session.getAttribute("loginMember");

			boolean hasError = (mem == null) || isEmpty(mem.getMember_teacher_id());

			if (hasError) {

				request.setAttribute("errorMsg", "担任は必ず選択してください");
				
				forward = "setting_C";

			} else {

				Setting_Dao setting_dao = new Setting_Dao();
				mem.setMember_teacher_id(request.getParameter("main_teacher_id"));
				mem.setMember_subteacher_id(request.getParameter("sub_teacher_id"));

				System.out.println(mem.getMember_teacher_id());
				System.out.println(mem.getMember_subteacher_id());

				boolean isUpdate_teacher = setting_dao.Teacher_Update(mem);
				boolean isUpdate_subteacher = setting_dao.SubTeacher_Update(mem);

				if (isUpdate_teacher && isUpdate_subteacher) {
					
					System.out.println("成功");
					session.setAttribute("loginMember", mem);
					forward = "Setting_E";
					
				} else {
					
					System.out.println("失敗");
					request.setAttribute("errorMsg", "DB障害 が原因です");
					forward = "Setting_C";
					
				}

			}

		} else if ("back_top".equals(action)) {

			forward = "005";
		} else if ("back_A".equals(action)) {

			// 名前を特定するために先生リストが必要なので、DAOから取得してセットする
			Setting_Dao dao = new Setting_Dao();
			ArrayList<Member> teacher_list = dao.Teacher_findAll();
			request.setAttribute("teacher_list", teacher_list);

			forward = "Setting_A";
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

	private boolean isLength(int values) {
		if (!(values >= 8)) {
			return true;
		}

		return false;
	}
}