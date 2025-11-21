package Dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Request;



public class Absence_Dao extends Base_Dao{
	public boolean InAbsence(Request request) {

		boolean isUpdate = false;

		try {

			this.connect();

			String sql = "INSERT INTO( request_table{request_id, request_type_id, request_member_id,"
					+ " request_day, request_implement, request_txt, request_flag)VALUES"
					+ "(?,?,?,?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, request.getRequest_id());
			ps.setString(2, request.getRequest_request_type_id());
			ps.setString(3, request.getRequest_menber_id());
			ps.setString(4, request.getRequest_day());
			ps.setString(5, request.getRequest_implement());
			ps.setString(6, request.getRequest_txt());
			ps.setString(7, request.getRequest_flag());

			int record = ps.executeUpdate();

			if (record == 1) {
				isUpdate = true;
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
		return isUpdate;

	}
}
