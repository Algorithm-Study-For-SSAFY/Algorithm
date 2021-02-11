package baekjoon;

import java.util.Scanner;

/* 하노이의 탑 */
public class Main_11729 {
	//필요한 매개변수 : 원판 번호, 현재위치, 옮겨질 위치
	private static int answer=0;
	private static StringBuilder sb=new StringBuilder();
	private static void hanoi(int n, int from, int temp, int to) {
		/*
		 * (n-1) 번째 원판까지 옮겨져 있는 상태,
		 * n번째 원판을 옮겨질 최종위치에 옮기고 + Hanoi(n-1)
		 */
		if(n==0) {
			return;
		}
		answer++;
		hanoi(n-1,from,to,temp); //n-1개를 임시 기둥에
		sb.append(from).append(" ").append(to).append("\n");
//		System.out.println(from + " " + to);
		hanoi(n-1,temp,from,to); //임시에서 목적기둥으로
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		hanoi(n,1,2,3);
		System.out.println(answer);
		System.out.println(sb.toString());
	}
}
