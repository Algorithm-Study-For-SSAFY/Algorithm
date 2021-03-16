import java.io.*;
import java.util.*;

class point {

	int r;
	int c;

	point(int x, int y) {
		this.r = x;
		this.c = y;
	}

}

public class SWEA_미로2 {
	private static int[][] visited, miro;
	private static int sx, sy, ex, ey;
	private static boolean check;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			int c = Integer.parseInt(br.readLine()); 
			sb.append("#").append(c).append(" ");
			miro = new int[100][100];// 미로
			visited = new int[100][100];// 방문 여부

			// 미로 입력
			for (int i = 0; i < 100; i++) {
				String s = br.readLine();
				for (int j = 0; j < 100; j++) {
					miro[i][j] = s.charAt(j) - '0';
				}
			}

			// 시작점과 도착 점 찾기
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					if (miro[i][j] == 2) {// 시작
						sx = i;
						sy = j;
					} else if (miro[i][j] == 3) { // 도착
						ex = i;
						ey = j;
					}
				}
			}

			bfs(sx, sy);// 1,1 칸에서 출발
			if (check) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}
		System.out.println(sb);

	} 

	public static void bfs(int x, int y) {
		check = false;
		int[] dx = { -1, 0, 1, 0 }; 
		int[] dy = { 0, 1, 0, -1 }; 
		Queue<point> q = new LinkedList<>(); 
		q.offer(new point(x, y));// 처음
		visited[x][y] = 1;

		while (!q.isEmpty()) {
			int r = q.peek().r;
			int c = q.peek().c;
			if (r == ex && c == ey) {// 종료칸에 도달 시
				check = true;
				return;// 종료
			}
			q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = r + dx[i];
				int nc = c + dy[i];
				// 조건
				if (nr >= 0 && nr < 100 && nc >= 0 && nc < 100 && miro[nr][nc] != 1 && visited[nr][nc] == 0) {
					visited[nr][nc] = 1; 
					q.offer(new point(nr, nc));// 새로운 값 삽입
				}
			}

		}

	}

}