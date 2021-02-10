import java.util.*;

public class 백준_1012_유기농배추 { // =2667 단지 번호 붙이기도 풀어봐야징
	static int map[][];
	static boolean visit[][];
	static int count; // 배추 흰지렁이 수
	static int M, N, K, x, y; // 가로, 세로, 배추 개수, 배추 위치
	static int dx[] = { 0, -1, 0, 1 }; // 상하좌우
	static int dy[] = { -1, 0, 1, 0 }; // 상하좌우

	public static void dfs(int y, int x) {
		visit[y][x] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
				if (map[ny][nx] == 1 && !visit[ny][nx]) {
					dfs(ny, nx);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int i = 0; i < TC; i++) {
			M = sc.nextInt(); // 가로가로
			N = sc.nextInt(); // 세로
			K = sc.nextInt(); // 배추 수
			map = new int[N][M];
			visit = new boolean[N][M];
			count = 0;

			for (int j = 0; j < K; j++) {
				int a = sc.nextInt(); // 가로
				int b = sc.nextInt(); // 세로
				map[b][a] = 1;
			}

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[j][k] == 1 && visit[j][k] == false) {
						dfs(j, k);
						count++;
					}
				}
			}
			System.out.println(count);
		}

	}
}

// 깔끔합니다!
