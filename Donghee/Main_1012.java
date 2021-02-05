package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
	int x;
	int y;
	public Pair(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
public class Main_1012 {
	static int N, M;
	static int dx[]= {1,-1,0,0};
	static int dy[]= {0,0,1,-1};
	static int map[][];
	static boolean visit[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int answer=0;
			StringTokenizer st=new StringTokenizer(br.readLine());
			M=Integer.parseInt(st.nextToken());
			N=Integer.parseInt(st.nextToken());
			int K=Integer.parseInt(st.nextToken());
			
			map=new int[N][M];
			visit=new boolean[N][M];
			
			for(int i=0; i<K; i++) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken());
				map[b][a]=1;
			}

			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]==1 && !visit[i][j]) {
						bfs(i,j);
						answer++;
					}
				}
			}
			System.out.println(answer);
		}//end of tc
	}//end of main
	public static void bfs(int i, int j) {
		Queue <Pair> q=new LinkedList<Pair>();
		q.offer(new Pair(i,j));
		visit[i][j]=true;
		while(!q.isEmpty()) {
			//나가기전에 기억해두기
			Pair p=q.poll();
			int x=p.x; int y=p.y;
			for(int k=0; k<4; k++) {
				int nx=x+dx[k];
				int ny=y+dy[k];
				
				if(nx>=0 && ny>=0 && nx<N && ny<M && !visit[nx][ny] && map[nx][ny]==1) {
					q.offer(new Pair(nx,ny));
					visit[nx][ny]=true;
				}
			}
		}
	} //end of bfs
}//end of class
