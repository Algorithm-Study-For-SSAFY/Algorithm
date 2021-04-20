package algo_study_12w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj2667 {
	private static int[][] map;
	private static boolean[][] visited;
	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0; i<N;i++) {
			String x = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = x.charAt(j)-'0';
			}
		}
		//input end
		visited = new boolean[N][N];
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i=0; i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					int tmp = bfs(i,j);
					answer.add(tmp);
				}
			}
		}
		answer.sort((a, b) -> {return a-b;});
		int len=answer.size();
		System.out.println(len);
		for(int i=0;  i<len ;i++) {
			System.out.println(answer.get(i));
		}
	}//main
	static int[]dr = {-1, 0, 1, 0};
	static int[]dc = {0, 1, 0, -1};
	static int bfs(int r, int c) {
		Queue<pos> q = new LinkedList<>();
		q.offer(new pos(r,c));
		visited[r][c] = true;
		int tmp = 1;
		while(!q.isEmpty()) {
			pos now = q.poll();
			for(int i=0; i<4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				if(nr>=0&&nr<N &&nc>=0&&nc<N && map[nr][nc]==1 && !visited[nr][nc]) {
					q.offer(new pos(nr, nc));
					visited[nr][nc] = true;
					tmp++;
				}
			}
		}
		return tmp;
	}//bfs
	static class pos{
		int r, c;

		public pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
}
