package Dynamic_programming;

import java.io.*;
import java.util.*;

public class 백준_11052_카드구매하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1부터 N-1까지의 카드팩 조합 +
		// N-1번째 카드팩의 갯수랑 N번째 카드팩의 개수를 비교

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr1[] = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		int arr2[] = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				arr2[i] = Math.max(arr2[i], arr2[i - j] + arr1[j]);
				System.out.println(arr2[N]);
			}
		}

	} // end of main
} // end of class
