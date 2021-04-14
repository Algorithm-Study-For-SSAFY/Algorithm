package algo_study_11w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj17070 {
	private static int[][] map;
	private static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer stk = null;
		map = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		//input end
		answer = 0;
		func(new pos(1,1,1,2, 0)); // (1,1) , (1,2) , 가로방향
		System.out.println(answer);
	
	}
	static int[] dr = {0, 1, 1};
	static int[] dc = {1, 1, 0};
	static int answer;
	static void func(pos X) {
		if(X.r2==N && X.c2 ==N) {
			answer++;
			return;
		}
		for(int i=0; i<3; i++) {
			if((X.dir==0 && i==2) || (X.dir==2&&i==0))continue;
			int nr = X.r2 + dr[i];
			int nc = X.c2 + dc[i];
			if(nr>=1&&nr<=N&&nc>=1&&nc<=N&&map[nr][nc] ==0 ) {
				if(i==1) {
					if( !(map[nr-1][nc]==0 && map[nr][nc-1]==0) ) {
						continue;
					}
				}
				func(new pos(X.r2, X.c2, nr, nc, i));
			}
		}
	}
	
	static class pos{
		int r1, c1, r2, c2 , dir;

		public pos(int r1, int c1, int r2, int c2, int dir) {
			super();
			this.r1 = r1;
			this.c1 = c1;
			this.r2 = r2;
			this.c2 = c2;
			this.dir = dir;
		}
		
	}
}
