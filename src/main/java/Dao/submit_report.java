package Dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Report;

public class submit_report extends Base_Dao {

	public boolean Submit_Report(Report report) {
		
		boolean issubmit = false;
		
		try {
			
			this.connect();
			
			String sql ="INSERT INTO( report_table{report_id, report_subject_type_id, report_member_id, report_deadline, report_implement, report_location, report_starttime, report_finishtime, report_txt,)VALUES"
				+ "(?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, report.getReport_id());
			ps.setString(2, report.getReport_subject_type_id());
			ps.setString(3, report.getReport_menber_id());
			ps.setString(4, report.getReport_deadline());
			ps.setString(5, report.getReport_implement());
			ps.setString(6, report.getReport_location());
			ps.setString(7, report.getReport_starttime());
			ps.setString(8, report.getReport_finishtime());
			ps.setString(9, report.getReport_txt());
			
			int record = ps.executeUpdate()	;
			
			if(record == 1) {
				issubmit = true;
			}
			
			}catch(Exception e){
				e.printStackTrace();
				
			}finally {
				try {
					this.disConnect();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		
		return issubmit;
		
	}

}
