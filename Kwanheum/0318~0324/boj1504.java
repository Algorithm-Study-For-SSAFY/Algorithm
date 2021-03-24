package algo_study_8w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1504 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N= Integer.parseInt(stk.nextToken());
		int E= Integer.parseInt(stk.nextToken());
		long[][] dist = new long[N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) dist[i][j] = 0;
				else dist[i][j] = Integer.MAX_VALUE;
			}
		}
		for(int i=0; i<E; i++) {
			stk = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(stk.nextToken());
			int b= Integer.parseInt(stk.nextToken());
			int c= Integer.parseInt(stk.nextToken());
			dist[a][b] = c;
			dist[b][a] = c;
		}

		stk = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(stk.nextToken());
		int v2 = Integer.parseInt(stk.nextToken());
		
		//F-W : 800^3
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);						
					
				}
			}
		}
		/*for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				System.out.print(dist[i][j]+" ");
			}
			System.out.println();
		}*/
		int max_val = Integer.MAX_VALUE;
		long a , b;
		a = dist[1][v1] + dist[v1][v2] + dist[v2][N];
		b = dist[1][v2] + dist[v2][v1] + dist[v1][N];
		long answer;
		if(a>=max_val && b>=max_val) answer=  -1;
		else if(a>=max_val) answer = b;
		else if(b>=max_val) answer = a;
		else {
			answer = Math.min(a, b);
		}
		
		System.out.println(answer);
		
	}//main
}
