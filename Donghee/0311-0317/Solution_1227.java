package March_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//미로, 벽:1, 길:0, 출발:2, 도착:3
public class Solution_1227 {
	private static class Pair{
		int x,y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	private static int dr[]= {1,-1,0,0};
	private static int dc[]= {0,0,1,-1};
	private static int map[][];
	private static boolean visit[][];
	private static int ans;
	private static Queue<Pair> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		//10번 반복
		for(int tc=1; tc<=10; tc++) {
			int T=Integer.parseInt(br.readLine());
			ans=0;
			map=new int[100][100];
			visit=new boolean[100][100];
			q=new LinkedList<>();
			for(int i=0; i<100; i++) {
				String str=br.readLine();
				for(int j=0; j<100; j++) {
					map[i][j]=str.charAt(j)-'0';
					if(map[i][j]==2) {
						q.offer(new Pair(i,j));
					}
				}
			}//end of input
			
			BFS();
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}//end of tc
		System.out.println(sb.toString());
	}
	
	private static void BFS() {
		while(!q.isEmpty()) {
			Pair p=q.poll();
			int r=p.x; int c=p.y;
			for(int i=0; i<4; i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				
				if(nr>=0 && nc>=0 && nr<100 && nc<100 && !visit[nr][nc]) {
					if(map[nr][nc]==3) { //도착지점이면 끝!
						ans=1;
						return; 
					}else if(map[nr][nc]==0) { //길이면
						visit[nr][nc]=true;
						q.offer(new Pair(nr,nc));
					}
				}
			}
		}
	}
}
