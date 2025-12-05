package Dao;

import Model.Request;

public class Absence_Logic {
	public void execute(Request request) {
		Absence_Dao absence_Dao = new Absence_Dao();
		absence_Dao.InAbsence(request);
	}

}
