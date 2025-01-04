package hw3;
import java.util.Scanner;

public class runner {
	public int distance = 100;
	public int speed;
	int a = 0;
	int b = 1;
	int count = 0;
	char r = '-';
	String runPlayer1;
	String[] runnerP1 = new String[5];
	String[] runnerP2 = new String[5];
	String runnertype;

	public void setRunner() {
		while (b > 0) {
			count = 0;

			System.out.println("請輸入跑者代碼");
			Scanner scanner = new Scanner(System.in);// 使用者輸入指令
			runPlayer1 = scanner.nextLine();

			if (!(runPlayer1.length() == 19)) {
				System.out.println("輸入錯誤，請重新輸入(字元數應為19)");
				continue;
			}

			for (int i = 0; i < runPlayer1.length(); i++) {
				char d = runPlayer1.charAt(i);
				if (d == r) {
					count++;
				}
			}
			if (!(count == 4)) {
				System.out.println("輸入錯誤，請重新輸入(指令應包含4個減號'-')");
				continue;
			}

			String[] AfterSplitP1 = runPlayer1.split("-");

			b = 0;
			for (a = 0; a < 5; a++) {
				if (!((AfterSplitP1[a].equals("str")) || (AfterSplitP1[a].equals("dex")))) {
					System.out.println("跑者代碼輸入錯誤，請重新輸入(代碼應為str或dex)");

					b++;
					break;
				} else
					continue;
			} // end of for

			runnerP1[0] = AfterSplitP1[0];
			runnerP1[1] = AfterSplitP1[1];
			runnerP1[2] = AfterSplitP1[2];
			runnerP1[3] = AfterSplitP1[3];
			runnerP1[4] = AfterSplitP1[4];

		} // end of while

	}

	public void getRunnerType(int number) {
		if (number == 1) {
			System.out.println(runnerP1[0]);

		}
		if (number == 2) {
			System.out.println(runnerP1[1]);

		}
		if (number == 3) {
			System.out.println(runnerP1[2]);

		}
		if (number == 4) {
			System.out.println(runnerP1[3]);

		}
		if (number == 5) {
			System.out.println(runnerP1[4]);

		}

	}

	public int setSpeed(String runnerType) {
		if (runnerType.equals("str")) {
			speed = 10;
		} else if (runnerType.equals("dex")) {
			speed = 20;
		} else {
			System.out.println("輸入錯誤");
		}
		return speed;
	}

	public String getRT(int t) {
		return runnerP1[t - 1];
	}

}