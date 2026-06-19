package Dao;

import java.util.ArrayList;

import Model.Absence;
import Model.Member;
import Model.Public_Absence;
import Model.Report;

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

	public Report Report_Search(String report_id) {

		Report_Dao report_dao = new Report_Dao();

		ArrayList<Report> report_list = report_dao.Report_findAll();

		for (Report r : report_list) {
			if (r.getReport_id().equals(report_id)) {
				return r;
			}
		}
		return null;
	}

	public Absence Absence_Search(String absence_id) {

		Absence_Dao absence_dao = new Absence_Dao();

		ArrayList<Absence> absence_list = absence_dao.Absence_findAll();

		for (Absence a : absence_list) {
			if (a.getAbsence_id().equals(absence_id)) {
				return a;
			}
		}
		return null;
	}

	public Public_Absence Public_Absence_Search(String public_absence_id) {

		Public_Absence_Dao public_absence_dao = new Public_Absence_Dao();

		ArrayList<Public_Absence> public_absence_list = public_absence_dao.Public_Absence_findAll();

		for (Public_Absence ab : public_absence_list) {
			if (ab.getPublic_absence_id().equals(public_absence_id)) {
				return ab;
			}
		}
		return null;
	}
}
