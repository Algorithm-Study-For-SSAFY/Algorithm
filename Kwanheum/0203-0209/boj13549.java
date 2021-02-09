import java.util.Scanner;

public class boj13549 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int answer = 0 ;
		if(N > K) { // N이 더 크다면 무조건 뒤로 걸어야됨
			answer = N-K;
		}
		else if(N < K) {
			//1. 순간이동은 시간이 안드는게 포인트
			//2. N보다 뒤로가는건 무조건 걸어야됨
			int arr[] = new int[K+3]; //
			for(int i=0; i<K+3; i++) {
				arr[i] = 200000;
			}//처음엔 모두 임의의 Max값
			arr[N]=0;
			// N보다 뒤
			for(int i=1; i<N; i++) {
				arr[N-i] = arr[N] + i;
			}
			
			for(int i=N+1; i<K+2; i++) {
				if(i%2==0) {
					arr[i] = Math.min( arr[i/2], Math.min(arr[i-1]+1, arr[i+1]+1));
				}
				else {
					arr[i] = Math.min(arr[i-1]+1, arr[i+1]+1);
				}
				//i번째 업데이트 이후, 이전 i-1도 한번 더 생각
				//이부분 처리안해주면 오답가능성 존재.. 뭔가 반례가 존재할 거같은데 일단 통과
				arr[i-1] = Math.min(arr[i-1], arr[i]+1);
			}
			answer = arr[K];
		}//else if
		System.out.println(answer);
		
	}//main
}
