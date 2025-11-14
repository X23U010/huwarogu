package Dao;

import Model.Menber;

public class Login_Logic {
		public boolean execute(Menber menber) {
			
			HuwaLog_Dao login_Dao = new HuwaLog_Dao();

			boolean isLogin = login_Dao.Login_findByIdAndPassword(menber);

			return isLogin;
		}
}
