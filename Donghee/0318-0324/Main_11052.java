package March_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11052 {
	private static int map[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		map=new int[N+1];
		for(int i=1; i<=N; i++) {
			map[i]=Integer.parseInt(st.nextToken());
		}
		int dp[]=new int[N+1];
		
		for(int i=1; i<=N; i++) {
			//i보다 작게
			//기본값 , 자기자신
			dp[i]=map[i];
			for(int j=i-1; j>0; j--) {
				dp[i]=Math.max(dp[i], map[j]+dp[i-j]);
			}
		}
		System.out.println(dp[N]);
	}
}
