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


/**
저는 입력받으면서 배열에 카운팅을 계속 해줘서 시간초과가 날 뻔 했는데
21-26번째 줄 처럼 해결하면 더 좋은 것 같아요 !!
그런데 high가 석순 받는 배열이고 low가 종유석 받는 배열이죠??
그럼 30번째 줄 for문에서 높이가 i일 때, obs=high[i]+low[H+1-i] 아닌가요...?? 물론 순서는 상관없어서 답은 어차피 똑같을 것 같습니다..!!!!
높이가 석순을 기준으로 판단하는 것 같아서요..!
제가 뭔가 잘못이해했다면 알려주세요..
*/
