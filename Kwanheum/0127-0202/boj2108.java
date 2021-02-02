import java.util.Arrays;
import java.util.Scanner;

public class boj2108 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] cnt = new int[8001];
		int total = 0;
		
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			arr[i] = x;
			cnt[ x+4000 ]++; //-4000 ~ 4000 인 값이라 인덱스를 위해 +4000
			total += x;
		}
		//산술평균
		System.out.printf("%d\n", Math.round((double)total/N)  ); //산술평균
		Arrays.sort(arr);
		//정렬한 중앙값
		System.out.printf("%d\n", arr[N/2]);
		// 최빈값
		int max_idx = 0;
		int max_value = 0;
		int chk = 1; //최빈값이 같을땐 두번째로 작은값을 원함.
		for(int i=0; i<8001; i++) {
			if(cnt[i] > max_value) { 
				max_idx = i;
				max_value = cnt[i];
				chk = 1;
			}
			else if(cnt[i] == max_value && chk==1) {
				max_idx = i;
				max_value = cnt[i];
				chk = 0;
			}
		}
		System.out.printf("%d\n", max_idx-4000);
		//범위
		System.out.printf("%d\n", arr[N-1] - arr[0]);
	}//main
}
