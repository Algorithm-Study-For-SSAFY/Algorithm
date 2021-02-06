import java.util.Scanner;

public class boj11441 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1]; // 0 index = dummy
		//매 순간순간의 구간합을 반복문을 통해 구하려하면 시간오버가 뜰듯
		//메모이제이션st로 활용. i번째 index까지의 누적합 개념
		for(int i=1; i<=N; i++) {
			int input = sc.nextInt();
			arr[i] = arr[i-1] + input;
		}
		StringBuilder sb = new StringBuilder();
		int M = sc.nextInt();
		for(int j=0; j<M; j++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			//원하는 구간 : a <= sum <= b
			sb.append(arr[b]-arr[a-1]).append("\n");
		}
		System.out.println(sb);
	}
}
