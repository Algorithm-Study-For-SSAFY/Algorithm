package BFS_DFS;
import java.io.*;
import java.util.*;

class danji {
	int x;
	int y;

	public danji(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class 백준_2667_단지번호붙이기_bfs {

	static int N;
	static int[][] arr;
	static boolean[][] visit;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static ArrayList<Integer> result = new ArrayList<>();
	static int totalHouse =0;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N][N];
		 
 
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1 && !visit[i][j]) {
					bfs(i, j);
				}
			}
		}
		// 단지수 카운트
		System.out.println(totalHouse);
		Collections.sort(result);
		for (int num : result) {
			System.out.println(num);
		}

	} // end of main

	private static void bfs(int x, int y) {
		Queue<danji> q = new LinkedList<danji>();
		int numberHouse = 0; // 집 개수
		q.offer(new danji(x, y)); //q에 넣고
		visit[x][y] = true; //방문체크
		totalHouse++;
		numberHouse++;

		while (!q.isEmpty()) {
			danji dan = q.poll();

			for (int k = 0; k < 4; k++) {
				int nx = dan.x + dx[k];
				int ny = dan.y + dy[k];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[nx][ny] && arr[nx][ny] == 1) {
					q.offer(new danji(nx, ny));
					visit[nx][ny] = true;
					numberHouse++;
				}
			}
		}
		result.add(numberHouse);
	}
} // end of class
