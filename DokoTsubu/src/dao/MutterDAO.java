package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class MutterDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/dokoTsubu?characterEncoding=utf-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";
	public List<Mutter> findAll() {
		List<Mutter> mutterList = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "select id, name, text from mutter order by id DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				int  id = rs.getInt("id");
				String userName = rs.getString("name");
				String text = rs.getString("text");
				Mutter mutter = new Mutter(id, userName, text);
				mutterList.add(mutter);
			}

		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return mutterList;
	}

	public boolean create(Mutter mutter) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS) ){
			String sql = "insert into mutter(name, text) values(?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, mutter.getUserName());
			pStmt.setString(2, mutter.getText());

			int result = pStmt.executeUpdate();
			if(result != 1) {
				return false;
			}

		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
