package model.bean.chars;

public class Chars_qualityBean {
	private int char_id;
	private int lv;
	private int job_lv;
	private int exp;
	private int job_exp;
	private int max_hp;
	private int hp;
	private int max_mp;
	private int mp;
	private int str;
	private int inte;
	private int dex;
	private int agi;
	private int luk;
	private int vit;
	private int points;
	
	public Chars_qualityBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Chars_qualityBean(int char_id, int lv, int job_lv, int exp, int job_exp, int max_hp, int hp, int max_mp,
			int mp, int str, int inte, int dex, int agi, int luk, int vit, int points) {
		super();
		this.char_id = char_id;
		this.lv = lv;
		this.job_lv = job_lv;
		this.exp = exp;
		this.job_exp = job_exp;
		this.max_hp = max_hp;
		this.hp = hp;
		this.max_mp = max_mp;
		this.mp = mp;
		this.str = str;
		this.inte = inte;
		this.dex = dex;
		this.agi = agi;
		this.luk = luk;
		this.vit = vit;
		this.points = points;
	}
	public int getChar_id() {
		return char_id;
	}
	public void setChar_id(int char_id) {
		this.char_id = char_id;
	}
	public int getLv() {
		return lv;
	}
	public void setLv(int lv) {
		this.lv = lv;
	}
	public int getJob_lv() {
		return job_lv;
	}
	public void setJob_lv(int job_lv) {
		this.job_lv = job_lv;
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
	public int getDex() {
		return dex;
	}
	public void setDex(int dex) {
		this.dex = dex;
	}
	public int getAgi() {
		return agi;
	}
	public void setAgi(int agi) {
		this.agi = agi;
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
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
}
