package March_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17182 {
	static private int N, now, answer;
	static private int map[][];
	static private boolean visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		now=Integer.parseInt(st.nextToken());
		map=new int[N][N];
		visit=new boolean[N];
		answer=Integer.MAX_VALUE;
			//N*N 배열 입력받기,
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}//end of input
		//폴로이드 와샬을 사용하여 map을 갱신시켜주기,
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				//(i,j)를 k를 거쳐간다면? 뭐가 더 최소비용인지 알기 위해
				for(int k=0; k<N; k++) {
					map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]); //기존의 i~j 가는 경로와 i~k,k~j가는 경로
				}
			}
		}
		
		visit[now]=true;
		DFS(1,0,now);
		System.out.println(answer);
	}//end of tc
	//모든 정점을 지나도록, now에서 시작해서
	private static void DFS(int cnt, int ans, int x) { //x가 시작점,
		if(cnt==N) { //기저조건 
			answer=Math.min(ans, answer);
			return;
		}
		//그게 아니라면, 정점 지나가면서 확인하기,
		for(int i=0; i<N; i++) {
			if(visit[i]) continue;
			visit[i]=true;
			DFS(cnt+1, ans+map[x][i], i);
			visit[i]=false;
		}
	}
}
