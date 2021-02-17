import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2229 {
	private static int N;
	private static int[] arr;
	private static int answer = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		//Solution2. memoization
		int[] dp = new int[N];
		dp[0] = 0;
		for(int i=1; i<N; i++) { //어디서 나눠야하는지 일일히 저장하지말고 최대값만 기억해놓자.
			int max = 0;
			int min = 10000+1;
			for(int k=i; k>=0; k--) { //최대 N^2 ( N<=1000)
				max = Math.max(max, arr[k]);
				min = Math.min(min, arr[k]);
				if(k==0) dp[i] = Math.max(dp[i], max - min  + 0);
				else dp[i] = Math.max(dp[i], max - min  + dp[k-1]);
			}
		}
		

		System.out.println(dp[N-1]);
	}
	
	/*Solution 1. 칸막이개념 . 시간초과
	 * private static int N;
	private static int[] arr;
	private static boolean[] divide;
	private static int answer = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		divide= new boolean[N];
		divide[N-1] = true; //N-1번째 칸막이는 항상 존재
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		// 적절하게 조를 나눠서 조 안에서의 최대값 - 최소값 이 Max가 되도록
		// 2 5 7 1 3 4 8 6 9 3
		//  | | | | | | | | | |칸막이가 있거나 없거나로 생각할수있을듯? -> 2^n
		Subset(1);
		System.out.println(answer);
	}
	static void Subset(int cnt) {
		if(cnt >= N-1) { //만들어야할 칸막이는 N-1개, 마지막숫자끝에는 항상칸막이가있음
			int total_sum = 0;
			int max = 0;
			int min = 10000+1; //점수 최대값보다 크게
			for(int i=0; i<N; i++) { 
				max = Math.max(max, arr[i]);
				min = Math.min(min, arr[i]);
				if(divide[i]) {
					total_sum += max-min;
					max = 0;
					min = 10000+1;
				}
			}
			answer = Math.max(answer, total_sum);
			return;
		}
		divide[cnt] = true;
		Subset(cnt+1);
		divide[cnt] = false;
		Subset(cnt+1);
	}*/
}
