package Dao;

import Model.Menber;

public class Add_member_Logic {
	public void execute(Menber member) {
		
		Add_Member_Dao add_member_Dao = new Add_Member_Dao();
		add_member_Dao.AddMember(member);
	}

}
