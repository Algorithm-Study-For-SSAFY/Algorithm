package al_4주차;

import java.util.Arrays;
import java.util.Scanner;
/*문제 요약
 * 사전에 각 문자열에 값 부여됨 
 * 두개의 문자열을 비교해서 값이 같으면 같다고 출력 틀리면 틀림출력
 * 
 * 아이디어
 * 전체 true 놓고 false 조건 찾기 
 * 문자열 길이 다르면 무조건 false
 * 문자열 -> 문자로 쪼개고 정해진 값 부여
 * 값 비교 -> 다르면 false
 * true - 같, false - 틀
 */

public class Solution_SWEA_7272_안경이없어 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();

		int TC = sc.nextInt(); // 테케
		for (int test_case = 1; test_case <= TC; test_case++) {
			String[] m = new String[2]; //
			m[0] = sc.next(); // 첫번째 문자열
			m[1] = sc.next(); // 두번째 문자열

			char arr[] = new char[m[0].length()];
			char arc[] = new char[m[1].length()];

			for (int b2 = 0; b2 < m[0].length(); b2++) {
				arr[b2] = m[0].charAt(b2); // 문자열을 하나하나 쪼갬
				if (arr[b2] == 'B') {// 쪼갠후 값 부여
					arr[b2] = 2;
				} else if (arr[b2] == 'A' || arr[b2] == 'D' || arr[b2] == 'O' || arr[b2] == 'P' || arr[b2] == 'Q'
						|| arr[b2] == 'R') {
					arr[b2] = 1;
				} else {
					arr[b2] = 0;
				}
			}
			for (int b2 = 0; b2 < m[1].length(); b2++) {
				arc[b2] = m[1].charAt(b2); // 두번째 문자열 쪼갠뒤 값 부여
				if (arc[b2] == 'B') {
					arc[b2] = 2;
				} else if (arc[b2] == 'A' || arc[b2] == 'D' || arc[b2] == 'O' || arc[b2] == 'P' || arc[b2] == 'Q'
						|| arc[b2] == 'R') {
					arc[b2] = 1;
				} else {
					arc[b2] = 0;
				}

			} /////// 문자열로 쪼개기 //////////

			boolean check = true;
			if (m[0].length() != m[1].length()) { // 개수 다르면 무조건 false
				check = false;

			} else {
				for (int rc = 0; rc < m[0].length(); rc++) {
					if (arr[rc] != arc[rc]) { // 하나라도 다르면 false
						check = false;
						break;
					}
				}
			}
			if (check) {
				sb.append("#").append(test_case).append(" SAME\n");
			} else {
				sb.append("#").append(test_case).append(" DIFF\n");
			}
		} // end of tc
		System.out.println(sb);
	} // end of main
}// end of class
