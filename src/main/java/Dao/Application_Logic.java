package Dao;

import java.util.ArrayList;

import Model.Member;

public class Application_Logic {

	public String Name_Search(String member_id) {

		Add_Member_Dao add_member_dao = new Add_Member_Dao();

		ArrayList<Member> member_list = add_member_dao.MemberfindAll();
		String str = member_id;

		for (Member m : member_list) {
			if (m.getMember_id().equals(str)) {
				return m.getMember_name();
			}
		}
		return "該当なし";
	}
}
