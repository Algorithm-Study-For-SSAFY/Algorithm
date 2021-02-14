package saem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// n,n만큼 , 개수, 범위 
// 합 

public class 백준_11441_합구하기 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i <M; i++) {
			
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int sum = 0;
			
			for (int j = start; j <= end; j++) {
				sum += arr[j];
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}
}

// 확인완료
