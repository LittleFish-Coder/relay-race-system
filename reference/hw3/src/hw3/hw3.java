package hw3;

import java.util.Scanner;

public class hw3 {
	public static void main(String args[]) {

		String[] runnerP1 = new String[5];
		String[] runnerP2 = new String[5];
		double distance1 = 100;
		double speed1 = 0;
		double distance2 = 100;
		double speed2 = 0;
		double t1 = 5;
		double t2 = 5;
		int n1 = 1;
		int n2 = 1;
		int tgo = 5;
		int number1 = 1;
		int number2 = 1;
		double distance1Fix;
		double distance2Fix;
		double tFix1;
		double tFix2;

		System.out.println("歡迎來到<成英大學 超能力接力大賽>");
		System.out.println("");
		System.out.println("以下為遊戲說明");
		System.out.println("每位玩家有五名跑者、五項技能，每位跑者的完賽距離為100公尺");
		System.out.println("*********************************************************");
		System.out.println("////跑者介紹////");
		System.out.println("跑者分為力量型與敏捷型");
		System.out.println("指令格式：");
		System.out.println("[跑者類型]-[跑者類型]-[跑者類型]-[跑者類型]-[跑者類型]");
		System.out.println("選擇力量型請輸入str");
		System.out.println("選擇敏捷型請輸入dex");
		System.out.println("請輸入五個棒次的跑者類型，並且以減號分隔各個棒次");
		System.out.println("例如： str-dex-str-dex-str");
		System.out.println("");
		System.out.println("////技能介紹////");
		System.out.println("技能分為冰凍與力場");
		System.out.println("指令格式：[冰凍技能數量]-[力場技能數量]");
		System.out.println("例如： 3-2");
		System.out.println("表示玩家共可使用3個冰凍技能與2個力場技能");
		System.out.println("");
		System.out.println("////跑者特性與技能影響");
		System.out.println("力量型跑者(str)：");
		System.out.println("速度：每秒10公尺");
		System.out.println("受冰凍影響：靜止5秒鐘");
		System.out.println("受力場影響：無影響");
		System.out.println("");
		System.out.println("敏捷型跑者(dex)：");
		System.out.println("速度：每秒20公尺");
		System.out.println("受冰凍影響：靜止3秒鐘");
		System.out.println("受力場影響：速度減少為每秒10公尺");
		System.out.println("");
		System.out.println("////遊戲流程////");
		System.out.println("玩家須依序輸入棒次順序並選擇技能");
		System.out.println("每個玩家須選取5個技能");
		System.out.println("比賽開始後，每5秒系統會顯示賽況，此時玩家可使用技能");
		System.out.println("指令格式： [冰凍技能數量]-[力場技能數量]");
		System.out.println("每次使用僅能各使用1次");
		System.out.println("*********************************************************");
		System.out.println("玩家一請進行選擇");
		runner P1runner = new runner();
		P1runner.setRunner();
		skill skill1 = new skill();
		skill1.setSkill();
		System.out.println("玩家二請進行選擇");
		runner P2runner = new runner();
		P2runner.setRunner();
		skill skill2 = new skill();
		skill2.setSkill();
		////////////////////////////////////// 遊戲階段
		System.out.println("");
		System.out.println("比賽開始");
		System.out.println("第0秒時");
		System.out.println("玩家一第" + number1 + "棒");
		System.out.print("跑者類型");
		P1runner.getRunnerType(n1);
		System.out.println("無遭受技能影響");
		System.out.println("");
		System.out.println("玩家二第" + number2 + "棒");
		System.out.print("跑者類型");
		P2runner.getRunnerType(n2);
		System.out.println("無遭受技能影響");
		System.out.println("");
		///////////////////////////////////////// 選擇技能
		System.out.println("玩家一請輸入欲使用的技能");
		skill1.useSkill(P2runner.getRT(1));
		System.out.println("玩家二請輸入欲使用的技能");
		skill2.useSkill(P1runner.getRT(1));
		///////////////////////////////////////// 第一棒跑步
		String P1 = P1runner.getRT(1);
		String P2 = P2runner.getRT(1);

		while (!((n1 == 5 && distance1 <= 0) || (n2 == 5 && distance2 <= 0))) {
			System.out.println("");
			System.out.println("************第" + tgo + "秒時賽況**************");
			t1 = 5;
			t2 = 5;

			/////////////////////// 玩家一/////////////////////////////
			System.out.println("玩家一第" + number1 + "棒");
			if (skill2.skillInf1 == 1 && skill2.skillInf2 == 0) {

				if (P1.equals("str")) {
					speed1 = P1runner.setSpeed("str");
					System.out.println("力量型跑者");
					System.out.println("受冰凍技能影響");
					t1 = t1 - 5;

				} else {
					speed1 = P1runner.setSpeed("dex");
					System.out.println("敏捷型跑者");
					System.out.println("受冰凍技能影響");
					t1 = t1 - 3;
				}
			}

			if (skill2.skillInf2 == 1 && skill2.skillInf1 == 0) {
				if (P1.equals("str")) {
					speed1 = P1runner.setSpeed("str");
					System.out.println("力量型跑者");
					System.out.println("受力場技能影響");

				} else {
					speed1 = P1runner.setSpeed("dex");
					System.out.println("敏捷型跑者");
					System.out.println("受力場技能影響");
					speed1 = speed1 - 10;

				}
			}

			if (skill2.skillInf2 == 1 && skill2.skillInf1 == 1) {
				if (P1.equals("str")) {
					speed1 = P1runner.setSpeed("str");
					System.out.println("力量型跑者");
					System.out.println("受冰凍技能影響");
					System.out.println("受力場技能影響");

					t1 = t1 - 5;
				} else {
					speed1 = P1runner.setSpeed("dex");
					System.out.println("敏捷型跑者");
					System.out.println("受冰凍技能影響");
					System.out.println("受力場技能影響");
					speed1 = speed1 - 10;
					t1 = t1 - 3;

				}
			}

			if (skill2.skillInf1 == 0 && skill2.skillInf2 == 0) {
				if (P1.equals("str")) {
					speed1 = P1runner.setSpeed("str");
					System.out.println("力量型跑者");
					System.out.println("無遭受技能影響");

				}
				if (P1.equals("dex")) {
					speed1 = P1runner.setSpeed("dex");
					System.out.println("敏捷型跑者");
					System.out.println("無遭受技能影響");
				}
			}
			distance1 = distance1 - (speed1 * t1);

			//////////////////////////////////// 玩家二////////////////////////////////////////

			System.out.println("");
			System.out.println("玩家二第" + number2 + "棒");
			if (skill1.skillInf1 == 1 && skill1.skillInf2 == 0) {

				if (P2.equals("str")) {
					speed2 = P2runner.setSpeed("str");
					System.out.println("力量型跑者");
					System.out.println("受冰凍技能影響");
					t2 = t2 - 5;
				} else {
					speed2 = P2runner.setSpeed("dex");
					System.out.println("敏捷型跑者");
					System.out.println("受冰凍技能影響");
					t2 = t2 - 3;
				}
			}

			if (skill1.skillInf2 == 1 && skill1.skillInf1 == 0) {
				if (P2.equals("str")) {
					speed2 = P2runner.setSpeed("str");
					System.out.println("力量型跑者");
					System.out.println("受力場技能影響");

				} else {
					speed2 = P2runner.setSpeed("dex");
					System.out.println("敏捷型跑者");
					System.out.println("受力場技能影響");
					speed2 = speed2 - 10;

				}
			}

			if (skill1.skillInf2 == 1 && skill1.skillInf1 == 1) {
				if (P2.equals("str")) {
					speed2 = P2runner.setSpeed("str");
					System.out.println("力量型跑者");
					System.out.println("受冰凍技能影響");
					System.out.println("受力場技能影響");
					t2 = t2 - 5;
				} else {
					speed2 = P2runner.setSpeed("dex");
					System.out.println("敏捷型跑者");
					System.out.println("受冰凍技能影響");
					System.out.println("受力場技能影響");
					speed2 = speed2 - 10;
					t2 = t2 - 3;

				}
			}

			if (skill1.skillInf1 == 0 && skill1.skillInf2 == 0) {
				if (P2.equals("str")) {
					speed2 = P2runner.setSpeed("str");
					System.out.println("力量型跑者");
					System.out.println("無遭受技能影響");
				}
				if (P2.equals("dex")) {
					speed2 = P2runner.setSpeed("dex");
					System.out.println("敏捷型跑者");
					System.out.println("無遭受技能影響");
				}
			}

			distance2 = distance2 - speed2 * t2;

			//////////////////////////////////// 修正玩家一距離小於零

			if (distance1 < 0) {

				if (n1 == 5) {

					if (distance2 <= 0) {
						if (n2 == 5) {
							distance1Fix = 0 - distance1;
							tFix1 = distance1Fix / speed1;
							distance2Fix = 0 - distance2;
							tFix2 = distance2Fix / speed2;
							System.out.println("");
							System.out.println("*玩家一完成比賽*");
							System.out.println("比賽時間" + (tgo - tFix1) + "秒");
							System.out.println("");
							System.out.println("*玩家二完成比賽*");
							System.out.println("比賽時間" + (tgo - tFix2) + "秒");
							System.out.println("");
							if ((tgo - tFix1) > (tgo - tFix2)) {
								System.out.println("比賽結果：玩家二獲勝");
								System.out.println("比賽結束");
								System.exit(0);
							}

							if ((tgo - tFix1) < (tgo - tFix2)) {
								System.out.println("比賽結果：玩家一獲勝");
								System.out.println("比賽結束");
								System.exit(0);
							}
							if ((tgo - tFix1) == (tgo - tFix2)) {
								System.out.println("比賽結果：兩隊平手");
								System.out.println("比賽結束");
								System.exit(0);
							}

						}
					}

					distance1Fix = 0 - distance1;
					tFix1 = distance1Fix / speed1;
					System.out.println("");
					System.out.println("玩家一第" + number1 + "棒跑者跑了" + (speed1 * (tFix1)) + "公尺");
					System.out.println("剩餘距離" + "0.0");
					System.out.println("*玩家一完成比賽*");
					System.out.println("玩家二第" + number2 + "棒跑者跑了" + (speed2 * t2) + "公尺");
					System.out.println("剩餘距離" + distance2);
					System.out.println("");
					System.out.println("比賽時間" + (tgo - tFix1) + "秒");
					System.out.println("比賽結果：玩家一獲勝");
					System.out.println("比賽結束");
					System.exit(0);
				}
				distance1Fix = 0 - distance1;
				tFix1 = distance1Fix / speed1;
				System.out.println("");
				System.out.println("第" + (tgo - tFix1) + "秒時");
				System.out.println("玩家一第" + number1 + "棒接棒給" + "第" + (number1 + 1) + "棒");

				n1 = n1 + 1;
				P1 = P1runner.getRT(n1);
				number1 = number1 + 1;
				distance1 = 100;
				if (P1.equals("str")) {
					speed1 = P1runner.setSpeed("str");
					System.out.println("力量型");
					distance1 = distance1 - speed1 * (tFix1);
					System.out.println("");
					System.out.println("玩家一第" + number1 + "棒跑者跑了" + (speed1 * (tFix1)) + "公尺");
					System.out.println("剩餘距離" + distance1);

				} else {
					speed1 = P1runner.setSpeed("dex");
					System.out.println("敏捷型");
					distance1 = distance1 - speed1 * (tFix1);
					System.out.println("");
					System.out.println("玩家一第" + number1 + "棒跑者跑了" + (speed1 * (tFix1)) + "公尺");
					System.out.println("剩餘距離" + distance1);

				}
			} else if (distance1 > 0) {
				System.out.println("");
				System.out.println("玩家一第" + number1 + "棒跑者跑了" + (speed1 * t1) + "公尺");
				System.out.println("剩餘距離" + distance1);

			}

			///////////////////////////// 修正玩家二距離小於零
			if (distance2 < 0) {

				if (n2 == 5) {

					if (distance1 <= 0) {
						if (n1 == 5) {
							distance1Fix = 0 - distance1;
							tFix1 = distance1Fix / speed1;
							distance2Fix = 0 - distance2;
							tFix2 = distance2Fix / speed2;
							System.out.println("");
							System.out.println("*玩家一完成比賽*");
							System.out.println("比賽時間" + (tgo - tFix1) + "秒");
							System.out.println("");
							System.out.println("*玩家二完成比賽*");
							System.out.println("比賽時間" + (tgo - tFix2) + "秒");
							System.out.println("");
							if ((tgo - tFix1) > (tgo - tFix2)) {
								System.out.println("比賽結果：玩家二獲勝");
								System.out.println("比賽結束");
								System.exit(0);
							}

							if ((tgo - tFix1) < (tgo - tFix2)) {
								System.out.println("比賽結果：玩家一獲勝");
								System.out.println("比賽結束");
								System.exit(0);
							}
							if ((tgo - tFix1) == (tgo - tFix2)) {
								System.out.println("比賽結果：兩隊平手");
								System.out.println("比賽結束");
								System.exit(0);
							}

						}
					}

					distance2Fix = 0 - distance2;
					tFix2 = distance2Fix / speed2;
					System.out.println("");
					System.out.println("玩家二第" + number2 + "棒跑者跑了" + (speed2 * (tFix2)) + "公尺");
					System.out.println("剩餘距離" + "0.0");
					System.out.println("");
					System.out.println("*玩家二完成比賽*");
					System.out.println("比賽時間" + (tgo - tFix2) + "秒");
					System.out.println("比賽結果：玩家二獲勝");
					System.out.println("比賽結束");
					System.exit(0);
				}

				distance2Fix = 0 - distance2;
				tFix2 = distance2Fix / speed2;
				System.out.println("");
				System.out.println("第" + (tgo - tFix2) + "秒時");
				System.out.println("玩家二第" + number2 + "棒接棒給" + "第" + (number2 + 1) + "棒");

				n2 = n2 + 1;
				P2 = P2runner.getRT(n2);
				number2 = number2 + 1;
				distance2 = 100;
				if (P2.equals("str")) {
					speed2 = P2runner.setSpeed("str");
					System.out.println("力量型");
					distance2 = distance2 - speed2 * (tFix2);
					System.out.println("玩家二第" + number2 + "棒跑者跑了" + (speed2 * (tFix2)) + "公尺");
					System.out.println("剩餘距離" + distance2);

				} else {
					speed2 = P2runner.setSpeed("dex");
					System.out.println("敏捷型");
					distance2 = distance2 - speed2 * (tFix2);
					System.out.println("玩家二第" + number2 + "棒跑者跑了" + (speed2 * (tFix2)) + "公尺");
					System.out.println("剩餘距離" + distance2);

				}
			} else if (distance2 > 0) {
				System.out.println("玩家二第" + number2 + "棒跑者跑了" + (speed2 * t2) + "公尺");
				System.out.println("剩餘距離" + distance2);

			}
			////////////////////////////////////////// 確認剩餘距離是否為0
			if (distance1 == 0) {

				if (n1 == 5) {

					if (distance2 == 0 && n2 == 5) {

						distance2Fix = 0 - distance2;
						tFix2 = distance2Fix / speed2;
						System.out.println("");
						System.out.println("玩家一第" + number1 + "棒跑者跑了" + (speed1 * t1) + "公尺");
						System.out.println("剩餘距離" + distance1);
						System.out.println("玩家二第" + number2 + "棒跑者跑了" + (speed2 * t2) + "公尺");
						System.out.println("剩餘距離" + distance2);
						System.out.println("*玩家一與玩家二同時完成比賽*");
						System.out.println("比賽時間" + (tgo - tFix2) + "秒");
						System.out.println("比賽結果：兩隊平手");
						System.out.println("比賽結束");
						System.exit(0);

					}

					System.out.println("");
					System.out.println("玩家一第" + number1 + "棒跑者跑了" + (speed1 * t1) + "公尺");
					System.out.println("剩餘距離" + distance1);
					System.out.println("*玩家一完成比賽*");
					System.out.println("玩家二第" + number2 + "棒跑者跑了" + (speed2 * t2) + "公尺");
					System.out.println("剩餘距離" + distance2);
					System.out.println("");
					System.out.println("比賽時間" + (tgo) + "秒");
					System.out.println("比賽結果：玩家一獲勝");
					System.out.println("比賽結束");
					System.exit(0);
				}
				if (distance2 == 0 && n2 == 5) {
					System.out.println("");
					System.out.println("玩家一第" + number1 + "棒跑者跑了" + (speed1 * t1) + "公尺");
					System.out.println("剩餘距離" + distance1);
					System.out.println("*玩家二完成比賽*");
					System.out.println("玩家二第" + number2 + "棒跑者跑了" + (speed2 * t2) + "公尺");
					System.out.println("剩餘距離" + distance2);
					System.out.println("");
					System.out.println("比賽時間" + (tgo) + "秒");
					System.out.println("比賽結果：玩家二獲勝");
					System.out.println("比賽結束");
					System.exit(0);
				}

				P1 = P1runner.getRT(2);
				n1 = n1 + 1;
				System.out.println("");
				System.out.println("玩家一第" + number1 + "棒跑者跑了" + (speed1 * t1) + "公尺");
				System.out.println("剩餘距離" + distance1);
				System.out.println("玩家一跑者接棒");
				System.out.println("第" + number1 + "棒接棒給第" + (number1 + 1) + "棒");
				number1 = number1 + 1;
				distance1 = 100;

			}

			if (distance2 == 0) {

				if (n2 == 5) {

					if (distance1 == 0) {
						if (n1 == 5) {
							distance2Fix = 0 - distance2;
							tFix2 = distance2Fix / speed2;
							System.out.println("");
							System.out.println("玩家一與玩家二同時完成比賽");
							System.out.println("比賽時間" + (tgo - tFix2) + "秒");
							System.out.println("比賽結果：兩隊平手");
							System.out.println("比賽結束");
							System.exit(0);
						}
					}

					System.out.println("");
					System.out.println("玩家二第" + number2 + "棒跑者跑了" + (speed2 * t2) + "公尺");
					System.out.println("剩餘距離" + distance2);
					System.out.println("");
					System.out.println("*玩家二完成比賽*");
					System.out.println("比賽時間" + (tgo) + "秒");
					System.out.println("比賽結果：玩家二獲勝");
					System.out.println("比賽結束");
					System.exit(0);
				}

				P2 = P2runner.getRT(2);
				n2 = n2 + 1;
				System.out.println("");
				System.out.println("玩家二第" + number2 + "棒跑者跑了" + (speed2 * t2) + "公尺");
				System.out.println("剩餘距離" + distance2);
				System.out.println("玩家二跑者接棒");
				System.out.println("第" + number2 + "棒接棒給第" + (number2 + 1) + "棒");
				number2 = number2 + 1;
				distance2 = 100;

			}
			///////////////////////////////////////// 確認及顯示賽況結束
			///////////////////////////////////////// 開始下一輪選擇

			System.out.println("");
			System.out.println("玩家一請輸入欲使用的技能");
			skill1.useSkill(P2runner.getRT(n1));
			System.out.println("");
			System.out.println("玩家二請輸入欲使用的技能");
			skill2.useSkill(P1runner.getRT(n2));

			tgo = tgo + 5;
		}

	}// end of main
}// end of class