package feb_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 조 짜기
 * DP 이용 : dp[1], dp[2] 는 같은 조일 때가 무조건 최선,
 * dp[3] 부터는 앞에 있는 그룹 수만큼 for문을 돌면서 dp 값과 최대, 최솟값을 이용하여 값을 갱신
 * 그룹수를 기억하고 있어야 하므로 tmpidx 변수만들어서 갱신시켜주기
 */
public class Main_2229 {
	static int N, answer;
	static int arr[];
	static boolean visit[];
	static int dp[];
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		arr=new int[N+1];
		dp=new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		dp[1]=0; //첫번째 원소 그룹은 1개밖에 없다.
		if(N>=1) dp[2]=Math.abs(arr[2]-arr[1]);
		
		int idx=2; //전 그룹의 갯수
		for(int i=3; i<=N; i++) { //3번째 이상의 모든 원소에 대해서 검사 시작

			//해당 원소 전그룹들과 max, min 조사해보기
			int tmpidx=0;
			for(int j=i-1; j>=i-idx && j>=1; j--) { //원소가 2개, 3개,,,,,idx개
				int max=Integer.MIN_VALUE; int min=Integer.MAX_VALUE;
				for(int k=j; k<=i; k++) {
					max=Math.max(max, arr[k]);
					min=Math.min(min, arr[k]);
				}
				if(max-min+dp[j-1]>dp[i]) { //값 갱신이 가능하면,
					dp[i]=max-min+dp[j-1];
					tmpidx=i-j+1; //임시로 그룹 원소갯수 저장해놓기,
				}
			}
			if(dp[i-1]>dp[i]) {//따로 떨어져 나오는게 나으면
				dp[i]=dp[i-1]; tmpidx=1;
			}
			idx=tmpidx;
			
		}
	
		System.out.println(dp[N]);
	}
	
}
