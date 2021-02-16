import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj3190 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[][] map = new int[N+2][N+2];
		for(int i=0; i<N+2; i++) {
			map[0][i] = 1;
			map[i][0] = 1;
			map[N+1][i] = 1;
			map[i][N+1] = 1;
		}//테두리는 다 1
		StringTokenizer stk;
		for(int k=0; k<K; k++) {
			stk = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(stk.nextToken());
			int c = Integer.parseInt(stk.nextToken()); 
			map[r][c] = 2; // 2 = 사과
		}
		int L = Integer.parseInt(br.readLine());
		
		int time = 0;
		int mr[] = {0, 1, 0, -1}; // 동 남 서 북
		int mc[] = {1, 0, -1, 0};
		int r =1, c=1;
		int dir = 0;
		map[r][c] = 1; //
		int tail_r = 1, tail_c = 1;
		int[][] tail_dir = new int[N+2][N+2];
		tail_dir[tail_r][tail_c] = dir;
		
		int L_time = 0;
		char L_turn = 0;
		
		while(true) {
			if(time == L_time) {
				if(L_turn == 'L') {
					dir = (dir+3)%4;
					tail_dir[r][c] = dir;
				}
				else if(L_turn =='D') {
					dir = (dir+1)%4;
					tail_dir[r][c] = dir;
				}
				if(L>0) {
					stk = new StringTokenizer(br.readLine());
					L_time = Integer.parseInt(stk.nextToken());
					L_turn = stk.nextToken().charAt(0);
					L--;
				}
			}
			//방향변환정보 체크 끝
			r = r+mr[dir];
			c = c+mc[dir];
			if(map[r][c] == 2) {//사과가 있다면
				map[r][c] = 1;
				tail_dir[r][c] = dir;
			}
			else if(map[r][c] == 0) {//사과가 없다면
				map[r][c] = 1;
				map[tail_r][tail_c] = 0;
				tail_dir[r][c] = dir;
				int dr = mr[tail_dir[tail_r][tail_c]];
				int dc = mc[tail_dir[tail_r][tail_c]];
				tail_r += dr;
				tail_c += dc;
				}
			else { //벽 or 자기몸에 부딪친다면 종료
				time++;
				break;
			}
			time++;
		}//while
		System.out.println(time);
	}
}
