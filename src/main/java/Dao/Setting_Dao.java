package Dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Member;

public class Setting_Dao extends Base_Dao {

	public boolean Member_Update(Member member) {

		boolean isUpdate = false;

		try {

			this.connect();

			String sql = "UPDATE member_table SET member_password = ? WHERE member_id = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, member.getMember_password());
			ps.setString(2, member.getMember_id());

			int record = ps.executeUpdate();

			if (record > 0) {
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

	public boolean Teacher_Update(Member member) {

		boolean isUpdate = false;

		try {

			this.connect();

			String sql = "UPDATE member_table SET member_teacherId = ? WHERE member_id = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, member.getMember_teacher_id());
			ps.setString(2, member.getMember_id());

			int record = ps.executeUpdate();

			if (record > 0) {
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

	public boolean SubTeacher_Update(Member member) {

		boolean isUpdate = false;

		try {

			this.connect();

			String sql = "UPDATE member_table SET member_subTeacherId = ? WHERE member_id = ?";

			PreparedStatement ps = con.prepareStatement(sql);
	
			ps.setString(1, member.getMember_subteacher_id());
			ps.setString(2, member.getMember_id());

			int record = ps.executeUpdate();

			if (record > 0) {
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
