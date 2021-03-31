package algo_study_9w_special;

import java.util.Arrays;
import java.util.Scanner;

public class boj12026 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String input = sc.next();
		//B O J 순서고려
		//1번에서 시작해서 N번까지
		//만날수 없는 경우 -1
		if(input.charAt(0) != 'B') {
			System.out.println(-1);
			return;
		}
		int[][] dp = new int[3][N];//{boj}{0~N-1}
		for(int i=0; i<3; i++) {
			Arrays.fill(dp[i], 1000000);
		}
		dp[0][0] = 0;
		int answer = -1;
		for(int i=1; i<N; i++) {
			int row_idx = 0;
			switch(input.charAt(i)) {
				case 'B' : row_idx = 0;
				break;
				case 'O' : row_idx = 1;
				break;
				case 'J' : row_idx = 2;
				break;
			}
			int before_row_idx = (row_idx+2)%3;
			for(int j=0; j<i; j++) {				
				dp[row_idx][i] = Math.min(dp[row_idx][i], dp[before_row_idx][j] + (i-j)*(i-j));
			}
			if(i==N-1) {
				if(dp[row_idx][N-1] < 1000000) {
					answer = dp[row_idx][N-1];
				}
			}
		}
		/*System.out.println(answer);
		for(int i=0; i<3; i++) {
			for(int j=0; j<N;j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}*/
		
	}//main
}
