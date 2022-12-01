package model;

public class StoryPlot {

	Story s = new Story();
	ScoreSheet ss1 = new ScoreSheet();
	ScoreSheet ss2 = new ScoreSheet();
	ScoreSheet ss3 = new ScoreSheet();
	ScoreSheet ss4 = new ScoreSheet();
	ScoreSheet ss5 = new ScoreSheet();
	Props p = new Props();

	public void storyPlot() {

		s.tutorial();
		ss1 = s.firstDay();
		ss1.setTotalScore(ss1.getResult1day());
		ss1.setScore(ss1.getResult1day());
		ss1.setTotalSaraPoint(ss1.getSaraPoint());
		ss1.setTotalVolfPoint(ss1.getVolfPoint());
		ss1.setTotalRuchiaPoint(ss1.getRuchiaPoint());
		ss1.setTotalMagellanPoint(ss1.getMagellanPoint());
		ss1.setTotalServeCnt(ss1.getServeCnt());

		//		System.out.println("◆◆◆値受け取りチェック1◆◆◆");
		//		System.out.print("ストーリー：");
		//		System.out.println(ss1.getTotalScore());
		//		System.out.print("サーブ回数：");
		//		System.out.println(ss1.getServeCnt());
		//		System.out.print("サラ：");
		//		System.out.println(ss1.getSaraPoint());
		//		System.out.print("ヴォルフ：");
		//		System.out.println(ss1.getVolfPoint());
		//		System.out.print("ルチア：");
		//		System.out.println(ss1.getRuchiaPoint());
		//		System.out.print("マゼラン：");
		//		System.out.println(ss1.getMagellanPoint());

		p.resultSheet(ss1);

		ss2.setResult1day(ss1.getTotalScore());
		ss2 = s.secondDay(ss1);
		ss2.setTotalScore(ss1.getResult1day() + ss2.getResult2day());
		ss2.setScore(ss2.getResult2day());
		ss2.setTotalSaraPoint(ss1.getTotalSaraPoint()+ss2.getSaraPoint());
		ss2.setTotalVolfPoint(ss1.getTotalVolfPoint()+ss2.getVolfPoint());
		ss2.setTotalRuchiaPoint(ss1.getTotalRuchiaPoint()+ss2.getRuchiaPoint());
		ss2.setTotalMagellanPoint(ss1.getTotalMagellanPoint()+ss2.getMagellanPoint());
		ss2.setTotalServeCnt(ss1.getTotalServeCnt()+ss2.getServeCnt());

		//		System.out.println("◆◆◆値受け取りチェック2◆◆◆");
		//		System.out.print("ストーリー：");
		//		System.out.println(ss2.getTotalScore());
		//		System.out.print("サーブ回数：");
		//		System.out.println(ss2.getServeCnt());
		//		System.out.print("サラ：");
		//		System.out.println(ss2.getSaraPoint());
		//		System.out.print("ヴォルフ：");
		//		System.out.println(ss2.getVolfPoint());
		//		System.out.print("ルチア：");
		//		System.out.println(ss2.getRuchiaPoint());
		//		System.out.print("マゼラン：");
		//		System.out.println(ss2.getMagellanPoint());

		p.resultSheet(ss2);

		ss3 = s.thirdDay(ss1, ss2);
		ss3.setResult1day(ss1.getTotalScore());
		ss3.setResult2day(ss2.getTotalScore());
		ss3.setTotalScore(ss1.getResult1day() + ss2.getResult2day() + ss3.getResult3day());
		ss3.setScore(ss3.getResult3day());
		ss3.setTotalSaraPoint(ss2.getTotalSaraPoint()+ss3.getSaraPoint());
		ss3.setTotalVolfPoint(ss2.getTotalVolfPoint()+ss3.getVolfPoint());
		ss3.setTotalRuchiaPoint(ss2.getTotalRuchiaPoint()+ss3.getRuchiaPoint());
		ss3.setTotalMagellanPoint(ss2.getTotalMagellanPoint()+ss3.getMagellanPoint());
		ss3.setTotalServeCnt(ss2.getTotalServeCnt()+ss3.getServeCnt());

		//		System.out.println("◆◆◆値受け取りチェック3◆◆◆");
		//		System.out.print("ストーリー：");
		//		System.out.println(ss3.getTotalScore());
		//		System.out.print("サーブ回数：");
		//		System.out.println(ss3.getServeCnt());
		//		System.out.print("サラ：");
		//		System.out.println(ss3.getSaraPoint());
		//		System.out.print("ヴォルフ：");
		//		System.out.println(ss3.getVolfPoint());
		//		System.out.print("ルチア：");
		//		System.out.println(ss3.getRuchiaPoint());
		//		System.out.print("マゼラン：");
		//		System.out.println(ss3.getMagellanPoint());

		p.resultSheet(ss3);

		ss4 = s.fourthDay();
		ss4.setResult1day(ss1.getTotalScore());
		ss4.setResult2day(ss2.getTotalScore());
		ss4.setResult3day(ss3.getTotalScore());
		ss4.setTotalScore(ss1.getResult1day() + ss2.getResult2day() + ss3.getResult3day() + ss4.getResult4day());
		ss4.setScore(ss4.getResult4day());
		ss4.setTotalSaraPoint(ss3.getTotalSaraPoint()+ss4.getSaraPoint());
		ss4.setTotalVolfPoint(ss3.getTotalVolfPoint()+ss4.getVolfPoint());
		ss4.setTotalRuchiaPoint(ss3.getTotalRuchiaPoint()+ss4.getRuchiaPoint());
		ss4.setTotalMagellanPoint(ss3.getTotalMagellanPoint()+ss4.getMagellanPoint());
		ss4.setTotalServeCnt(ss3.getTotalServeCnt()+ss4.getServeCnt());

		//		System.out.println("◆◆◆値受け取りチェック4◆◆◆");
		//		System.out.print("ストーリー：");
		//		System.out.println(ss4.getTotalScore());
		//		System.out.print("サーブ回数：");
		//		System.out.println(ss4.getServeCnt());
		//		System.out.print("サラ：");
		//		System.out.println(ss4.getSaraPoint());
		//		System.out.print("ヴォルフ：");
		//		System.out.println(ss4.getVolfPoint());
		//		System.out.print("ルチア：");
		//		System.out.println(ss4.getRuchiaPoint());
		//		System.out.print("マゼラン：");
		//		System.out.println(ss4.getMagellanPoint());

		p.resultSheet(ss4);

		ss5 = s.fifthDay(ss4);
		ss5.setResult1day(ss1.getTotalScore());
		ss5.setResult2day(ss2.getTotalScore());
		ss5.setResult3day(ss3.getTotalScore());
		ss5.setResult4day(ss4.getTotalScore());
		ss5.setTotalScore(ss1.getResult1day() + ss2.getResult2day() + ss3.getResult3day() + ss4.getResult4day()
				+ ss5.getResult5day());
		ss5.setScore( ss5.getResult5day());
		ss5.setTotalSaraPoint(ss4.getTotalSaraPoint()+ss5.getSaraPoint());
		ss5.setTotalVolfPoint(ss4.getTotalVolfPoint()+ss5.getVolfPoint());
		ss5.setTotalRuchiaPoint(ss4.getTotalRuchiaPoint()+ss5.getRuchiaPoint());
		ss5.setTotalMagellanPoint(ss4.getTotalMagellanPoint()+ss5.getMagellanPoint());
		ss5.setTotalServeCnt(ss4.getTotalServeCnt()+ss5.getServeCnt());

		//		System.out.println("◆◆◆値受け取りチェック5◆◆◆");
		//		System.out.print("ストーリー：");
		//		System.out.println(ss5.getTotalScore());
		//		System.out.print("サーブ回数：");
		//		System.out.println(ss5.getServeCnt());
		//		System.out.print("サラ：");
		//		System.out.println(ss5.getSaraPoint());
		//		System.out.print("ヴォルフ：");
		//		System.out.println(ss5.getVolfPoint());
		//		System.out.print("ルチア：");
		//		System.out.println(ss5.getRuchiaPoint());
		//		System.out.print("マゼラン：");
		//		System.out.println(ss5.getMagellanPoint());

		p.resultSheet(ss5);

		s.ending(ss5);

	}

}
