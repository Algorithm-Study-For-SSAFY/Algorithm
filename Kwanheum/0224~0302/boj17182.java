package algo_study_5w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj17182 {
	private static int[][] arr;
	private static int K;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		//Input End
		
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
				}
			}
		}
		//플로이드 워셜. 노드간의 최단 거리 계산할 수 있는 알고리즘
		
		chk = new boolean[N];
		answer = Integer.MAX_VALUE;
		chk[K] = true;
		func(K, 0, 0);
		System.out.println(answer);
	}//main
	
	static boolean[] chk;
	static int answer;
	static void func(int now,int visit_cnt , int time) {
		if(visit_cnt == N-1) {
			answer = Math.min(answer, time);
			return;
		}
		for(int i=0; i<N; i++) {
			if(i != now) {
				if(!chk[i]) {
					chk[i] = true;
					func(i, visit_cnt+1, time+arr[now][i]);
					chk[i] = false;
				}
			}
		}//for
	}//func
}
