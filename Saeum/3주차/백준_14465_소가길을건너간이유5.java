package week3;

import java.io.*;
import java.util.*;

 
public class 백준_14465_소가길을건너간이유5 {

	private static int N, K, B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 신호등 개수
		K = Integer.parseInt(st.nextToken()); // 만들고 싶은 연속된 개수
		B = Integer.parseInt(st.nextToken()); // 고장난 신호등 개수

		int[] sum = new int[N + 1];
		boolean[] visit = new boolean[N + 1];
		for (int i = 0; i < B; i++) {
			visit[Integer.parseInt(br.readLine())] = true;
		}

		int count = 0;
		// K번째 횡단보도까지 망가진 횡단보도의 개수 count
		for (int i = 1; i <= K; i++) {
			if (visit[i])
				count++;
		}
		sum[K] = count;
		int answer = count;

		for (int i = K + 1; i <= N; i++) {
			int temp = sum[i - 1]; 
			// 이번 횡단보도도 망가졌다면
			if (visit[i])
				temp++;
			// K번째 전에 망가진 횡단보도가 있었다면
			if (visit[i - K])
				temp--;

			sum[i] = temp;
			answer = Math.min(answer, temp);
		}

		System.out.println(answer);
	}

}

/**
 * 
 * 반복문을 한번만 돌아서 깔끔하네요!
 *
 */
