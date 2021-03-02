package March_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7562 {
	private static class Pair{
		int x, y;
		int cnt;
		public Pair(int x, int y, int cnt) {
			this.x=x; this.y=y;
			this.cnt=cnt;
		}
	}
	private static int N, map[][];
	private static boolean visit[][];
	private static Queue<Pair> q;
	private static int x, y, z, w, answer;
	private static int dr[]= {-2,-1,1,2,2,1,-1,-2 };
	private static int dc[]= {1,2,2,1,-1,-2,-2,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N=Integer.parseInt(br.readLine());
			answer=Integer.MAX_VALUE;
			map=new int[N][N];
			visit=new boolean[N][N];
			q=new LinkedList<>();
			st=new StringTokenizer(br.readLine());
			x=Integer.parseInt(st.nextToken());
			y=Integer.parseInt(st.nextToken()); //출발점,
			q.offer(new Pair(x,y,0));
			visit[x][y]=true;
			st=new StringTokenizer(br.readLine());
			z=Integer.parseInt(st.nextToken());
			w=Integer.parseInt(st.nextToken()); //도착점,
			BFS();
			System.out.println(answer);
		}//end of tc
	}
	private static void BFS() {
		while(!q.isEmpty()) {
			Pair p=q.poll();
			int x=p.x; int y=p.y;
			int cnt=p.cnt;
			if(x==z && y==w) {
				answer=cnt;
				break;
			}
			for(int i=0; i<8; i++) {
				int nx=x+dr[i]; int ny=y+dc[i];
				if(nx>=0 && ny>=0 && nx<N && ny<N && !visit[nx][ny]) {
					visit[nx][ny]=true;
					q.offer(new Pair(nx, ny, cnt+1));
				}
			}
		}
	}
}
