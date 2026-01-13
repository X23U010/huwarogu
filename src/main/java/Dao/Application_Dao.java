package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Absence;
import Model.Public_Absence;
import Model.Report;

public class Application_Dao extends Base_Dao {
	
//欠席申請一覧取得
	public ArrayList<Absence> getAbsenceList() {

	    ArrayList<Absence> abList = new ArrayList<>();

	    String sql = "SELECT * FROM Absence_table WHERE Absence_flag = 0";

	    try {
	        this.connect();
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);

	        while (rs.next()) {
	            Absence absence= new Absence();
	                absence.setAbsence_id(rs.getString("Absence_id"));
	                absence.setAbsence_member_id(rs.getString("Absence_member_id"));
	                absence.setAbsence_date(rs.getString("Absence_day"));
	                absence.setAbsence_application_date(rs.getString("Absence_implement"));
	                absence.setAbsence_txt(rs.getString("Absence_txt"));
	                absence.setAbsence_flag(rs.getString("Absence_flag")); 

	            abList.add(absence);
	        }

	        rs.close();
	        stmt.close();
	        this.disConnect();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return abList;
	}

	//欠席許可
		public void PermissionAbsence(String[] absenceIds) {

		    try {
		        this.connect();
		        String sql = "UPDATE Absence_table SET Absence_flag = 1 WHERE Absence_id = ?";
				PreparedStatement ps = con.prepareStatement(sql);

				for (String id : absenceIds) {
					ps.setString(1, id);
					ps.executeUpdate();
		        }
		        this.disConnect();

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
	
	//欠席拒否
		public void DenyAbsence(String[] absenceIds) {

		    try {
		        this.connect();
		        String sql = "DELETE FROM Absence_table WHERE Absence_id = ?";
		        PreparedStatement ps = con.prepareStatement(sql);

		        for (String id : absenceIds) {
		            ps.setString(1, id);
		            ps.executeUpdate();
		        }

		        ps.close();

		        this.disConnect();

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
	
	

//公欠申請一覧取得
	public ArrayList<Public_Absence> getPublicAbsenceList() {

	    ArrayList<Public_Absence> PuAbList = new ArrayList<>();

	    String sql = "SELECT * FROM OfficilAbsence_table WHERE OfficilAbsence_flag = 0";

	    try {
	        this.connect();
	        Statement stmt = con.createStatement();
	        ResultSet rs = stmt.executeQuery(sql);

	        while (rs.next()) {
	        	Public_Absence pa = new Public_Absence();

	        	pa.setPublic_absence_id(rs.getString("OfficilAbsence_id"));
	        	pa.setStudent_id(rs.getString("OfficilAbsence_member_id"));
	        	pa.setApplication_date(rs.getString("OfficilAbsence_implement"));

	        	pa.setActivity_date(rs.getString("OfficilAbsence_day"));
	        	pa.setActivity_end_date(rs.getString("OfficilAbsence_end_day"));

	        	pa.setStart_time(rs.getString("OfficilAbsence_startTime"));
	        	pa.setEnd_time(rs.getString("OfficilAbsence_finishTime"));

	        	pa.setCompany_name(rs.getString("OfficilAbsence_coName"));
	        	pa.setLocation(rs.getString("OfficilAbsence_place"));
	        	pa.setReason(rs.getString("OfficilAbsence_select_reason"));
	        	pa.setSelection_details(rs.getString("OfficilAbsence_content"));

	        	pa.setReview_status(rs.getBoolean("OfficilAbsence_flag"));
	        	pa.setSubmission_status(rs.getString("OfficilAbsence_stateId"));

	        	PuAbList.add(pa);

	        }

	        rs.close();
	        stmt.close();
	        this.disConnect();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return PuAbList;
	}
	
	
	//公欠許可
		public void PermissionPublicAbsence(String[] publicAbsenceIds) {

		    try {
		        this.connect();
		        String sql = "UPDATE officilabsence_table SET OfficilAbsence_flag = 1 WHERE OfficilAbsence_id = ?";
				PreparedStatement ps = con.prepareStatement(sql);

				for (String id : publicAbsenceIds) {
					ps.setString(1, id);
					ps.executeUpdate();
		        }
		        this.disConnect();

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
	
	//公欠拒否
		public void DenyPublicAbsence(String[] publicAbsenceIds) {

		    try {
		        this.connect();
		        String sql = "DELETE FROM officilabsence_table WHERE OfficilAbsence_id = ?";
		        PreparedStatement ps = con.prepareStatement(sql);

		        for (String id : publicAbsenceIds) {
		            ps.setString(1, id);
		            ps.executeUpdate();
		        }

		        ps.close();

		        this.disConnect();

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
	
//レポート申請一覧取得

	    public ArrayList<Report> getReportList() {

	        ArrayList<Report> reportList = new ArrayList<>();

	        String sql = "SELECT * FROM report_table WHERE report_flag = 0";

	        try {
	            this.connect();
	            Statement stmt = con.createStatement();
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

	            	reportList.add(report);

	            }

	            rs.close();
	            stmt.close();
	            this.disConnect();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return reportList;
	    }
	    
	//レポート許可
		public void PermissionReport(String[] reportIds) {

		    try {
		        this.connect();
		        String sql = "UPDATE report_table SET report_flag = 1 WHERE report_id = ?";
				PreparedStatement ps = con.prepareStatement(sql);

				for (String id : reportIds) {
					ps.setString(1, id);
					ps.executeUpdate();
		        }
		        this.disConnect();

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
	
	//レポート拒否
		public void DenyPublicReport(String[] reportIds) {

		    try {
		        this.connect();
		        String sql = "DELETE FROM report_table WHERE report_id = ?";
		        PreparedStatement ps = con.prepareStatement(sql);

		        for (String id : reportIds) {
		            ps.setString(1, id);
		            ps.executeUpdate();
		        }

		        ps.close();

		        this.disConnect();

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
	}



