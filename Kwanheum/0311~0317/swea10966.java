package algo_study_7w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea10966 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for(int t=1; t<=T; t++) {	
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int N= Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			char [][]arr = new char[N][M];
			boolean [][]chk = new boolean[N][M];
			Queue<pos> q = new LinkedList<>();
			for(int i=0; i<N; i++) {
				String input = br.readLine();
				for(int j=0; j<M; j++) {
					arr[i][j] = input.charAt(j);
					if(arr[i][j] == 'W') {
						q.offer(new pos(i, j));
					}
				}
			}
			//input end
			
			int answer = 0;
			int []dr = {-1, 0, 1, 0};
			int []dc = {0, 1, 0, -1};
			int level = 0;
			while(!q.isEmpty()) {
				int size = q.size();
				answer += level*size;
				while(size>0) {
					pos now = q.poll();
					for(int i=0; i<4; i++) {
						int nr = now.r + dr[i];
						int nc = now.c + dc[i];
						if(nr>=0&&nr<N &&nc>=0&&nc<M) {
							if(arr[nr][nc]=='L' && !chk[nr][nc]) {
								q.offer(new pos(nr,nc));
								chk[nr][nc] = true;
							}
						}
					}
					size--;
				}
				level++;
			}
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
			
		}//test case
		System.out.println(sb);
	}//main
	static class pos{
		int r, c;

		public pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
}
