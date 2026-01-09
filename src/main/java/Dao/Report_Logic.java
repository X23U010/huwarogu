package Dao;

import Model.Report;

public class Report_Logic {

	public boolean execute(Report report) {

		Report_Dao report_Dao = new Report_Dao();
		boolean isSubmit = report_Dao.Report_Submit(report);

		return isSubmit;

	}

	public String Reason_Search(String code) {

		String reason = "";

		if ("C01".equals(code)) {
			reason = "インターン選考";
		} else if ("C02".equals(code)) {
			reason = "インターン";
		} else if ("C03".equals(code)) {
			reason = "オープンカンパニー";
		} else if ("C05".equals(code)) {
			reason = "説明会(選考に進む予定)";
		} else if ("C06".equals(code)) {
			reason = "説明会(選考に進まない予定)";
		} else if ("C07".equals(code)) {
			reason = "選考受験";
		} else if ("C08".equals(code)) {
			reason = "面談・懇親会";
		} else if ("C09".equals(code)) {
			reason = "内定式";
		} else if ("C10".equals(code)) {
			reason = "研修";
		}

		return reason;

	}

	public String Report_Create_id() {
		Report_Dao report_dao = new Report_Dao();

		int max = 8;
		String str = String.valueOf(report_dao.Report_findAll().size() + 1);
		String id = "R";

		for (int i = 0; i < max - str.length() - 1; i++) {
			id = id + "0";
		}

		id = id + str;
		
		return id;
	}
}
