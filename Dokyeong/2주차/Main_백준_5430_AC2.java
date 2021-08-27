package al_2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_백준_5430_AC2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); //테케 개수 입력받기
		StringTokenizer st = null;
		for (int test_case = 1; test_case <= T; test_case++) {
			String sentence = br.readLine(); //RDD등 입력
			char[] sen = sentence.toCharArray();//문자열 문자로 쪼갬
			int N = Integer.parseInt(br.readLine()); //배열개수
			Deque<String> de = new LinkedList<>(); // 디큐 생성

			String arr = br.readLine(); // 숫자 배열을 문자열로 입력받음
			arr = arr.substring(1, arr.length() - 1); 
			if (N != 0)
				st = new StringTokenizer(arr, ","); // ,별로  쪼갠다.
			else {
				// 배열에 주어진 수가 없는데 빼려하면 error
				// 빼려하지 않으면 "[]" 출력
				if (sentence.contains("D"))
					System.out.println("error");
				else
					System.out.println("[]");
				continue;
			}

			for (int i = 0; i < N; i++)
				de.offer(st.nextToken()); //디큐에 입력받음

			// true면 정방향 -> 앞에서 지움
			// false: 역방향 -> 뒤에서 지움
			boolean r = true;
			boolean errorFlag = false;
			for (int i = 0; i < sen.length; i++) {
				// 방향 바꾸기
				if (sen[i] == 'R')
					r = !r;
				else {
					// 뺄게 없으면 오류
					if (de.isEmpty()) {
						errorFlag = true;
						break;
					}
					// 정방향 이면 앞에서 빼기
					if (r)
						de.pollFirst();
					else
						de.pollLast(); // 역방향이면 뒤에서 빼기
				}
			}

			// 에러가 안났으면 남은 수 출력
			if (!errorFlag) {
				System.out.print("[");
				if (r) {
					while (de.size() > 1)
						System.out.print(de.pollFirst() + ",");
				} else {
					while (de.size() > 1)
						System.out.print(de.pollLast() + ",");
				}
				if (de.size() != 0)
					System.out.print(de.getFirst());
				System.out.println("]");
			} else {
				System.out.println("error");
			}
		}
	}

}

//////////////////////////////
////////관흠 코드 리뷰/////////////
//////////////////////////////
/* 
 * 24~34번에 N이 0인지 아닌지로 예외처리 해주시는 부분을 빼도 뒤에서(49번) 다 처리가 될거같아요!
*  저는 그냥 ArrayList로 썼는데 deque도 좋은생각인거같습니다 ㅎㅎ
*  
*/
