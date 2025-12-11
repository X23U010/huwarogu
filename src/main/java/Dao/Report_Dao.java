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
				report.setReport_id(rs.getString(""));
				report.setStudent_id(rs.getString(""));
				report.setApplication_date(rs.getString(""));
				report.setCompany_name(rs.getString(""));
				report.setLocation(rs.getString(""));
				report.setActivity_date(rs.getString(""));
				report.setStart_time(rs.getString(""));
				report.setEnd_time(rs.getString(""));
				report.setReason(rs.getString(""));
				report.setReport_details(rs.getString(""));
				report.setReview_status(rs.getBoolean(""));
				report.setSubmission_status(rs.getString(""));

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
			//SQLを変更
			String sql = "INSERT INTO( report_table{report_id, report_subject_type_id, report_member_id, report_deadline, report_implement, report_location, report_starttime, report_finishtime, report_txt,)VALUES"
					+ "(?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, report.getReport_id());
			ps.setString(2, report.getStudent_id());
			ps.setString(3, report.getApplication_date());
			ps.setString(4, report.getCompany_name());
			ps.setString(5, report.getLocation());
			ps.setString(6, report.getActivity_date());
			ps.setString(7, report.getStart_time());
			ps.setString(8, report.getEnd_time());
			ps.setString(9, report.getReason());
			ps.setString(10, report.getReport_details());
			ps.setBoolean(11, report.getReview_status());
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
