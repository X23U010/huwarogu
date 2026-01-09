package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Public_Absence;

public class Public_Absence_Dao extends Base_Dao {
	// ... Public_Absence_findAll() は変更なし ...
	public ArrayList<Public_Absence> Public_Absence_findAll() {

		ArrayList<Public_Absence> public_absence_list = new ArrayList<Public_Absence>();
		Statement stmt = null;

		try {

			this.connect();

			// テーブル名が OfficilAbsence_table ならこのまま
			// もしテーブル名が OfficilAbsence なら "SELECT * FROM OfficilAbsence" に変更してください
			String sql = "SELECT * FROM officilabsence_table"; 

			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Public_Absence public_absence = new Public_Absence();
				public_absence.setPublic_absence_id(rs.getString("OfficilAbsence_id"));
				public_absence.setStudent_id(rs.getString("OfficilAbsence_member_id"));
				public_absence.setApplication_date(rs.getString("OfficilAbsence_implement"));
				public_absence.setActivity_date(rs.getString("OfficilAbsence_day"));
				public_absence.setActivity_end_date(rs.getString("OfficilAbsence_end_day"));
				public_absence.setStart_time(rs.getString("OfficilAbsence_startTime"));
				public_absence.setEnd_time(rs.getString("OfficilAbsence_finishTime"));
				public_absence.setCompany_name(rs.getString("OfficilAbsence_coName"));
				public_absence.setLocation(rs.getString("OfficilAbsence_place"));
				public_absence.setReason(rs.getString("OfficilAbsence_content")); // ここが content
				public_absence.setSelection_details(rs.getString("OfficilAbsence_select_reason")); // ここが txt
				public_absence.setReview_status(rs.getBoolean("OfficilAbsence_flag"));
				public_absence.setSubmission_status(rs.getString("OfficilAbsence_stateId"));
				
				public_absence_list.add(public_absence);
			}

			return public_absence_list;

		} catch (SQLException e) {

			e.printStackTrace();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} finally {

			if (stmt != null) {

				try {

					stmt.close();

				} catch (SQLException e) {

					e.printStackTrace();

				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return public_absence_list;
	}
	
	public boolean Public_Absence_Submit(Public_Absence public_absence) {

		boolean issubmit = false;
		PreparedStatement ps = null; // PreparedStatementをfinallyブロックでクローズできるように宣言

		try {

			this.connect();

			String sql = "INSERT INTO officilabsence_table (\n"
					+ "    OfficilAbsence_id, \n"
					+ "    OfficilAbsence_member_id, \n"
					+ "    OfficilAbsence_implement, \n"
					+ "    OfficilAbsence_day, \n"
					+ "    OfficilAbsence_end_day, \n" // 5. 活動終了日
					+ "    OfficilAbsence_startTime, \n" // 6. 開始時間
					+ "    OfficilAbsence_finishTime, \n" // 7. 終了時間
					+ "    OfficilAbsence_coName, \n" // 8. 企業名
					+ "    OfficilAbsence_place, \n" // 9. 場所
					+ "    OfficilAbsence_select_reason, \n" // 10. 詳細(選択)
					+ "    OfficilAbsence_content, \n" // 11. 理由(content)
					+ "    OfficilAbsence_flag, \n" // 12. 審査ステータス
					+ "    OfficilAbsence_stateId\n" // 13. 提出ステータス
					+ ")\n"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)"; // パラメータは13個に修正（元のSQLが13カラム指定のため）
			
			ps = con.prepareStatement(sql);

			// 1. OfficilAbsence_id
	        ps.setString(1, public_absence.getPublic_absence_id());
	        
	        // 2. OfficilAbsence_member_id
	        ps.setString(2, public_absence.getStudent_id());
	        
	        // 3. OfficilAbsence_implement (申請日)
	        ps.setString(3, public_absence.getApplication_date());
	        
	        // 4. OfficilAbsence_day (活動日)
	        ps.setString(4, public_absence.getActivity_date());
	        
	        // 5. OfficilAbsence_end_day (活動終了日) *抜けていたパラメータを追加
	        ps.setString(5, public_absence.getActivity_end_date());
	        
	        // 6. OfficilAbsence_startTime (活動開始時間)
	        ps.setString(6, public_absence.getStart_time());
	        
	        // 7. OfficilAbsence_finishTime (活動終了時間)
	        ps.setString(7, public_absence.getEnd_time());
	        
	        // 8. OfficilAbsence_coName (企業名)
	        ps.setString(8, public_absence.getCompany_name());
	        
	        // 9. OfficilAbsence_place (活動場所)
	        ps.setString(9, public_absence.getLocation());
	        
	        // 10. OfficilAbsence_txt (詳細) *SQLの順序と合わせて修正
	        ps.setString(10, public_absence.getSelection_details());
	        
	        // 11. OfficilAbsence_content (理由) *SQLの順序と合わせて修正
	        ps.setString(11, public_absence.getReason());
	        
	        // 12. OfficilAbsence_flag (審査ステータス: false)
	        ps.setBoolean(12, public_absence.getReview_status());
	        
	        // 13. OfficilAbsence_stateId (提出ステータス: S001)
	        ps.setString(13, public_absence.getSubmission_status());


			int record = ps.executeUpdate();

			if (record > 0) {
				issubmit = true;
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			// PreparedStatement のクローズを追加
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			try {
				this.disConnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return issubmit;

	}
}