package algo_study_6w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1083 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int [] arr = new int[n];
		for(int i =0; i<n; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		int chance = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<n; i++) {
			int tmp_max = arr[i];
			int max_idx = i;
			
			if(chance<=0) break;
			for(int j=i+1; j<=i+chance && j<n; j++) {
				// n or i+chance만큼의 범위에서 가능한 최대값 찾아
				if( arr[j] > tmp_max) {
					tmp_max = arr[j];
					max_idx = j;
				}
			}
			chance -= max_idx - i;
			for(int k=max_idx ; k>i; k--) {
				arr[k] = arr[k-1];
			}
			arr[i] = tmp_max;

		}//for i
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			sb.append(arr[i]).append(" ");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
	}
}
