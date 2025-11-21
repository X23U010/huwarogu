package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Lesson;

public class Lesson_Dao extends Base_Dao {
	public boolean findByIdAndPassword(Lesson lesson) {
		//検索結果あり（true）or なし（false）
		boolean isLogin = false;

		try {
			//DB接続する
			this.connect();

			String sql = "SELECT id, name, hash "
					+ "FROM manber_table "
					+ "WHERE id = ? "
					+ "AND password = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			//バインド変数に検索条件を取得する
			ps.setString(1, lesson.getLesson_id());
			ps.setString(2, lesson.getLesson_password());

			//検索処理を実行し検索結果を取得する
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				//検索結果あり
				isLogin = true;
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
