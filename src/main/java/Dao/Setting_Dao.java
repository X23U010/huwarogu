package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	
	public ArrayList<Member> Teacher_findAll() {

		ArrayList<Member> teacher_list = new ArrayList<Member>();
		Statement stmt = null;

		try {

			this.connect();

			String sql = "SELECT * FROM member_table"; 

			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				
				String str = rs.getString("member_id");
				if(str !=null && str.length() > 0) {
					String firstChar = str.substring(0, 1);
					
					if (firstChar.equals("t")) {
						Member member = new Member();
						member.setMember_id(rs.getString("member_id"));
						member.setMember_name(rs.getString("member_name"));
						member.setMember_month(rs.getString("member_month"));
						member.setMember_password(rs.getString("member_password"));
						teacher_list.add(member);
			        }
				}
			}

			return teacher_list;

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
		return teacher_list;
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
