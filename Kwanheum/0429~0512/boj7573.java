package algo_study_13w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj7573 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int L =Integer.parseInt(stk.nextToken());
		int M =Integer.parseInt(stk.nextToken());
		boolean[][] map = new boolean[N+1][N+1];
		int[] rowArr = new int[M];
		int[] colArr = new int[M];
		for(int i=0; i<M;i++) {
			stk = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken());
			map[r][c] = true;
			rowArr[i] = r;
			colArr[i] = c;
		}
		
		
		
		int answer = 0;
		for(int ri=0; ri<M; ri++) {
			for(int ci=0; ci<M; ci++) {
				int r = rowArr[ri];
				int c = colArr[ci];
				for(int k=1; k<L/2; k++) {
					int cnt = 0;
					int x = k;
					int y = (L/2)-x;
					for(int h=r; h<=r+y; h++) {
						for(int w=c; w<=c+x; w++) {
							if(h>N || w>N) continue;
							if(map[h][w]) cnt++;
						}
					}
					answer = Math.max(answer, cnt);
				}
			}
		}
		System.out.println(answer);
	}
}
