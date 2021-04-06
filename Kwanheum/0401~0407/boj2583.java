package algo_study_10w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj2583 {
	private static int m;
	private static int n;
	private static int[][] Big;
	private static boolean[][] visited;
	private static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		m = Integer.parseInt(stk.nextToken());
		n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		Big = new int[m][n];
		for (int i = 0; i < k; i++) {
			stk = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(stk.nextToken()); //x좌표
			int r1 = Integer.parseInt(stk.nextToken()); //y좌표
			int c2 = Integer.parseInt(stk.nextToken());
			int r2 = Integer.parseInt(stk.nextToken());
			for(int r=r1; r<r2; r++) {
				for(int c=c1; c<c2; c++) {
					Big[r][c] = 1;
				}
			}
		}
		//input end
		visited = new boolean[m][n];
		ArrayList<Integer> answer = new ArrayList<>();
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j] && Big[i][j] ==0) {
					cnt = 0;
					dfs(i,j);
					answer.add(cnt);
				}
			}
		}
		answer.sort((a,b) -> {return a-b;} );
		int len = answer.size();
		System.out.println(len);
		for(int i=0; i<len ;i++) {
			System.out.print(answer.get(i)+" ");
		}
	}
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	static void dfs(int r, int c) {
		visited[r][c] = true;
		cnt++;
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr>=0 && nr<m && nc>=0 && nc<n) {
				if(!visited[nr][nc] && Big[nr][nc] ==0) {
					dfs(nr, nc);
				}
			}
		}
	}
}
