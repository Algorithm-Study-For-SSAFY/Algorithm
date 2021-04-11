package April_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//경쟁적 전염 virus class=>list에 담긴 애들 상하좌우로 전염, 전염 시키고 나면 빼고 새로운 애들 list에 넣기
public class Main_18405 {
	private static int N, K, map[][];
	private static ArrayList<Virus> virus[];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken()); //바이러스 K까지
		map=new int[N+1][N+1];
		virus=new ArrayList[K+1];
		for(int i=0; i<K+1; i++)
			virus[i]=new ArrayList<>();
		for(int i=1; i<=N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]!=0) {
					virus[map[i][j]].add(new Virus(i,j));
				}
			}
		}
		
		int s=0,x=0,y=0;
		st=new StringTokenizer(br.readLine());

		s=Integer.parseInt(st.nextToken());
		x=Integer.parseInt(st.nextToken());
		y=Integer.parseInt(st.nextToken());
		while(s-->0) { //총 s 번 반복,
			for(int i=1; i<=K; i++) {
				if(virus[i].size()>0) {
					//i번째 부터 순서대로!
					bfs(i);
				}
			}
			
		}
		System.out.println(map[x][y]);
	}
	private static int dr[]= {1,-1,0,0};
	private static int dc[]= {0,0,1,-1};
	private static void bfs(int x) {
		boolean visit[][]=new boolean[N+1][N+1];
		Queue <Virus> q=new LinkedList<>();
		for(int i=0; i<virus[x].size(); i++) {
			q.add(new Virus(virus[x].get(i).r, virus[x].get(i).c));
			visit[virus[x].get(i).r][virus[x].get(i).c]=true;
		}
		virus[x]=new ArrayList<>(); //초기화
		while(!q.isEmpty()) {
			Virus vi=q.poll();
			int r=vi.r; int c=vi.c;
			for(int i=0; i<4; i++) {
				int nr=r+dr[i]; int nc=c+dc[i];
				if(nr>=1 && nc>=1 && nr<=N && nc<=N && !visit[nr][nc] && map[nr][nc]==0) {
					map[nr][nc]=x;
					visit[nr][nc]=true;
					virus[x].add(new Virus(nr,nc));
				}
			}
		}
	}
	
	private static class Virus{
		int r, c; //바이러스 위치
		public Virus(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
}
