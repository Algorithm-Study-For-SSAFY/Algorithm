import java.util.Scanner;

public class boj3020 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int H = sc.nextInt();
		
		int []high = new int[H+1]; // 0미터 ~ H미터까지
		int []low = new int[H+1];
		for(int i=0; i<N; i++) {
			int h = sc.nextInt();
			if(i%2==1) {
				low[h] += 1;
			}
			else {
				high[h] += 1;
			}
		}
		//memoization st.
		for(int i=H; i>=2; i--) {
			low[i-1] += low[i];
		}
		for(int i=H; i>=2; i--) {
			high[i-1] += high[i];
		}
		//개똥벌레는 1번구간~H번구간 까지 날아감
		int min_val = Integer.MAX_VALUE;
		int same_number = 0;
		for(int i=1; i<=H; i++) {
			int obs = low[i] + high[H+1-i];
			if(obs < min_val) {
				min_val = obs;
				same_number = 1;
			}
			else if(obs == min_val) {
				same_number ++;
			}
		}
		System.out.println(min_val+" "+same_number);
		
	}//main
}
