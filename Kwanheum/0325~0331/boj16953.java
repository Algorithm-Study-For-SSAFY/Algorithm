package algo_study_9w_special;

import java.util.Scanner;

public class boj16953 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		answer = Integer.MAX_VALUE;
		func(A, B, 0);
		if(answer >= Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(answer+1);
		
	}
	static int answer;
	static void func(int A , int B, int cnt) {
		if(A < B)
		{ //overflow 조심
			if( A <= 1000000000/2)	func(2*A, B, cnt+1);
			if( A <= 100000000)	func(10*A+1, B ,cnt+1);
		}
		else if( A == B) answer = Math.min(cnt, answer);
		
		return;
		
	}
}
