package al_2주차;

import java.util.Scanner;

public class Main_백준_1254_팰린드롬만들기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine(); // 문자열 입력받기
		System.out.println(sol(s)); // 총 개수 출력
	}

	static int sol(String s) {
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if (isPalindrome(s.substring(i))) { // 앞에부터 확인
				return len + i; // 팰린드롬이 아니면 해당 번째 문자열 더해준다
			}
		}
		return len; // 팰린드롬이면 자기자신 리턴
	}

	private static boolean isPalindrome(String s) {
		int len = s.length();
		for (int i = 0; i < len / 2; i++) {
			if (s.charAt(i) != s.charAt(len - i - 1)) { // 앞에문자와 같은지 확인
				return false; // 다르면 false
			}
		}
		return true; // 같으면 true
	}

}

//////////////////////////////
////////관흠 코드 리뷰/////////////
//////////////////////////////
/*
 * 오... 엄청 깔끔하게 잘짜신거같아요!!!
 */