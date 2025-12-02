package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Divination;

public class Divination_Dao extends Base_Dao{

	public ArrayList<Divination> DivinationfindAll() {

		ArrayList<Divination> divination_list = new ArrayList<Divination>();
		Statement stmt = null;

		try {

			this.connect();

			String sql = "SELECT * FROM divination_table";

			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Divination divination = new Divination();
				divination.setDivination_id(rs.getString("divination_id"));
				divination.setDivination_txt(rs.getString("divination_txt"));
				divination.setDivination_item(rs.getString("divination_item"));
				divination_list.add(divination);
			}

			return divination_list;

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
		return divination_list;
	}

}
