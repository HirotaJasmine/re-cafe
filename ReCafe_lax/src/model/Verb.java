package model;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 	ドリンクの提供など、動詞にあたる部分
 *	 @author Jasmine
 *	製作日：2022/11/15
 */
public class Verb {
	Menu m = new Menu();
	Props p = new Props();
	Drink d = new Drink();
	boolean judgeM;//マテリアル1の入力の判定
	boolean judgeM2;//マテリアル2の入力・選択肢の判定
	boolean judgeP;//プロダクト-ドリンクの調理結果が完成かどうか判定する。

	public Drink doServe() {
		Scanner scan = new Scanner(System.in);

		p.line();
		p.captionSpeed("【ドリンクを調理します。】");
		int menu1 = 0;
		int menu2 = 0;

		do {
			m.firstMaterial(0);
			menu1 = 0;
			try {
				menu1 = scan.nextInt();
				judgeM = m.firstMaterial(menu1);
			} catch (InputMismatchException e) {
				System.out.println("数字を入力してください。");
			}
		} while (!(judgeM));
		do {
			try {

				do {
					menu2 = scan.nextInt();
					judgeM2 = p.ensureMaterial(menu1, menu2);//入力された値がメニュー通り選べているか判定。
					if (!(judgeM2)) {
						System.out.println("※表示されている数字で入力してください※");
					}
				} while (!(judgeM2));

				d = m.product(menu1, menu2);
				judgeP = d.isJudgeServe();
			} catch (InputMismatchException e) {
				System.out.println("数字を入力してください。");
			}

		} while (!(judgeP));
		return d;
	}

	public int orderSame(int orderNo) {//1～7のみ ユーザが使う場面ではないのでバリデーションを省く
		Drink order = new Drink();
		Drink serve = new Drink();
		Verb v = new Verb();
		int point;

		order = m.inPutOrder(orderNo, 0);
		serve = v.doServe();

		point = v.serviceResult(serve.getProductNum(), order.getProductNum(), order.getHowToJudge());

		return point;
	}

	public int orderCaffeinMany() {//1～7のみ ユーザが使う場面ではないのでバリデーションを省く
		Drink order = new Drink();
		Drink serve = new Drink();
		Verb v = new Verb();
		int point;

		order = m.inPutOrder(1);
		serve = v.doServe();

		point = v.serviceResult(serve.getProductNum(), order.getHowToJudge());

		return point;
	}

	public int orderCaffeinLess() {//1～7のみ ユーザが使う場面ではないのでバリデーションを省く
		Drink order = new Drink();
		Drink serve = new Drink();
		Verb v = new Verb();
		int point;

		order = m.inPutOrder(2);
		serve = v.doServe();

		point = v.serviceResult(serve.getProductNum(), order.getHowToJudge());

		return point;
	}

	public int orderCaffeinNothing() {//1～7のみ ユーザが使う場面ではないのでバリデーションを省く
		Drink order = new Drink();
		Drink serve = new Drink();
		Verb v = new Verb();
		int point;

		order = m.inPutOrder(3);
		serve = v.doServe();

		point = v.serviceResult(serve.getProductNum(), order.getHowToJudge());

		return point;
	}

	public int orderSweetMany() {
		Drink order = new Drink();
		Drink serve = new Drink();
		Verb v = new Verb();
		int point;

		order = m.inPutOrder(4);
		serve = v.doServe();

		point = v.serviceResult(serve.getProductNum(), order.getHowToJudge());

		return point;
	}

	public int orderSweetLess() {
		Drink order = new Drink();
		Drink serve = new Drink();
		Verb v = new Verb();
		int point;

		order = m.inPutOrder(5);
		serve = v.doServe();

		point = v.serviceResult(serve.getProductNum(), order.getHowToJudge());

		return point;

	}

	public int orderMildMany() {
		Drink order = new Drink();
		Drink serve = new Drink();
		Verb v = new Verb();
		int point;

		order = m.inPutOrder(6);
		serve = v.doServe();

		point = v.serviceResult(serve.getProductNum(), order.getHowToJudge());

		return point;

	}


	public int serviceResult(int order_num, int serve_num, int judge) {
		int story_point = 0;
		/**story_point
		 * 2：大成功
		 * 1：成功
		 * 0：初期値
		 * -1：失敗
		 */
		//		System.out.println("引数確認");
		//		System.out.println("order_num:"+order_num);
		//		System.out.println("serve_num:"+serve_num);
		//		System.out.println("judge:"+judge);
		//
		//		System.out.println("★★★ServiceResult：order");
		Menu menu_o = new Menu();
		Drink order = menu_o.inPutServe(order_num);
		order.setHowToJudge(judge);
		//		System.out.println("order:"+order.getProductNum());
		//		System.out.println("★★★ServiceResult：serve");

		Menu menu_s = new Menu();
		Drink serve = menu_s.inPutServe(serve_num);

		//		System.out.println("order:"+order.getProductNum());
		//		System.out.println("serve:"+serve.getProductNum());

		/**
		 * 0：同じものを提供できているか
		 * 1：カフェイン量の比較、カフェインが多いものがよい
		 * 2：カフェイン量の比較、カフェインの少ないものがよい
		 * 3：カフェイン量の比較、カフェインがないものがよい
		 * 4：甘さの比較、甘いものが良い
		 * 5：甘さの比較、甘くないものが良い
		 */

		//		System.out.println("\n〇〇〇判定確認　atMenu");
		//		System.out.println(order.getHowToJudge());
		//		System.out.println();
		//		System.out.println("\n判定前の値確認");
		//		System.out.println("order:"+order.getProductNum());
		//		System.out.println("serve:"+serve.getProductNum());

		if (order.getHowToJudge() == 0) {

			//			System.out.println("判定方法：" + 0);
			//0：同じものを提供できているか
			if (order.getProductNum() == serve.getProductNum()) {
				//				System.out.println("order:"+order.getProductNum());
				//				System.out.println("serve:"+serve.getProductNum());

				//				System.out.println("注文通りに提供できました。");
				story_point = 2;
			} else {
				//				System.out.println("注文通りの提供ができませんでした。");
				story_point = -1;
			}
		} else if (order.getHowToJudge() == 1) {

			//			System.out.println("判定方法：" + 1);
			//			1：カフェイン量の比較、カフェインが多いものがよい
			if (serve.getCaffein_n() == 4) {//カフェイン値が4
				//				System.out.println("注文通りのカフェイン量を提供できた。：4");
				story_point = 2;
			} else if (serve.getCaffein_n() < 4 || serve.getCaffein_n() > 1) {//カフェイン値が2,3
				//				System.out.println("注文に近いカフェイン量を提供できた。：2，3");
				story_point = 1;
			} else if (serve.getCaffein_n() <= 1) {//カフェイン値が0,1
				//				System.out.println("注文通りのカフェイン量を提供できなかった。：0，1");
				story_point = -1;
			}

		} else if (order.getHowToJudge() == 2) {

			//			System.out.println("判定方法：" + 2);
			//			2：カフェイン量の比較、カフェインの少ないものがよい
			if (serve.getCaffein_n() < 2) {//カフェイン値が0,1
				//				System.out.println("注文通りのカフェイン量を提供できた。：0,1");
				story_point = 2;
			} else if (serve.getCaffein_n() < 4 || serve.getCaffein_n() > 1) {//カフェイン値が2,3
				//				System.out.println("注文に近いカフェイン量を提供できた。：2，3");
				story_point = 1;
			} else if (serve.getCaffein_n() == 4) {//カフェイン値が4
				//				System.out.println("注文通りのカフェイン量を提供できなかった。：4");
				story_point = -1;
			}

		} else if (order.getHowToJudge() == 3) {
			//			System.out.println("判定方法：" + 3);
			//			3：カフェイン量の比較、カフェインがないものがよい
			if (serve.getCaffein_n() == 0) {//カフェイン値が0
				//				System.out.println("注文通りのカフェイン量を提供できた。：0");
				story_point = 2;
			} else if (serve.getCaffein_n() > 0) {//カフェイン値が1,2,3,4
				//				System.out.println("注文通りのカフェイン量を提供できなかった。：1,2,3,4");
				story_point = -1;
			}

		} else if (order.getHowToJudge() == 4) {
			//			System.out.println("判定方法：" + 4);
			//			4：甘さの比較、甘いものが良い
			if (serve.getSweet_n() == 4) {//甘さ値が4
				//				System.out.println("注文通りの甘さを提供できた。：4");
				story_point = 2;
			} else if (serve.getSweet_n() < 4 || serve.getSweet_n() > 1) {//甘さ値が2,3
				//				System.out.println("注文に近い甘さを提供できた。：2，3");
				story_point = 1;
			} else if (serve.getSweet_n() < 2) {//甘さ値が0,1
				//				System.out.println("注文通りの甘さを提供できなかった。：0，1");
				story_point = -1;
			}

		} else if (order.getHowToJudge() == 5) {
			//			System.out.println("判定方法：" + 5);
			//			5：甘さの比較、甘くないものが良い
			if (serve.getSweet_n() == 0) {//甘さ値が0
				//				System.out.println("注文通りの甘さを提供できた。：0");
				story_point = 2;
			} else if (serve.getSweet_n() > 0) {//甘さ値が1,2,3,4
				//				System.out.println("注文通りの甘さを提供できなかった。：1,2,3,4");
				story_point = -1;
			}

		} else if (order.getHowToJudge() == 6) {
			//			6：まろやかさの比較、まろやかなものが良い

			if (serve.getMild_n() == 4) {//まろやか値が4
				//				System.out.println("注文通りのまろやかさを提供できた。：4");
				story_point = 2;
			} else if (serve.getMild_n() < 4 || serve.getMild_n() > 0) {//まろやか値が1,2,3
				//				System.out.println("注文に近いまろやかさを提供できた。：1,2,3");
				story_point = 1;
			} else if (serve.getMild_n() == 0) {//まろやか値が0
				//				System.out.println("注文通りのまろやかさを提供できなかった。：0");
				story_point = -1;
			}

		} else {
			System.out.println("正しい参照にならなかった");
		}

//		if (story_point == 2) {
//			System.out.println("【大成功】" + story_point + "点");
//		} else if (story_point == 1) {
//			System.out.println("【成功】" + story_point + "点");
//		} else if (story_point == -1) {
//			System.out.println("【失敗】" + story_point + "点");
//		}

		return story_point;

	}

	public int serviceResult(int serve_num, int judge) {
		int story_point = 0;
		/**story_point
		 * 2：大成功
		 * 1：成功
		 * 0：初期値
		 * -1：失敗
		 */
		//		System.out.println("引数確認");
		//		System.out.println("order_num:"+order_num);
		//		System.out.println("serve_num:"+serve_num);
		//		System.out.println("judge:"+judge);
		//
		//		System.out.println("★★★ServiceResult：order");
		Drink order = new Drink();
		order.setHowToJudge(judge);
		//		System.out.println("order:"+order.getProductNum());
		//
		//		System.out.println("★★★ServiceResult：serve");

		Menu menu_s = new Menu();
		Drink serve = menu_s.inPutServe(serve_num);

		//		System.out.println("order:"+order.getProductNum());
		//		System.out.println("serve:"+serve.getProductNum());

		/**
		 * 0：同じものを提供できているか
		 * 1：カフェイン量の比較、カフェインが多いものがよい
		 * 2：カフェイン量の比較、カフェインの少ないものがよい
		 * 3：カフェイン量の比較、カフェインがないものがよい
		 * 4：甘さの比較、甘いものが良い
		 * 5：甘さの比較、甘くないものが良い
		 */

		//		System.out.println("\n〇〇〇判定確認　atMenu");
		//		System.out.println(order.getHowToJudge());
		//		System.out.println();
		//		System.out.println("\n判定前の値確認");
		//		System.out.println("order:"+order.getProductNum());
		//		System.out.println("serve:"+serve.getProductNum());

		if (order.getHowToJudge() == 1) {

//			System.out.println("判定方法：" + 1);
			//			1：カフェイン量の比較、カフェインが多いものがよい

//			System.out.print("★★★値チェック");
//			System.out.println(serve.getCaffein_n());

			switch (serve.getCaffein_n()) {
			case 4:
//				System.out.println("注文通りのカフェイン量を提供できた。：4");
				story_point = 2;
				return story_point;

			case 2:
			case 3:
//				System.out.println("注文に近いカフェイン量を提供できた。：2，3");
				story_point = 1;
				return story_point;

			case 1:
			case 0:
//				System.out.println("注文通りのカフェイン量を提供できなかった。：0，1");
				story_point = -1;
				return story_point;
			}

		} else if (order.getHowToJudge() == 2) {
//			System.out.print("★★★値チェック");
//			System.out.println(serve.getCaffein_n());

//			System.out.println("判定方法：" + 2);
			//			2：カフェイン量の比較、カフェインの少ないものがよい

			switch (serve.getCaffein_n()) {
			case 1:
			case 0:
//				System.out.println("注文通りのカフェイン量を提供できた。：0,1");
				story_point = 2;
				return story_point;

			case 2:
			case 3:
//				System.out.println("注文に近いカフェイン量を提供できた。：2，3");
				story_point = 1;
				return story_point;

			case 4:
//				System.out.println("注文通りのカフェイン量を提供できなかった。：4");
				story_point = -1;
				return story_point;
			}

		} else if (order.getHowToJudge() == 3) {
//			System.out.print("★★★値チェック");
//			System.out.println(serve.getCaffein_n());

//			System.out.println("判定方法：" + 3);
			//			3：カフェイン量の比較、カフェインがないものがよい
			switch (serve.getCaffein_n()) {
			case 0:
//				System.out.println("注文通りのカフェイン量を提供できた。：0");
				story_point = 2;
				return story_point;

			case 1:
			case 2:
			case 3:
			case 4:
//				System.out.println("注文通りのカフェイン量を提供できなかった。：1,2,3,4");
				story_point = -1;
				return story_point;
			}

		} else if (order.getHowToJudge() == 4) {
//			System.out.print("★★★値チェック");
//			System.out.println(serve.getSweet_n());

//			System.out.println("判定方法：" + 4);
			//			4：甘さの比較、甘いものが良い
			switch (serve.getSweet_n()) {
			case 4:
//				System.out.println("注文通りの甘さを提供できた。：4");
				story_point = 2;
				return story_point;

			case 2:
			case 3:
//				System.out.println("注文に近い甘さを提供できた。：2，3");
				story_point = 1;
				return story_point;

			case 0:
			case 1:
//				System.out.println("注文通りの甘さを提供できなかった。：0，1");
				story_point = -1;
				return story_point;
			}

		} else if (order.getHowToJudge() == 5) {
//			System.out.print("★★★値チェック");
//			System.out.println(serve.getSweet_n());

//			System.out.println("判定方法：" + 5);
			//			5：甘さの比較、甘くないものが良い
			switch (serve.getSweet_n()) {
			case 0:
//				System.out.println("注文通りの甘さを提供できた。：0");
				story_point = 2;
				return story_point;

			case 1:
			case 2:
			case 3:
			case 4:
//				System.out.println("注文通りの甘さを提供できなかった。：1,2,3,4");

				story_point = -1;
				return story_point;
			}

		} else if (order.getHowToJudge() == 6) {
//			System.out.print("★★★値チェック");
//			System.out.println(serve.getMild_n());

//			System.out.println("判定方法：" + 6);
			//			5：まろやかさの比較、まろやかなものが良い
			switch (serve.getMild_n()) {
			case 4:
//				System.out.println("注文通りのまろやかさを提供できた。：4");
				story_point = 2;
				return story_point;

			case 1:
			case 2:
			case 3:
//				System.out.println("注文に近いまろやかさを提供できた。：1,2,3");
				story_point = 1;
				return story_point;

			case 0:
//				System.out.println("注文通りのまろやかさを提供できなかった。：0");

				story_point = -1;
				return story_point;
			}

		} else {
			System.out.println("正しい参照にならなかった");
		}

		return story_point;

	}

}
