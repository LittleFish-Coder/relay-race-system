package hw3;

import java.util.Scanner;

public class skill {
	public int skillInf1;
	public int skillInf2;
	int distance;
	int count2 = 0;
	int count4 = 0;
	char r = '-';
	int p = 0;
	int a = 1;
	int s1;
	int s2;
	String skillPlayer;
	int S1use;
	int S2use;

	public void setSkill() {// 初始技能
		while (a > 0) {

			count2 = 0;
			System.out.println("技能選擇");
			Scanner scanner = new Scanner(System.in);// 使用者輸入指令
			skillPlayer = scanner.nextLine();
			if (!(skillPlayer.length() == 3)) { // 判斷指令格式
				System.out.println("字數輸入錯誤，請重新輸入(長度應為3)");
				continue;
			}
			for (int i = 0; i < skillPlayer.length(); i++) {
				char g = skillPlayer.charAt(i);
				if (g == r)
					count2++;
			}
			if (!(count2 == 1)) {
				System.out.println("符號輸入錯誤，請重新輸入(應包含一個減號)");
				continue;
			}

			char check = skillPlayer.charAt(1);
			if (!(check == ('-'))) {
				System.out.println("符號輸入錯誤，請重新輸入(減號應位於第二個位置)");
				continue;
			}

			String[] AfterSplitS1 = skillPlayer.split("-");
			try {
				s1 = Integer.parseInt(AfterSplitS1[0]);
				s2 = Integer.parseInt(AfterSplitS1[1]);
			} catch (NumberFormatException e) {
				System.out.println("指令應為數字，請重新輸入");
				continue;
			}
			if (!(s1 + s2 == 5)) {
				System.out.println("技能總數應為5，請重新輸入");
				continue;
			} else {
				a--;
			}
		}
	}
	////////////// end of set skill/////////////////

	public void useSkill(String runnerType) {// 使用技能
		String skillUse;
		int p = 1;
		skillInf1 = 0;
		skillInf2 = 0;
		while (p > 0) {
			count4 = 0;

			System.out.println("冰凍技能剩餘數量：" + s1);// 顯示技能剩餘量
			System.out.println("力場技能剩餘數量：" + s2);// 顯示技能剩餘量
			Scanner scanner = new Scanner(System.in);// 使用者輸入指令
			skillUse = scanner.nextLine();

			if (!(skillUse.length() == 3)) {
				System.out.println("字數輸入錯誤，請重新輸入(長度應為3)");
				continue;
			}

			for (int i = 0; i < skillUse.length(); i++) {
				char o = skillUse.charAt(i);
				if (o == r) {
					count4++;
				}
			}
			if (!(count4 == 1)) {
				System.out.println("符號輸入錯誤，請重新輸入(應包含1個減號)");
				continue;
			}

			char check = skillUse.charAt(1);
			if (!(check == ('-'))) {
				System.out.println("符號輸入錯誤，請重新輸入(指令第2個位置應為減號)");
				continue;
			}

			String[] AfterSplitSUse = skillUse.split("-");

			p = 0;
			int S1use = 0;
			int S2use = 0;
			try {
				S1use = Integer.parseInt(AfterSplitSUse[0]);
				S2use = Integer.parseInt(AfterSplitSUse[1]);
			} catch (NumberFormatException e) {
				System.out.println("需輸入數字，請重新輸入");
				p++;
				continue;
			}
			if (!(S1use <= s1 && S2use <= s2)) {
				System.out.println("使用量需小於剩餘數量，請重新輸入(若技能都無剩餘請輸入0-0)");
				p++;
				continue;
			}

			else if (!(S1use < 2 && S2use < 2)) {
				System.out.println("每回合每項最多使用1次，請重新輸入(僅能輸入0-0,1-0,0-1,或1-1)");
				p++;
				continue;
			} else {

				s1 = s1 - S1use;
				s2 = s2 - S2use;

				if (S1use == 1) {
					skillInf1 = 1;
					System.out.println("使用冰凍技能");
				}
				if (S2use == 1) {
					skillInf2 = 1;
					System.out.println("使用力場技能");
				}
			}
		} // end of while
	}
}///// end of class
