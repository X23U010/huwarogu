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

import Dao.Add_Member_Dao;
import Model.Member;

@WebServlet("/New_Registration_Servlet")
public class New_Registration_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String error_msg = "";

		request.setCharacterEncoding("UTF-8");

		String action = request.getParameter("action");
		HttpSession session = request.getSession();

		if ("new_registretion_register".equals(action)) {

			Member member = new Member();
			member.setMember_id(request.getParameter("student_id"));
			member.setMember_name(request.getParameter("name"));
			member.setMember_month(request.getParameter("birth_month"));
			member.setMember_password(request.getParameter("password"));

			session.setAttribute("member_info", member);

			forward = "003";

		} else if ("new_registretion_register_comit".equals(action)) {

			Member mem = (Member) session.getAttribute("member_info");
			
			boolean hasError_id = (mem == null) || isEmpty(mem.getMember_id()) || isId_1(mem.getMember_id())
					|| isId_2(mem.getMember_id()) || isId_3(mem.getMember_id());
			boolean hasError_password = (mem == null) || isEmpty(mem.getMember_id())
					|| isLength(mem.getMember_password().length());
			boolean hasError_month = (mem == null) || isEmpty(mem.getMember_id()) || isMonth(mem.getMember_month());
			boolean hasError_name = (mem == null) || isEmpty(mem.getMember_name());

			if (hasError_id || hasError_password || hasError_month || hasError_name) {

				if (hasError_id) {
					if (isEmpty(mem.getMember_id())) {
						error_msg = error_msg + "ID未入力 ";
					}

					if (isId_1(mem.getMember_id())) {
						error_msg = error_msg + "ID文字不足 ";
					}

					if (isId_2(mem.getMember_id())) {
						error_msg = error_msg + "ID不正値 ";
					}

					if (isId_3(mem.getMember_id())) {
						error_msg = error_msg + "ID重複 ";
					}

				}

				if (hasError_password) {
					if (isEmpty(mem.getMember_password())) {
						error_msg = error_msg + "Puss未入力 ";
					}

					if (isLength(mem.getMember_password().length())) {
						error_msg = error_msg + "Puss文字不足 ";
					}

				}

				if (hasError_month) {
					if (isEmpty(mem.getMember_month())) {
						error_msg = error_msg + "Month入力 ";
					}
					if (isMonth(mem.getMember_month())) {
						error_msg = error_msg + "Month不正値 ";
					}
				}

				if (hasError_name) {
					if (isEmpty(mem.getMember_name())) {
						error_msg = error_msg + "Name未入力 ";
					}
				}

				request.setAttribute("errorMsg", error_msg);
				forward = "003";
				
			} else {
				
				Member member = (Member) session.getAttribute("member_info");
				
				Add_Member_Dao AMD = new Add_Member_Dao();

				boolean isUpdate = AMD.AddMember(member);

				if (isUpdate) {
					System.out.println("成功");
					forward = "004";

				} else {

					System.out.println("失敗");
					request.setAttribute("errorMsg", "DB障害 が原因です");
					forward = "003";

				}
				
			}

			

		}

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/WEB-INF/jsp/Page_" + forward + ".jsp");
		dispatcher.forward(request, response);
	}

	private boolean isId_1(String values) {
		if (!(values.length() == 7)) {

			return true;
		}

		return false;
	}

	private boolean isId_2(String values) {
		if (!(values.startsWith("x")) || !(values.startsWith("t"))) {

			return true;
		}

		return false;
	}

	private boolean isId_3(String values) {
		Add_Member_Dao add_member_dao = new Add_Member_Dao();
		ArrayList<Member> list = add_member_dao.MemberfindAll();

		for (Member member : list) {
			if (member.getMember_id().equals(values)) {
				return true;
			}
		}

		return false;
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

	private boolean isMonth(String values) {

		for (int i = 1; i >= 12; i++) {
			if (!(values.equals(i))) {
				return true;
			}
		}
		return false;
	}

}