import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14889 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int n=0; n<N; n++) {
			String x = br.readLine();
			StringTokenizer stk = new StringTokenizer(x);
			for(int j=0; j<N; j++) {
				arr[n][j] = Integer.parseInt(stk.nextToken());
			}
		}//Input 끝
		chk = new boolean[N+1]; //false default
		divide(0, 1);
		System.out.println(answer);
	}//main
	
	static int N;
	static int[][]arr; //점수 배열
	static int[] T1;
	static int[] T2;
	static boolean[] chk;
	static int answer = Integer.MAX_VALUE;
	static void divide(int cnt, int start) {
		if(cnt == N/2) {
			T1 = new int[N/2];
			T2 = new int[N/2];
			int i1=0;
			int i2=0;
			for(int i=1; i<=N; i++) {
				if(chk[i]) { //chk는 1 base index 기준
					//T1,2는 0index기준. 저장되는 값은 1기준!
					T1[i1++] = i;
				}
				else {
					T2[i2++] = i;
				}
			}
			int sum1 = 0;
			int sum2 = 0;
			for(int i=0; i<N/2; i++) { //arr은 0 index기준이라 1 빼줘야됨
				for(int j=i+1; j<N/2; j++) {
					sum1 += arr[T1[i]-1][T1[j]-1] + arr[T1[j]-1][T1[i]-1];
					sum2 += arr[T2[i]-1][T2[j]-1] + arr[T2[j]-1][T2[i]-1];
				}
			}
			int tmp = Math.abs(sum1-sum2);
			answer = Math.min(tmp, answer);
			return;
		}
		
		for(int i=start; i<=N; i++) {
			chk[i] = true;
			divide(cnt+1, i+1);
			chk[i] = false;
		}
	}//divide
}

/**
스타트와 링크 팀을 나누고 해당하는 팀을 배열에 넣은 뒤에 따로 sum1, sum2 값을 계산하여 비교해주는 것도 좋은 것 같습니다.
저는 chk배열이 true면 for문을 0~N-1 까지 돌면서 인덱스가 다를 때, start 변수에 arr[][] 값을 바로바로 더해주었어요!
*/
