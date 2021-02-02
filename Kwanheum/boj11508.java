import java.util.Arrays;
import java.util.Scanner;

public class boj11508 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		int total = 0;
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
			total += arr[i];
		}
		Arrays.sort(arr);
		int cnt = 1;
		for(int i=N-1; i>=0; i--) {
			if(cnt%3 == 0) total -= arr[i];
			cnt++;
		}
		System.out.println(total);
	}
}
