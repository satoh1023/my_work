package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserListDeleteCompleteDAO {

	private String sql = "DELETE FROM login_user_transaction";
	private String sqll="insert into login_user_transaction(login_id,login_pass,user_name,admin_flg) values(?,?,?,?)";

	public int deleteUserList() throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		PreparedStatement ps;
		int result =0;
		try {
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();

			ps=con.prepareStatement(sqll);
			ps.setString(1,"admin");
			ps.setString(2,"admin");
			ps.setString(3,"admin");
			ps.setString(4,"1");
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;
	}
}
