package April_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468 {
	private static int N, map[][];
	private static boolean visit[][];
	private static int max, answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				max=Math.max(max, map[i][j]);
			}
		}//end of input
		//depth가 0이면 안전영역은 1이된다.
		answer=1;
		int tmp=0;
		for(int depth=1; depth<=max-1; depth++) {

			visit=new boolean[N][N];
			tmp=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visit[i][j]) continue;
					//선 방문처리 
					visit[i][j]=true;
					if(map[i][j]>depth) {
						bfs(i,j,depth);
						tmp++;
					}
				}
			}//해당 d에 대해서 bfs를 돌고나면
			answer=Math.max(answer, tmp);
		}
		System.out.println(answer);
		
	}
	private static int dr[]= {1,-1,0,0};
	private static int dc[]= {0,0,1,-1};
	private static void bfs(int x, int y, int depth) {
		Queue<int []> q=new LinkedList<>();
		q.add(new int[] {x,y});
		while(!q.isEmpty()) {
			int[] p=q.poll();
			int r=p[0]; int c=p[1];
			for(int i=0; i<4; i++) {
				int nr=r+dr[i]; int nc=c+dc[i];
				if(nr>=0 && nc>=0 && nr<N && nc<N && !visit[nr][nc] && map[nr][nc]>depth) {
					visit[nr][nc]=true;
					q.add(new int[] {nr,nc});
				}
			}
		}
	}
	
}
