package model;

import java.util.Random;

public class Story {//ストーリー
	Character luca = new Character(1, "ルカ");
	Character boss = new Character(2, "ボス");
	Character sara = new Character(3, "サラ");
	Character volf = new Character(4, "ヴォルフ");
	Character ruchia = new Character(5, "ルチア");
	Character magellan = new Character(6, "マゼラン");

	//	int switchTest=0;//通常
	int switchTest = 1;//テスト用

	//	public int test(int order) {
	//		Props p = new Props();
	//		Menu m = new Menu();
	//		Verb v = new Verb();
	//		Drink d = new Drink();
	//		Drink ord = new Drink();
	//		int sum;
	//		//int order=1;
	//
	//		//		System.out.print("アンナ「");
	//
	//		//		p.captionSpeed(m.showMenu(order) + "をいただけるかしら。」");
	//
	//		//		v.orderSame(order);
	//		//		d = m.inPutServe(order);
	//		p.charaTalk("アンナ", m.showMenu(order) + "をひとつ");
	//		int a = v.orderSame(order);
	//		System.out.println(a + "点");
	//
	//		p.charaTalk("アンナ", "カフェインたっぷりのドリンクを");
	//		int b = v.orderCaffeinMany();//オーダー方法によってインスタンスにどれくらいの情報が必要かが変わる。
	//		System.out.println(b + "点");
	//
	//		p.charaTalk("アンナ", "カフェインの少ないドリンクを");
	//		int c = v.orderCaffeinLess();//オーダー方法によってインスタンスにどれくらいの情報が必要かが変わる。
	//		System.out.println(c + "点");
	//
	//		p.charaTalk("アンナ", "カフェインのないドリンクを");
	//		int e = v.orderCaffeinNothing();//オーダー方法によってインスタンスにどれくらいの情報が必要かが変わる。
	//		System.out.println(e + "点");
	//
	//		p.charaTalk("アンナ", "とびっきり甘いドリンクを");
	//		int f = v.orderSweetMany();//オーダー方法によってインスタンスにどれくらいの情報が必要かが変わる。
	//		System.out.println(f + "点");
	//
	//		p.charaTalk("アンナ", "甘くないドリンクを");
	//		int g = v.orderSweetLess();//オーダー方法によってインスタンスにどれくらいの情報が必要かが変わる。
	//		System.out.println(g + "点");
	//
	//		p.charaTalk("アンナ", "ホッとするドリンクを");
	//		int h = v.orderMildMany();//オーダー方法によってインスタンスにどれくらいの情報が必要かが変わる。
	//		System.out.println(h + "点");
	//
	//		sum = (a + b + c + e + f + g + h);
	//
	//		return sum;
	//	}

	public int tutorial() {

		Props p = new Props();
		Menu m = new Menu();
		Verb v = new Verb();
		Drink order = new Drink();
		Drink serve = new Drink();
		Random rdm = new Random();
		int result;
		int order_num;

		//			System.out.print("？？？（");
		//			p.captionSpeed("うーん、今日も暇だといいなぁ...\n　　　　なんて、何を考えているのルカ）");

		if (switchTest == 0) {

			p.charaThink("？？？", "うーん、今日も暇だといいなぁ...\n　　　　なんて、何を考えているのルカ。");

			p.charaThink(luca.getName(), "それにしてもお金がない...、とりあえず今月は持つとして...");

			p.captionSpeed("");

			p.charaTalk("？？？", "やあ、" + luca.getName());

			p.charaTalk(luca.getName(), "...あ、" + boss.getName() + "。おはようございます。");

			p.charaTalk(boss.getName(), "ぼーっとしてどうかしたのかい？");

			p.charaTalk(luca.getName(), "...ちょっと、考え事していました。\n　　　開店前にすみません。");

			p.charaTalk(boss.getName(), "悩み事があるなら聞くけど");

			p.charaTalk(luca.getName(), "いいえ、大丈夫です。\n　　　準備はもうできたので何か手伝いますか？");

			p.charaTalk(boss.getName(), "うーん、こっちも大丈夫かな。\n　　　ただ、少し心配だな...。\n　　　そうだ、開店前の肩慣らしに付き合ってもらおうかな。");

			p.charaTalk(luca.getName(), "えぇっ...。");

			p.charaTalk(boss.getName(), "なにか作れない事情でもあるのかい？");

			p.charaTalk(luca.getName(), "大丈夫です。");

			p.charaTalk(boss.getName(), "ならばよし！");

			p.charaThink(luca.getName(), "めんどくさい...なんて、言えないけど。");

			p.charaTalk(luca.getName(), "それではご注文はいかがいたしましょうか？");
		} else {
			System.out.println("【チュートリアル】");
			p.captionSpeed("材料を二つ選んでドリンクを作ろう！");
		}

		do {

			order_num = rdm.nextInt(6) + 1;
			p.charaTalk(boss.getName(), "よし、それじゃあ、" + m.showMenu(order_num) + "をいただけるかな？」");

			m.inPutOrder(order_num, 0);
			order = m.inPutServe(order_num);

			serve = v.doServe();

			result = v.serviceResult(order.getProductNum(), serve.getProductNum(), order.getHowToJudge());

			if (result == 2) {
				System.out.println();
				p.charaTalk(boss.getName(), "上出来じゃないか！");

			} else {
				System.out.println();
				p.charaTalk(boss.getName(), "うーん...、違うじゃないか。\n　　　もう一度作ってくれるかな？");
			}
		} while (result == -1);

		if (switchTest == 0) {
			p.charaTalk(boss.getName(), m.showMenu(order_num) + "...");
			p.charaTalk(luca.getName(), "どうかしましたか？");
			p.charaTalk(boss.getName(), "やっぱり" + luca.getName() + "の作るドリンクはおいしい。");
			p.charaTalk(luca.getName(), "そういっていただけるのは嬉しいです。\n　　　でも、どうして急に？");
			p.charaTalk(boss.getName(), "特に意味はないさ。\n　　　さて、今日も忙しいことを祈って開店しようじゃないか！");
			p.charaTalk(luca.getName(), "そんな時間ですね、開けましょう。");
			p.charaThink(luca.getName(), "本当は忙しくなるなんて祈りたくないけど。");
		}

		return result;
	}

	public int orderRandom(int i) {
		Props p = new Props();
		Menu m = new Menu();
		Verb v = new Verb();
		Random rdm = new Random();
		Drink order = new Drink();
		Drink serve = new Drink();
		int order_num;
		int point = 0;
		int sum = 0;

		p.line();
		p.captionSpeed("【ランダムモード】");
		p.captionSpeed("オーダーに対して正しくサーブしよう！");

		p.captionSpeed("");

		for (int j = 0; j < i; j++) {

			p.line_equal();
			p.captionSpeed(j + 1 + "回目");
			p.line_equal(10);

			int judge_num = rdm.nextInt(7);//ランダムで判定方法を決める。
			//			judge_num = 0;//テスト用

			if (judge_num == 0) {
				Random rdm2 = new Random();//オーダーするドリンクをランダムで決める。
				order_num = rdm2.nextInt(6) + 1;
				m.inPutOrder(order_num, 0);
				order = m.inPutServe(order_num);

				System.out.println("【オーダー】");
				p.captionSpeed(order.getName() + "");

				serve = v.doServe();
				point = v.serviceResult(order.getProductNum(), serve.getProductNum(), order.getHowToJudge());

				//				point=v.orderSame(order_num);

			} else if (judge_num == 1) {
				System.out.println("【オーダー】");
				p.captionSpeed("カフェインがたっぷり入ったドリンク");

				serve = v.doServe();
				point = v.serviceResult(serve.getProductNum(), 1);
			} else if (judge_num == 2) {

				System.out.println("【オーダー】");
				p.captionSpeed("カフェイン少なめのドリンク");

				serve = v.doServe();
				point = v.serviceResult(serve.getProductNum(), 2);
			} else if (judge_num == 3) {

				System.out.println("【オーダー】");
				p.captionSpeed("カフェインがないドリンク");

				serve = v.doServe();
				point = v.serviceResult(serve.getProductNum(), 3);
			} else if (judge_num == 4) {

				System.out.println("【オーダー】");
				p.captionSpeed("とっても甘いドリンク");

				serve = v.doServe();
				point = v.serviceResult(serve.getProductNum(), 4);
			} else if (judge_num == 5) {

				System.out.println("【オーダー】");
				p.captionSpeed("まったく甘くないドリンク");

				serve = v.doServe();
				point = v.serviceResult(serve.getProductNum(), 5);
			} else if (judge_num == 6) {

				System.out.println("【オーダー】");
				p.captionSpeed("まろやかなホッとするドリンク");

				serve = v.doServe();
				point = v.serviceResult(serve.getProductNum(), 6);
			}

			sum = sum + point;
			System.out.println("現在の点数：" + sum + "点");

		}

		p.line_equal();
		System.out.println("★リザルト★");
		p.line_equal();
		p.captionSpeed("");
		if (sum >= (i * 2)) {
			System.out.println("パーフェクト");
		} else if (sum < (i * 2) || sum > ((i / 2) * 2 + (i / 2))) {
			System.out.println("グレイト");
		} else if (sum <= ((i / 2) * 2 + (i / 2)) || sum >= i) {
			System.out.println("グッド");
		} else if (sum < i || sum == 0) {
			System.out.println("まずまず");
		} else if (sum < 0 || sum > (-1 * i)) {
			System.out.println("どうしてこうなった");
		} else if (sum <= -1 * i) {
			System.out.println("かなり、だめ。");
		}

		System.out.println(i * 2 + "点中" + sum + "点");
		p.captionSpeed("");
		p.line_equal();
		return sum;

	}

	public void opening() {
		Props p = new Props();

		p.lineFeed(2);

		p.captionSpeed("Loading...");

		p.lineFeed(3);

		p.captionSpeed("Please waiting...");

		p.lineFeed(3);

		p.captionSpeed("He11o Welcome to Cafe Lax.");

		p.lineFeed(3);

		p.captionSpeed("How do you do?");

		p.lineFeed(2);

		p.captionSpeed("Let's starting a day.");
		p.captionSpeed("I hope you have a wonderful day.");

		p.lineFeed(3);

		p.line_equal();
		p.lineFeed(1);

		p.captionSpeed("				Re:Cafe Lax");
		//		p.captionSpeed("ようこそ、Cafe Laxへ" + "\nあなたはこのカフェのマスターです。");

		p.lineFeed(1);
		p.line_equal();

		p.lineFeed();
	}

	public ScoreSheet firstDay() {
		Props p = new Props();
		Menu m = new Menu();
		Verb v = new Verb();
		ScoreSheet ss = new ScoreSheet();
		int order1 = 1;
		int order2 = 1;
		int order3 = 3;
		int order4 = 2;
		int order5 = 5;
		int order6 = 2;
		String order7 = "カフェインがたっぷり";

		int score = 0;
		int totalScore = 0;
		int serveCnt = 0;

		p.line_equal();
		p.lineFeed(1);
		p.captionSpeed("　　　　　　　　　開店", 50);
		p.captionSpeed("　　　　　　　　　　　　１日目", 50);

		p.lineFeed(1);
		p.line_equal();

		p.charaTalk("？？？", "やっほ＝");
		p.charaThink(luca.getName(), "一発目からにぎやかなやつだ...。");
		p.charaTalk(luca.getName(), "やあ、サラ。いらっしゃいませ。");
		p.charaTalk(sara.getName(), "ご機嫌どうも！");


		if (switchTest == 0) {

			p.charaTalk(luca.getName(), "どうしたの");
			p.charaTalk(sara.getName(), "どうしたのって...挨拶だよ");
			p.charaTalk(luca.getName(), "にしても上機嫌、何かあった？");
			p.charaTalk(sara.getName(), "それがね...おっと注文忘れてた");
			p.charaTalk(luca.getName(), "そうだった。ご注文はいかがいたしましょうか？");
			p.charaTalk(sara.getName(), "それじゃあ、" + m.showMenu(order1) + "で！");
			p.charaTalk(luca.getName(), "かしこまりました。それでは" + m.showMenu(order1) + "を一杯");
		} else {
			p.charaTalk(luca.getName(), "ご注文はいかがいたしましょうか？");
			p.charaTalk(sara.getName(), "それじゃあ、" + m.showMenu(order1) + "で！");
			p.charaTalk(luca.getName(), "かしこまりました。それでは" + m.showMenu(order1) + "を一杯");
			p.captionSpeed("");


			System.out.println("【注文】");
			p.captionSpeed("◆" + sara.getName() + "：" + m.showMenu(order1));
		}

		score = v.orderSame(order1);
		serveCnt++;
		sara.setEmotionPoint(sara.getEmotionPoint() + score);
		totalScore = totalScore + score;

		switch (score) {
		case 2:
			p.charaTalk(sara.getName(), "すっごくおいしい！やっぱり" + luca.getName() + "のドリンクは最高だよ。");
			if (switchTest == 0) {
				p.charaTalk(luca.getName(), "どういたしまして。喜んでもらえて嬉しいよ。	\n　　　そういえば何があったのさ？");
			} else {
				p.charaTalk(luca.getName(), "どういたしまして。喜んでもらえて嬉しいよ。");
			}
			break;
		case -1:
			p.charaTalk(sara.getName(), "..." + luca.getName() + "、大丈夫？\n　　　疲れてる？");
			p.charaTalk(luca.getName(), "あ...申し訳ない。作り直すよ。");
			p.charaTalk(sara.getName(), "ううん、大丈夫よ。何が出てきたってあなたのドリンクは最高だもの。");
			p.charaTalk(luca.getName(), "そう言ってもらえると助かるよ。");
			if (switchTest == 0) {
				p.charaTalk(sara.getName(), "...そういえば、今日私が上機嫌だった理由だけどね。");
			}
			break;
		}

		if (switchTest == 0) {
			p.charaTalk(sara.getName(), "私の仕事、覚えてる？");
			p.charaTalk(luca.getName(), "もちろん！たしか、どこかの大学の助手さんだっけ？");
			p.charaTalk(sara.getName(), "そう！その助手さんが先生になれるかもしれないの！");
			p.charaTalk(luca.getName(), "助手さんって先生じゃないの？");
			p.charaTalk(sara.getName(), "うーん、学生からは先生って呼ばれるけど先生ではないのよね。あくまで助手。");
			p.charaTalk(luca.getName(), "そうだったんだ、じゃあどうしたら先生になれるんだい？");
			p.charaTalk(sara.getName(), "一言で言ったら実績を積んで認められる必要があるの。\n　　　それで、私は実績を見てもらえるチャンスに恵まれたの！");
			p.charaTalk(luca.getName(), "じゃあこのチャンスを掴んだら教授になれるってこと？");
			p.charaTalk(sara.getName(), "残念、先生には色々と段階があって、今回は助教。\n　　　大抵次に講師に進んで、准教授、教授...色々あるの。");
			p.charaTalk(luca.getName(), "そうか、夢への一歩ってことだね。がんばれ！");
			p.charaTalk(sara.getName(), "ありがとう！...あ、ごめん。ちょっと急ぎのメール");
			p.charaTalk(luca.getName(), "いいよ、落ち着いて読んで。");

			p.ringBell();

			p.charaTalk("？？？", "ごめんください。");
			p.charaTalk("？？？", "...こんにちは");

			p.charaTalk(luca.getName(), "いらっしゃいませ。カウンターへどうぞ。");
			p.charaTalk("？？？", "えぇ、ありがとう。" + ruchia.getName() + "、カウンター席だ。", 200);
			p.charaTalk(ruchia.getName(), "ちゃんと聞こえてるよ、" + volf.getName() + "おじさん。\n　　　わからなかったらちゃんと聞くから、みんなと同じ速さでいいよ。");
			p.charaTalk(volf.getName(), "あぁ、すまない。それじゃあ言葉に甘えよう。");

			p.charaTalk(luca.getName(), "ようこそ、Cafe Laxへ、ご注文はいかがいたしましょうか？");

			p.charaTalk(volf.getName(), "そうだな、それじゃあ" + m.showMenu(order2) + "にしようかな。");
			p.charaTalk(luca.getName(), "かしこまりました。そちらのお方は？");
			p.charaTalk(ruchia.getName(), "...考え中です。先におじさんの分を作っててください。", 180);
			p.charaTalk(volf.getName(), "申し訳ないが、先にお願いしてもいいかな？");

			p.charaTalk(luca.getName(), "えぇ、かしこまりました。それでは先に" + m.showMenu(order1) + "をお持ちいたします。");

		} else {
			p.ringBell();

			p.charaTalk("？？？", "ごめんください。");
			p.charaTalk("？？？", "...こんにちは");

			p.charaTalk(luca.getName(), "いらっしゃいませ。カウンターへどうぞ。");
			p.charaTalk("？？？", "えぇ、ありがとう。" + ruchia.getName() + "、カウンター席だ。", 200);
			p.charaTalk(ruchia.getName(),  volf.getName() + "おじさん、ありがとう",180);

			p.charaTalk(luca.getName(), "ようこそ、Cafe Laxへ、ご注文はいかがいたしましょうか？");

			p.charaTalk(volf.getName(), "そうだな、それじゃあ" + m.showMenu(order2) + "にしようかな。");
			p.charaTalk(luca.getName(), "かしこまりました。そちらのお方は？");
			p.charaTalk(ruchia.getName(), "...考え中です。先におじさんの分を作っててください。", 180);
			p.charaTalk(volf.getName(), "申し訳ないが、先にお願いしてもいいかな？");

			p.charaTalk(luca.getName(), "えぇ、かしこまりました。それでは先に" + m.showMenu(order1) + "をお持ちいたします。");
			p.captionSpeed("");

			System.out.println("【注文】");
			p.captionSpeed("◆" + volf.getName() + "：" + m.showMenu(order2));

		}

		score = v.orderSame(order2);
		serveCnt++;
		volf.setEmotionPoint(volf.getEmotionPoint() + score);
		totalScore = totalScore + score;

		switch (score) {
		case 2:
			p.charaTalk(volf.getName(), "おぉ、いい香りだ。ありがとう。");
			break;
		case -1:
			p.charaTalk(volf.getName(), "頼んだものとは違うが...");
			p.charaTalk(luca.getName(), "あ...大変申し訳ございません。");
			p.charaTalk(volf.getName(), "いや、まぁ飲み物に変わりはない。頂こう。");
			break;
		}

		if (switchTest == 0) {
			p.charaTalk(volf.getName(), ruchia.getName() + "、何にするか決めたかな？");
			p.charaTalk(ruchia.getName(), "うん、決めた。" + m.showMenu(order3) + "をお願いします。", 180);
			p.charaTalk(luca.getName(), "かしこまりました。すぐにお持ちいたします。");
		} else {
			p.charaTalk(ruchia.getName(), "うん、決めた。" + m.showMenu(order3) + "をお願いします。", 180);
			p.charaTalk(luca.getName(), "かしこまりました。すぐにお持ちいたします。");
			System.out.println("【注文】");
			p.captionSpeed("◆" + ruchia.getName() + "：" + m.showMenu(order3));
		}

		score = v.orderSame(order3);
		serveCnt++;
		ruchia.setEmotionPoint(ruchia.getEmotionPoint() + score);
		totalScore = totalScore + score;

		switch (score) {
		case 2:
			p.charaTalk(ruchia.getName(), "ありがとうございます。", 180);
			break;
		case -1:
			p.charaTalk(ruchia.getName(), "想像と違う...", 180);
			p.charaTalk(luca.getName(), "そんな...大変申し訳ございません。");
			p.charaTalk(ruchia.getName(), "ううん、おいしそうだからいただきます。", 180);
			break;
		}

		if (switchTest == 0) {
			p.charaTalk(ruchia.getName(), "...おいしい", 180);
			p.charaTalk(volf.getName(), "あぁ、おいしいな。\n　　　そういえば、そっちではどうだい？");
			p.charaTalk(ruchia.getName(), "うん、大丈夫...かな。でもやっぱり東アジアとこっちはだいぶ違うね。", 180);
			p.charaTalk(volf.getName(), "そうだな...、");
			p.charaTalk(sara.getName(), "そうだなぁ、" + m.showMenu(order4) + "で！");
		} else {
			System.out.println("【注文】");
			p.captionSpeed("◆" + sara.getName() + "：" + m.showMenu(order4));
		}

		score = v.orderSame(order4);
		serveCnt++;
		sara.setEmotionPoint(sara.getEmotionPoint() + score);
		totalScore = totalScore + score;

		switch (score) {
		case 2:
			p.charaTalk(sara.getName(), "ありがと");
			break;
		case -1:
			p.charaTalk(sara.getName(), "えっとぉ～");
			p.charaTalk(luca.getName(), "うっそ...、本当にごめんなさい。今から...");
			p.charaTalk(sara.getName(), "ううん、飲めるからいいの。にしても大丈夫？疲れてる？");
			break;
		}

		if (switchTest == 0) {
			p.charaTalk(ruchia.getName(), m.showMenu(order5) + "をください。", 180);
		} else {
			System.out.println("【注文】");
			p.captionSpeed("◆" + ruchia.getName() + "：" + m.showMenu(order5));
		}

		score = v.orderSame(order5);
		serveCnt++;
		ruchia.setEmotionPoint(ruchia.getEmotionPoint() + score);
		totalScore = totalScore + score;

		switch (score) {
		case 2:
			p.charaTalk(ruchia.getName(), "ありがとうすごくおいしい", 180);
			break;
		case -1:
			p.charaTalk(ruchia.getName(), "...うーんと、", 160);
			p.charaTalk(luca.getName(), "あぁ...、大変申し訳ございません。");
			p.charaTalk(ruchia.getName(), "いいえ、大丈夫です。あってます。");
			break;
		}

		if (switchTest == 0) {
			p.charaTalk(volf.getName(), m.showMenu(order6) + "をいただけるかな。");
		} else {
			System.out.println("【注文】");
			p.captionSpeed("◆" + volf.getName() + "：" + m.showMenu(order6));
		}

		score = v.orderSame(order6);
		serveCnt++;
		volf.setEmotionPoint(volf.getEmotionPoint() + score);
		totalScore = totalScore + score;

		switch (score) {
		case 2:
			p.charaTalk(volf.getName(), "うむ、ありがとう");
			break;
		case -1:
			p.charaTalk(volf.getName(), "これは...");
			p.charaTalk(luca.getName(), "あぁ...、大変申し訳ございません。");
			p.charaTalk(volf.getName(), "いや、大丈夫だ。誰にだって過ちはある。");
			p.charaTalk(luca.getName(), "ありがとうございます。");
			break;
		}

		p.charaTalk(volf.getName(), "それじゃあそろそろ帰らせてもらうよ");
		p.charaTalk(ruchia.getName(), "ありがとう、失礼します。",180);
		p.ringBell();

		if (switchTest == 0) {
			p.charaTalk(sara.getName(), "じゃあ、" + order7 + "なドリンクを！");
		} else {
			System.out.println("【注文】");
			p.captionSpeed("◆" + sara.getName() + "：" + order7 + "なドリンク");
		}

		score = v.orderCaffeinMany();
		serveCnt++;
		sara.setEmotionPoint(sara.getEmotionPoint() + score);
		totalScore = totalScore + score;

		switch (score) {
		case 2:
			p.charaTalk(sara.getName(), "ありがとー！うん、いい感じのカフェイン！");
			break;
		case 1:
			p.charaTalk(sara.getName(), "ありがと。うん、ちょっと物足りないけどおいしい。");

			break;
		case -1:
			p.charaTalk(sara.getName(), "うーん、ぬるい");
			p.charaTalk(luca.getName(), "ごめん、足りなかったね...。");
			p.charaTalk(sara.getName(), "まぁできたものはしょうがないね。");
			break;
		}

		ss.setTotalScore(totalScore);
		ss.setServeCnt(serveCnt);
		ss.setResult1day(totalScore);
		ss.setSaraPoint(sara.getEmotionPoint());
		ss.setVolfPoint(volf.getEmotionPoint());
		ss.setRuchiaPoint(ruchia.getEmotionPoint());

		return ss;

	}

	public ScoreSheet secondDay(ScoreSheet ss) {
		Props p = new Props();
		ScoreSheet ss2 = new ScoreSheet();
		Menu m = new Menu();
		Verb v = new Verb();

		//オーダーリスト
		int order1 = 7;
		int order2 = 4;
		int order3 = 1;
		int order4 = 5;
		String order5 = "とても甘い";
		String order6 = "カフェインたっぷり";
		String order7 = "落ち着くような";
		int order8 = 2;

		int score = 0;
		int totalScore = 0;
		int serveCnt = 0;

		p.line_equal();
		p.lineFeed(1);
		p.captionSpeed("　　　　　　　　　開店", 50);
		p.captionSpeed("　　　　　　　　　　　　２日目", 50);

		p.lineFeed(1);
		p.line_equal();

		p.ringBell();

		if (ss.getRuchiaPoint() > 3) {
			if (switchTest == 0) {
				p.charaTalk(luca.getName(), "いらっしゃいませ。");
				p.charaTalk(ruchia.getName(), "こんにちは", 180);
				p.charaTalk(luca.getName(), "やあ、こんにちは。おひとりですか？");
				p.charaTalk(ruchia.getName(), "うん...はい、昨日来たけど居心地よかったから...きました。", 180);
				p.charaTalk(luca.getName(), "そういってくれて嬉しいよ。ご注文はお決まりですか？");
				p.charaTalk(ruchia.getName(), m.showMenu(order1) + "をお願いします。", 180);
				p.charaTalk(luca.getName(), "かしこまりました。");
			} else {
				p.charaTalk(luca.getName(), "いらっしゃいませ。");
				p.charaTalk(ruchia.getName(), "こんにちは", 180);
				p.charaTalk(luca.getName(), "やあ、こんにちは。おひとりですか？");
				p.charaTalk(ruchia.getName(), "うん...はい、昨日来たけど居心地よかったから...きました。", 180);
				p.charaTalk(luca.getName(), "そういってくれて嬉しいよ。ご注文はお決まりですか？");
				p.charaTalk(ruchia.getName(), m.showMenu(order1) + "をお願いします。", 180);
				p.charaTalk(luca.getName(), "かしこまりました。");

				p.captionSpeed("");
				System.out.println("【注文】");
				p.captionSpeed("◆" + ruchia.getName() + "：" + m.showMenu(order1));

			}

			score = v.orderSame(order1);
			serveCnt++;
			ruchia.setEmotionPoint(ruchia.getEmotionPoint() + score);
			totalScore = totalScore + score;

			switch (score) {
			case 2:
				p.charaTalk(ruchia.getName(), "ありがとうございます。", 180);
				break;
			case -1:
				p.charaTalk(ruchia.getName(), "...うーんと、", 160);
				p.charaTalk(luca.getName(), "あぁ...、大変申し訳ございません。");
				p.charaTalk(ruchia.getName(), "えーと、大丈夫、あってます。");
				break;
			}

			p.ringBell();

			if (switchTest == 0) {
				p.charaTalk(luca.getName(), "いらっしゃいませ。");
				p.charaTalk(sara.getName(), "やっほー、ご機嫌よう！");
				p.charaTalk(luca.getName(), "やぁ、" + sara.getName());
				p.charaTalk(sara.getName(), "あれ？あなたのこと昨日も見かけたわ！");
				p.charaTalk(ruchia.getName(), "えーっと、ごきが...こんにちは。\n　　　わたし、" + ruchia.getName() + "です。", 180);
				p.charaTalk(sara.getName(), "あたし" + sara.getName() + "。よろしくね");
				p.charaTalk(luca.getName(), "私は" + luca.getName() + "です。よろしくお願いします。");
				p.charaTalk(ruchia.getName(), "こちらこそ、よろしく。会えてうれしいです。", 180);
				p.charaTalk(sara.getName(), "それじゃあ、" + m.showMenu(order2) + "を！");
			} else {
				p.charaTalk(luca.getName(), "いらっしゃいませ。");
				p.charaTalk(sara.getName(), "やっほー、ご機嫌よう！");
				p.charaTalk(luca.getName(), "やぁ、" + sara.getName());
				p.charaTalk(ruchia.getName(), "えーっと、...こんにちは。\n　　　わたし、" + ruchia.getName() + "です。", 180);
				p.charaTalk(sara.getName(), "よろしくね！それじゃあ、" + m.showMenu(order2) + "を！");

				p.captionSpeed("");
				System.out.println("【注文】");
				p.captionSpeed("◆" + sara.getName() + "：" + m.showMenu(order2));
			}

			score = v.orderSame(order2);
			serveCnt++;
			sara.setEmotionPoint(sara.getEmotionPoint() + score);
			totalScore = totalScore + score;

			switch (score) {
			case 2:
				p.charaTalk(sara.getName(), "ありがとう！最高だよ。");
				break;
			case -1:
				p.charaTalk(sara.getName(), "うん、あたしこれも好き。");
				p.charaTalk(luca.getName(), "いけない...、ごめんよ。");
				p.charaTalk(sara.getName(), "大丈夫、大丈夫。");
				break;
			}

			if (ruchia.getEmotionPoint() >= 2) {
				if (switchTest == 0) {
					p.charaTalk(ruchia.getName(), "私,違う国から来たんです。学校の長期休暇を使って。", 180);
					p.charaTalk(luca.getName(), "東アジアって言ってたね。");
					p.charaTalk(ruchia.getName(), "はい", 180);
					p.charaTalk(sara.getName(), "東アジアかぁ、行ったことないなぁ。");
					p.charaTalk(ruchia.getName(), "とてもいいところです。", 180);
					p.charaTalk(sara.getName(), "そうえいば、あなたの母国語はその国の言葉？");
					p.charaTalk(ruchia.getName(), "...", 180);
					p.charaTalk(luca.getName(),
							sara.getName() + "...、" + ruchia.getName() + "さん、答えにくいことだったら答えなくても大丈夫だよ。");
					p.charaTalk(sara.getName(), "えへへ、ごめんんさい");
					p.charaTalk(ruchia.getName(), "大丈夫、答えられます。\n　　　私は２つの言葉喋れます、けどこっちの言葉は...あれ？", 180);
					p.charaTalk(sara.getName(), "大丈夫よ、伝わった。");
				}
			} else {
				if (switchTest == 0) {
					p.charaTalk(sara.getName(), "そうえいば、" + ruchia.getName() + "ちゃん");
				}
			}

			if (switchTest == 0) {
				p.charaTalk(ruchia.getName(), "わたし紅茶はよく飲むけどコーヒーは、全くしばしば...？\n　　　あまり飲んだことなくて...。", 180);
				p.charaTalk(ruchia.getName(), "おいしそうだから飲んでみたいです。" + m.showMenu(order3) + "を\"一つ\"ください。", 180);
				p.charaTalk(sara.getName(), "\"一杯\"っていうのよ。");
				p.charaTalk(ruchia.getName(), "...！ありがとうございます。\"いっぱい\"ください。", 180);
				p.charaTalk(luca.getName(), "一杯だけね。");
			} else {

				System.out.println("【注文】");
				p.captionSpeed("◆" + ruchia.getName() + "：" + m.showMenu(order3));
			}

			score = v.orderSame(order3);
			serveCnt++;
			ruchia.setEmotionPoint(ruchia.getEmotionPoint() + score);
			totalScore = totalScore + score;

			switch (score) {
			case 2:
				p.charaTalk(ruchia.getName(), "ありがとうございます。...いい香り。\n　　　...でも苦い。", 180);
				if (switchTest == 0) {
					p.charaTalk(sara.getName(), "ふふふ、かわいい");
				}
				break;
			case -1:
				p.charaTalk(ruchia.getName(), "わたしにはまだ早い、ですか？", 180);
				p.charaTalk(luca.getName(), "無理して飲む必要はないよ。");
				p.charaTalk(ruchia.getName(), "うーん...", 180);
				p.charaTalk(sara.getName(), "大丈夫よ、私もコーヒーを飲めるようになったのは２２歳を過ぎた頃だし。\n　　　最初は副流煙のようなノリで過ごしていたわ。");
				p.charaTalk(ruchia.getName(), "ふくりゅえん？", 160);
				p.charaTalk(luca.getName(),
						sara.getName() + "、その通りだけどコーヒーをそんな風に例えないでくれ。\n　　　" + ruchia.getName() + "さんだって困ってるじゃないか。");
				break;
			}

			if (switchTest == 0) {
				p.charaTalk(sara.getName(), "なんだか甘いものの気分。ねぇ、" + m.showMenu(order4) + "が飲みたいわ。");
			} else {
				System.out.println("【注文】");
				p.captionSpeed("◆" + sara.getName() + "：" + m.showMenu(order4));
			}

			score = v.orderSame(order4);
			serveCnt++;
			sara.setEmotionPoint(sara.getEmotionPoint() + score);
			totalScore = totalScore + score;

			switch (score) {
			case 2:
				p.charaTalk(sara.getName(), "ありがとう！最高だよ。\n　　　今は甘いものが気分でね。\n　　　" + ruchia.getName() + "ちゃんもどう？");
				p.charaTalk(ruchia.getName(), "わたしも...飲みたいです。", 180);

				break;
			case -1:
				p.charaTalk(sara.getName(), "うん、あたしこれも好き。");
				p.charaTalk(luca.getName(), "いけない...、ごめんよ。");
				p.charaTalk(sara.getName(), "大丈夫、大丈夫。");

				p.charaTalk(ruchia.getName(), "あの...、わたし、" + order5 + "もの飲みたいです。", 180);

				break;
			}

			if (switchTest == 0) {

			} else {
				System.out.println("【注文】");
				p.captionSpeed("◆" + ruchia.getName() + "：" + order5 + "もの");
			}

			score = v.orderSweetMany();
			serveCnt++;
			ruchia.setEmotionPoint(ruchia.getEmotionPoint() + score);
			totalScore = totalScore + score;

			switch (score) {
			case 2:
				p.charaTalk(ruchia.getName(), "ありがとうございます。甘くておいしい...です。", 180);
				p.charaTalk(luca.getName(), "お褒めに預かり光栄だよ。");

				break;

			case 1:
			case -1:
				p.charaTalk(ruchia.getName(), "甘くない？", 180);
				p.charaTalk(luca.getName(), "おっといけない...、大変申し訳ございません。");
				p.charaTalk(sara.getName(), "ちょっと、しっかりしてよ。\n　　　" + ruchia.getName() + "ちゃん、大丈夫？");

				if (switchTest == 0) {
					p.charaTalk(ruchia.getName(), "えっと...", 180);
					p.charaTalk(sara.getName(), "あたしチョコ持ち歩いてるの食べる？");
					p.charaTalk(ruchia.getName(), "いいんですか？", 180);
					p.charaTalk(sara.getName(), "いーの、いーの。食べたほうがおいしい！");
					p.charaTalk(ruchia.getName(), "ありがとうございます。", 180);
					p.charaTalk(luca.getName(), ruchia.getName() + "さんごめんね。\\n　　　そして" +
							sara.getName() + "、ありがとう。");
					p.charaTalk(sara.getName(), "どういたしまして。");
				}
				break;
			}

			p.charaTalk(ruchia.getName(), "いけない、こんな時間...。\n　　　わたしそろそろかえります。", 180);
			p.charaTalk(sara.getName(), "あら、もうそんな時間？寂しいなぁ...しょうがないけどねっ。");

			if (ruchia.getEmotionPoint() >= 6) {
				p.charaTalk(ruchia.getName(), "とても楽しかったです。ありがとうございました。", 180);
				p.charaTalk(luca.getName(), "良い時間を提供できたようで何よりだよ。");
			}
			p.charaTalk(ruchia.getName(), "あした、おじさんと一緒に来るかもです。\n　　　さよなら。", 180);

			p.ringBell();

			p.ringBell();
			p.charaTalk("？？？", "どーも");
			p.charaTalk(sara.getName(), "その声は！" + magellan.getName() + "！うそうそ、どうして？");
			p.charaTalk(magellan.getName(),
					"相変わらず煩いやつだな。\n　　　" + luca.getName() + "、" + sara.getName() + "久しぶりだな。");
			p.charaTalk(luca.getName(), "久しぶり、Cafe Laxへおかえりなさい。");
			p.charaTalk(sara.getName(), "いつ戻ってきたの？");
			p.charaTalk(magellan.getName(), "待ってくれちょっと、ちょっと眠たいからカフェインをキメさせてくれ。");
			p.charaTalk(luca.getName(), order6 + "なドリンクね。");
			if (switchTest == 0) {
			} else {
				System.out.println("【注文】");
				p.captionSpeed("◆" + magellan.getName() + "：" + order6 + "なドリンク");
			}

			score = v.orderCaffeinMany();
			serveCnt++;
			magellan.setEmotionPoint(magellan.getEmotionPoint() + score);
			totalScore = totalScore + score;

			switch (score) {
			case 2:
				p.charaTalk(magellan.getName(), "うん、やっぱりうまい。最強だ。");
				p.charaTalk(luca.getName(), "褒めてもらえて嬉しいよ。");

				break;

			case 1:
				p.charaTalk(magellan.getName(), "ん。カフェインがちょっと足りねぇや。");
				p.charaTalk(luca.getName(), "すまない、もう少しばかり入れるべきだったよ。");

			case -1:
				p.charaTalk(magellan.getName(), "んだこれ。キマらねぇじゃん、２年の間に鈍ったか？");
				p.charaTalk(luca.getName(), "すまない。");
				p.charaTalk(magellan.getName(), "いーよ、そういう時もある。");
				break;
			}

			if (switchTest == 0) {
				p.charaTalk(sara.getName(), "相変わらずむさくるしいやつ");
				p.charaTalk(magellan.getName(), "あんたは死ぬほど煩いがな");
				p.charaTalk(sara.getName(),
						"なっ！...なんか落ち着きたい気分！\n　　　" + luca.getName() + "、" + order7 + "ドリンク！まろやかマシマシで！");
			} else {
				System.out.println("【注文】");
				p.captionSpeed("◆" + sara.getName() + "：" + order7 + "ドリンク");
			}

			score = v.orderMildMany();
			serveCnt++;
			sara.setEmotionPoint(sara.getEmotionPoint() + score);
			totalScore = totalScore + score;

			switch (score) {
			case 2:
				p.charaTalk(sara.getName(), "うん、落ち着いた。ありがとう。");
				if (switchTest == 0) {
				p.charaTalk(luca.getName(), "どういたしまして。\n　　　プロレスが開戦されないようで何よりだ。");
				p.charaTalk(sara.getName(), "ちょっと！どういう意味よ？");
				p.charaTalk(magellan.getName(), "そういう意味だろ");
				}

				break;

			case 1:
				p.charaTalk(sara.getName(), "うーん、ぼちぼち落ち着いた。");
				p.charaTalk(luca.getName(), "よかった。");
				break;

			case -1:
				if (switchTest == 0) {
				p.charaTalk(sara.getName(), "全然落ち着かないなぁ、プロレスを見たいなら望みを叶えるけど。");
				p.charaTalk(luca.getName(), "すまない。");
				p.charaTalk(magellan.getName(), "俺は構わねぇぜ");
				p.charaTalk(luca.getName(), "お願いだからやめてくれ...。");
				p.charaTalk(boss.getName(), "おーい、オフィスにも聞こえてるからなぁー！\n　　　会場は外で頼む！");
				p.charaTalk(luca.getName(), "すみません、" + boss.getName());
				}else {
					p.charaTalk(sara.getName(), "全然落ち着かないなぁ、気分あがっちゃう！！");
				}

				break;
			}
			if (switchTest == 0) {
				p.charaTalk(magellan.getName(), "そういえば" + boss.getName() + "もまだいるのか。あれは元気か？");
				p.charaTalk(luca.getName(), "うん、元気だよ。");
				p.charaTalk(magellan.getName(), "そりゃあいい");
			}

			if (magellan.getEmotionPoint() >= 2) {

				if (switchTest == 0) {
					p.charaTalk(magellan.getName(), "そうだ、あれ頼めるか？");
					p.charaTalk(sara.getName(), "あれ？");
					p.charaTalk(magellan.getName(), "あれだよ、ほら、カフェインとミルクを混ぜた...\n　　　コーヒー入ってるやつ。");
					p.charaTalk(luca.getName(), "あー、あれね？");
					p.charaTalk(sara.getName(), "うそ、わかったの？");
					p.charaTalk(luca.getName(), "まぁね、とりあえず作るよ。");
					p.charaTalk(magellan.getName(), "頼んだ");
					p.charaTalk(sara.getName(), "マジ？それで注文受けて大丈夫？");
				} else {
					System.out.println("【注文】");
					p.captionSpeed("◆" + magellan.getName() + "：カフェインとミルクを混ぜた、コーヒーが入ってるやつ。");

				}

				score = v.orderSame(order8);
				serveCnt++;
				magellan.setEmotionPoint(magellan.getEmotionPoint() + score);
				totalScore = totalScore + score;

				switch (score) {
				case 2:
					p.charaTalk(magellan.getName(), "そう、これだよこれ！最強だ。");
					p.charaTalk(sara.getName(), "うそ、正解しちゃったよ");
					p.charaTalk(luca.getName(), "どーもどーも。");
					break;
				case -1:
					p.charaTalk(magellan.getName(), "ぶっ、なんだこれぇ違ぇぞ");
					p.charaTalk(sara.getName(), "ほら、いわんこっちゃない");
					p.charaTalk(luca.getName(), "すまない、こっちだと思った。");
					p.charaTalk(magellan.getName(), "これじゃあ最弱だぞ");
					p.charaTalk(luca.getName(), "本当にごめん。");
					break;
				}
				p.charaTalk(magellan.getName(), "それじゃ、そろそろ帰る\n　　　帰って寝る。");
				if (switchTest == 0) {
					p.charaTalk(sara.getName(), "ほんと大丈夫？心配なんだけど");
					p.charaTalk(magellan.getName(), "大丈夫だよ、迎えがある。");
					p.charaTalk(sara.getName(), "ならいいけど");
					p.charaTalk(luca.getName(), "会えて嬉しかったよ。");
					p.charaTalk(magellan.getName(), "こっちこそな、多分明日来るわ。んじゃ");
					p.charaTalk(luca.getName(), "気をつけてね。");
				}
			} else {
				p.charaTalk(magellan.getName(), "悪ぃ、さすがに眠たいから家で仮眠を取らせてくれ");
				p.charaTalk(sara.getName(), "それはかなり重大");
				p.charaTalk(luca.getName(), "気をつけてね。");
				p.charaTalk(magellan.getName(), "おうよ、また来るわ。楽しかったぜ。");
				p.charaTalk(sara.getName(), "またね");
				p.charaTalk(luca.getName(), "それじゃあ、また。");
			}
			p.ringBell();
			if (switchTest == 0) {
				p.charaTalk(sara.getName(), "アイツが元気そうでよかった");
				p.charaTalk(luca.getName(), "本当にね。旅に出るって飛び出したもんだったから...");
				p.charaTalk(sara.getName(), "あたしはああいうタイプじゃないけど、ああいう生き方も良いなって思う。");
				p.charaTalk(luca.getName(), "人の生き方に良いも悪いもないけどね。");
				p.charaTalk(sara.getName(), "それはそう。\n　　　あたしもそろそろ帰ろうかな。");
				p.charaTalk(luca.getName(), "わかったよ。帰り気をつけてね？");
				p.charaTalk(sara.getName(), "うん！あなたもアレの対応ひとりじゃ大変でしょ？\n　　　タスク次第だけど明日は早めに来てあげるわ！");
				p.charaTalk(luca.getName(), "それは嬉しい、ぜひとも待ってるよ。");
			}

		} else {
			if (switchTest == 0) {
				p.charaTalk(luca.getName(), "いらっしゃいませ。");
				p.charaTalk(sara.getName(), "やっほー、ご機嫌よう！");
				p.charaTalk(luca.getName(), "やぁ、" + sara.getName());
				p.charaTalk(sara.getName(), "それじゃあ、" + m.showMenu(order2) + "を！");

			} else {
				System.out.println("【注文】");
				p.captionSpeed("◆" + sara.getName() + "：" + m.showMenu(order2));
			}

			score = v.orderSame(order2);
			serveCnt++;
			sara.setEmotionPoint(sara.getEmotionPoint() + score);
			totalScore = totalScore + score;

			switch (score) {
			case 2:
				p.charaTalk(sara.getName(), "ありがとう！最高だよ。");
				break;
			case -1:
				p.charaTalk(sara.getName(), "うん、あたしこれも好き。");
				p.charaTalk(luca.getName(), "いけない...、ごめんよ。");
				p.charaTalk(sara.getName(), "大丈夫、大丈夫。");
				break;
			}

			switch (score) {
			case 2:
				p.charaTalk(sara.getName(), "ありがとう！最高だよ。\n　　　甘いものってたまに飲みたくなるの。");
				break;
			case -1:
				p.charaTalk(sara.getName(), "うん、あたしこれも好き。");
				p.charaTalk(luca.getName(), "いけない...、ごめんよ。");
				p.charaTalk(sara.getName(), "大丈夫、大丈夫。");
				break;
			}

			p.ringBell();

			if (switchTest == 0) {
				p.charaTalk("？？？", "どーも");
				p.charaTalk(sara.getName(), "その声は！" + magellan.getName() + "！うそうそ、どうして？");
				p.charaTalk(magellan.getName(),
						"相変わらず煩いやつだな。\n　　　" + luca.getName() + "、" + sara.getName() + "久しぶりだな。");
				p.charaTalk(luca.getName(), "久しぶり、Cafe Laxへおかえりなさい。");
				p.charaTalk(sara.getName(), "いつ戻ってきたの？");

				p.charaTalk(magellan.getName(), "待ってくれちょっと、ちょっと眠たいからカフェインをキメさせてくれ。");
				p.charaTalk(luca.getName(), order6 + "なドリンクね。");
			} else {
				System.out.println("【注文】");
				p.captionSpeed("◆" + magellan.getName() + "：" + order6 + "なドリンク");
			}

			score = v.orderSweetMany();
			serveCnt++;
			magellan.setEmotionPoint(magellan.getEmotionPoint() + score);
			totalScore = totalScore + score;

			switch (score) {
			case 2:
				p.charaTalk(magellan.getName(), "うん、やっぱりうまい。最強だ。");
				p.charaTalk(luca.getName(), "褒めてもらえて嬉しいよ。");

				break;

			case 1:
				p.charaTalk(magellan.getName(), "ん。カフェインがちょっと足りねぇや。");
				p.charaTalk(luca.getName(), "すまない、もう少しばかり入れるべきだったよ。");
				break;

			case -1:
				p.charaTalk(magellan.getName(), "んだこれ。キマらねぇじゃん、２年の間に鈍ったか？");
				p.charaTalk(luca.getName(), "すまない。");
				p.charaTalk(magellan.getName(), "いーよ、そういう時もある。");
				break;
			}

			if (switchTest == 0) {
				p.charaTalk(sara.getName(), "相変わらずむさくるしいやつ");
				p.charaTalk(magellan.getName(), "あんたは死ぬほど煩いがな");
				p.charaTalk(sara.getName(),
						"なっ！...なんか落ち着きたい気分！\n　　　" + luca.getName() + "、" + order7 + "ドリンク！まろやかマシマシで！");
			} else {
				System.out.println("【注文】");
				p.captionSpeed("◆" + sara.getName() + "：" + order7 + "ドリンク");
			}

			score = v.orderMildMany();
			serveCnt++;
			sara.setEmotionPoint(sara.getEmotionPoint() + score);
			totalScore = totalScore + score;

			switch (score) {
			case 2:
				p.charaTalk(sara.getName(), "うん、落ち着いた。ありがとう。");
				if (switchTest == 0) {
				p.charaTalk(luca.getName(), "どういたしまして。\n　　　プロレスが開戦されないようで何よりだ。");
				p.charaTalk(sara.getName(), "ちょっと！どういう意味よ？");
				p.charaTalk(magellan.getName(), "そういう意味だろ");
				}
				break;

			case 1:
				p.charaTalk(sara.getName(), "うーん、ぼちぼち落ち着いた。");
				p.charaTalk(luca.getName(), "よかった。");

				break;
			case -1:
				if (switchTest == 0) {
				p.charaTalk(sara.getName(), "全然落ち着かないなぁ、プロレスを見たいなら望みを叶えるけど。");
				p.charaTalk(luca.getName(), "すまない。");
				p.charaTalk(magellan.getName(), "俺は構わねぇぜ");
				p.charaTalk(luca.getName(), "お願いだからやめてくれ...。");
				p.charaTalk(boss.getName(), "おーい、オフィスにも聞こえてるからなぁー！\n　　　会場は外で頼む！");
				p.charaTalk(luca.getName(), "すみません、" + boss.getName());
				}else {
					p.charaTalk(sara.getName(), "全然落ち着かないなぁ、気分あがっちゃう！！");
				}

				break;
			}
			if (switchTest == 0) {
				p.charaTalk(magellan.getName(), "そういえば" + boss.getName() + "もまだいるのか。あれは元気か？");
				p.charaTalk(luca.getName(), "うん、元気だよ。");
				p.charaTalk(magellan.getName(), "そりゃあいい");
			}

			if (magellan.getEmotionPoint() >= 2) {
				if (switchTest == 0) {
					p.charaTalk(magellan.getName(), "そうだ、あれ頼めるか？");
					p.charaTalk(sara.getName(), "あれ？");
					p.charaTalk(magellan.getName(), "あれだよ、ほら、カフェインとミルクを混ぜた...\n　　　コーヒー入ってるやつ。");
					p.charaTalk(luca.getName(), "あー、あれね？");
					p.charaTalk(sara.getName(), "うそ、わかったの？");
					p.charaTalk(luca.getName(), "まぁね、とりあえず作るよ。");
					p.charaTalk(magellan.getName(), "頼んだ");
					p.charaTalk(sara.getName(), "マジ？それで注文受けて大丈夫？");
				} else {
					System.out.println("【注文】");
					p.captionSpeed("◆" + magellan.getName() + "：カフェインとミルクを混ぜた、コーヒーが入ってるやつ。");
				}

				score = v.orderSame(order8);
				serveCnt++;
				magellan.setEmotionPoint(magellan.getEmotionPoint() + score);
				totalScore = totalScore + score;

				switch (score) {
				case 2:
					p.charaTalk(magellan.getName(), "そう、これだよこれ！最強だ。");
					p.charaTalk(sara.getName(), "うそ、正解しちゃったよ");
					p.charaTalk(luca.getName(), "どーもどーも。");

					break;
				case -1:

					p.charaTalk(magellan.getName(), "ぶっ、なんだこれぇ違ぇぞ");
					p.charaTalk(sara.getName(), "ほら、いわんこっちゃない");
					p.charaTalk(luca.getName(), "すまない、こっちだと思った。");
					p.charaTalk(magellan.getName(), "これじゃあ最弱だぞ");
					p.charaTalk(luca.getName(), "本当にごめん。");

					break;
				}
				if (switchTest == 0) {
					p.charaTalk(magellan.getName(), "それじゃ、そろそろ帰る\n　　　帰って寝る。");
					p.charaTalk(sara.getName(), "ほんと大丈夫？心配なんだけど");
					p.charaTalk(magellan.getName(), "大丈夫だよ、迎えがある。");
					p.charaTalk(sara.getName(), "ならいいけど");
					p.charaTalk(luca.getName(), "会えて嬉しかったよ。");
					p.charaTalk(magellan.getName(), "こっちこそな、多分明日来るわ。んじゃ");
					p.charaTalk(luca.getName(), "気をつけてね。");
				}
			} else {
				p.charaTalk(magellan.getName(), "悪ぃ、さすがに眠たいから家で仮眠を取らせてくれ");
				p.charaTalk(sara.getName(), "それはかなり重大");
				p.charaTalk(luca.getName(), "気をつけてね。");
				p.charaTalk(magellan.getName(), "おうよ、また来るわ。楽しかったぜ。");
				p.charaTalk(sara.getName(), "またね");
				p.charaTalk(luca.getName(), "それじゃあ、また。");

			}

			if (switchTest == 0) {
				p.charaTalk(sara.getName(), "アイツが元気そうでよかった");
				p.charaTalk(luca.getName(), "本当にね。旅に出るって飛び出したもんだったから...");
				p.charaTalk(sara.getName(), "あたしはああいうタイプじゃないけど、ああいう生き方も良いなって思う。");
				p.charaTalk(luca.getName(), "人の生き方に良いも悪いもないけどね。");
				p.charaTalk(sara.getName(), "それはそう。\n　　　あたしもそろそろ帰ろうかな。");
				p.charaTalk(luca.getName(), "わかったよ。帰り気をつけてね？");
				p.charaTalk(sara.getName(), "うん！あなたもアレの対応ひとりじゃ大変でしょ？\n　　　タスク次第だけど明日は早めに来てあげるわ！");
				p.charaTalk(luca.getName(), "それは嬉しい、ぜひとも待ってるよ。");
			}
		}

		ss2.setTotalScore(totalScore);
		ss2.setServeCnt(serveCnt);
		ss2.setResult2day(totalScore);
		ss2.setSaraPoint(sara.getEmotionPoint());
		ss2.setVolfPoint(volf.getEmotionPoint());
		ss2.setRuchiaPoint(ruchia.getEmotionPoint());
		ss2.setMagellanPoint(magellan.getEmotionPoint());

		return ss2;

	}

	public ScoreSheet thirdDay(ScoreSheet ss1, ScoreSheet ss2) {
		Props p = new Props();
		Menu m = new Menu();
		Verb v = new Verb();
		ScoreSheet ss3 = new ScoreSheet();

		//オーダーリスト
		String order1 = "カフェインがガツンと強い";
		int order2 = 1;
		String order3 = "まろやかな";
		String order4 = "かなり甘い";
		String order5 = "とても甘い";
		int order6 = 3;
		String order7 = "まろやかな";
		String order8 = "カフェイン強め";
		int order9 = 6;

		int score = 0;
		int totalScore = 0;
		int serveCnt = 0;

		p.line_equal();
		p.lineFeed(1);
		p.captionSpeed("　　　　　　　　　開店", 50);
		p.captionSpeed("　　　　　　　　　　　　３日目", 50);

		p.lineFeed(1);
		p.line_equal();

		p.ringBell();

		if (switchTest == 0) {
			p.charaTalk(magellan.getName(), "よっ");
			p.charaTalk(luca.getName(), "お、いらっしゃいませ、" + magellan.getName() + "。");

			p.charaTalk(magellan.getName(), "んじゃ、まずは" + order1 + "ドリンクを頼むぜ");
			p.charaTalk(luca.getName(), "かしこまりました。");
		} else {
			System.out.println("【注文】");
			p.captionSpeed("◆" + magellan.getName() + "：" + order1 + "ドリンク");
		}

		score = v.orderCaffeinMany();
		serveCnt++;
		magellan.setEmotionPoint(magellan.getEmotionPoint() + score);
		totalScore = totalScore + score;

		switch (score) {
		case 2:
			p.charaTalk(magellan.getName(), "やっぱ美味ぇじゃねーの");
			p.charaTalk(luca.getName(), "お褒めに預かり光栄だよ。");
			break;

		case 1:
			p.charaTalk(magellan.getName(), "うーん、足りねえ。まぁいいか、今日は眠ぃ訳じゃねぇし");
			p.charaTalk(luca.getName(), "申し訳ない。");
			break;

		case -1:
			p.charaTalk(magellan.getName(), "注文、聞こえてたかよ。");
			p.charaTalk(luca.getName(), "すまない、勘違いしていたみたいだ...。");
			p.charaTalk(magellan.getName(), "ま、そういうことならしゃーねぇわな");
			break;

		}

		p.ringBell();

		p.charaTalk(luca.getName(), "いらっしゃいませ。");
		p.charaTalk(volf.getName(), "やぁ、こんにちは。");

		p.charaTalk(volf.getName(), "昨日も来たんだが、コーヒーがいい香りでね。\n　　　" + m.showMenu(order2) + "を頂けるかな。");
		p.charaTalk(luca.getName(), "かしこまりました。");
		if (switchTest == 0) {
		} else {
			System.out.println("【注文】");
			p.captionSpeed("◆" + volf.getName() + "：" + m.showMenu(order2));
		}

		score = v.orderSame(order2);
		serveCnt++;
		volf.setEmotionPoint(volf.getEmotionPoint() + score);
		totalScore = totalScore + score;

		switch (score) {
		case 2:
			p.charaTalk(volf.getName(), "ふむ、美味いな。\n　　　ありがとう。");
			p.charaTalk(luca.getName(), "ありがとうございます。\n　　　またご来店頂けて嬉しいです。");
			break;
		case -1:
			p.charaTalk(volf.getName(), "ふむ...、" + m.showMenu(order2) + "を頼むのは難しいようだな。");
			p.charaTalk(luca.getName(), "あぁ...、大変申し訳ございません。");
			break;
		}
		if (switchTest == 0) {

			p.charaTalk(magellan.getName(), "なぁ、" + luca.getName() + "よ。");
			p.charaTalk(luca.getName(), "どうしたんだい？");
			p.charaTalk(magellan.getName(), "久しぶりに自分の国に帰ってたんだよ。\n　　　やっぱ雰囲気ちげぇなって思わされてよ...。");
			p.charaTalk(luca.getName(), "弱気なのかい？");
			p.charaTalk(magellan.getName(), "まさか、ただ違うって思っただけだ。");

			p.charaTalk(volf.getName(), "もし、そこのお兄さん。");
			p.charaTalk(magellan.getName(), "うん？俺の事ですか？");
			p.charaThink(luca.getName(), "珍しく社会人の言葉を話している...。");
			p.charaTalk(magellan.getName(), luca.getName() + "、なんか言いたい事でもあっか。");
			p.charaTalk(luca.getName(), "ないない。それよりお客様、どうかなさいましたか？");
			p.charaTalk(volf.getName(), "あぁいや、踏み込んだ話で悪いが、\n　　　\"自分の国\"に帰ってたって話が聞こえてな。");
			p.charaTalk(magellan.getName(), "あぁ、そうですね。それで外国の事に興味を持ったと？");
			p.charaTalk(volf.getName(), "それもあるが、自分にとっての外国だと思っている場所に居ることは、\n　　　どういった気持ちなんだろうと思ってな。");
			p.charaTalk(magellan.getName(), "...");
			p.charaTalk(volf.getName(), "あぁ、気を悪くさせてしまったら申し訳ない。\n　　　...私には娘のような子が居てな、外国から一時的に来ているんだ。");
			if ((ss1.getRuchiaPoint() + ss2.getRuchiaPoint()) > 3) {
				p.charaThink(luca.getName(), ruchia.getName() + "のことだ...。");
			}
			p.charaTalk(luca.getName(), "その方が気がかりなんですか？");
			p.charaTalk(volf.getName(), "そういうことだ。");
			p.charaTalk(magellan.getName(), "それで、その子ってのは困ってんですか？");
			p.charaTalk(volf.getName(), "どうだろうか、ただこっちに居たって友人もいる様子がないし寂しそうに見えてな。");
			p.charaTalk(magellan.getName(), "そうですか、因みに誰の都合で？");
			p.charaTalk(volf.getName(), "彼女自身の親の都合で...だな。");
			p.charaTalk(magellan.getName(), "そりゃつらい");
			p.charaTalk(luca.getName(), "ちょっと、" + magellan.getName() + "さすがに...");
			p.charaTalk(volf.getName(),
					"いや、問題ないよ。私から話しかけたんだからね。\n　　　それもそうだが、私としたことが名乗るのを忘れていたよ。\n　　　" + volf.getName() + "だ。よろしく頼む。");
			p.charaTalk(magellan.getName(), magellan.getName() + "...です。よろしくおねがいします");
			p.charaTalk(luca.getName(), luca.getName() + "と申します。");
			p.charaTalk(volf.getName(), "ありがとう、それと砕けた口調で大丈夫だ。\n　　　これでも教師をやっていたものでな。その方が嬉しい。");
			p.charaTalk(magellan.getName(), "そうか、それは助かる。改めてよろしく。");
			p.charaTalk(volf.getName(), "彼女のことだが...、");
			p.charaTalk(magellan.getName(), "あぁ、続けなよ");
			p.charaTalk(volf.getName(), "私の前妻の新しい夫の前妻の子供に当たるんだがね。");
			p.charaTalk(luca.getName(), "なんて？");
			p.charaTalk(magellan.getName(), "前の奥さんの新しい子供ってことか？");
			p.charaTalk(volf.getName(), "惜しい、新しい旦那の前の奥さんの子供だ。\n　　　私や前妻とは全く血の繋がりはないよ。");
			p.charaTalk(magellan.getName(), "ややこしい...、そんでもってその子の母親が外国人で、\n　　　その子もその国で育ったってことか？");
			p.charaTalk(volf.getName(), "あぁ、その通りだ。");
			p.charaTalk(luca.getName(), "その子はこの国で学校に通ってるんですか？");
			p.charaTalk(volf.getName(), "いや、長期休暇で来てるだけだからな。\n　　　プレ入学の話も出たんだが、結局通うことにはならなかったよ。");
			p.charaTalk(magellan.getName(), "兄弟姉妹だとかいとこだとか、同年代はいないのか？");
			p.charaTalk(volf.getName(), "いるにはいる。前妻と私の間の子だが、特に話をしてる様子でもないんだ。同い年なんだがね。");
			p.charaTalk(luca.getName(), "ご本人はなんて？");
			p.charaTalk(volf.getName(), "上手くコミュニケーションが取れないって、悩んでいたよ。");
			p.charaTalk(magellan.getName(), "一個気になってたから聞くんだがよ、何であんたなんだ？");
			p.charaTalk(volf.getName(), "...");
			p.charaTalk(luca.getName(), magellan.getName() + "、もう少し細かく。");
			p.charaTalk(magellan.getName(), "悪ぃな、" + volf.getName() + "さんよ。\n　　　どうしてあんたがその子の世話をしてるんだかピンとこねぇ");
			p.charaTalk(volf.getName(), "そういうことか。...彼女の居た国に私も訪れたことがあって、少し文化を知ってるからだね。");
			p.charaTalk(magellan.getName(), "よーくわかった。ありがとよ。");
			p.charaTalk(luca.getName(), "それにしても複雑な立ち位置ですね...。");

			p.charaTalk(volf.getName(), "少し頭が痛くなって来たよ。");
			p.charaTalk(luca.getName(), "何か落ち着くような飲み物を出しましょうか？");
			p.charaTalk(volf.getName(), "あぁ、頼むよ。");
			p.charaTalk(magellan.getName(), "そういう時は" + order3 + "なのが最強だぜ。");
			p.charaTalk(volf.getName(), "そうか、それじゃあそれを。ありがとう、" + magellan.getName() + "君");
		} else {
			System.out.println("【注文】");
			p.captionSpeed("◆" + volf.getName() + "：" + order3 + "なドリンク");
		}
		score = v.orderMildMany();
		serveCnt++;
		volf.setEmotionPoint(volf.getEmotionPoint() + score);
		totalScore = totalScore + score;

		switch (score) {
		case 2:
			p.charaTalk(volf.getName(), "ふむ...気持ちが落ち着いたよ。\n　　　ありがとう。");
			p.charaTalk(luca.getName(), "ありがとうございます。");
			p.charaTalk(magellan.getName(), "ほらな、最強だろ。");
			break;
		case 1:
			p.charaTalk(volf.getName(), "ふむ...少し気持ちが落ち着いたよ。\n　　　ありがとう。");
			p.charaTalk(luca.getName(), "ありがとうございます。");
			break;
		case -1:
			p.charaTalk(volf.getName(), "ふむ...、なんだか落ち着かないなぁ。");
			p.charaTalk(magellan.getName(), "...最弱め");
			p.charaTalk(luca.getName(), "ぁ...、大変申し訳ございません。");
			break;
		}

		if (switchTest == 0) {
			p.charaTalk(magellan.getName(), "にしてもそれは大変だ。俺なんか...");
		}


		p.ringBell();

		p.charaTalk(sara.getName(), "やっほ～、ごきげんよう！");
		p.charaTalk(luca.getName(), "いらっしゃいませ。");


		if (switchTest == 0) {
			p.charaTalk(sara.getName(), "やっほ～、ごきげんよう！");
			p.charaTalk(luca.getName(), "いらっしゃいませ。");
			p.charaTalk(magellan.getName(), "げ、うるせえのが来た。");
			p.charaTalk(sara.getName(), "先越されちゃったかぁ");
			p.charaTalk(volf.getName(), "どうも、こんにちは");
			p.charaTalk(sara.getName(), "あれ？ごきげんよう。この前の人ですよね？");
			p.charaTalk(volf.getName(), "あぁ、" + volf.getName() + "だ。話しやすい話し方で大丈夫だよ。");
			p.charaTalk(sara.getName(), "オッケー！あたしは" + sara.getName() + "。よろしく！");
			p.charaTalk(volf.getName(), "こちらこそよろしく、" + sara.getName() + "くん。");
			p.charaTalk(sara.getName(), "それでそれでどうしたの？");

			p.charaTalk(magellan.getName(), "...の前に！落ち着いて話が聞きたい。\n　　　" + order4 + "飲み物頼めるか？");
			p.charaTalk(luca.getName(), "かしこまりました。" + sara.getName() + "はどうするかい？");
			p.charaTalk(sara.getName(), "うーん、" + magellan.getName() + "のが終わってからでいい？\n　　　ちゃんと頼むつもりよ、ちょっと悩んでるの。");
			p.charaTalk(luca.getName(), "オッケー、わかったよ。\n　　　" + volf.getName() + "さんはどうなさいます？");
			p.charaTalk(volf.getName(), "いや、大丈夫だよ。気を遣ってくれてありがとう。");
			p.charaTalk(luca.getName(), "いえいえ。");
		} else {
			System.out.println("【注文】");
			p.captionSpeed("◆" + magellan.getName() + "：" + order4 + "ドリンク");
		}

		score = v.orderSweetMany();
		serveCnt++;
		magellan.setEmotionPoint(magellan.getEmotionPoint() + score);
		totalScore = totalScore + score;

		switch (score) {
		case 2:
			p.charaTalk(magellan.getName(), "やっぱこれだよ、サンキュな");
			break;
		case 1:
			p.charaTalk(magellan.getName(), "うーん、足りねえ。まぁいいか");
			p.charaTalk(luca.getName(), "申し訳ない...。");
			break;
		case -1:
			p.charaTalk(magellan.getName(), "甘くねぇな");
			p.charaTalk(luca.getName(), "すまない、勘違いしていたみたいだ...。");
			p.charaTalk(magellan.getName(), "まぁいーよ。");
			break;
		}

		if (switchTest == 0) {
			p.charaTalk(sara.getName(), "あたしも" + order5 + "の飲みたい！");
			p.charaTalk(luca.getName(), "かしこまりました。");
		} else {
			System.out.println("【注文】");
			p.captionSpeed("◆" + sara.getName() + "：" + order5 + "のドリンク");
		}

		score = v.orderSweetMany();
		serveCnt++;
		sara.setEmotionPoint(sara.getEmotionPoint() + score);
		totalScore = totalScore + score;

		switch (score) {
		case 2:
			p.charaTalk(sara.getName(), "うーん、癒される。ありがとう！");
			break;
		case 1:
			p.charaTalk(sara.getName(), "うーん、おいしい。ありがとう！");
			break;
		case -1:
			p.charaTalk(sara.getName(), "あ、甘くない...");
			p.charaTalk(luca.getName(), "あぁ、申し訳ない...");
			break;
		}

		if (switchTest == 0) {
			p.charaTalk(volf.getName(), m.showMenu(order6) + "を頼めるかい？");
			p.charaTalk(luca.getName(), "かしこまりました。");
		} else {
			System.out.println("【注文】");
			p.captionSpeed("◆" + volf.getName() + "：" + m.showMenu(order6));
		}

		score = v.orderSame(order6);
		serveCnt++;
		volf.setEmotionPoint(volf.getEmotionPoint() + score);
		totalScore = totalScore + score;

		switch (score) {
		case 2:
			p.charaTalk(volf.getName(), "たまには" + m.showMenu(order6) + "もいいな。");
			break;
		case -1:
			p.charaTalk(volf.getName(), "ふむ...");
			p.charaTalk(luca.getName(), "あぁ、大変申し訳ございません...");
			break;
		}

			p.charaTalk(volf.getName(), "それじゃあ、そろそろ失礼するよ。\n　　　話をしてくれてありがとう。");
			p.charaTalk(sara.getName(), "さよなら！");
			p.charaTalk(magellan.getName(), "またな");
			p.charaTalk(luca.getName(), "ありがとうございました。");
			p.ringBell();

		if (switchTest == 0) {
			p.charaTalk(sara.getName(), order7 + "なドリンクを");
		} else {
			System.out.println("【注文】");
			p.captionSpeed("◆" + sara.getName() + "：" + order7 + "なドリンク");
		}

		score = v.orderMildMany();
		serveCnt++;
		sara.setEmotionPoint(sara.getEmotionPoint() + score);
		totalScore = totalScore + score;

		switch (score) {
		case 2:
			p.charaTalk(sara.getName(), "うーん、癒される。ありがとう！");
			break;

		case 1:
			p.charaTalk(sara.getName(), "うーん、おいしい。ありがとう！");
			break;

		case -1:
			p.charaTalk(sara.getName(), "強すぎるよ...");
			p.charaTalk(luca.getName(), "あぁ、申し訳ない...");
			break;
		}

		if (switchTest == 0) {

			p.charaTalk(magellan.getName(), order8 + "で");
		} else {
			System.out.println("【注文】");
			p.captionSpeed("◆" + magellan.getName() + "：" + order8 + "で");

		}

		score = v.orderCaffeinMany();
		serveCnt++;
		magellan.setEmotionPoint(magellan.getEmotionPoint() + score);
		totalScore = totalScore + score;

		switch (score) {
		case 2:
			p.charaTalk(magellan.getName(), "最強");
			break;

		case 1:
			p.charaTalk(magellan.getName(), "中ボス");
			break;

		case -1:
			p.charaTalk(magellan.getName(), "最弱");
			p.charaTalk(luca.getName(), "あぁ、申し訳ない...");
			break;
		}

		if (switchTest == 0) {
			p.charaTalk(boss.getName(), m.showMenu(order9) + "を");
		} else {
			System.out.println("【注文】");
			p.captionSpeed("◆" + boss.getName() + "：" + m.showMenu(order9));
		}

		score = v.orderSame(order9);
		serveCnt++;
		boss.setEmotionPoint(boss.getEmotionPoint() + score);
		totalScore = totalScore + score;

		switch (score) {
		case 2:
			p.charaTalk(boss.getName(), "ありがとう、とってもおいしいよ。");
			break;
		case -1:
			p.charaTalk(boss.getName(), "給料の出し方は考慮しないといけないね。");
			p.charaTalk(luca.getName(), "うそ...、大変申し訳ございません。");
			break;
		}

		ss3.setTotalScore(totalScore);
		ss3.setServeCnt(serveCnt);
		ss3.setResult2day(totalScore);
		ss3.setSaraPoint(sara.getEmotionPoint());
		ss3.setVolfPoint(volf.getEmotionPoint());
		ss3.setMagellanPoint(magellan.getEmotionPoint());

		ss3.setResult3day(totalScore);

		return ss3;
	}

	public ScoreSheet fourthDay() {
		Menu m = new Menu();
		Verb v = new Verb();
		Props p = new Props();
		ScoreSheet ss4 = new ScoreSheet();

		//オーダーリスト
		int order1 = 1;
		int order2 = 3;
		String order3 = "とっても甘い";
		String order4 = "まろやかな";
		String order5 = "甘い";
		String order6 = "カフェインが少ないもの";
		int order7 = 2;
		String order8 = "おちつけるような";

		int score = 0;
		int totalScore = 0;
		int serveCnt = 0;

		p.line_equal();
		p.lineFeed(1);
		p.captionSpeed("　　　　　　　　　開店", 50);
		p.captionSpeed("　　　　　　　　　　　　４日目", 50);

		p.lineFeed(1);
		p.line_equal();

		p.ringBell();
		if (switchTest == 0) {
			p.charaTalk(ruchia.getName(), m.showMenu(order1) + "をお願いします。", 180);
		} else {
			System.out.println("【注文】");
			p.captionSpeed("◆" + ruchia.getName() + "：" + m.showMenu(order1));
		}

		score = v.orderSame(order1);
		serveCnt++;
		ruchia.setEmotionPoint(ruchia.getEmotionPoint() + score);
		totalScore = totalScore + score;

		switch (score) {
		case 2:
			p.charaTalk(ruchia.getName(), "とってもおいしい、ありがとうございます。", 180);
			break;
		case -1:
			p.charaTalk(ruchia.getName(), "...ちがう気がするけど、ありがとうございます。", 180);
			p.charaTalk(luca.getName(), "わぁ...大変申し訳ないです。");
			break;
		}

		if (switchTest == 0) {
			p.charaTalk(volf.getName(), m.showMenu(order2) + "をお願いするよ。");
		} else {
			System.out.println("【注文】");
			p.captionSpeed("◆" + volf.getName() + "：" + m.showMenu(order2));
		}

		score = v.orderSame(order2);
		serveCnt++;
		volf.setEmotionPoint(volf.getEmotionPoint() + score);
		totalScore = totalScore + score;

		switch (score) {
		case 2:
			p.charaTalk(volf.getName(), "おいしいよ、ありがとう。");
			break;
		case -1:
			p.charaTalk(volf.getName(), "まぁこれも悪くはない。");
			p.charaTalk(luca.getName(), "あ...、申し訳ありません。");
			break;
		}

		if (switchTest == 0) {
			p.charaTalk(ruchia.getName(), order3 + "飲み物をお願いします。", 180);
		} else {
			System.out.println("【注文】");
			p.captionSpeed("◆" + ruchia.getName() + "：" + order3 + "飲み物");
		}

		score = v.orderSweetMany();
		serveCnt++;
		ruchia.setEmotionPoint(ruchia.getEmotionPoint() + score);
		totalScore = totalScore + score;

		switch (score) {
		case 2:
			p.charaTalk(ruchia.getName(), "とってもおいしい、ありがとうございます。", 180);
			break;
		case 1:
			p.charaTalk(ruchia.getName(), "うん...おいしい、ありがとうございます。", 180);
			p.charaThink(luca.getName(), "足りなかったかな...。");
			break;
		case -1:
			p.charaTalk(ruchia.getName(), "...ちがう気がするけど、ありがとうございます。", 180);
			p.charaTalk(luca.getName(), "わぁ...大変申し訳ないです。");
			break;
		}

		if (switchTest == 0) {
			p.charaTalk(volf.getName(), order4 + "なものをお願いするよ。");
		} else {
			System.out.println("【注文】");
			p.captionSpeed("◆" + ruchia.getName() + "：" + order4 + "な飲み物");
		}

		score = v.orderMildMany();
		serveCnt++;
		volf.setEmotionPoint(volf.getEmotionPoint() + score);
		totalScore = totalScore + score;

		switch (score) {
		case 2:
			p.charaTalk(volf.getName(), "おいしいよ、ありがとう。");
			break;
		case 1:
			p.charaTalk(volf.getName(), "うむ、ありがとう。");
			break;
		case -1:
			p.charaTalk(volf.getName(), "まぁこれも悪くはない。");
			p.charaTalk(luca.getName(), "あ...、申し訳ありません。");
			break;
		}

		if (switchTest == 0) {
			p.charaTalk(sara.getName(), order5 + "のを！");
		} else {
			System.out.println("【注文】");
			p.captionSpeed("◆" + sara.getName() + "：" + order4 + "ドリンク");
		}

		score = v.orderSweetMany();
		serveCnt++;
		sara.setEmotionPoint(sara.getEmotionPoint() + score);
		totalScore = totalScore + score;

		switch (score) {
		case 2:
			p.charaTalk(sara.getName(), "おいしい！ありがとう。");
			break;
		case 1:
			p.charaTalk(sara.getName(), "ありがとう。");
			break;
		case -1:
			p.charaTalk(sara.getName(), "ちょっと違うかも");
			p.charaTalk(luca.getName(), "あ...、申し訳ないよ...。");
			break;
		}

		if (switchTest == 0) {
			p.charaTalk(volf.getName(), order6 + "をお願いするよ。");
		} else {
			System.out.println("【注文】");
			p.captionSpeed("◆" + volf.getName() + "：" + order6);
		}

		score = v.orderMildMany();
		serveCnt++;
		volf.setEmotionPoint(volf.getEmotionPoint() + score);
		totalScore = totalScore + score;

		switch (score) {
		case 2:
			p.charaTalk(volf.getName(), "おいしいよ、ありがとう。");
			break;
		case 1:
			p.charaTalk(volf.getName(), "うむ、ありがとう。");
			break;
		case -1:
			p.charaTalk(volf.getName(), "まぁこれも悪くはない。");
			p.charaTalk(luca.getName(), "あ...、申し訳ありません。");
			break;
		}

		if (switchTest == 0) {
			p.charaTalk(sara.getName(), m.showMenu(order7) + "を！");
		} else {
			System.out.println("【注文】");
			p.captionSpeed("◆" + sara.getName() + "：" + m.showMenu(order7));
		}

		score = v.orderSame(order7);
		serveCnt++;
		sara.setEmotionPoint(sara.getEmotionPoint() + score);
		totalScore = totalScore + score;

		switch (score) {
		case 2:
			p.charaTalk(sara.getName(), "おいしい！ありがとう。");
			break;
		case -1:
			p.charaTalk(sara.getName(), "ちょっと違うかも");
			p.charaTalk(luca.getName(), "あ...、申し訳ないよ...。");
			break;
		}

		if (switchTest == 0) {
			p.charaTalk(ruchia.getName(), order8 + "飲み物をお願いします。", 180);
		} else {
			System.out.println("【注文】");
			p.captionSpeed("◆" + ruchia.getName() + "：" + order8 + "のみもの。ホッとするもの。");
		}

		score = v.orderMildMany();
		serveCnt++;
		ruchia.setEmotionPoint(ruchia.getEmotionPoint() + score);
		totalScore = totalScore + score;

		switch (score) {
		case 2:
			p.charaTalk(ruchia.getName(), "とってもおいしい、ありがとうございます。", 180);
			break;
		case 1:
			p.charaTalk(ruchia.getName(), "うん...おいしい、ありがとうございます。", 180);
			p.charaThink(luca.getName(), "足りなかったかな...。");
			break;

		case -1:
			p.charaTalk(ruchia.getName(), "...ちがう気がするけど、ありがとうございます。", 180);
			p.charaTalk(luca.getName(), "わぁ...大変申し訳ないです。");
			break;
		}

		ss4.setTotalScore(totalScore);
		ss4.setServeCnt(serveCnt);
		ss4.setResult2day(totalScore);
		ss4.setSaraPoint(sara.getEmotionPoint());
		ss4.setVolfPoint(volf.getEmotionPoint());
		ss4.setRuchiaPoint(ruchia.getEmotionPoint());

		ss4.setResult4day(totalScore);
		return ss4;
	}

	public ScoreSheet fifthDay(ScoreSheet ss) {
		Verb v = new Verb();
		Menu m = new Menu();
		Props p = new Props();
		ScoreSheet ss5 = new ScoreSheet();

		//オーダーリスト
		int order1 = 4;
		String order2 = "甘くない";
		String order3 = "甘い";
		String order4 = "カフェインが効いてる";
		String order5 = "カフェインがガツンとくる";
		int order6 = 1;
		int order7 = 7;
		String order8 = "ほっと落ち着きたい";

		int score = 0;
		int totalScore = 0;
		int serveCnt = 0;

		p.line_equal();
		p.lineFeed(1);
		p.captionSpeed("　　　　　　　　　開店", 50);
		p.captionSpeed("　　　　　　　　　　　　５日目", 50);

		p.lineFeed(1);
		p.line_equal();

		if (switchTest == 0) {
			p.charaTalk(sara.getName(), m.showMenu(order1) + "をお願い！");
		} else {
			System.out.println("【注文】");
			p.captionSpeed("◆" + sara.getName() + "：" + m.showMenu(order1));
		}

		score = v.orderSame(order1);
		serveCnt++;
		sara.setEmotionPoint(sara.getEmotionPoint() + score);
		totalScore = totalScore + score;

		switch (score) {
		case 2:
			p.charaTalk(sara.getName(), "とってもおいしい！ありがと！");
			break;
		case -1:
			p.charaTalk(sara.getName(), "...ちょっと～調子大丈夫？");
			p.charaTalk(luca.getName(), "ごめん、作り直すよ。");
			p.charaTalk(sara.getName(), "いーよ、これもおいしいんだから気にしないの！");
			p.charaTalk(luca.getName(), "ありがとう。");
			break;
		}

		if (switchTest == 0) {
			p.charaTalk(magellan.getName(), order2 + "ドリンクを頼む");
		} else {
			System.out.println("【注文】");
			p.captionSpeed("◆" + magellan.getName() + "：" + order2 + "ドリンク");
		}

		score = v.orderSweetLess();
		serveCnt++;
		magellan.setEmotionPoint(magellan.getEmotionPoint() + score);
		totalScore = totalScore + score;

		switch (score) {
		case 2:
			p.charaTalk(magellan.getName(), "最強だ、美味い");
			break;
		case 1:
			p.charaTalk(magellan.getName(), "物足りねぇな");
			p.charaThink(luca.getName(), "まちがえたかも...。");
			break;

		case -1:
			p.charaTalk(magellan.getName(), "最弱だ、人生甘くない結果が甘いのな");
			p.charaTalk(luca.getName(), "わ...ごめん、ただの不注意だ。");
			break;
		}

		if ((ss.getVolfPoint() + ss.getRuchiaPoint()) > 31) {//ヴォルフとルチアのサーブをこれまですべて成功していた場合に発動する。

			if (switchTest == 0) {
				p.charaTalk(volf.getName(), order3 + "飲み物を頂けるかな。");
			} else {
				System.out.println("【注文】");
				p.captionSpeed("◆" + volf.getName() + "：" + order3 + "飲み物");
			}

			score = v.orderSweetMany();
			serveCnt++;
			volf.setEmotionPoint(volf.getEmotionPoint() + score);
			totalScore = totalScore + score;

			switch (score) {
			case 2:
				p.charaTalk(volf.getName(), "美味いよ。ありがとう。");
				break;
			case 1:
				p.charaTalk(volf.getName(), "うーん少し、渋いな。");
				p.charaTalk(luca.getName(), "足りなかったですか...申し訳ありません。");
				break;
			case -1:
				p.charaTalk(volf.getName(), "これは...");
				p.charaTalk(luca.getName(), "...申し訳ありません。");
				p.charaTalk(volf.getName(), "いや、良いんだ。いつも通りの姿を忘れるなという事だと思って受け取るよ。");
				p.charaTalk(luca.getName(), "...");
				break;
			}

			if (switchTest == 0) {
				p.charaTalk(sara.getName(), order4 + "やつをお願い！");
			} else {
				System.out.println("【注文】");
				p.captionSpeed("◆" + sara.getName() + "：" + order4 + "飲み物");
			}

			score = v.orderCaffeinMany();
			serveCnt++;
			sara.setEmotionPoint(sara.getEmotionPoint() + score);
			totalScore = totalScore + score;

			switch (score) {
			case 2:
				p.charaTalk(sara.getName(), "ありがとう！集中できそう！");
				break;
			case 1:
				p.charaTalk(sara.getName(), "うん、ありがとう！");
				break;
			case -1:
				p.charaTalk(sara.getName(), "ふふふ、カフェインがなくったって集中できるよ？");
				p.charaTalk(luca.getName(), "あぁ、ごめん。どうかしてたよ。");
				break;
			}

			if (switchTest == 0) {
				p.charaTalk(magellan.getName(), order5 + "ドリンクを頼む");
			} else {
				System.out.println("【注文】");
				p.captionSpeed("◆" + magellan.getName() + "：" + order5 + "飲み物");
			}

			score = v.orderCaffeinMany();
			serveCnt++;
			magellan.setEmotionPoint(magellan.getEmotionPoint() + score);
			totalScore = totalScore + score;

			switch (score) {
			case 2:
				p.charaTalk(magellan.getName(), "いいじゃねぇかよく効く！最強だ！");
				break;
			case 1:
				p.charaTalk(magellan.getName(), "そこそこの効き目だな。");
				break;
			case -1:
				p.charaTalk(magellan.getName(), "最弱なカフェインだ。");
				p.charaTalk(luca.getName(), "あぁ、ごめん。間違えてしまったよ。");
				break;
			}

			if (switchTest == 0) {
				p.charaTalk(volf.getName(), m.showMenu(order6) + "を一杯。");
			} else {
				System.out.println("【注文】");
				p.captionSpeed("◆" + volf.getName() + "：" + m.showMenu(order6));
			}

			score = v.orderSame(order6);
			serveCnt++;
			volf.setEmotionPoint(volf.getEmotionPoint() + score);
			totalScore = totalScore + score;

			switch (score) {
			case 2:
				p.charaTalk(volf.getName(), "ありがとう、美味しいよ。");
				break;
			case -1:
				p.charaTalk(volf.getName(), "ううむ、違うようだ。");
				p.charaTalk(luca.getName(), "いけない、大変申し訳ありません。");
				break;

			}

			if (switchTest == 0) {
				p.charaTalk(magellan.getName(), m.showMenu(order7) + "を！");
			} else {
				System.out.println("【注文】");
				p.captionSpeed("◆" + magellan.getName() + "：" + m.showMenu(order7));
			}

			score = v.orderSame(order7);
			serveCnt++;
			magellan.setEmotionPoint(magellan.getEmotionPoint() + score);
			totalScore = totalScore + score;

			switch (score) {
			case 2:
				p.charaTalk(magellan.getName(), "やっぱこれだよなぁ、美味ぇや！");
				break;
			case -1:
				p.charaTalk(magellan.getName(), "美味ぇけど最弱だ...！");
				p.charaTalk(luca.getName(), "あぁ...すまない、なんてことだ。");
				break;
			}

			if (switchTest == 0) {
				p.charaTalk(magellan.getName(), order8 + "。");
			} else {
				System.out.println("【注文】");
				p.captionSpeed("◆" + magellan.getName() + "：" + order8 + "のを叶えるドリンク。");

			}

			score = v.orderMildMany();
			serveCnt++;
			sara.setEmotionPoint(sara.getEmotionPoint() + score);
			totalScore = totalScore + score;

			switch (score) {
			case 2:
				p.charaTalk(sara.getName(), "ありがとう、落ち着くわ。");
				break;
			case 1:
				p.charaTalk(sara.getName(), "ありがとう。");
				break;
			case -1:
				p.charaTalk(sara.getName(), "...ありがとう。");
				p.charaTalk(luca.getName(), "あぁ、ごめん。間違えてしまった...。");
				break;
			}

		} else {
			if (switchTest == 0) {
				p.charaTalk(sara.getName(), order4 + "やつをお願い！");
			} else {
				System.out.println("【注文】");
				p.captionSpeed("◆" + sara.getName() + "：" + order4 + "飲み物");
			}

			score = v.orderCaffeinMany();
			serveCnt++;
			sara.setEmotionPoint(sara.getEmotionPoint() + score);
			totalScore = totalScore + score;

			switch (score) {
			case 2:
				p.charaTalk(sara.getName(), "ありがとう！集中できそう！");
				break;
			case 1:
				p.charaTalk(sara.getName(), "うん、ありがとう！");
				break;
			case -1:
				p.charaTalk(sara.getName(), "ふふふ、カフェインがなくったって集中できるよ？");
				p.charaTalk(luca.getName(), "あぁ、ごめん。どうかしてたよ。");
				break;
			}

			if (switchTest == 0) {
				p.charaTalk(magellan.getName(), order5 + "ドリンクを頼む");
			} else {
				System.out.println("【注文】");
				p.captionSpeed("◆" + magellan.getName() + "：" + order4 + "ドリンク");
			}

			score = v.orderCaffeinMany();
			serveCnt++;
			magellan.setEmotionPoint(magellan.getEmotionPoint() + score);
			totalScore = totalScore + score;

			switch (score) {
			case 2:
				p.charaTalk(magellan.getName(), "いいじゃねぇかよく効く！最強だ！");
				break;
			case 1:
				p.charaTalk(magellan.getName(), "そこそこの効き目だな。");
				break;
			case -1:
				p.charaTalk(magellan.getName(), "最弱なカフェインだ。");
				p.charaTalk(luca.getName(), "あぁ、ごめん。間違えてしまったよ。");
				break;
			}

			if (switchTest == 0) {
				p.charaTalk(magellan.getName(), m.showMenu(order7) + "を！");
			} else {
				System.out.println("【注文】");
				p.captionSpeed("◆" + magellan.getName() + "：" + m.showMenu(order7));
			}

			score = v.orderSame(order7);
			serveCnt++;
			magellan.setEmotionPoint(magellan.getEmotionPoint() + score);
			totalScore = totalScore + score;

			switch (score) {
			case 2:
				p.charaTalk(magellan.getName(), "やっぱこれだよなぁ、美味ぇや！");
				break;
			case -1:
				p.charaTalk(magellan.getName(), "美味ぇけど最弱だ...！");
				p.charaTalk(luca.getName(), "あぁ...すまない、なんてことだ。");
				break;
			}

			if (switchTest == 0) {
				p.charaTalk(sara.getName(), order8 + "。");
			} else {
				System.out.println("【注文】");
				p.captionSpeed("◆" + sara.getName() + "：" + order8 + "のを叶えるドリンク。");
			}

			score = v.orderMildMany();
			serveCnt++;
			sara.setEmotionPoint(sara.getEmotionPoint() + score);
			totalScore = totalScore + score;

			switch (score) {
			case 2:
				p.charaTalk(sara.getName(), "ありがとう、落ち着くわ。");
				break;
			case 1:
				p.charaTalk(sara.getName(), "ありがとう。");
				break;
			case -1:
				p.charaTalk(sara.getName(), "...ありがとう。");
				p.charaTalk(luca.getName(), "あぁ、ごめん。間違えてしまった...。");
				break;
			}

		}

		ss5.setTotalScore(totalScore);
		ss5.setServeCnt(serveCnt);
		ss5.setResult2day(totalScore);
		ss5.setSaraPoint(sara.getEmotionPoint());
		ss5.setVolfPoint(volf.getEmotionPoint());
		ss5.setMagellanPoint(magellan.getEmotionPoint());

		ss5.setResult4day(totalScore);
		return ss5;
	}

	public void ending(ScoreSheet ss5) {
		Props p = new Props();

		p.lineFeed(3);
		p.line_equal();
		p.captionSpeed("エンディング");
		p.line_equal();
		p.lineFeed(3);

		//サラのエンディング判定。
		p.line_flower();
		p.lineFeed(1);

		if ((ss5.getTotalSaraPoint() >= 0) && (ss5.getTotalSaraPoint() < 9) || (ss5.getTotalSaraPoint() < 0)) {
			p.captionSpeed(sara.getName() + "：Ｃエンド");
		} else if ((ss5.getTotalSaraPoint() >= 9) && (ss5.getTotalSaraPoint() < 17)) {
			p.captionSpeed(sara.getName() + "：Ｂエンド");
		} else if ((ss5.getTotalSaraPoint() >= 17) && (ss5.getTotalSaraPoint() < 26)) {
			p.captionSpeed(sara.getName() + "：Ａエンド");
		} else if (ss5.getTotalSaraPoint() >= 26) {
			p.captionSpeed(sara.getName() + "：Ｓエンド");
		}

		p.lineFeed(3);
		p.line_flower();
		p.lineFeed(1);

		//ヴォルフのエンディング判定。
		if ((ss5.getTotalVolfPoint() >= 0) && (ss5.getTotalVolfPoint() < 7) || (ss5.getTotalVolfPoint() < 0)) {
			p.captionSpeed(volf.getName() + "：Ｃエンド");
		} else if ((ss5.getTotalVolfPoint() >= 7) && (ss5.getTotalVolfPoint() < 17)) {
			p.captionSpeed(volf.getName() + "：Ｂエンド");
		} else if ((ss5.getTotalVolfPoint() >= 13) && (ss5.getTotalVolfPoint() < 20)) {
			p.captionSpeed(volf.getName() + "：Ａエンド");
		} else if (ss5.getTotalVolfPoint() >= 20) {
			p.captionSpeed(volf.getName() + "：Ｓエンド");
		}

		p.lineFeed(3);
		p.line_flower();
		p.lineFeed(1);
		//ルチアのエンディング判定。
		if ((ss5.getTotalRuchiaPoint() >= 0) && (ss5.getTotalRuchiaPoint() < 5) || (ss5.getTotalRuchiaPoint() < 0)) {
			p.captionSpeed(ruchia.getName() + "：Ｃエンド");
		} else if ((ss5.getTotalRuchiaPoint() >= 5) && (ss5.getTotalRuchiaPoint() < 11)) {
			p.captionSpeed(ruchia.getName() + "：Ｂエンド");
		} else if ((ss5.getTotalRuchiaPoint() >= 11) && (ss5.getTotalRuchiaPoint() < 16)) {
			p.captionSpeed(ruchia.getName() + "：Ａエンド");
		} else if (ss5.getTotalRuchiaPoint() >= 16) {
			p.captionSpeed(ruchia.getName() + "：Ｓエンド");
		}

		p.lineFeed(3);
		p.line_flower();
		p.lineFeed(1);
		//マゼランのエンディング判定。
		if ((ss5.getTotalMagellanPoint() >= 0) && (ss5.getTotalMagellanPoint() < 5)
				|| (ss5.getTotalMagellanPoint() < 0)) {
			p.captionSpeed(magellan.getName() + "：Ｃエンド");
		} else if ((ss5.getTotalMagellanPoint() >= 5) && (ss5.getTotalMagellanPoint() < 11)) {
			p.captionSpeed(magellan.getName() + "：Ｂエンド");
		} else if ((ss5.getTotalMagellanPoint() >= 11) && (ss5.getTotalMagellanPoint() < 16)) {
			p.captionSpeed(magellan.getName() + "：Ａエンド");
		} else if (ss5.getTotalMagellanPoint() >= 16) {
			p.captionSpeed(magellan.getName() + "：Ｓエンド");
		}

		p.lineFeed(3);
		p.line_flower();
		p.lineFeed(1);
		p.line_equal();
		//サーブ回数
		p.captionSpeed("サーブ回数：" + ss5.getTotalServeCnt() + "回");
		//トータルのランク
		if (ss5.getTotalScore() >= 0 && ss5.getTotalScore() < 27) {
			p.captionSpeed("サービスランク：Ｃランク");
			p.captionSpeed("【がっかりバーテンダー】");
		} else if (ss5.getTotalScore() >= 27 && ss5.getTotalScore() < 55) {
			p.captionSpeed("サービスランク：Ｂランク");
			p.captionSpeed("【半人前バーテンダー】");
		} else if (ss5.getTotalScore() >= 55 && ss5.getTotalScore() < 80) {
			p.captionSpeed("サービスランク：Ａランク");
			p.captionSpeed("【一人前バーテンダー】");
		} else if (ss5.getTotalScore() >= 80) {
			p.captionSpeed("サービスランク：Ｓランク");
			p.captionSpeed("【一流のバーテンダー】");
		}
		p.line_equal();

		p.lineFeed(3);
		p.line_equal();
		p.captionSpeed("Thank you for play this game!");
		p.line_equal();
		p.lineFeed(3);
	}

}
