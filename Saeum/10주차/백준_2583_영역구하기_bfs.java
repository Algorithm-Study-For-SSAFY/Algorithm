package BFS_DFS;
import java.io.*;
import java.util.*;

class point {
	int x;
	int y;

	public point(int x, int y) {
		this.x = x;
		this.y = y;

	}
}

public class 백준_2583_영역구하기_bfs {

	static int K;
	static int N;
	static int M;
	static boolean[][] visit;
	static int[][] map;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static int count;
	static List<Integer> results = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		visit = new boolean[M][N];
		ArrayList<Integer> list = new ArrayList<>();

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int y1 = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());

			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					map[i][j] = 1;// 속한 부분은 1로 표시하기

				}
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j] && map[i][j] == 0) {
					bfs(i, j);
				}
			}
		}
		Collections.sort(results); // arraylist results에 넣어서 정렬

		for (int number : results) {
			sb.append(number).append(" ");
		}

		System.out.println(results.size());
		System.out.println(sb.toString().trim());

	} // end of main

	private static void bfs(int i, int j) {
		Queue<point> q = new LinkedList<point>();
		q.offer(new point(i, j));
		visit[i][j] = true;
		int count = 0;

		while (!q.isEmpty()) {
			point po = q.poll();
			count++;

			for (int k = 0; k < 4; k++) {
				int nx = po.x + dx[k];
				int ny = po.y + dy[k];

				if (nx >= 0 && ny >= 0 && nx < M && ny < N && !visit[nx][ny] && map[nx][ny] == 0) {
					q.offer(new point(nx, ny));
					visit[nx][ny] = true;
				}
			}
		}
		results.add(count);
	}
} // end of class
