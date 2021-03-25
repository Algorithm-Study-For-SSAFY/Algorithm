package March_04;

import java.util.Scanner;

public class Main_16932_AB {
	private static long answer=Long.MAX_VALUE;
	private static long a;
	private static long b;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		a=sc.nextInt();
		b=sc.nextInt();
		recur(a, 1);
		if(answer==Long.MAX_VALUE) answer=-1;
		System.out.println(answer);
		
	}
	private static void recur(long num, long cnt) {
		if(num==b) {
			answer=Math.min(cnt, answer);
			return;
		}
		if(num>b) return; //이미 큰 상태라면, 할 필요 x
		//2를 곱하거나
		recur(num*2,cnt+1);
		recur(num*10+1, cnt+1);
	}
}
