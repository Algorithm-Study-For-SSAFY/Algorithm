package March_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4008 {
	private static int N;
	private static int cal[];
	private static int num[];
	private static int max, min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			//연산자의 갯수
			N=Integer.parseInt(br.readLine());
			max=Integer.MIN_VALUE; min=Integer.MAX_VALUE;
			cal=new int[4]; num=new int[N];
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=0; i<4; i++) {
				cal[i]=Integer.parseInt(st.nextToken());
			}
			//N개 숫자 입력받기
			st=new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				num[i]=Integer.parseInt(st.nextToken());
			}
			calculate(num[0],0); //시작은 첫번째 숫자부터,
			sb.append("#").append(tc).append(" ").append(max-min).append("\n");
		}//end of tc
		System.out.println(sb.toString());
	}//end of main
	
	
	private static void calculate(int n, int cnt) { //cnt는 연산자 뽑은 갯수
		if(cnt==N-1) {
			max=Math.max(max, n);
			min=Math.min(min, n);
			return;
		}
		if(cal[0]>0) {
			cal[0]--;
			calculate(n+num[cnt+1], cnt+1);
			cal[0]++;
		}
		if(cal[1]>0) {
			cal[1]--;
			calculate(n-num[cnt+1], cnt+1);
			cal[1]++;
		}
		if(cal[2]>0) {
			cal[2]--;
			calculate(n*num[cnt+1], cnt+1);
			cal[2]++;
		}
		if(cal[3]>0) {
			cal[3]--;
			calculate(n/num[cnt+1], cnt+1);
			cal[3]++;
		}
	}
	
	
}
