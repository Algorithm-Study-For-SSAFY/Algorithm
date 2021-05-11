package algo_study_13w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj16987 {
	private static int N;
	private static boolean[] breaked;
	private static int[] ws;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer stk = null;
		int d , w;
		int[] ds = new int[N];
		ws = new int[N];
		for(int i=0;i<N;i++) {
			stk = new StringTokenizer(br.readLine());
			d = Integer.parseInt(stk.nextToken());
			w = Integer.parseInt(stk.nextToken());
			ds[i] = d;
			ws[i] = w;
		}
		breaked = new boolean[N];
		answer = 0;
		DFS(0 , ds);
		System.out.println(answer);
	}
	private static int answer;
	static void DFS(int idx, int[] ds) {
		
		
		if(idx==N) {
			int tmp= 0;
			for(int i=0; i<N; i++) {
				if(breaked[i]) tmp++;
			}
			answer = Math.max(answer, tmp);
			return;
		}
		
		if(breaked[idx]) {
			DFS(idx+1, ds);
			return;
		}
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(i==idx) continue;
			if(!breaked[i]) {
				cnt++;
				int[] newds = new int[N];
				for(int j=0; j<N; j++) {
					newds[j] = ds[j];
				}
				
				newds[idx] -= ws[i];
				newds[i] -= ws[idx];
				if(newds[i]<=0) breaked[i] = true;
				if(newds[idx]<=0) {
					breaked[idx] = true;
					DFS(idx+1, newds);
					breaked[idx] = false;
				}else {
					DFS(idx+1 , newds);
				}
				if(newds[i]<=0) breaked[i] = false; //원복
			}
		}//for
		if(cnt == 0) {
			DFS(idx+1 , ds);
		}
	}
}
