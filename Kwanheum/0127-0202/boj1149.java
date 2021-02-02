import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class boj1149 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		// N-1번까지의 최솟값 + 가능한 N번째 와
		// N-2번까지의 최솟값 + 다른 N-1 + 가능한 N번째
		int[] min = new int[N+1]; //1번~N번
		int[] r = new int[N+1];
		int[] g = new int[N+1];
		int[] b = new int[N+1];
		for(int i=1; i<=N; i++) {
			String x = br.readLine();
			StringTokenizer stk = new StringTokenizer(x);
			r[i] = Integer.parseInt(stk.nextToken());
			g[i] = Integer.parseInt(stk.nextToken());
			b[i] = Integer.parseInt(stk.nextToken());
		}
		//N번째의 색을 결정할 때 N-1의 집 컬러를 다 기억해서 결정하는건 너무 예외가 많다..
		//N번째의 색을 기준으로 생각해보자
		int[] r_end = new int[N+1];
		int[] g_end = new int[N+1];
		int[] b_end = new int[N+1];
		r_end[1] = r[1];
		g_end[1] = g[1];
		b_end[1] = b[1];
		for(int i=2; i<=N; i++) {
			r_end[i] = r[i]+ Math.min(g_end[i-1], b_end[i-1]);
			g_end[i] = g[i]+ Math.min(r_end[i-1], b_end[i-1]);
			b_end[i] = b[i]+ Math.min(g_end[i-1], r_end[i-1]);
		}
		System.out.println(Math.min(r_end[N], Math.min(g_end[N], b_end[N])));
		
	}//main
}
