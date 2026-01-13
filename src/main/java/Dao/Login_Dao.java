package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Member;

public class Login_Dao extends Base_Dao {
	public boolean findByIdAndPassword(Member member) {
		//検索結果あり（true）or なし（false）
		boolean isLogin = false;

		try {
			//DB接続する
			this.connect();

			String sql = "SELECT * "
					+ "FROM member_table "
					+ "WHERE member_id = ? "
					+ "AND member_password = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			//バインド変数に検索条件を取得する
			ps.setString(1, member.getMember_id());
			ps.setString(2, member.getMember_password());

			//検索処理を実行し検索結果を取得する
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				//検索結果あり
				isLogin = true;
				
				member.setMember_name(rs.getString("member_name"));
				member.setMember_month(rs.getString("member_month"));
				member.setMember_teacher_id(rs.getString("member_teacherId"));
				member.setMember_subteacher_id(rs.getString("member_subTeacherId"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//DB切断する
				this.disConnect();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isLogin;
	}
}
