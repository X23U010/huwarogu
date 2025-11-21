package Dao;

import Model.Menber;

public class Login_Logic {
	public boolean execute(Menber menber) {

		Login_Dao login_Dao = new Login_Dao();

		boolean isLogin = login_Dao.findByIdAndPassword(menber);

		return isLogin;
	}
}
