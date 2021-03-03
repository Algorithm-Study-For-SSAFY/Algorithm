package algo_study_5w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7562 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int l = Integer.parseInt(br.readLine());
			boolean [][] map = new boolean[l][l];
			
			stk = new StringTokenizer(br.readLine());
			int start_row = Integer.parseInt(stk.nextToken());
			int start_col = Integer.parseInt(stk.nextToken());
			pos start = new pos(start_row, start_col, 0);
			stk = new StringTokenizer(br.readLine());
			int dest_row = Integer.parseInt(stk.nextToken());
			int dest_col = Integer.parseInt(stk.nextToken());
			pos dest = new pos(dest_row, dest_col, -1);
			
			//큐에 넣고, bfs개념으로 돌리는데, 방문체크 트루!
			Queue<pos> q = new LinkedList<>();
			map[start_row][start_col] = true;
			q.offer(start);
			int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
			int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};
			while(!q.isEmpty()) {
				pos now = q.poll();
				if(now.r == dest.r && now.c == dest.c) {
					System.out.println(now.cnt);
					break;
				}
				for(int i=0; i<8; i++) {
					int nr = now.r + dr[i];
					int nc = now.c + dc[i];
					int cnt = now.cnt;
					if(nr>=0 && nr<l && nc>=0 && nc<l) {//범위 안
						if(!map[nr][nc]) {
							map[nr][nc] = true;
							q.offer(new pos(nr, nc, cnt+1));
						}
					}
				}
			}
			
		}//test case
	
	}
	
	static class pos{
		int r , c;
		int cnt;
		public pos(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
}


//깔끔합니다 !!!
