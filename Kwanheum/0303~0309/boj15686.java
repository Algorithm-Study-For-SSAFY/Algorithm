package algo_study_6w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj15686 {
	private static int N;
	private static int M;
	private static int[][] arr;
	private static int[][] dist;
	private static ArrayList<pos> chicken;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		
		arr = new int[N+1][N+1];
		dist = new int[N+1][N+1];
		for(int i=1; i<=N;i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		
		chicken = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			stk =new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
				if(arr[i][j] == 2) {
					chicken.add(new pos(i,j));
				}
			}
		}
		chk = new boolean[chicken.size()];
		answer = Integer.MAX_VALUE;
		comb(0, 0);
		System.out.println(answer);
	
	}
	static boolean chk[];
	static int answer;
	static void comb(int start, int cnt) {
		int size = chicken.size();
		if(cnt == M) {
			//arr을 돌면서 chk의 true인 치킨집 M개에 대해  치킨거리 구하기
			int tmp_sum = 0;
			for(int i=1; i<=N;i++) {
				for(int j=1; j<=N; j++) {
					if(arr[i][j]==1) {
						int tmp_dist = Integer.MAX_VALUE;
						for(int c=0; c<size; c++) {
							if(chk[c]) {
								pos now = chicken.get(c);
								tmp_dist =Math.min(tmp_dist, Math.abs(now.r-i) + Math.abs(now.c-j));
								
							}
						}//for c
						tmp_sum += tmp_dist;
					}
				}
			}
			answer = Math.min(answer, tmp_sum);
			return;
		}
		
		for(int i=start; i<size; i++) {
			chk[i] = true;
			comb(i+1, cnt+1);
			chk[i] = false;
		}
	}
	
	
	
	static class pos{
		int r, c;
		public pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
}
