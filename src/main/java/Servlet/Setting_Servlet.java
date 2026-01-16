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

		if ("setting_B".equals(action)) {
			forward = "Setting_B";
		} else if ("setting_C".equals(action)) {
			Setting_Dao Setting_dao = new Setting_Dao();
			ArrayList<Member> teacher_list = Setting_dao.Teacher_findAll();
			request.setAttribute("teacher_list", teacher_list);
			forward = "Setting_C";

		} else if ("setting_E_password".equals(action)) {
			// パスワード更新処理 (現状のコードを維持)
			mem.setMember_password(request.getParameter("password"));
			boolean hasError_empty = (mem == null) || isEmpty(mem.getMember_password());
			boolean hasError_length = (mem == null) || isLength(mem.getMember_password().length());

			if (hasError_empty || hasError_length) {
				request.setAttribute("errorMsg", "入力内容を確認してください。");
				forward = "Setting_B";
			} else {
				Setting_Dao setting_dao = new Setting_Dao();
				if (setting_dao.Member_Update(mem)) {
					Divination_Logic dlogic = new Divination_Logic();
					request.setAttribute("divinationResult", dlogic.divination_execute());
					forward = "Setting_E";
				} else {
					forward = "Setting_B";
				}
			}

		} else if ("setting_E_teacher".equals(action)) {
			// 画面からIDを取得
			String mainId = request.getParameter("main_teacher_id");
			String subId = request.getParameter("sub_teacher_id");

			// 未選択チェック（担任は必須）
			if (mainId == null || mainId.trim().isEmpty()) {
				request.setAttribute("errorMsg", "担任は必ず選択してください");
				// 再表示用にリストを取得
				Setting_Dao dao = new Setting_Dao();
				request.setAttribute("teacher_list", dao.Teacher_findAll());
				forward = "Setting_C";
			} else {
				// Beansにセット（空白を除去して保存）
				mem.setMember_teacher_id(mainId.trim());
				
				if (subId == null || subId.trim().isEmpty()) {
				    mem.setMember_subteacher_id(null); // 空ならnullをセット
				} else {
				    mem.setMember_subteacher_id(subId.trim());
				}

				Setting_Dao setting_dao = new Setting_Dao();
				boolean isUpdate_teacher = setting_dao.Teacher_Update(mem);
				boolean isUpdate_subteacher = setting_dao.SubTeacher_Update(mem);

				if (isUpdate_teacher || isUpdate_subteacher) {
					// 成功時に最新のmemをセッションに上書き
					session.setAttribute("loginMember", mem);
					forward = "Setting_E";
				} else {
					request.setAttribute("errorMsg", "DB更新に失敗しました");
					forward = "Setting_C";
				}
			}

		} else if ("back_top".equals(action)) {
			
			forward = "005";
			
		} else if ("back_A".equals(action)) {
			// Setting_Aに戻る際も、名前特定のために先生リストが必要
			Setting_Dao dao = new Setting_Dao();
			request.setAttribute("teacher_list", dao.Teacher_findAll());
			forward = "Setting_A";
		}

		session.setAttribute("loginMember", mem);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Page_" + forward + ".jsp");
		dispatcher.forward(request, response);
	}

	private boolean isEmpty(String... values) {
		for (String val : values) {
			if (val == null || val.trim().isEmpty()) return true;
		}
		return false;
	}

	private boolean isLength(int length) {
		return length < 8;
	}
}