package algo_study_7w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea4008 {
	private static int N;
	private static int[] arr;
	private static int[] op;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb =new StringBuilder();
		StringTokenizer stk = null;
		for(int t=1; t<=T; t++) {
			
			sb.append("#").append(t).append(" ");
			N = Integer.parseInt(br.readLine());
			stk = new StringTokenizer(br.readLine());
			op = new int[4];
			for(int i=0; i<4; i++) {
				int num = Integer.parseInt(stk.nextToken());
				op[i] = num;
			}
			arr = new int[N];
			stk = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(stk.nextToken());
			}
			order = new int[N-1];
			answer_max = Integer.MIN_VALUE;
			answer_min = Integer.MAX_VALUE;
			permu(0);
			sb.append(answer_max-answer_min).append("\n");
		
		}//test case
		System.out.println(sb);
	}//main
	static int order[];
	static int answer_max, answer_min;
	static void permu(int cnt) {
		
		if(cnt == N-1) {
			int tmp = arr[0];
			for(int i=0; i<N-1; i++) {
				int op_num = order[i];
				switch(op_num) {
					case 0 :
						tmp += arr[i+1];
						break;
					case 1 :
						tmp -= arr[i+1];
						break;
					case 2 :
						tmp *= arr[i+1];
						break;
					case 3 :
						tmp /= arr[i+1];
						break;
				}
			}
			answer_min = Math.min(tmp, answer_min);
			answer_max = Math.max(tmp, answer_max);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(op[i] > 0) {
				op[i]--;
				order[cnt] = i;
				permu(cnt+1);
				op[i]++;
			}
		}
	}
	
	
	
	
	
}
