package algo_study_11w;

import java.util.Scanner;

public class boj1806 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();
		int arr[] = new int[N+1];
		int partial_sum[] = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = sc.nextInt();
			partial_sum[i] = partial_sum[i-1] + arr[i];
		}
		//input end
		int answer = 0;
		if(partial_sum[N] < S) answer = 0;
		else {
			boolean flag;
			int start = 1, end=N , mid;
			while(start<=end) {
				mid = (start+end)/2;
				flag = false;
				for(int i=0; i<=N-mid; i++) {
					int val = partial_sum[mid+i] - partial_sum[i];
					if(val >= S) {
						flag = true;
						break;
					}
				}
				if(flag) {
					end = mid-1;
				}else {
					start = mid+1;
				}
			}
			answer = start;
		}
		System.out.println(answer);
	}
}
