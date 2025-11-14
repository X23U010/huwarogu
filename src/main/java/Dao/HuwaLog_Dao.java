package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Lesson;
import Model.Menber;

public class HuwaLog_Dao extends Base_Dao {
	public String LessonSearch(String lesson_id) {
		ArrayList<Lesson> lesson_list = new ArrayList<Lesson>();
		String lesson_name = null;

		for (int i = 0; lesson_list.size() > i; i++) {
			if (lesson_list.get(i).getLesson_name().equals(lesson_id)) {
				lesson_name = lesson_list.get(i).getLesson_name();
			}
		}
		return lesson_name;
	}

	public ArrayList<Lesson> LessonfindAll() {

		ArrayList<Lesson> lesson_list = new ArrayList<Lesson>();
		Statement stmt = null;

		try {

			this.connect();

			String sql = "SELECT * FROM lesson_table";

			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Lesson lesson = new Lesson();
				lesson.setLesson_id(rs.getString("lesson_id"));
				lesson.setLesson_name(rs.getString("lesson_name"));
				lesson.setLesson_password(rs.getString("lesson_password"));
				lesson.setLesson_day(rs.getString("lesson_day"));
				lesson_list.add(lesson);
			}

			return lesson_list;

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
		return lesson_list;
	}

	public boolean Lesson_findByIdAndPassword(Lesson lesson) {
		//検索結果あり（true）or なし（false）
		boolean isAttendance = false;

		try {
			//DB接続する
			this.connect();

			String sql = "SELECT lesson_id, lesson_name,lesson_password "
					+ "FROM lesson_table "
					+ "WHERE lesson_id = ? "
					+ "AND lesson_password = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			//バインド変数に検索条件を取得する
			ps.setString(1, lesson.getLesson_id());
			ps.setString(2, lesson.getLesson_password());

			//検索処理を実行し検索結果を取得する
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				//検索結果あり
				isAttendance = true;
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
		return isAttendance;
	}

	public boolean Login_findByIdAndPassword(Menber menber) {
		//検索結果あり（true）or なし（false）
		boolean isLogin = false;

		try {
			//DB接続する
			this.connect();

			String sql = "SELECT id, name, hash "
					+ "FROM mamber_table "
					+ "WHERE id = ? "
					+ "AND password = ?";

			PreparedStatement ps = con.prepareStatement(sql);

			//バインド変数に検索条件を取得する
			ps.setString(1, menber.getMenber_id());
			ps.setString(2, menber.getMenber_password());

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
