package March_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//물->땅으로,

public class Solution_10966 {
	private static class Pair{
		int x,y,cnt;
		public Pair(int x, int y, int cnt) {
			this.x=x; this.y=y;
			this.cnt=cnt;
		}
	}
	private static int N, M;
	private static boolean visit[][];
	private static char map[][];
	private static Queue<Pair> q;
	private static int dx[]= {1,-1,0,0};
	private static int dy[]= {0,0,1,-1};
	private static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			ans=0;
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			map=new char[N][M];
			q=new LinkedList<>();
			visit=new boolean[N][M];
			
			for(int i=0; i<N; i++) {
				String str=br.readLine();
				for(int j=0; j<M; j++) {
					map[i][j]=str.charAt(j);
					if(map[i][j]=='W') {
						q.offer(new Pair(i,j,0));
						visit[i][j]=true;
					}
				}
			}//end of input
			//현재 q에는 물들이 들어가있다.
			BFS();
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}//end of tc
		System.out.println(sb.toString());
	}//end of main
	private static void BFS() {
		//q에 들어간 같은 단계애들은 한번에 처리하기
		while(!q.isEmpty()) {
			Pair p=q.poll();
			int x=p.x;
			int y=p.y;
			int cnt=p.cnt;
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				if(nx>=0 && ny>=0 && nx<N && ny<M && !visit[nx][ny]) {
					visit[nx][ny]=true;
					q.offer(new Pair(nx,ny,cnt+1));
					ans+=cnt+1;
				}
			}
		}
	}
	
	
	
}
