package model.bean.community;

public class BattleMapBean {
	private int battlemap_id;
	private String battlemap_name;

	public BattleMapBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BattleMapBean(int battlemap_id, String battlemap_name) {
		super();
		this.battlemap_id = battlemap_id;
		this.battlemap_name = battlemap_name;
	}

	public int getBattlemap_id() {
		return battlemap_id;
	}

	public void setBattlemap_id(int battlemap_id) {
		this.battlemap_id = battlemap_id;
	}

	public String getBattlemap_name() {
		return battlemap_name;
	}

	public void setBattlemap_name(String battlemap_name) {
		this.battlemap_name = battlemap_name;
	}

}
