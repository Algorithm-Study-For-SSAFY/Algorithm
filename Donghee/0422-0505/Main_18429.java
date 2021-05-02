package May_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_18429 {
	private static int N, K;
	private static int map[];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		
		//모든 경우 순서대로 돌면서 되는지 확인하기
		map=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			map[i]=Integer.parseInt(st.nextToken());
		}
		visit=new boolean[N];
		permu(0,500);
		System.out.println(answer);
	}
	private static boolean visit[];
	private static int answer;
	private static void permu(int cnt, int now) {
		if(now<500) return; //이미 중량이 500미만이면 볼 필요가 X
		//조건에 도닳했을 때
		if(cnt==N) {
			answer++;
		}
		for(int i=0; i<N; i++) {
			if(visit[i]) continue;
			
			visit[i]=true;
			permu(cnt+1, now-K+map[i]);
			visit[i]=false;
		}
		
	}
}
