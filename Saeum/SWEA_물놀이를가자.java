import java.io.*;
import java.util.*;

class Solution {
	static int n, m;
	static String[][] arr;
	static int[][] visit;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static Queue<Node> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new String[n][m];
			visit = new int[n][m];
			for (int i = 0; i < n; i++) {
				Arrays.fill(visit[i], -1);
			}

			queue = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				String str[] = br.readLine().split("");
				for (int j = 0; j < m; j++) {
					arr[i][j] = str[j];
					if (arr[i][j].equals("W")) {
						queue.add(new Node(i, j, 1));
						visit[i][j] = 0;
					}
				}
			}
			bfs();
			int sum = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (visit[i][j] != -1) {
						sum += visit[i][j];
					}
				}
			}

			sb.append("#" + tc + " " + sum + "\n");
		}
		System.out.println(sb.toString());
		br.close();
		System.exit(0);
	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			int qSize = queue.size();
			for (int j = 0; j < qSize; j++) {
				Node node = queue.poll();
				for (int i = 0; i < 4; i++) {
					int r = node.x + dr[i];
					int c = node.y + dc[i];
					int turn = node.turn;
					if (r < 0 || r >= n || c < 0 || c >= m)
						continue;
					if (visit[r][c] == -1) {
						queue.add(new Node(r, c, turn + 1));
						visit[r][c] = turn;
					}
				}
			}
		}
	}

	static class Node {
		int x;
		int y;
		int turn;

		Node(int x, int y, int turn) {
			this.x = x;
			this.y = y;
			this.turn = turn;
		}
	}
}