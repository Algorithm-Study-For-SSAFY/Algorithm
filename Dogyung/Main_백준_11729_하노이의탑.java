package Back;

import java.util.Scanner;

public class Main_백준_11729_하노이의탑 {

	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println((int) Math.pow(2, n) - 1);
		hanoi(n, 1, 2, 3);

	}

	private static void hanoi(int cnt, int from, int temp, int to) {

		if (cnt == 0)
			return;

		// n-1개 원판 이동

		hanoi(cnt - 1, from, to, temp);

		System.out.println(from + " " + to);
		
		hanoi(cnt - 1, temp, from, to);

	}

}

