package algo_study_9w_special;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj12907 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int sum = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
			sum+= arr[i];
		}
		Arrays.sort(arr);
		int[] num_chk = new int[41];
		for(int i=0; i<N; i++) {
			num_chk[arr[i]]++;
			if(arr[i] >=1 && num_chk[arr[i]] > num_chk[arr[i]-1]) {
				System.out.println(0);
				return;
			}
		}
		
		int answer = 0;
		for(int i=0; i<=N/2; i++) {
			int chk = i*(i-1)/2 + (N-i)*(N-i-1)/2;
			if(chk == sum) {
				answer = (int) ((Math.pow(2, i)));
				if(i != N-i) {
					answer *= 2;
				}
			}
		}
		System.out.println(answer);
	}//main
}
