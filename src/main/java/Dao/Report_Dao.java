package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Report;

public class Report_Dao extends Base_Dao {

	public ArrayList<Report> Report_findAll() {

		ArrayList<Report> report_list = new ArrayList<Report>();
		Statement stmt = null;

		try {

			this.connect();

			String sql = "SELECT * FROM report_table";

			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				Report report = new Report();
				report.setReport_id(rs.getString("report_id"));
				report.setStudent_id(rs.getString("report_member_id"));
				report.setApplication_date(rs.getString("report_deadline"));
				report.setCompany_name(rs.getString("report_company_name"));
				report.setLocation(rs.getString("report_location"));
				report.setActivity_date(rs.getString("report_implement"));
				report.setStart_time(rs.getString("report_starttime"));
				report.setEnd_time(rs.getString("report_finishtime"));
				report.setReason(rs.getString("report_subject_type_id"));
				report.setReport_details(rs.getString("report_txt"));
				report.setReview_status(rs.getBoolean("report_flag"));
				report.setSubmission_status(rs.getString("report_stateId"));

				report_list.add(report);
			}

			return report_list;

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
		return report_list;
	}

	public boolean Report_Submit(Report report) {

		boolean issubmit = false;

		try {

			this.connect();

			String sql = "INSERT INTO report_table ("
	                   + "report_id, report_subject_type_id, report_member_id, report_deadline, report_implement, " // report_implem は完全なカラム名が不明だが、ここではreport_implemとしておく
	                   + "report_company_name, report_location, report_starttime, report_finishtime, report_txt, " // report_compa, report_finishti も同様
	                   + "report_flag, report_stateId) "
	                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = con.prepareStatement(sql);

			// 1. report_id
	        ps.setString(1, report.getReport_id());
	        
	        // 2. report_subject_type_id (活動内容コード)
	        ps.setString(2, report.getReason()); 
	        
	        // 3. report_member_id (学生ID)
	        ps.setString(3, report.getStudent_id());        
	        
	        // 4. report_deadline (申請日)
	        ps.setString(4, report.getApplication_date());  
	        
	        // 5. report_implem (活動日)
	        ps.setString(5, report.getActivity_date());    
	        
	        // 6. report_compa (企業名)
	        ps.setString(6, report.getCompany_name());      
	        
	        // 7. report_location (活動場所)
	        ps.setString(7, report.getLocation());         
	        
	        // 8. report_starttime (活動開始時間)
	        ps.setString(8, report.getStart_time());       
	        
	        // 9. report_finishti (活動終了時間)
	        ps.setString(9, report.getEnd_time());         
	        
	        // 10. report_txt (レポート詳細)
	        ps.setString(10, report.getReport_details());   
	        
	        // 11. report_flag (審査ステータス: false)
	        ps.setBoolean(11, report.getReview_status());  
	        
	        // 12. report_stateId (提出ステータス: S001)
	        ps.setString(12, report.getSubmission_status());

			int record = ps.executeUpdate();

			if (record == 1) {
				issubmit = true;
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				this.disConnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return issubmit;

	}
}