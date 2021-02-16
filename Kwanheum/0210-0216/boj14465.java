import java.util.Scanner;

public class boj14465 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K  = sc.nextInt();
		int B  = sc.nextInt();
		boolean[] arr = new boolean[N+1]; // 0 is dummy
		for(int i=0; i<B; i++) {
			int x = sc.nextInt();
			arr[x] = true;// true : 고장난 신호등
		}
		int num = 0;
		for(int i=1; i<=K; i++) {
			if(arr[i]) num++;
		}
		int answer = K; // K개를 다고쳐야되면 max
		for(int i=2; i<=N-K+1; i++) {
			if(arr[i-1] && !arr[i+K-1]) {//범위에서 빠지는 신호등이 고장나있고 , 들어오는 신호등이 안고장
				num--;
			}
			else if(!arr[i-1] && arr[i+K-1]) {//범위에 들어오는 신호등이 고장, 나가는 신호등이 안고장
				num++;
			}
			answer = Math.min(num, answer);
		}
		System.out.println(answer);
	}//main
}

//코드 깔끔해요~~~
//저는 저번 알고리즘 문제에서 풀었던 합 구하기 문제처럼
//고장난 신호등이 아니라면 전 신호등의 배열값에서 1을 더하고, 고장났다면 더하지 않는 식으로 누적합(?)을 구해서
//int tmp=K-(sum[i+K]-sum[i]); 고쳐야 할 신호등의 값을 이런식으로 구해줬습니다 !
