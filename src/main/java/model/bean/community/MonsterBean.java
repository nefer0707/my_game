package model.bean.community;

public class MonsterBean {
	private int monster_id;
	private String monster_name;
	private String monster_img;
	private int lv;
	private int exp;
	private int job_exp;
	private int max_hp;
	private int hp;
	private int max_mp;
	private int mp;
	private int str;
	private int inte;
	private int agi;
	private int dex;
	private int luk;
	private int vit;
	private int battlemap_id;

	public MonsterBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MonsterBean(int monster_id, String monster_name, String monster_img, int lv, int exp, int job_exp,
			int max_hp, int hp, int max_mp, int mp, int str, int inte, int agi, int dex, int luk, int vit,
			int battlemap_id) {
		super();
		this.monster_id = monster_id;
		this.monster_name = monster_name;
		this.monster_img = monster_img;
		this.lv = lv;
		this.exp = exp;
		this.job_exp = job_exp;
		this.max_hp = max_hp;
		this.hp = hp;
		this.max_mp = max_mp;
		this.mp = mp;
		this.str = str;
		this.inte = inte;
		this.agi = agi;
		this.dex = dex;
		this.luk = luk;
		this.vit = vit;
		this.battlemap_id = battlemap_id;
	}

	public int getMonster_id() {
		return monster_id;
	}

	public void setMonster_id(int monster_id) {
		this.monster_id = monster_id;
	}

	public String getMonster_name() {
		return monster_name;
	}

	public void setMonster_name(String monster_name) {
		this.monster_name = monster_name;
	}

	public String getMonster_img() {
		return monster_img;
	}

	public void setMonster_img(String monster_img) {
		this.monster_img = monster_img;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getJob_exp() {
		return job_exp;
	}

	public void setJob_exp(int job_exp) {
		this.job_exp = job_exp;
	}

	public int getMax_hp() {
		return max_hp;
	}

	public void setMax_hp(int max_hp) {
		this.max_hp = max_hp;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMax_mp() {
		return max_mp;
	}

	public void setMax_mp(int max_mp) {
		this.max_mp = max_mp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getStr() {
		return str;
	}

	public void setStr(int str) {
		this.str = str;
	}

	public int getInte() {
		return inte;
	}

	public void setInte(int inte) {
		this.inte = inte;
	}

	public int getAgi() {
		return agi;
	}

	public void setAgi(int agi) {
		this.agi = agi;
	}

	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public int getLuk() {
		return luk;
	}

	public void setLuk(int luk) {
		this.luk = luk;
	}

	public int getVit() {
		return vit;
	}

	public void setVit(int vit) {
		this.vit = vit;
	}

	public int getBattlemap_id() {
		return battlemap_id;
	}

	public void setBattlemap_id(int battlemap_id) {
		this.battlemap_id = battlemap_id;
	}


}
