package Dao;

import Model.Menber;

public class Add_member_Logic {
	public boolean execute(Menber member) {
		
		Add_member_Dao add_member_Dao = new Add_member_Dao();
		add_member_Dao.addMember(member);
	}

}
