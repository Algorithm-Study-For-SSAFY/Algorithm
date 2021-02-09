import java.util.*;

public class 백준_1254_팰린드롬만들기 {

	// 일단 팰린드롬인지 판별하고
	// 팰린드롬이 아니라면? 맞으면?

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println(palindrome(input));

	}

	private static boolean isPalindrome(String input) {
		int length = input.length();
		for (int i = 0; i < length; i++) {
			if (input.charAt(i) != input.charAt(length - i - 1)) {
				return false;
			}
		}
		return true;
	}

	private static int palindrome(String input) {
		int length = input.length();
		for (int i = 0; i < length; i++) {
			if (isPalindrome(input.substring(i))) {  
				return length + i;
			}
		}
		return length * 2;
	}
}
