package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Absence;

public class Absence_Dao extends Base_Dao{
		public ArrayList<Absence> Absence_findAll() {

			ArrayList<Absence> absence_list = new ArrayList<Absence>();
			Statement stmt = null;

			try {

				this.connect();

				
				String sql = "SELECT * FROM absence_table"; 

				stmt = con.createStatement();

				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					Absence absence = new Absence();
					absence.setAbsence_id(rs.getString("Absence_id"));
					absence.setAbsence_member_id(rs.getString("Absence_member_id"));
					absence.setAbsence_date(rs.getString("Absence_day"));
					absence.setAbsence_application_date(rs.getString("Absence_implement"));
					absence.setAbsence_txt(rs.getString("Absence_txt"));
					absence.setAbsence_flag(rs.getString("Absence_flag"));
					
					absence_list.add(absence);
				}

				return absence_list;

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
			return absence_list;
		}
		
		public boolean Absence_Submit(Absence absence) {

			boolean issubmit = false;
			PreparedStatement ps = null;

			try {

				this.connect();

				String sql = "INSERT INTO absence_table \n"
						+ "(\n"
						+ "Absence_id,\n"
						+ "Absence_member_id,\n"
						+ "Absence_day,\n"
						+ "Absence_implement,\n"
						+ "Absence_txt,\n"
						+ "Absence_flag\n"
						+ ") \n"
						+ "VALUES (?,?,?,?,?,?)";
				
				ps = con.prepareStatement(sql);

				// 1. absence_id
		        ps.setString(1, absence.getAbsence_id());
		        
		        // 2. absence_member_id
		        ps.setString(2, absence.getAbsence_member_id());
		        
		        // 3. absence_date
		        ps.setString(3, absence.getAbsence_date());
		        
		        // 4. absence_application_date
		        ps.setString(4, absence.getAbsence_application_date());
		        
		        // 5. absence_txt
		        ps.setString(5, absence.getAbsence_txt());
		        
		        // 6. absence_flag
		        ps.setString(6, absence.getAbsence_flag());

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
