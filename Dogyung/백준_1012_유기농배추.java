package al_2주차;

import java.util.Scanner;

public class Main_백준_1012_유기농배추 {
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };// 상하좌우
	static int farm[][];
	static boolean check[][];

	private static int M;
	private static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			M = sc.nextInt(); // 밭 가로
			N = sc.nextInt(); // 밭 세로
			int K = sc.nextInt(); // 배추 개수
			farm = new int[N][M]; // 농장의 배열
			check = new boolean[N][M];

			for (int i = 0; i < K; i++) {
				int X = sc.nextInt(); // 배추위치 행
				int Y = sc.nextInt();// 배추 위치 열
				farm[Y][X] = 1;

			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (farm[i][j] == 1 && !check[i][j]) {
						check[i][j] = true;
						move(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);

		} // end of tc
	}// end of main

	static void move(int i, int j) {
		int nr = 0;
		int nc = 0;
		for (int d = 0; d < 4; d++) {
			nr = i + dr[d];
			nc = j + dc[d];

			if (nr >= 0 && nr < N && nc >= 0 && nc < M && !check[nr][nc] && farm[nr][nc] == 1) {
				check[nr][nc] = true;
				move(nr, nc);

			}

		}
		return;
	}

}// end of class
