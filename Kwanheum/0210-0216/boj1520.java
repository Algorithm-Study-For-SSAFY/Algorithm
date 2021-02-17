import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1520 {
	private static int N;
	private static int M;
	private static int[][] map;
	static int dr[] = {0, 1, 0, -1};
	static int dc[] = {1, 0, -1, 0};
	static boolean chk[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk =  new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		chk = new boolean[N][M];
		//Input End.
		
		//number와 r,c가 같은 경로를 여러번 계산하는 걸 막기위해 pq사용
		int answer[][] = new int[N][M]; //해당 좌표를 지나가는 경로 수
		PriorityQueue<X> pq = new PriorityQueue<>();
		pq.offer(new X(0, 0, map[0][0]));
		answer[0][0] = 1;
		chk[0][0] = true; //재방문 하지 않기 위해 체크
		while(!pq.isEmpty()) {
			X tmp = pq.poll();
			int r = tmp.row;
			int c = tmp.col;
			for(int i=0; i<4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr == N-1 && nc ==M-1 && map[nr][nc] < map[r][c]) {
					answer[nr][nc] += answer[r][c];
					continue;
				}
				if(nr>=0 && nr<N && nc>=0 && nc<M) {//테두리 안쪽이고
					if(map[nr][nc] < map[r][c]) { //진행방향이 낮은지점이라면
						answer[nr][nc] += answer[r][c]; //이전 경로의 경로수를 그대로 더해줌
						if(!chk[nr][nc]) { //기존에 방문하지않았다 = pq에 안넣었다.=>추가해줌
							pq.offer(new X(nr, nc, map[nr][nc]));
							chk[nr][nc] = true;
						}
					}
				}
			}
		}//while
		
		System.out.println(answer[N-1][M-1]);
	}//main


	static class X implements Comparable<X>{
		int row;
		int col;
		int number;
		public X(int row, int col, int number) {
			super();
			this.row = row;
			this.col = col;
			this.number = number;
		}
		@Override
		public int compareTo(X o) {
			// TODO Auto-generated method stub
			return o.number - this.number; // 내림차순
		}
		
	}
	
	/*
	//기본 DFS로는 시간초과!
	static void DFS(int r, int c) {
		if( r== N-1 & c == N-1) {
			answer ++;
			return;
		}
		//chk[r][c] = true;
		for(int i=0; i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>=0 && nr<N && nc>=0 && nc<M && !chk[nr][nc]) {//테두리 안쪽
				if(map[nr][nc] < map[r][c]) { //낮은지점이라면
					chk[nr][nc] = true;
					DFS(nr, nc);
					chk[nr][nc] = false;
				}
			}
		}
	}*/
}
