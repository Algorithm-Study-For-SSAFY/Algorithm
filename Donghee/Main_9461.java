package feb_01;

import java.util.Scanner;

//파도반 수열
/*dp[1]~dp[5]까지 1,1,1,2,2 값 저장
 * dp[6]=dp[5]+dp[1]
 */

public class Main_9461 {
	static long dp[]=new long[101];
	private static void calc(int n) {
		dp[1]=1;
		dp[2]=1;
		dp[3]=1;
		dp[4]=2;
		dp[5]=2;
		for(int i=6; i<=n; i++)
			dp[i]=dp[i-1]+dp[i-5];
	}
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N=sc.nextInt();
			calc(N);
			System.out.println(dp[N]);
			
		}
	}//end of main
}//end of class
