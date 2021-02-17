import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj14503 {
	private static int[][] map;
	private static int N;
	private static int M;
	private static int answer;
	private static boolean[][] chk;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		map = new int[N+2][M+2];
		chk = new boolean[N+2][M+2];
		for(int i=0; i<N+2;i++) {
			Arrays.fill(map[i], 1);
		}
		
		stk = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(stk.nextToken()); //0 base
		int c = Integer.parseInt(stk.nextToken());
		int d = Integer.parseInt(stk.nextToken()); //북 동 남 서
		
		for(int i=0; i<N; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		clean(r, c, d);
		System.out.println(answer);
	}
	
	static int[] mr = {-1, 0, 1, 0};
	static int[] mc = {0, 1, 0, -1};
	static void clean(int r , int c, int d) {
		if(map[r][c] == 0 && !chk[r][c] ) { //1. 현재위치를 청소한다.
			chk[r][c] = true;
			answer++;
		}
		int dir = d;
		int nr ;
		int nc ;
		//2. 현재방향을 기준으로 왼쪽부터 탐색 시작.
		for(int i=3; i>=0; i--) {//2-b.
			dir = (d+i)%4;
			nr = r + mr[dir];
			nc = c + mc[dir];
			if( map[nr][nc] == 0 && !chk[nr][nc]) {
				clean(nr, nc, dir);// 2-a.
				return;
			}
		}
		// 2-c. 1번이 아니라 2번으로 돌아가야하지만, 이미 4방 모두 청소가 되어있는지 확인을 했기에 1번부터 시작하는 재귀를 돌려도 문제없을듯
		nr = r - mr[dir];//후진
		nc = c - mc[dir];
		if(map[nr][nc] == 0) clean(nr, nc, dir);
		return; //후진해야하는데 벽인경우 그대로 종료.
	}//clean
	
	
	
	
	
	
	
	
	
	
	
}


//코드가 깔끔해요~! 
