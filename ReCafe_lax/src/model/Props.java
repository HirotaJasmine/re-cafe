package model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Props {//

	public void captionSpeed(String s, int second) {//文字送りの為のメソッド

		String[] t = s.split("");

		for (String u : t) {
			second = 20;//テスト用の代入
			//second = second/3;
			try {
//				Thread.sleep(second);//１文字ずつ出力する間隔を調整
				Thread.sleep(0);//１文字ずつ出力する間隔を調整
				System.out.print(u);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		System.out.println();
	}

	public void captionSpeed(String s) {//文字送りの為のメソッド

		String[] t = s.split("");

		for (String u : t) {
			//						second=0;//テスト用の代入
			try {
				//								Thread.sleep(150/3);//１文字ずつ出力する間隔を調整
				Thread.sleep(0);//１文字ずつ出力する間隔を調整
//				Thread.sleep(20);//１文字ずつ出力する間隔を調整
				System.out.print(u);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		System.out.println();
	}

	public void ensureMenu(int input, int cnt) {
		if (input >= 0 && input <= 4) {
			System.out.println("適正な数字");
		} else {
			System.out.println("不適切な数字");
		}
	}

	public boolean ensureMaterial(int material1, int material2) {

		if (material1 == 1) {
			switch (material2) {
			case 1:
			case 4:
				return true;

			case 2:
			case 3:
				return false;

			}
		} else if (material1 == 2) {
			switch (material2) {
			case 2:
			case 4:
				return true;

			case 1:
			case 3:
				return false;

			}
		} else if (material1 == 3) {
			switch (material2) {
			case 3:
			case 4:
				return true;

			case 1:
			case 2:
				return false;

			}
		} else if (material1 == 4) {

			switch (material2) {
			case 1:
			case 2:
			case 3:
			case 4:
				return true;
			}
		}
		return false;
	}

	public void line() {
		System.out.println("◆--------------------------------------◆");
	}

	public void line(int i) {

		System.out.print("◆");
		for (int j = 0; j < i; j++) {
			System.out.print("=");
		}
		System.out.print("◆");
		System.out.println();
	}

	public void line_equal() {
		System.out.println("〇======================================〇");
	}

	public void line_equal(int i) {

		System.out.print("〇");
		for (int j = 0; j < i; j++) {
			System.out.print("=");
		}
		System.out.print("〇");
		System.out.println();
	}

	public void line_flower() {
		System.out.println("〇*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-〇");
	}

	public void line_flower(int i) {

		System.out.print("〇");
		for (int j = 0; j < i; j++) {
			System.out.print("*-");
		}
		System.out.print("〇");
		System.out.println();
	}

	public void charaTalk(String name, String talk) {
		Props p = new Props();
		System.out.print(name + "「");
		p.captionSpeed(talk + "」");
		p.captionSpeed("");
	}

	public void charaTalk(String name, String talk, int second) {
		Props p = new Props();
		System.out.print(name + "「");
		p.captionSpeed(talk + "」", second);
		p.captionSpeed("");
	}

	public void charaThink(String name, String talk) {
		Props p = new Props();
		System.out.print(name + "（");
		p.captionSpeed(talk + "）");
		p.captionSpeed("");
	}

	public void lineFeed(int i) {
		for (int j = 0; j < i; j++) {
			captionSpeed("");
		}
	}

	public void lineFeed() {
		for (int j = 0; j < 5; j++) {
			captionSpeed("");
		}
	}

	public void selectMode() {
		Props p = new Props();
		Story s = new Story();
		StoryPlot s_p = new StoryPlot();
		int mode = 0;
		int cnt = 0;

		p.line();
		p.captionSpeed("モードを選んで下さい。");

		System.out.println("◇１：DEMO");
		System.out.println("◇２：RANDOM");
		System.out.println("◇■：MAIN_STORY...TO BE CONTINUED");

		p.line();

		do {
			try {
				Scanner scan = new Scanner(System.in);
				mode = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("数字を入力してください。");
			}
			if (!(mode > 0) || !(mode < 3)) {
				System.out.println("１か２を入力してください。");
			}
		} while (!(mode > 0) || !(mode < 3));

		switch (mode) {
		case 1:
			s_p.storyPlot();
			break;

		case 2:
			do {
				try {
					Scanner scan = new Scanner(System.in);
					p.captionSpeed("【入力】何回やりますか？：１～３０回できます！");
					cnt = scan.nextInt();
					if (!(cnt > 0) || !(cnt < 31)) {
						System.out.println("※１～３０の数字を入力してください。");
					}
				} catch (InputMismatchException e) {
					System.out.println("数字を入力してください。");
				}
			} while (!(cnt > 0) || !(cnt < 31));

			s.orderRandom(cnt);
			break;
		}

	}

	public void ringBell() {
		Props p = new Props();
		p.lineFeed(1);
		p.captionSpeed("...カランコロン");
		p.lineFeed(1);
	}

	public void resultSheet(ScoreSheet ss) {
		Props p = new Props();

		//		System.out.println("◆◆◆値受け取りチェック：リザルトシート◆◆◆");
		//		System.out.print("ストーリー：");
		//		System.out.println(ss.getTotalScore());
		//		System.out.print("サーブ回数：");
		//		System.out.println(ss.getServeCnt());
		//		System.out.print("サラ：");
		//		System.out.println(ss.getSaraPoint());
		//		System.out.print("ヴォルフ：");
		//		System.out.println(ss.getVolfPoint());
		//		System.out.print("ルチア：");
		//		System.out.println(ss.getRuchiaPoint());
		//		System.out.print("マゼラン：");
		//		System.out.println(ss.getMagellanPoint());

		p.line_equal();
		p.captionSpeed("今回の成績", 250);
		p.captionSpeed("");
		System.out.print("サーブ回数：");
		p.captionSpeed(ss.getServeCnt() + "回", 250);

		System.out.print("サーブ成績：");

		if (ss.getScore() >= (ss.getServeCnt() * 2)) {
			System.out.println("パーフェクト");
		} else if ((ss.getScore() < (ss.getServeCnt() * 2))
				|| (ss.getScore() > ((ss.getServeCnt() / 2) * 2 + (ss.getServeCnt() / 2)))) {
			System.out.println("グレイト");
		} else if ((ss.getScore() <= ((ss.getServeCnt() / 2) * 2 + (ss.getServeCnt() / 2)))
				|| (ss.getScore() >= ss.getServeCnt())) {
			System.out.println("グッド");
		} else if ((ss.getScore() < ss.getServeCnt()) || (ss.getScore() == 0)) {
			System.out.println("まずまず");
		} else if ((ss.getScore() < 0) || (ss.getScore() > (-1 * ss.getServeCnt()))) {
			System.out.println("どうしてこうなった");
		} else if (ss.getScore() <= -1 * ss.getServeCnt()) {
			System.out.println("かなり、だめ。");
		}

	}

	//使いたい返値を考えたらまた新しいBeansになってしまう、、、、保留。
	//	public void scorePoint(Character c,int totalScore,int judge) {
	//		Verb v=new Verb();
	//
	//		int score=0;
	//
	//		switch(judge) {
	//		case 0:
	//			System.out.println("◆◆◆◆Props.scprePoint()◆◆◆◆");
	//			break;
	//		case 1:
	//			score=v.orderCaffeinMany();
	//			break;
	//		case 2:
	//			score=v.orderCaffeinLess();
	//			break;
	//		case 3:
	//			score=v.orderCaffeinNothing();
	//			break;
	//		case 4:
	//			score=v.orderSweetMany();
	//			break;
	//		case 5:
	//			score=v.orderSweetLess();
	//			break;
	//		case 6:
	//			score=v.orderMildMany();
	//			break;
	//		}
	//
	//		c.setEmotionPoint(c.getEmotionPoint()+score);
	//		totalScore = totalScore + score;
	//
	//	}
	//	public void scorePoint(Character c,int totalScore,int judge,int order) {
	//		Verb v=new Verb();
	//
	//		int score=0;
	//
	//		if(judge==0) {
	//			score=v.orderSame(order);
	//			}else {
	//				System.out.println("◆◆◆◆Props.scprePoint()◆◆◆◆\nJudgeは0あるべき");
	//			}
	//
	//
	//
	//		c.setEmotionPoint(c.getEmotionPoint()+score);
	//		totalScore = totalScore + score;
	//
	//	}

}
