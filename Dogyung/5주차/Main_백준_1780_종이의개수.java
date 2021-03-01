package al_5주차;

import java.util.Scanner;

public class Main_백준_1780_종이의개수 {
	private static int N;
	private static int[][] map;
	private static int[] cnt =new int [3];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		} // 입력 받기 완료 //

		divide(0, 0, N);
		System.out.println(cnt[0]);
		System.out.println(cnt[1]);
		System.out.println(cnt[2]);

	} // end of main

	private static void divide(int row, int col, int N) {
		if (check(row, col, N)) { //N*N이 다 동일
			cnt[map[row][col]+1]++; // 개수 세기 
		} else {
			int nine = N / 3; //3.3 등분 
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					divide(row + nine * i, col + nine * j, nine);
				}
			}
		}
	}

	private static boolean check(int row, int col, int N) {
		int now = map[row][col];
		for (int i = row; i < row + N; i++) {
			for (int j = col; j < col + N; j++) {
				if (now != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
} // end of class
