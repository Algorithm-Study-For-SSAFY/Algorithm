import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class boj1012 {
	static int T, col, row, number;
	static int[] mr = {1, 0, -1, 0};
	static int[] mc = {0, 1, 0, -1};
	static boolean[][] _map;
	static boolean[][] _chk;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=0; t<T; t++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			col = Integer.parseInt(stk.nextToken());
			row = Integer.parseInt(stk.nextToken());
			number = Integer.parseInt(stk.nextToken());
			_map = new boolean[row][col];
			_chk = new boolean[row][col];
			for(int i=0; i<number; i++) {
				stk = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(stk.nextToken()); //가로길이가 c
				int r = Integer.parseInt(stk.nextToken()); //세로길이가 r
				_map[r][c] = true; //배추가 있다면 true
			}
			
			int cnt = 0;
			for(int r=0; r<row; r++) {
				for(int c = 0; c<col; c++) {
					if(_map[r][c] && !_chk[r][c]) { 
						_chk[r][c] = true; 
						DFS(r, c);
						cnt++;
					}
				}//for c
			}//for r
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}// main

	static void DFS(int r, int c) {
		for(int i=0; i<4; i++) {
			int nr = r + mr[i];
			int nc = c + mc[i];
			if(nr>=0 && nr<row && nc>=0 && nc<col) { //범위 체크하는게 간단해서 굳이 map 바깥쪽에 둘레를 안만들어도 쉬운듯 ,, 만들면 이조건 빼도됨
				if(_map[nr][nc] && !_chk[nr][nc]) {
					_chk[nr][nc] = true;
					DFS(nr, nc);
				}
			}
		}//for
		return;
	}
}
/**
DFS의 정석적인 풀이 같습니다 ~ 깔끔해요~
/
