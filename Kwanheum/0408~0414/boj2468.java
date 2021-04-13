package algo_study_11w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2468 {
	private static boolean[][] chk;
	private static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer stk= null;
		int map[][] = new int[N][N];
		int maxH = 0;
		for(int i=0; i<N; i++) {
			stk = new StringTokenizer(br.readLine());
			for( int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				maxH = Math.max(maxH, map[i][j]);
			}
		}
		//input end
		int maxArea = 1;
		for(int h=1; h<maxH; h++) {
			chk = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] <= h) {
						chk[i][j] = true;
					}
				}
			}
			
			int area = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!chk[i][j]) {
						dfs(i,j);
						area++;
					}
				}
			}
			
			maxArea = Math.max(maxArea, area);
		}// h
		System.out.println(maxArea);
	}//main
	static int []dr = {-1, 0, 1, 0};
	static int []dc = {0, 1, 0, -1};
	static void dfs(int r, int c) {
		
		chk[r][c] = true;
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr>=0 && nr<N && nc>=0 && nc<N) {
				if(!chk[nr][nc]) {
					dfs(nr, nc);
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
