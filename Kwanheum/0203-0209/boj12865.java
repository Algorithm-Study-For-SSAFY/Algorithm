import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj12865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken()); //버틸 수 있는 무게
		
		s[] arr = new s[N];
		for(int n=0; n<N; n++) {
			stk = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(stk.nextToken());
			int v = Integer.parseInt(stk.nextToken());
			arr[n] = new s(w, v);
		}//N
		Arrays.sort(arr);
		int[][] dp = new int[N+1][K+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<= K; j++) {
				int weight = arr[i-1].w;
				int value = arr[i-1].v;
				if(weight <=j) {
					dp[i][j] = Math.max( dp[i-1][j], value + dp[i-1][j-weight] );
					// i번째 원소를 더하지 않은값과, 더하고 그 무게만큼 적을때의 값을 더한 값을 비교
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
		}
		int answer = 0;
		for(int i=1; i<=N; i++) {
			answer = Math.max(answer, dp[i][K]);
		}
		System.out.println(answer);
		
	}//main

	
}// class
class s implements Comparable{
	int w;
	int v;
	public s(int w, int v) {
		super();
		this.w = w;
		this.v = v;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		s cmp = (s) o;
		return this.w - cmp.w;
	}
	
}
