package feb_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 평범한 배낭
 * 배열 index 유의, 2차원배열, 
 */
public class Main_12865 {
	
	public static void main(String[] args) throws IOException {
		int N, K;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		int dp[][]=new int[101][100001]; //idx에 해당하는 무게에서 가치의 최대치 , 

		for(int i=1; i<=N; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int weight=Integer.parseInt(st.nextToken());
			int value=Integer.parseInt(st.nextToken());
			//weight보다 작은 값은 그대로 물려받고, 
			for(int j=0; j<weight; j++) {
				dp[i][j]=dp[i-1][j];
			}
			//weight이상은 max 갱신
			for(int j=weight; j<=K; j++) {
				dp[i][j]=Math.max(dp[i-1][j-weight]+value, dp[i-1][j]);
			}
		}
		
		System.out.println(dp[N][K]);
	}//end of main
}//end of class

//저는 이 문제가 어려워서 풀지 못했어요 ㅠㅠ 동희님처럼 점화식을 이용한 간단한 문제였네요 다시 풀러가야겠어요 >_<
