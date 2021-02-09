
//Main_백준_1254_팰린드롬만들기_조규홍

import java.io.IOException;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		int center = (str.length() - 1) / 2;
		int strIsEven = str.length() % 2 == 0 ? 1 : 0;
		int answerEven = Integer.MAX_VALUE;
		int answerOdd = Integer.MAX_VALUE;
		int answer;

		boolean isPalEven = true;
		boolean isPalOdd = true;

		while (true) {

			isPalEven = true;

			// 결과가 짝수
			for (int i = 0; i + center + 1 < str.length(); i++) {
				if (str.charAt(center - i) == str.charAt(center + i + 1)) {
					continue;
				}
				isPalEven = false;
				break;
			}

			if (isPalEven) {
				answerEven = (center + 1) * 2;
			}

			isPalOdd = true;

			// 결과가 홀수
			for (int i = 1; i + strIsEven + center < str.length(); i++) {
				if (str.charAt(center + strIsEven - i) == str.charAt(center + strIsEven + i)) {
					continue;
				}
				isPalOdd = false;
				break;
			}

			if (isPalOdd) {
				answerOdd = (center + strIsEven) * 2 + 1;
			}

			if (isPalOdd || isPalEven) {
				answer = Math.min(answerEven, answerOdd);
				break;
			}
			center++;
		}

		System.out.println(answer);
		sc.close();
	}
}

// a b a c c (2) (2,3)  center = 2     5,6
// a b a c c a (3) (2,3) center = 2    6,7
// a a a a a a a (3) (3,4) center = 3  7,8

/**************************************/
// 코드리뷰-도경
/*
풀이 아이디어가 좋네요!
부럽습니다...
저도.. 언젠가는..? 

*/
