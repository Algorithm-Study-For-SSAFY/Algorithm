package algo_study_5w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj9205 {
	private static pos festival;
	private static pos[] conv;
	private static pos home;
	private static boolean flag;
	private static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<T; t++) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer stk = new StringTokenizer(br.readLine());
			home = new pos(stk.nextToken(), stk.nextToken());
			conv = new pos[n];
			for(int i=0; i<n; i++) {
				stk = new StringTokenizer(br.readLine());
				conv[i] = new pos(stk.nextToken(), stk.nextToken());
			}
			stk = new StringTokenizer(br.readLine());
			festival = new pos(stk.nextToken(), stk.nextToken());
			
			flag = false;
			visited_chk = new boolean[n];
			func(home);
			if(flag) sb.append("happy\n");
			else sb.append("sad\n");
		}
		System.out.println(sb);
	}//main
	
	static boolean[] visited_chk;
	static void func(pos from) {
		if(distance(from, festival) <= 1000) {
			flag = true;
			return;
		}
		
		if(flag) return;
		for(int i=0; i<n; i++) {
			if(!visited_chk[i] && distance(from, conv[i]) <=1000 ) {
				visited_chk[i] = true;
				func(conv[i]);
				//visited_chk[i] = false;
			}
		}
	}
	
	
	static class pos{
		int x, y;
		public pos(String x, String y) {
			super();
			this.x = Integer.parseInt(x);
			this.y = Integer.parseInt(y);
		}
		
	}
	
	static int distance(pos A , pos B) {
		return Math.abs(A.x - B.x) + Math.abs(A.y - B.y);
	}
}
