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
