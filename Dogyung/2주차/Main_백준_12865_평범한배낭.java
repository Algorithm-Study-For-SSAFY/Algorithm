package al_2주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_백준_12865_평범한배낭 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] input = in.readLine().split(" "); // 한 칸 뛰면 구분해주면서 입력받기
		int N = Integer.parseInt(input[0]); // 물품의 수
		int K = Integer.parseInt(input[1]); // 버틸 수 있는 무게

		int[] W = new int[N + 1]; // 무게
		int[] V = new int[N + 1]; // 가치
		int[] dp = new int[K + 1]; // 최대가치 출력 할 때 사용

		for (int i = 1; i <= N; i++) {
			input = in.readLine().split(" ");
			W[i] = Integer.parseInt(input[0]);
			V[i] = Integer.parseInt(input[1]);
		} // 입력 받기

		for (int i = 1; i <= N; i++) {
			for (int j = K; j - W[i] >= 0; j--) { // 버틸 수 있는 무게부터 (버틸 수 있는 무게 -물품 무게)
				dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]); // 최대값 구하기 
			}
		}
		System.out.println(dp[K]);
	}
}
