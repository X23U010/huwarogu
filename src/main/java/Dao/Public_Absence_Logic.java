package Dao;

public class Public_Absence_Logic {
	public String Public_Absence_Create_id() {
		Public_Absence_Dao report_dao = new Public_Absence_Dao();

		int max = 6;
		String str = String.valueOf(report_dao.Public_Absence_findAll().size() + 1);
		String id = "P";

		for (int i = 0; i < max - str.length() - 1; i++) {
			id = id + "0";
		}

		id = id + str;

		return id;
	}
	
	public String Public_Absence_Search(String code) {

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
		} else if ("S01".equals(code)) {
			reason = "なし";
		} else if ("S02".equals(code)) {
			reason = "適性検査（性格、作文等も含む）";
		} else if ("S03".equals(code)) {
			reason = "面接";
		} else if ("S04".equals(code)) {
			reason = "グループディスカッション・ワーク";
		}

		return reason;

	}
}
