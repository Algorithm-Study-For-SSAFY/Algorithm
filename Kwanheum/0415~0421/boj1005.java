package algo_study_12w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1005 {
	private static ArrayList<ArrayList<Integer>> l ;
	private static int[] buildTime;
	private static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer stk = null;
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			stk = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stk.nextToken());
			int K = Integer.parseInt(stk.nextToken());
			
			stk = new StringTokenizer(br.readLine());
			buildTime= new int[N+1]; // 0 is dummy
			for(int i=1; i<=N; i++) {
				buildTime[i] = Integer.parseInt(stk.nextToken());
			}
			l = new ArrayList<>();
			for(int i=0; i<=N; i++) {
				l.add(new ArrayList<>());
			}
			for(int i=0; i<K; i++) {
				stk =new StringTokenizer(br.readLine());
				int X = Integer.parseInt(stk.nextToken());
				int Y = Integer.parseInt(stk.nextToken());
				l.get(Y).add(X);
			}
			int W = Integer.parseInt(br.readLine());
			//input end
			
			mem = new int[N+1];
			Arrays.fill(mem, -1);
			dp(W);
			sb.append(mem[W]).append("\n");
		}
		System.out.println(sb);
	}//main
	static int mem[];
	static int dp(int start) {
		if(mem[start]!=-1) {
			return mem[start];
		}
		int tmp = 0;
		int len = l.get(start).size();
		if(len == 0 ) {
			return mem[start] = buildTime[start];
		}
		for(int i=0; i<len; i++) {
			int next = l.get(start).get(i);
			tmp = Math.max(dp(next)+buildTime[start], tmp);
		}
		return mem[start] = tmp;
	}
	
	
	
	
	
	
}
