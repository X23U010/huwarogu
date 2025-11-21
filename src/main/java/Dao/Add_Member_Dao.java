package Dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Menber;

public class Add_Member_Dao extends Base_Dao {

	public boolean AddMember(Menber menber) {

		boolean isUpdate = false;

		try {

			this.connect();

			String sql = "INSERT INTO( member_table{member_id, member_name, member_month, member_password,)VALUES"
					+ "(?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, menber.getMenber_id());
			ps.setString(2, menber.getMenber_name());
			ps.setString(3, menber.getMenber_month());
			ps.setString(4, menber.getMenber_password());

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
