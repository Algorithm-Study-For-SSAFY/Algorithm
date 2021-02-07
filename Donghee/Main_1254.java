package feb_01;

import java.util.Scanner;

/* 팰린드롬 만들기
 * 1. 팰린드롬 문자인지 확인하는 함수
 * 2. substring의 범위를 좁혀가면서 check, 찾으면 break.
 */
public class Main_1254 {

	//String s가 팰린드롬 문자인지 확인하는 함수, 
	private static boolean check(String s) {
		//S의 처음과 끝을
		int i=0; int j=s.length()-1;
		while(i<=j) {
			if(s.charAt(i)!=s.charAt(j))
				return false;
			//같으면, 범위 좁혀가면서 check
			i++; j--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		String str=sc.next();
		int answer=0;
		//substring 이용
		for(int i=0; i<str.length(); i++) {
			if(check(str.substring(i))) { //substr이 팰린드롬인지 확인하고, 맞으면
				answer=str.length()+(str.length()-str.substring(i).length());
				break;
			}
		}
		System.out.println(answer);
	}
}
