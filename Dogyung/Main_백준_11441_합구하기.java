package al_2주차;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_11441_합구하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // 개수

		String[] input = br.readLine().split(" "); // 값 입력
		int[] arr = new int[N + 2];
		for (int i = 1; i < arr.length - 1; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt(input[i - 1]);// 누적해서 입력한다. a[0]=10, a[1]=30.. (원래 입력은 20)
																	// 뒤에구간합 편하게 하기 위해
		} // 입력 받기

		int M = Integer.parseInt(br.readLine());// 구간 개수

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); // 구간 입력받기
			sb.append(-arr[Integer.parseInt(st.nextToken()) - 1] + arr[Integer.parseInt(st.nextToken())] + "\n");
		} // 누적해서 배열에 저장해놨기때문에, 큰 구간 - 작은구간(-1) 것으로 구한다 .
		System.out.println(sb);
	}// end of main

}// end of class
