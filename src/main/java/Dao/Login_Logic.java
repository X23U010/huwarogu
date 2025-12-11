package Dao;

import Model.Member;

public class Login_Logic {
	public boolean execute(Member menber) {

		Login_Dao login_Dao = new Login_Dao();

		boolean isLogin = login_Dao.findByIdAndPassword(menber);

		return isLogin;
	}
}
