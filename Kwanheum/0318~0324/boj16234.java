package algo_study_8w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj16234 {
	private static int[][] pop;
	private static int L;
	private static int R;
	private static int N;
	private static boolean[][] visited;
	private static int pop_sum;
	private static int pop_cnt;
	private static int pop_val;
	private static int[][] changed;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		L = Integer.parseInt(stk.nextToken());
		R = Integer.parseInt(stk.nextToken());
		
		pop = new int[N][N];
		for(int i=0; i<N; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0;j<N; j++) {
				pop[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		//input end
		visited = new boolean[N][N];
		changed = new int[N][N];
		ArrayList<Integer> val = new ArrayList<>();
		int move = 0;
		while(true) {
			val.clear();
			int union_number = 1;
			boolean move_chk = false;
			for(int i=0; i<N; i++) {
				for(int j=0;j<N; j++) {
					pop_sum = 0;
					pop_cnt = 0;
					if(!visited[i][j]) {
						func( i , j, union_number++); //연합 찾기
						if(pop_sum > pop[i][j]) move_chk = true;
						val.add(pop_sum/pop_cnt);
					}
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0;j<N; j++) {
					pop[i][j] = val.get(changed[i][j]-1);
				}
			}
			
			
			if( move_chk ) {
				move++;
				visited = new boolean[N][N];
				changed = new int[N][N];
			}	
			else break;
		}
		System.out.println(move);
	}
	static int dr[] = {-1, 0, 1, 0};
	static int dc[] = {0, 1, 0, -1};
	static void func(int r, int c, int union_number) {
		visited[r][c] = true;
		changed[r][c] = union_number;
		pop_sum += pop[r][c];
		pop_cnt ++;
		
		for(int i=0; i<4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr>=0 && nr<N && nc>=0 && nc<N) {				
				int gap = Math.abs(pop[nr][nc] - pop[r][c]);
				if(!visited[nr][nc] && gap>=L && gap<=R ) {
					func(nr, nc, union_number);
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
