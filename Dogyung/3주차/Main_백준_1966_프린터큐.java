package al_3주차;

import java.util.LinkedList;
import java.util.Scanner;

public class Main_백준_1966_프린터큐 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt(); // tc 수
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // 문서의 개수
			int M = sc.nextInt(); // 궁금한 문서의 현재 위치

			LinkedList<int[]> qu = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				qu.offer(new int[] { i, sc.nextInt() });
			} // 큐에 입력 받고 배열 넣기

			int cnt = 0;
			while (!qu.isEmpty()) {
				int p[] = qu.poll(); // 가장 첫번째 원소 넣기
				boolean check = true; // 가장 큰값인지 확인변수

				for (int i = 0; i < qu.size(); i++) {// 큐에 남아있는 원소들과 중요도 비교
					if (p[1] < qu.get(i)[1]) {// 처음것보다 다른것이 클 경우

						qu.offer(p); // 맨뒤로 보냄
						for (int j = 0; j < i; j++) { // i이전의 원소들 맨뒤로 보냄
							qu.offer(qu.poll());
						}
						check = false;
						break;
						// 가장 큰 원소가 아니었으므로 false하고 탐색끝

					}
				}
				if (check == false) { // 가장 큰 원소가 아니었으므로 컨티뉴
					continue;
				}
				cnt++;
				if (p[0] == M) {
					break;
				}
			}
			sb.append(cnt).append("\n");
		} // end of tc
		System.out.println(sb);
	}// end of main
}// end of class
