package Dao;

import Model.Member;

public class Add_member_Logic {
	public void execute(Member member) {
		
		Add_Member_Dao add_member_Dao = new Add_Member_Dao();
		add_member_Dao.AddMember(member);
	}

}
