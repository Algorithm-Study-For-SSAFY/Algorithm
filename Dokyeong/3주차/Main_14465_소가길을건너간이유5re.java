package al_3주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14465_소가길을건너간이유5re {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 횡단보도 개수
		int K = Integer.parseInt(st.nextToken()); // 연속한 k개의 신호등
		int B = Integer.parseInt(st.nextToken()); // 고장난 신호등 개수
		boolean broken[] = new boolean[N + 1];
		int sum[] = new int[N + 1];
		int cnt = 0;

		for (int i = 0; i < B; i++) {
			broken[Integer.parseInt(br.readLine())] = true; // 고장난 신호등 번호 true로 바꿈
		}
		for (int i = 1; i <= K; i++) {// 앞에서 부터 k번까지 중 고장난거 개수 구하기
			if (broken[i])
				cnt++;
		}
		sum[K] = cnt;
		int result = cnt;

		for (int i = K + 1; i <= N; i++) {// k번 이후
			int temp = sum[i - 1];

			if (broken[i])
				temp++;
			if (broken[i - K]) // 전에 망가진것 개수 빼기
				temp--;
			sum[i] = temp; // 누적합 ( 1번째꺼 빼고 K+1추가)
			result = Math.min(result, temp);
			// 최소면 갱신

		}
		System.out.println(result);
	}// end of main
} // end of class

/////////////////////////
////////관흠 리뷰///////////
/////////////////////////
/*
 *  깔끔합니다.
 */