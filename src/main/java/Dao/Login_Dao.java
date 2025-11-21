package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Menber;

public class Login_Dao extends Base_Dao {
	public boolean findByIdAndPassword(Menber menber) {
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
			ps.setString(1, menber.getMenber_id());
			ps.setString(2, menber.getMenber_password());

			//検索処理を実行し検索結果を取得する
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				//検索結果あり
				isLogin = true;
				
				menber.setMenber_name(rs.getString("member_name"));
				menber.setMenber_month(rs.getString("member_month"));
				
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
