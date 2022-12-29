package model.dao.community;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.community.ItemBean;

public class ItemDAO {
	Connection con;

	public ItemDAO(Connection con) {
		this.con = con;
	}

	public ItemBean select_item(int item_id) throws SQLException {
		String sql = "select * from [MyGame].[dbo].[item] as b inner join [MyGame].[dbo].[Item_type] as c on b.item_type_id = c.item_type_id where b.item_id =?";
		ItemBean Item = null;
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, item_id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			item_id = rs.getInt("item_id");
			String item_name = rs.getString("item_name").trim();
			int item_type_id = rs.getInt("item_type_id");
			String caption = rs.getString("caption").trim();
			int add_hp = rs.getInt("add_hp");
			int add_mp = rs.getInt("add_mp");
			int add_points = rs.getInt("add_points");
			int add_str = rs.getInt("add_str");
			int add_inte = rs.getInt("add_inte");
			int add_dex = rs.getInt("add_dex");
			int add_agi = rs.getInt("add_agi");
			int add_luk = rs.getInt("add_luk");
			int add_vit = rs.getInt("add_vit");
			int add_money = rs.getInt("add_money");
			int add_exp = rs.getInt("add_exp");
			int add_job_exp = rs.getInt("add_job_exp");
			int sell_money = rs.getInt("sell_money");
			int buy_money = rs.getInt("buy_money");
			int add_max_hp = rs.getInt("add_max_hp");
			int add_max_mp = rs.getInt("add_max_mp");
			String item_type_name = rs.getString("item_type_name").trim();
			int add_lv = rs.getInt("add_lv");
			int add_job_lv = rs.getInt("add_job_lv");
			Item = new ItemBean(item_id, item_name, item_type_id, caption, add_hp, add_mp, add_points, add_str,
					add_inte, add_dex, add_agi, add_luk, add_vit, add_money, add_exp, add_job_exp, sell_money,
					buy_money, add_max_hp, add_max_mp, add_lv, add_job_lv, item_type_name);
		}
		rs.close();
		ps.close();
		return Item;
	}
	public ItemBean select_item_top1() throws SQLException {
		String sql = "select top 1 * from [MyGame].[dbo].[item] as b inner join [MyGame].[dbo].[Item_type] as c on b.item_type_id = c.item_type_id order by newid()";
		ItemBean Item = null;
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int item_id = rs.getInt("item_id");
			String item_name = rs.getString("item_name").trim();
			int item_type_id = rs.getInt("item_type_id");
			String caption = rs.getString("caption").trim();
			int add_hp = rs.getInt("add_hp");
			int add_mp = rs.getInt("add_mp");
			int add_points = rs.getInt("add_points");
			int add_str = rs.getInt("add_str");
			int add_inte = rs.getInt("add_inte");
			int add_dex = rs.getInt("add_dex");
			int add_agi = rs.getInt("add_agi");
			int add_luk = rs.getInt("add_luk");
			int add_vit = rs.getInt("add_vit");
			int add_money = rs.getInt("add_money");
			int add_exp = rs.getInt("add_exp");
			int add_job_exp = rs.getInt("add_job_exp");
			int sell_money = rs.getInt("sell_money");
			int buy_money = rs.getInt("buy_money");
			int add_max_hp = rs.getInt("add_max_hp");
			int add_max_mp = rs.getInt("add_max_mp");
			String item_type_name = rs.getString("item_type_name").trim();
			int add_lv = rs.getInt("add_lv");
			int add_job_lv = rs.getInt("add_job_lv");
			Item = new ItemBean(item_id, item_name, item_type_id, caption, add_hp, add_mp, add_points, add_str,
					add_inte, add_dex, add_agi, add_luk, add_vit, add_money, add_exp, add_job_exp, sell_money,
					buy_money, add_max_hp, add_max_mp, add_lv, add_job_lv, item_type_name);
		}
		rs.close();
		ps.close();
		return Item;
	}
	public List<ItemBean> select_item_all() throws SQLException {
		String sql = "select * from ([MyGame].[dbo].[item] as a inner join [MyGame].[dbo].[item] as b on a.item_id = b.item_id)inner join [MyGame].[dbo].[Item_type] as c on b.item_type_id = c.item_type_id";
		List<ItemBean> items = new ArrayList<ItemBean>();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int item_id = rs.getInt("item_id");
			String item_name = rs.getString("item_name").trim();
			int item_type_id = rs.getInt("item_type_id");
			String caption = rs.getString("caption").trim();
			int add_hp = rs.getInt("add_hp");
			int add_mp = rs.getInt("add_mp");
			int add_points = rs.getInt("add_points");
			int add_str = rs.getInt("add_str");
			int add_inte = rs.getInt("add_inte");
			int add_dex = rs.getInt("add_dex");
			int add_agi = rs.getInt("add_agi");
			int add_luk = rs.getInt("add_luk");
			int add_vit = rs.getInt("add_vit");
			int add_money = rs.getInt("add_money");
			int add_exp = rs.getInt("add_exp");
			int add_job_exp = rs.getInt("add_job_exp");
			int sell_money = rs.getInt("sell_money");
			int buy_money = rs.getInt("buy_money");
			int add_max_hp = rs.getInt("add_max_hp");
			int add_max_mp = rs.getInt("add_max_mp");
			String item_type_name = rs.getString("item_type_name").trim();
			int add_lv = rs.getInt("add_lv");
			int add_job_lv = rs.getInt("add_job_lv");
			ItemBean item = new ItemBean(item_id, item_name, item_type_id, caption, add_hp, add_mp, add_points, add_str,
					add_inte, add_dex, add_agi, add_luk, add_vit, add_money, add_exp, add_job_exp, sell_money,
					buy_money, add_max_hp, add_max_mp, add_lv, add_job_lv, item_type_name);
			items.add(item);
		}
		rs.close();
		ps.close();
		return items;
	}

	public void update_item(int item_id, String item_name, int item_type_id, String caption, int add_hp, int add_mp,
			int add_points, int add_str, int add_inte, int add_dex, int add_agi, int add_luk, int add_vit,
			int add_money, int add_exp, int add_job_exp, int sell_money, int buy_money, int add_max_hp, int add_max_mp,
			int add_job_lv, int add_lv) throws SQLException {
		String sql = "UPDATE [MyGame].[dbo].[item]  SET [item_type_id] =?,[item_name] =?,[caption] = ?,[add_hp] = ?,[add_mp] = ?,[add_points]?,[add_str] = ?,[add_inte] = ?,[add_dex] = ?,[add_agi] = ?,[add_luk] = ?,[add_vit] = ?,[add_money] =?,[add_exp] = ?,[add_job_exp]=?,[sell_money] =?,[buy_money] = ?,[add_max_hp] =?,[add_max_mp] =?,add_lv=?,add_job_lv WHERE [item_id] = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, item_type_id);
		ps.setString(2, item_name);
		ps.setString(3, caption);
		ps.setInt(4, add_hp);
		ps.setInt(5, add_mp);
		ps.setInt(6, add_points);
		ps.setInt(7, add_str);
		ps.setInt(8, add_inte);
		ps.setInt(9, add_dex);
		ps.setInt(10, add_agi);
		ps.setInt(11, add_luk);
		ps.setInt(12, add_vit);
		ps.setInt(13, add_money);
		ps.setInt(14, add_exp);
		ps.setInt(15, add_job_exp);
		ps.setInt(16, sell_money);
		ps.setInt(17, buy_money);
		ps.setInt(18, add_max_hp);
		ps.setInt(19, add_max_mp);
		ps.setInt(20, add_lv);
		ps.setInt(21, add_job_lv);
		ps.setInt(22, item_id);

		ps.executeUpdate();
		ps.close();
	}

	public void delete_item(int item_id) throws SQLException {
		String sql = "dalete from [MyGame].[dbo].[item] WHERE item_id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, item_id);
		ps.executeUpdate();
		ps.close();
	}

	public void insert_item(int item_id, String item_name, int item_type_id, String caption, int add_hp, int add_mp,
			int add_points, int add_str, int add_inte, int add_dex, int add_agi, int add_luk, int add_vit,
			int add_money, int add_exp, int add_job_exp, int sell_money, int buy_money, int add_max_hp, int add_max_mp,
			int add_job_lv, int add_lv) throws SQLException {
		String sql = "INSERT INTO [MyGame].[dbo].[item]"
				+ "([[item_type_id],item_name],[caption],[add_hp],[add_mp],[add_points],[add_str],[add_inte],[add_dex],[add_agi],[add_luk],[add_vit],[add_money],[add_exp],[add_job_exp],[sell_money],[buy_money],[add_max_hp],[add_max_mp],add_lv,add_job_lv)"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, item_type_id);
		ps.setString(2, item_name);
		ps.setString(3, caption);
		ps.setInt(4, add_hp);
		ps.setInt(5, add_mp);
		ps.setInt(6, add_points);
		ps.setInt(7, add_str);
		ps.setInt(8, add_inte);
		ps.setInt(9, add_dex);
		ps.setInt(10, add_agi);
		ps.setInt(11, add_luk);
		ps.setInt(12, add_vit);
		ps.setInt(13, add_money);
		ps.setInt(14, add_exp);
		ps.setInt(15, add_job_exp);
		ps.setInt(16, sell_money);
		ps.setInt(17, buy_money);
		ps.setInt(18, add_max_hp);
		ps.setInt(19, add_max_mp);
		ps.setInt(20, add_lv);
		ps.setInt(21, add_job_lv);
		ps.executeUpdate();
		ps.close();
	}

}
