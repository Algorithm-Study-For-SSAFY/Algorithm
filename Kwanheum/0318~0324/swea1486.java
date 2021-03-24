package algo_study_8w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1486 {
	private static int N;
	private static int B;
	private static int[] height;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk = null;
		for(int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			stk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stk.nextToken());
			B = Integer.parseInt(stk.nextToken());
			
			stk = new StringTokenizer(br.readLine());
			height = new int[N];
			for(int i=0; i<N; i++) {
				height[i] = Integer.parseInt(stk.nextToken());
			}
			// 합에 포함 or 불포함 ,, 2^20일듯
			answer = Integer.MAX_VALUE;
			func(0 , 0 );
			sb.append(answer).append("\n");
		}	
		System.out.println(sb);
	}//main
	static int answer;
	static void func(int cnt, int sum) {
		if(sum >= B) {
			answer = Math.min(sum - B, answer);
			return;
		}
		if(cnt == N) {
			return;
		}
		
		func(cnt+1, sum+height[cnt]);
		func(cnt+1, sum);
	}
}
