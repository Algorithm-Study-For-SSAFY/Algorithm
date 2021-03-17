package algo_study_7w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea1227 {
	private static int[][] arr;
	private static pos start, end;
	private static boolean[][] chk;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int size = 100;
		for(int t=1; t<=10; t++) {
			br.readLine(); // testcase number
			sb.append("#").append(t).append(" ");
			arr = new int[size][size];
			for(int i=0; i<size; i++	) {
				String input = br.readLine();
				for(int j=0; j<size; j++) {
					arr[i][j] = input.charAt(j) -'0';
					if(arr[i][j] == 2) {
						start = new pos(i,j);
					}
					else if(arr[i][j] == 3)
						end = new pos(i,j);
				}
			}
			//input end
			chk = new boolean[size][size];
			if(DFS(start)) {
				sb.append("1").append("\n");
			}else {
				sb.append("0").append("\n");
			}
		}//test case
		System.out.println(sb);
	}
	static int[]dr = {-1, 0, 1, 0};
	static int[]dc = {0, 1, 0, -1};
	static boolean DFS(pos input) {
		int r = input.r;
		int c = input.c;
		chk[r][c] = true;
		if(r== end.r && c== end.c) {
			return true;
		}
		
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			//테두리가 1로 된 노란색 벽이라 갈일이 없으므로, 범위체크가 의미가없을듯?
			if((arr[nr][nc] ==0 || arr[nr][nc]==3) && !chk[nr][nc] ) {
				if(DFS(new pos(nr,nc))) return true;
			}
		}
		return false;
	}
	
	static class pos{
		int r, c;

		public pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
}
