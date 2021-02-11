package baekjoon;

import java.util.Scanner;

public class Problem_1316 {
	private static boolean visit[]=new boolean[26];
	private static boolean check(String str){
		visit[str.charAt(0)-97]=true; //가장 첫 글자
		int j=0;
		for(int i=1; i<str.length(); i++) {
			if(str.charAt(j)==str.charAt(i))
				continue;
			//다르면 visit TF 확인하고 F면 T로 바꿔주기
			if(!visit[str.charAt(i)-97]) {
				visit[str.charAt(i)-97]=true;
				j=i;
			}
			//이미 f면 그냥 끝
			else return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int answer=0;
		while(N>0) {
			//소문자 a~z에 해당하는 visit class 초기화 (방문여부!)
			for(int i=0; i<26; i++)
				visit[i]=false;
			N--;
			String str=sc.next();
			if(check(str)) answer++;
		}
		System.out.println(answer);
	}
}
