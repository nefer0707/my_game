package model.bean.community;

public class BattleBean {
	private int battle_id;
	private int char_id;

	public BattleBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BattleBean(int battle_id, int char_id) {
		super();
		this.battle_id = battle_id;
		this.char_id = char_id;
	}

	public int getBattle_id() {
		return battle_id;
	}

	public void setBattle_id(int battle_id) {
		this.battle_id = battle_id;
	}

	public int getChar_id() {
		return char_id;
	}

	public void setChar_id(int char_id) {
		this.char_id = char_id;
	}
}
