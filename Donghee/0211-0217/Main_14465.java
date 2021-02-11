package feb_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 소가 길을 건너간 이유5
 * 연속해서 K개만들기!
 *
 */
public class Main_14465 {

	private static int N, K, B;

	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		N=Integer.parseInt(st.nextToken()); //신호등 갯수
		K=Integer.parseInt(st.nextToken()); //만들고 싶은 연속된 갯수
		B=Integer.parseInt(st.nextToken()); //고장난 신호등 갯수
		

		boolean visit[]=new boolean[N+1];//1~N까지 신호등
		int sum[]=new int[N+1];
		for(int b=0; b<B; b++) {
			visit[Integer.parseInt(br.readLine())]=true;
		}//end of input
		for(int i=1; i<=N; i++) {
			if(visit[i]) {
				sum[i]=sum[i-1]; //고장난 신호등이면 누적합 이어받기
				continue;
			}
			//고장난 신호등이 아니라면 +1
			sum[i]=sum[i-1]+1;	
		}
    
		int answer=Integer.MAX_VALUE;
		//answer구하기
		for(int i=0; i<=N-K; i++) {
			//고쳐야 할 신호등갯수
			int tmp=K-(sum[i+K]-sum[i]);
			answer=Math.min(answer, tmp);
		}
		System.out.println(answer);
	}//end of main

}
