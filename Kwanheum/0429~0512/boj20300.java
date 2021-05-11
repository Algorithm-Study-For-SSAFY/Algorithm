package algo_study_13w;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj20300 {
	private static boolean[] visited;
	private static int N;
	private static long[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer stk  = new StringTokenizer(br.readLine());
		arr = new long[N];
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(stk.nextToken());
		}
		//input end
		Arrays.sort(arr);
		if(N%2!=0) {
			answer = arr[N-1];
			N -= 1;
		}else {
			answer = 0;
		}
		for(int i=0; i<N/2; i++) {
			long tmp = arr[i] + arr[N-1-i];
			answer = Math.max(answer, tmp);
		}
		System.out.println(answer);
	}
	private static long answer;
	/*public static void comb(int cnt , int pt, long m, long max ) {
		if(max > answer) return;
		if(pt==2) {
			pt = 0;
			max = Math.max(m, max);
			m = 0;
		}
		if(cnt==N) {
			if(N%2!=0 && pt==1) {
				max = Math.max(m, max);
			}
			answer = Math.min(answer, max);
			return;
		}
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				comb(cnt+1, pt+1, m+arr[i], max);
				visited[i] = false;
			}
		}
	}//comb
*/}
