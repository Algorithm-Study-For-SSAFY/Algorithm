package algo_study_10w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11052 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int [] p = new int [n+1];
		for(int i=1; i<=n; i++) {
			p[i] = Integer.parseInt(stk.nextToken());
		}
		
		int [] max = new int [n+1];
		max[1] = p[1];
		for(int i=2; i<=n; i++) {
			max[i] = p[i];
			for(int j=1; j<i; j++) {
				max[i] = Math.max(max[i], max[j] + p[i-j]);
			}
		}
		System.out.println(max[n]);
	}
}
