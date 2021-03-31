package algo_study_9w_special;

import java.util.Scanner;

public class boj16922 {
	private static int N;
	private static int[] arr;
	private static boolean[][] chk;
	private static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[4];
		chk = new boolean[21][1001]; // max 1000
		answer = 0;
		func(0 , 0 ,0, 0, 0);
		
		System.out.println(answer);
	}
	
	static void func(int a, int b, int c, int d, int sum) {
		int cnt = a+b+c+d;
		
		if(!chk[cnt][sum]) {
			chk[cnt][sum] = true;
			if(cnt == N) {
				answer++;
				return;
			}
		}
		else {
			return;
		}
		
		
		func(a+1, b, c, d, sum+1);
		func(a, b+1, c, d, sum+5);
		func(a, b, c+1 , d, sum+10);
		func(a, b, c, d+1, sum+50);
	}
	
}
