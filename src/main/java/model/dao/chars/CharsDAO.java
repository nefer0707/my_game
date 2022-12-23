package model.dao.chars;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.chars.CharsBean;
public class CharsDAO {
	public Connection con ;

	public CharsDAO(Connection con) throws Exception {
		this.con=con;
	}

	public CharsBean selectBycharid(int char_id) throws Exception {
		String sql = "select * from [MyGame].[dbo].[chars] where char_id = ?";
		CharsBean mychar = null;
		try (PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setObject(1, char_id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					int uid = rs.getInt("uid");
					char_id = rs.getInt("char_id");
					String char_name = rs.getString("char_name");
					String img = rs.getString("img");
					int job_id = rs.getInt("job_id");
					int money = rs.getInt("money");
					mychar = new CharsBean(uid, char_id, char_name, img, job_id, money);
				}
			}
		}
		return mychar;
	}
	public CharsBean selectByuid(int uid) throws Exception {
		String sql = "select * from [MyGame].[dbo].[chars] where uid = ?";
		CharsBean mychar = null;
		try (PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setObject(1, uid);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					uid = rs.getInt("uid");
					int char_id = rs.getInt("char_id");
					String char_name = rs.getString("char_name");
					String img = rs.getString("img");
					int job_id = rs.getInt("job_id");
					int money = rs.getInt("money");
					mychar = new CharsBean(uid, char_id, char_name, img, job_id, money);
				}
			}
		}
		return mychar;
	}
	public List<CharsBean> selectAllbyuid(int uid) throws Exception {
		String sql = "select * from [MyGame].[dbo].[chars] where uid = ?";
		List<CharsBean> mychars = new ArrayList<CharsBean>();
		try (PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setObject(1, uid);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					uid = rs.getInt("uid");
					int char_id = rs.getInt("char_id");
					String char_name = rs.getString("char_name");
					String img = rs.getString("img");
					int job_id = rs.getInt("job_id");
					int money = rs.getInt("money");
					CharsBean mychar = new CharsBean(uid, char_id, char_name, img, job_id, money);
					mychars.add(mychar);
				}
			}
		}
		return mychars;
	}
	public void insertChars(int uid,String char_name,String img) throws SQLException {
		String sql = "INSERT INTO [MyGame].[dbo].[chars]"
		          + "([uid],[char_name],[img],[job_id],[money]) VALUES(?,?,?,?,?)";
		try (PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, uid);
			ps.setString(2, char_name);
			ps.setString(3, img);
			ps.setInt(4, 100);
			ps.setInt(5, 1000);
			ps.executeUpdate();
		}
	}

	public void delectChars(int char_id) throws SQLException {
		String sql = "delete from [MyGame].[dbo].[chars] where char_id = ?";
		try (PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, char_id);
			ps.executeUpdate();
		}
	}

	public void updateChars_job_id(int job_id,int char_id) throws SQLException {
		String sql = "UPDATE [MyGame].[dbo].[account] SET [job_id] = ? WHERE char_id = ?";
		try (PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, job_id);
			ps.setInt(2, char_id);
			ps.executeUpdate();
		}
	}
	public void updateChars_money(int money,int char_id) throws SQLException {
		String sql = "UPDATE [MyGame].[dbo].[chars] SET [money] = ? WHERE char_id = ?";
		try (PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, money);
			ps.setInt(2, char_id);
			ps.executeUpdate();
		}
	}
	public void closeConn() {
		try {
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
