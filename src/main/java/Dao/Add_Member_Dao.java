package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

		} catch (Exception e) {

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

	public ArrayList<Member> MemberfindAll() {

		ArrayList<Member> member_list = new ArrayList<Member>();
		Statement stmt = null;

		try {

			this.connect();

			String sql = "SELECT * FROM member_table";

			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Member member = new Member();
				member.setMember_id(rs.getString("member_id"));
				member.setMember_name(rs.getString("member_name"));
				member.setMember_month(rs.getString("member_month"));
				member.setMember_password(rs.getString("member_password"));
				member.setMember_teacher_id(rs.getString("member_teacherId"));
				member.setMember_teacher_id(rs.getString("member_subTeacherId"));
				member_list.add(member);
			}

			return member_list;

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
		return member_list;
	}

}