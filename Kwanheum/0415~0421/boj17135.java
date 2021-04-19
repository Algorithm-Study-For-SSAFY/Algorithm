package algo_study_12w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj17135 {
	private static int N;
	private static int M;
	private static int D;
	private static int[][] map;
	static class pos{
		int r, c;

		public pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		D = Integer.parseInt(stk.nextToken());
		map = new int[N][M];
		total = 0;
		for(int i=0; i<N; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				if(map[i][j]==1) total++;
			}
		}
		//input end
		attacker = new int[3];
		answer = 0;
		func(0, 0);
		System.out.println(answer);
	}//main
	static int[] attacker;
	static int total;
	static int answer;
	static void func(int start, int cnt) {
		if(cnt == 3) {
			int[][] newMap = new int[N][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					newMap[i][j] = map[i][j];
				}
			}
			int removed = 0;
			int passed = 0;
			while(true) {
			//choose
				ArrayList<pos> target = new ArrayList<>();
				choose(target, newMap);
			// remove
				for(int i=0, len=target.size(); i<len; i++) {
					int r = target.get(i).r;
					int c = target.get(i).c;
					if(newMap[r][c] == 1) {
						newMap[r][c] = 0;
						removed++;
					}
				}
			// move
				for(int j=0; j<M; j++) {
					if(newMap[N-1][j]==1) {
						passed++;
					}
				}
				for(int i=N-2; i>=0; i--) {
					for(int j=0; j<M; j++) {
						newMap[i+1][j] = newMap[i][j];
					}
				}
				Arrays.fill(newMap[0], 0);
				
				//남아있는 적이 0 이면 break
				if(removed+passed== total) break;
			}
			answer = Math.max(removed, answer);
			return;
		}
		
		for(int i=start; i<M; i++) {
			attacker[cnt] = i;
			func(i+1, cnt+1);
			attacker[cnt] = 0;
		}
	}
	
	static int dc[] = {-1, 1};
	static void choose(ArrayList<pos> target, int[][] newMap) {
		for(int i=0; i<3; i++) {
			pos att = new pos(N, attacker[i]);
			int min = Integer.MAX_VALUE;
			pos tmp = null;
			for(int r=1; r<=D; r++) {
				for(int c=0; c<D; c++) {
					int dist = r+c;
					if(dist <= D) {
						for(int j=0; j<2; j++) {
							int nr = att.r - r;
							int nc = att.c + dc[j]*c;
							if(nr>=0&&nr<N&&nc>=0&&nc<M&&newMap[nr][nc]==1) {
								if(dist < min) {
									min = dist;
									tmp = new pos(nr , nc);
								}else if(dist==min) {
									if(nc < tmp.c) {
										tmp = new pos(nr , nc);
									}
								}
							}
						}
					}
				}
			}
			if(tmp!=null) target.add(tmp);
		}//for i
	}
	
	
	
	
	
	
	
	
	
}
