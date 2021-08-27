package al_6주차;

import java.util.Scanner;
import java.util.Stack;

/*문제 요약
 * LIFO 특징 -->push:+, poll:- 이용
 * 
 * 아이디어
 * 스택사용
 * 1부터 입력값까지 채운다
 * */
public class Main_백준_1874_스택수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt(); // 개수
		int start = 0;
		int value = 0;
		Stack<Integer> stack = new Stack<>();
		while (N-- > 0) {
			value = sc.nextInt();
			if (value > start) { // 입력값이 시작값 보다 클 경우
				for (int j = start + 1; j <= value; j++) {
					stack.push(j); // 입력 값까지 스택에 넣기
					sb.append('+').append('\n'); // 입력값까지 만큼 +출력
				}
				start = value; // 시작값은 입력값으로

			} else if (stack.peek() != value) { // 스택의 top과 다르면
				System.out.println("NO"); // no반환
				return;
			}

			stack.pop(); // 입력값과 맞추면 poll하기
			sb.append('-').append('\n');

		} // end of for N
		System.out.println(sb);

	}// end of main
}// end of class
