package algo_study_13w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj18429 {
	private static int N, K , answer;
	private static int[] weights;
	private static boolean[] used;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		stk = new StringTokenizer(br.readLine());
		weights = new int[N];
		for(int i=0; i<N; i++) {
			weights[i] = Integer.parseInt(stk.nextToken());
		}
		answer = 0;
		used = new boolean[N];
		comb(0, 500);
		System.out.println(answer);
	}
	static void comb(int cnt, int nowWeight) {
		if(cnt==N ) {
			answer++;
			return;
		}
		
		
		for(int i=0; i<N; i++) {
			if(!used[i]) {
				int tmp = nowWeight + weights[i] - K;
				if(tmp >= 500) {
					used[i] = true;
					comb( cnt+1, tmp);
					used[i] = false;
				}
			}
		}
	}
}
