package model;

public class Menu {
	Props p = new Props();
	Drink d = new Drink();

	public String showMenu(int productNo) {
		if(productNo==1) {
			return "コーヒー";
		}else if(productNo==2) {
			return "カフェオレ";
		}else if(productNo==3) {
			return "紅茶";
		}else if(productNo==4) {
			return "ミルクティー";
		}else if(productNo==5) {
			return "ホットチョコ";
		}else if(productNo==6) {
			return "ミルクココア";
		}else if(productNo==7) {
			return "ホットミルク";
		}else {
		return "隠しメニュー...";
		}
	}

	public boolean firstMaterial(int select) {

		p.captionSpeed(" ");

		if (!(select != 0)) {
			p.captionSpeed("◆１つ目の材料を選んでください◆");
			p.captionSpeed("     ");
		} else if (select > 4) {
			p.captionSpeed("※材料を1～4で選んでください※");
			p.captionSpeed("     ");
			return false;
		} else {
			p.captionSpeed("◆２つ目の材料を選んでください◆");
			p.captionSpeed("     ");

			switch (select) {
			case 1:
				System.out.println("◇１つ目の材料：コーヒー");
				break;
			case 2:
				System.out.println("◇１つ目の材料：紅茶");
				break;
			case 3:
				System.out.println("◇１つ目の材料：チョコレート");
				break;
			case 4:
				System.out.println("◇１つ目の材料：ミルク");
				break;
			}
		}

		if (select < 5) {
			switch (select) {
			case 0:
				System.out.println("１:コーヒー");
				System.out.println("２:紅茶");
				System.out.println("３:チョコレート");
				System.out.println("４:ミルク");
				break;
			case 1:
				System.out.println("１:コーヒー");
				System.out.println("４:ミルク");
				break;
			case 2:
				System.out.println("２:紅茶");
				System.out.println("４:ミルク");
				break;
			case 3:
				System.out.println("３:チョコレート");
				System.out.println("４:ミルク");
				break;
			case 4:
				System.out.println("１:コーヒー");
				System.out.println("２:紅茶");
				System.out.println("３:チョコレート");
				System.out.println("４:ミルク");
				break;
			}
			return true;
		} else {
			return false;
		}

	}

	public Drink product(int m1, int m2) {
		Drink order = new Drink();

		if (((m1 < 1 || m1 > 4)) || (m2 < 1 || m2 > 4)) {
			p.captionSpeed("※材料を1～4で選んでください※");
			p.captionSpeed("     ");
			p.captionSpeed("◆２つ目の材料を選んでください◆");

			switch (m1) {
			case 0:
				System.out.println("１:コーヒー");
				System.out.println("２:紅茶");
				System.out.println("３:チョコレート");
				System.out.println("４:ミルク");
				break;

			case 1:
				System.out.println("１:コーヒー");
				System.out.println("４:ミルク");
				break;
			case 2:
				System.out.println("２:紅茶");
				System.out.println("４:ミルク");

				break;
			case 3:
				System.out.println("３:チョコレート");
				System.out.println("４:ミルク");
				break;
			case 4:
				System.out.println("１:コーヒー");
				System.out.println("２:紅茶");
				System.out.println("３:チョコレート");
				System.out.println("４:ミルク");
				break;

			}
			return order;
		}


		p.captionSpeed("調理中...");

		System.out.println("完成しました。");
		if (m1 == 1 && m2 == 1) {
			System.out.println("【コーヒー】");
			d.setJudgeServe(true);
			order = inPutServe(1);
		} else if ((m1 == 1 && m2 == 4) || (m1 == 4 && m2 == 1)) {
			System.out.println("【カフェオレ】");
			d.setJudgeServe(true);
			order = inPutServe(2);

		} else if (m1 == 2 && m2 == 2) {
			System.out.println("【紅茶】");
			d.setJudgeServe(true);
			order = inPutServe(3);

		} else if ((m1 == 2 && m2 == 4) || (m1 == 4 && m2 == 2)) {
			System.out.println("【ミルクティー】");
			d.setJudgeServe(true);
			order = inPutServe(4);

		} else if (m1 == 3 && m2 == 3) {
			System.out.println("【ホットチョコ】");
			d.setJudgeServe(true);
			order = inPutServe(5);

		} else if ((m1 == 3 && m2 == 4) || (m1 == 4 && m2 == 3)) {
			System.out.println("【ミルクココア】");
			d.setJudgeServe(true);
			order = inPutServe(6);

		} else if (m1 == 4 && m2 == 4) {
			System.out.println("【ホットミルク】");
			d.setJudgeServe(true);
			order = inPutServe(7);

		} else {
			System.out.println("【失敗】");
			p.captionSpeed("もう一度作り直してください。\n");
			p.line();
			return order;
		}

		p.line();

		System.out.println();
		return order;

	}

	public Drink inPutMaterial1(int m1) {

		if (m1 == 1) {//コーヒー
			d.setCaffein_m1(2);
			d.setMild_m1(0);
			d.setSweet_m1(0);
		} else if (m1 == 2) {//紅茶
			d.setCaffein_m1(2);
			d.setMild_m1(0);
			d.setSweet_m1(0);
		} else if (m1 == 3) {//チョコ
			d.setCaffein_m1(1);
			d.setMild_m1(0);
			d.setSweet_m1(2);
		} else if (m1 == 4) {//ミルク
			d.setCaffein_m1(0);
			d.setMild_m1(2);
			d.setSweet_m1(1);
		}
		return d;
	}

	public Drink inPutMaterial2(int m2) {
		if (m2 == 1) {//コーヒー
			d.setCaffein_m2(2);
			d.setMild_m2(0);
			d.setSweet_m2(0);
		} else if (m2 == 2) {//紅茶
			d.setCaffein_m2(2);
			d.setMild_m2(0);
			d.setSweet_m2(0);
		} else if (m2 == 3) {//チョコ
			d.setCaffein_m2(1);
			d.setMild_m2(0);
			d.setSweet_m2(2);
		} else if (m2 == 4) {//ミルク
			d.setCaffein_m2(0);
			d.setMild_m2(2);
			d.setSweet_m2(1);
		}
		return d;
	}

	public Drink inPutServe(int productNo) {

		if (productNo == 1) {//コーヒー
			int m1 = 1;
			int m2 = 1;
			//それぞれの原材料の適切な値のsetを分岐している
			//原料1
			d = inPutMaterial1(m1);
			//原料2
			d = inPutMaterial2(m2);

			d.setName("コーヒー");
			d.setProductNum(productNo);
			d.setMaterial1(m1);
			d.setMaterial2(m2);

			d.setCaffein_n((d.getCaffein_m1() + d.getCaffein_m2()));
			d.setMild_n((d.getMild_m1() + d.getMild_m2()));
			d.setSweet_n((d.getSweet_m1() + d.getSweet_m2()));

		} else if (productNo == 2) {//カフェオレ
			int m1 = 1;
			int m2 = 4;
			//それぞれの原材料の適切な値のsetを分岐している
			//原料1
			d = inPutMaterial1(m1);
			//原料2
			d = inPutMaterial2(m2);

			d.setName("カフェオレ");
			d.setProductNum(productNo);
			d.setMaterial1(m1);
			d.setMaterial2(m2);
			d.setCaffein_n((d.getCaffein_m1() + d.getCaffein_m2()));
			d.setMild_n((d.getMild_m1() + d.getMild_m2()));
			d.setSweet_n((d.getSweet_m1() + d.getSweet_m2()));

		} else if (productNo == 3) {//紅茶
			int m1 = 2;
			int m2 = 2;
			//それぞれの原材料の適切な値のsetを分岐している
			//原料1
			d = inPutMaterial1(m1);
			//原料2
			d = inPutMaterial2(m2);

			d.setName("紅茶");
			d.setProductNum(productNo);
			d.setMaterial1(m1);
			d.setMaterial2(m2);
			d.setCaffein_n((d.getCaffein_m1() + d.getCaffein_m2()));
			d.setMild_n((d.getMild_m1() + d.getMild_m2()));
			d.setSweet_n((d.getSweet_m1() + d.getSweet_m2()));

		} else if (productNo == 4) {//ミルクティー
			int m1 = 2;
			int m2 = 4;
			//それぞれの原材料の適切な値のsetを分岐している
			//原料1
			d = inPutMaterial1(m1);
			//原料2
			d = inPutMaterial2(m2);

			d.setName("ミルクティー");
			d.setProductNum(productNo);
			d.setMaterial1(m1);
			d.setMaterial2(m2);
			d.setCaffein_n((d.getCaffein_m1() + d.getCaffein_m2()));
			d.setMild_n((d.getMild_m1() + d.getMild_m2()));
			d.setSweet_n((d.getSweet_m1() + d.getSweet_m2()));

		} else if (productNo == 5) {//ホットチョコ
			int m1 = 3;
			int m2 = 3;
			//それぞれの原材料の適切な値のsetを分岐している
			//原料1
			d = inPutMaterial1(m1);
			//原料2
			d = inPutMaterial2(m2);

			d.setName("ホットチョコレート");
			d.setProductNum(productNo);
			d.setMaterial1(m1);
			d.setMaterial2(m2);
			d.setCaffein_n((d.getCaffein_m1() + d.getCaffein_m2()));
			d.setMild_n((d.getMild_m1() + d.getMild_m2()));
			d.setSweet_n((d.getSweet_m1() + d.getSweet_m2()));

		} else if (productNo == 6) {//ミルクココア

			int m1 = 3;
			int m2 = 4;
			//それぞれの原材料の適切な値のsetを分岐している
			//原料1
			d = inPutMaterial1(m1);
			//原料2
			d = inPutMaterial2(m2);

			d.setName("ミルクココア");
			d.setProductNum(productNo);
			d.setMaterial1(m1);
			d.setMaterial2(m2);
			d.setCaffein_n((d.getCaffein_m1() + d.getCaffein_m2()));
			d.setMild_n((d.getMild_m1() + d.getMild_m2()));
			d.setSweet_n((d.getSweet_m1() + d.getSweet_m2()));

		} else if (productNo == 7) {//ホットミルク
			int m1 = 4;
			int m2 = 4;
			//それぞれの原材料の適切な値のsetを分岐している
			//原料1
			d = inPutMaterial1(m1);
			//原料2
			d = inPutMaterial2(m2);

			d.setName("ホットミルク");
			d.setProductNum(productNo);
			d.setMaterial1(m1);
			d.setMaterial2(m2);
			d.setCaffein_n((d.getCaffein_m1() + d.getCaffein_m2()));
			d.setMild_n((d.getMild_m1() + d.getMild_m2()));
			d.setSweet_n((d.getSweet_m1() + d.getSweet_m2()));
		}

//		System.out.println(d.getName());
//		System.out.println("メニュー番号：" + d.getProductNum());
//		System.out.println("原料番号1：" + d.getMaterial1());
//		System.out.println("原料番号2：" + d.getMaterial2());
//		System.out.println("カフェイン1：" + d.getCaffein_m1());
//		System.out.println("カフェイン2：" + d.getCaffein_m2());
//		System.out.println("カフェイン合計：" + d.getCaffein_n());
//		System.out.println("まろやか1：" + d.getMild_m1());
//		System.out.println("まろやか2：" + d.getMild_m2());
//		System.out.println("まろやか合計：" + d.getMild_n());
//		System.out.println("甘さ1：" + d.getSweet_m1());
//		System.out.println("甘さ2：" + d.getSweet_m2());
//		System.out.println("甘さ合計：" + d.getSweet_n());
		return d;
	}

	public Drink inPutOrder(int productNo, int HowToJudge) {

		if (productNo == 1) {//コーヒー
			int m1 = 1;
			int m2 = 1;
			//それぞれの原材料の適切な値のsetを分岐している
			//原料1
			d = inPutMaterial1(m1);
			//原料2
			d = inPutMaterial2(m2);

			d.setName("コーヒー");
			d.setProductNum(productNo);
			d.setMaterial1(m1);
			d.setMaterial2(m2);

			d.setCaffein_n((d.getCaffein_m1() + d.getCaffein_m2()));
			d.setMild_n((d.getMild_m1() + d.getMild_m2()));
			d.setSweet_n((d.getSweet_m1() + d.getSweet_m2()));

		} else if (productNo == 2) {//カフェオレ
			int m1 = 1;
			int m2 = 4;
			//それぞれの原材料の適切な値のsetを分岐している
			//原料1
			d = inPutMaterial1(m1);
			//原料2
			d = inPutMaterial2(m2);

			d.setName("カフェオレ");
			d.setProductNum(productNo);
			d.setMaterial1(m1);
			d.setMaterial2(m2);
			d.setCaffein_n((d.getCaffein_m1() + d.getCaffein_m2()));
			d.setMild_n((d.getMild_m1() + d.getMild_m2()));
			d.setSweet_n((d.getSweet_m1() + d.getSweet_m2()));

		} else if (productNo == 3) {//紅茶
			int m1 = 2;
			int m2 = 2;
			//それぞれの原材料の適切な値のsetを分岐している
			//原料1
			d = inPutMaterial1(m1);
			//原料2
			d = inPutMaterial2(m2);

			d.setName("紅茶");
			d.setProductNum(productNo);
			d.setMaterial1(m1);
			d.setMaterial2(m2);
			d.setCaffein_n((d.getCaffein_m1() + d.getCaffein_m2()));
			d.setMild_n((d.getMild_m1() + d.getMild_m2()));
			d.setSweet_n((d.getSweet_m1() + d.getSweet_m2()));

		} else if (productNo == 4) {//ミルクティー
			int m1 = 2;
			int m2 = 4;
			//それぞれの原材料の適切な値のsetを分岐している
			//原料1
			d = inPutMaterial1(m1);
			//原料2
			d = inPutMaterial2(m2);

			d.setName("ミルクティー");
			d.setProductNum(productNo);
			d.setMaterial1(m1);
			d.setMaterial2(m2);
			d.setCaffein_n((d.getCaffein_m1() + d.getCaffein_m2()));
			d.setMild_n((d.getMild_m1() + d.getMild_m2()));
			d.setSweet_n((d.getSweet_m1() + d.getSweet_m2()));

		} else if (productNo == 5) {//ホットチョコ
			int m1 = 3;
			int m2 = 3;
			//それぞれの原材料の適切な値のsetを分岐している
			//原料1
			d = inPutMaterial1(m1);
			//原料2
			d = inPutMaterial2(m2);

			d.setName("ホットチョコレート");
			d.setProductNum(productNo);
			d.setMaterial1(m1);
			d.setMaterial2(m2);
			d.setCaffein_n((d.getCaffein_m1() + d.getCaffein_m2()));
			d.setMild_n((d.getMild_m1() + d.getMild_m2()));
			d.setSweet_n((d.getSweet_m1() + d.getSweet_m2()));

		} else if (productNo == 6) {//ミルクココア

			int m1 = 3;
			int m2 = 4;
			//それぞれの原材料の適切な値のsetを分岐している
			//原料1
			d = inPutMaterial1(m1);
			//原料2
			d = inPutMaterial2(m2);

			d.setName("ミルクココア");
			d.setProductNum(productNo);
			d.setMaterial1(m1);
			d.setMaterial2(m2);
			d.setCaffein_n((d.getCaffein_m1() + d.getCaffein_m2()));
			d.setMild_n((d.getMild_m1() + d.getMild_m2()));
			d.setSweet_n((d.getSweet_m1() + d.getSweet_m2()));

		} else if (productNo == 7) {//ホットミルク
			int m1 = 4;
			int m2 = 4;
			//それぞれの原材料の適切な値のsetを分岐している
			//原料1
			d = inPutMaterial1(m1);
			//原料2
			d = inPutMaterial2(m2);

			d.setName("ホットミルク");
			d.setProductNum(productNo);
			d.setMaterial1(m1);
			d.setMaterial2(m2);
			d.setCaffein_n((d.getCaffein_m1() + d.getCaffein_m2()));
			d.setMild_n((d.getMild_m1() + d.getMild_m2()));
			d.setSweet_n((d.getSweet_m1() + d.getSweet_m2()));
		}

		d.setHowToJudge(HowToJudge);

		//値の確認用
//		System.out.println(d.getName());
//		System.out.println("メニュー番号1：" + d.getProductNum());
//		System.out.println("原料番号1：" + d.getMaterial1());
//		System.out.println("原料番号2：" + d.getMaterial2());
//		System.out.println("カフェイン1：" + d.getCaffein_m1());
//		System.out.println("カフェイン2：" + d.getCaffein_m2());
//		System.out.println("カフェイン合計：" + d.getCaffein_n());
//		System.out.println("まろやか1：" + d.getMild_m1());
//		System.out.println("まろやか2：" + d.getMild_m2());
//		System.out.println("まろやか合計：" + d.getMild_n());
//		System.out.println("甘さ1：" + d.getSweet_m1());
//		System.out.println("甘さ2：" + d.getSweet_m2());
//		System.out.println("甘さ合計：" + d.getSweet_n());
//		System.out.println("判定方法：" + d.getHowToJudge());
		return d;
	}

	public Drink inPutOrder(int howToJudege) {
		Drink order=new Drink(howToJudege);

		return order;
	}

}
