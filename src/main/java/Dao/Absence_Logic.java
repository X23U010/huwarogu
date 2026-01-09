package Dao;

public class Absence_Logic {
	public String Absence_Create_id() {
		Absence_Dao absence_dao = new Absence_Dao();

		int max = 6;
		String str = String.valueOf(absence_dao.Absence_findAll().size() + 1);
		String id = "A";

		for (int i = 0; i < max - str.length() - 1; i++) {
			id = id + "0";
		}

		id = id + str;

		return id;
	}
}
