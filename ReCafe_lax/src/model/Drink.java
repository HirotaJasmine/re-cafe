package model;

public class Drink {

	private String name;//完成品の名前
	private int productNum;//商品の番号
	private int material1;//メイン原料しか入れないとする。
	private int material2;//メイン、サブどちらでもよいとする。
	private int caffein_n;//カフェインの強さを示す値、大きいほど強い。
	private int caffein_m1;
	private int caffein_m2;
	private int mild_n;//まろやかさを示す値、大きいほどまろやか。
	private int mild_m1;
	private int mild_m2;
	private int sweet_n;//甘さを示す値、大きいほど甘い。
	private int sweet_m1;
	private int sweet_m2;
	private boolean judgeServe;//ドリンクを作ったときだけに使う
	private int howToJudge;//判定方法を区別する数字

	public Drink() {
		//コンストラクタ
	}

	public Drink(int howToJudge) {
		super();
		this.howToJudge = howToJudge;
	}

	//★getter
	public String getName() {
		return this.name;
	}

	public int getMaterial1() {
		return this.material1;
	}

	public int getMaterial2() {
		return this.material2;
	}

	public int getCaffein_n() {
		return this.caffein_n;
	}

	public int getCaffein_m1() {
		return this.caffein_m1;
	}

	public int getCaffein_m2() {
		return this.caffein_m2;
	}

	public int getMild_n() {
		return this.mild_n;
	}

	public int getMild_m1() {
		return this.mild_m1;
	}

	public int getMild_m2() {
		return this.mild_m2;
	}

	public int getSweet_n() {
		return this.sweet_n;
	}

	public int getSweet_m1() {
		return this.sweet_m1;
	}

	public int getSweet_m2() {
		return this.sweet_m2;
	}

	public int getProductNum() {
		return this.productNum;
	}


	public boolean isJudgeServe() {
		return judgeServe;
	}


	public int getHowToJudge() {
		return howToJudge;
	}


	//★setter
	public void setName(String name) {
		this.name = name;
	}

	public void setMaterial1(int material1) {
		this.material1 = material1;
	}

	public void setMaterial2(int material2) {
		this.material2 = material2;
	}

	public void setCaffein_n(int caffein_n) {
		this.caffein_n = caffein_n;
	}

	public void setCaffein_m1(int caffein_m1) {
		this.caffein_m1 = caffein_m1;
	}

	public void setCaffein_m2(int caffein_m2) {
		this.caffein_m2 = caffein_m2;
	}

	public void setMild_n(int mild_n) {
		this.mild_n = mild_n;
	}

	public void setMild_m1(int mild_m1) {
		this.mild_m1 = mild_m1;
	}

	public void setMild_m2(int mild_m2) {
		this.mild_m2 = mild_m2;
	}

	public void setSweet_n(int sweet_n) {
		this.sweet_n = sweet_n;
	}

	public void setSweet_m1(int sweet_m1) {
		this.sweet_m1 = sweet_m1;
	}

	public void setSweet_m2(int sweet_m2) {
		this.sweet_m2 = sweet_m2;
	}
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public void setJudgeServe(boolean judgeServe) {
		this.judgeServe = judgeServe;
	}
	public void setHowToJudge(int howToJudge) {
		this.howToJudge = howToJudge;
		/**
		 * 0：同じものを提供できているか
		 * 1：カフェイン量の比較、カフェインが多いものがよい
		 * 2：カフェイン量の比較、カフェインの少ないものがよい
		 * 3：カフェイン量の比較、カフェインがないものがよい
		 * 4：甘さの比較、甘いものが良い
		 * 5：甘さの比較、甘くないものが良い
		 */

	}
}



