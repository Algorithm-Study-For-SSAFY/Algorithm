package algo_study_9w_special;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj17103 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int max_val = 1000000;
		boolean chk[] = new boolean[max_val+1];
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=2; i<=max_val; i++) {
			if(!chk[i]) {
				arr.add(i);
				int idx = 2;
				while(idx*i <= max_val) {
					chk[idx*i] = true;
					idx++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			int n = Integer.parseInt(br.readLine());
			int answer = 0;
			for(int i=0; i<arr.size();i++) {
				int now = arr.get(i);
				if(now > n/2) break;
				if( !chk[n - now]) {
					answer++;
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}//main
}
