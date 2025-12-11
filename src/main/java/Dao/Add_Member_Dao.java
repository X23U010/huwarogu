package Dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Member;

public class Add_Member_Dao extends Base_Dao {

	public boolean AddMember(Member menber) {

		boolean isUpdate = false;

		try {

			this.connect();

			String sql = "INSERT INTO member_table (member_id, member_name, member_month, member_password) VALUES (?, ?, ?, ?)";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, menber.getMember_id());
			ps.setString(2, menber.getMember_name());
			ps.setString(3, menber.getMember_month());
			ps.setString(4, menber.getMember_password());

			int record = ps.executeUpdate();

			if (record == 1) {
				isUpdate = true;
			}

		}catch (Exception e) {
		
			e.printStackTrace();
		} finally {
			try {
				this.disConnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		System.out.println(isUpdate);
		
		return isUpdate;

	}
}
