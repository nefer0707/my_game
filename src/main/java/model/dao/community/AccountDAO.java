package model.dao.community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.bean.community.AccountBean;

public class AccountDAO {
	public Connection con;

	public AccountDAO(Connection con) throws Exception {
		this.con = con;
	}

	public AccountBean selectByAccount(String account) throws Exception {
		String sql = "select * from [MyGame].[dbo].[account] where account = ?";
		AccountBean acc = null;
		try (PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setObject(1, account);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					account = rs.getString("account").trim();
					String password = rs.getString("password").trim();
					int uid = rs.getInt("uid");
					int lv = rs.getInt("lv");
					acc = new AccountBean(account, password, uid, lv);
				}
			}
		}
		return acc;
	}

	public void insertAccount(String account, String password) throws SQLException {
		String sql = "INSERT INTO [MyGame].[dbo].[account]([account],[password],lv) VALUES(?,?,?)";
		try (PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, account);
			ps.setString(2, password);
			ps.setInt(3, 1);
			ps.executeUpdate();
		}
	}

	public void delectAccoint(String account) throws SQLException {
		String sql = "delete from [MyGame].[dbo].[account] where account = ?";
		try (PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, account);
			ps.executeUpdate();
		}
	}

	public void update(String account, String password) throws SQLException {
		String sql = "UPDATE [MyGame].[dbo].[account] SET [password] = ? WHERE account = ?";
		try (PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setString(1, password);
			ps.setString(2, account);
			ps.executeUpdate();
		}
	}
}
