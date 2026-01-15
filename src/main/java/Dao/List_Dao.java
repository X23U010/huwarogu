package Dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Absence;
import Model.Public_Absence;

public class List_Dao extends Base_Dao {
	
	//許可された欠席一覧を取得(今日の日付以降)
	public ArrayList<Absence> getAbList(){
	    
		ArrayList<Absence> abList = new ArrayList<>();
		
		String sql = "SELECT * FROM Absence_table WHERE Absence_flag = 1 "
				+ "AND Absence_implement >= CURRENT_DATE ORDER BY Absence_implement ASC;";

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
	
	//許可された欠席一覧を取得ALL
		public ArrayList<Absence> getALLAbList(){
		    
			ArrayList<Absence> abList = new ArrayList<>();
			
			String sql = "SELECT * FROM Absence_table WHERE Absence_flag = 1 "
					+ "ORDER BY Absence_implement ASC;";

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
	
	//許可された公欠一覧を取得(今日の日付以降)
	public ArrayList<Public_Absence> getPuAbList() {

	    ArrayList<Public_Absence> PuAbList = new ArrayList<>();

	    String sql = "SELECT * FROM OfficilAbsence_table WHERE OfficilAbsence_flag = 1 "
	    		+ "AND OfficilAbsence_day >= CURRENT_DATE "
	    		+ "ORDER BY OfficilAbsence_day ASC;";

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
	
	//許可された公欠一覧を取得ALL
	public ArrayList<Public_Absence> getALLPuAbList() {

	    ArrayList<Public_Absence> PuAbList = new ArrayList<>();

	    String sql = "SELECT * FROM OfficilAbsence_table WHERE OfficilAbsence_flag = 1 "
	    		+ "ORDER BY OfficilAbsence_day ASC;";

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

}
