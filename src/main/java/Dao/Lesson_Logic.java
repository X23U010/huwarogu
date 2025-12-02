package Dao;

import Model.Lesson;

public class Lesson_Logic {
	public boolean execute(Lesson lesson) {

		HuwaLog_Dao lesson_Dao = new HuwaLog_Dao();

		boolean isLogin = lesson_Dao.Lesson_findByIdAndPassword(lesson);

		return isLogin;
	}
	
	
}
