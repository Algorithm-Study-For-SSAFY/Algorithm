
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_10988_팰린드롬만들기 {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println(solution(input));
	}

	static int solution(String input) {

		int len = input.length();
		for (int i = 0; i < len; i++) {
			if (isPalindrome(input.substring(i))) {
				return len + i;
			}
		}
		return len;
	}

	static boolean isPalindrome(String input) {

		int len = input.length();
		for (int i = 0; i < len / 2; i++) {
			if (input.charAt(i) != input.charAt(len - i - 1)) {
				return false;
			}
		}
		return true;
	}
}


// 이 문제가 아닌거 같은데요....?
// https://www.acmicpc.net/problem/1254
