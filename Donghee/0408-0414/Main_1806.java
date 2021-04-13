package April_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//부분합
//10000이하의 자연수, 길이 N짜리 수열
//합이 S 이상이 되는 것중 가장 짧은 것의 길이구하기

public class Main_1806 {
	static int N, S;
	static int map[];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		S=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int totalSum[]=new int[N+1]; //누적합 구하기
		
		map=new int[N+1];
		for(int i=1; i<=N; i++) {
			map[i]=Integer.parseInt(st.nextToken());
			//i까지의 합
			totalSum[i]=totalSum[i-1]+map[i];
		}//end of input
		
		//S이상
		int start=0; int finish=1;
		int answer=Integer.MAX_VALUE;
		//투포인터
		while(finish<=N) { //finish가 마지막에 도달하면 종료,
			int tmp=totalSum[finish]-totalSum[start]; //start+1부터 finish까지의 합
			if(tmp>=S) {
				//주어진 조건을 만족한다면,
				answer=Math.min(finish-start, answer);
				start++;
			}else {
				//만족하지 않으면 
				finish++;
			}
		}
		answer=(answer==Integer.MAX_VALUE)?0:answer;
		System.out.println(answer);
	}
	
}
