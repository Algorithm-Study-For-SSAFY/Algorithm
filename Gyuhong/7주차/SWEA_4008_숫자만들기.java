import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_4008_숫자만들기 {
	
	static int N;
	static int[] operator;
	static int[] nums;
	static int max;
	static int min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			
			N = Integer.parseInt(br.readLine());
			operator = new int[4];
			nums = new int[N];
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 4; i++) {
				operator[i] = Integer.parseInt(st.nextToken());			
			}
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			
			
			solve(1,nums[0]);
			
			
			sb.append("#").append(testCase).append(" ").append(max-min).append("\n");

		}

		System.out.println(sb);
	}
	
	static void solve(int idx, int result) {
		
		if(idx == N) {
			min = Math.min(min, result);
			max = Math.max(max, result);
			return;
		}
		
		if(operator[0] > 0) {
			operator[0]--;
			solve(idx+1, result + nums[idx]);
			operator[0]++;
		}
		
		if(operator[1] > 0) {
			operator[1]--;
			solve(idx+1, result - nums[idx]);
			operator[1]++;
		}
		
		if(operator[2] > 0) {
			operator[2]--;
			solve(idx+1, result * nums[idx]);
			operator[2]++;
		}
		
		if(operator[3] > 0 && nums[idx] != 0) {
			operator[3]--;
			solve(idx+1, result / nums[idx]);
			operator[3]++;
		}
		
	}
	
	
	
	
}




