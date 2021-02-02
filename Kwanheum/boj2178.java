import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class boj2178 {
	static int N, M;
	static int [][] _map;
	static boolean [][] _chk;
	static int [] mr = {0, 1, 0, -1};
	static int [] mc = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		_map = new int[N+1][M+1]; //���������� �����, �ݵ�� �ʱ�ȭ!
		_chk = new boolean[N+1][M+1];
		for(int i=1; i<=N; i++) {
			String x = sc.next();
			for(int j=1; j<=M; j++) {
				_map[i][j] = x.charAt(j-1) - '0';
			}
		}
		
		//(1,1) ���� (N,M)
		int answer = BFS();
		System.out.println(answer);
	}
	
	static class Pair{
		int r, c, cnt;
		public Pair() {		
		}
		public Pair(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	static int BFS() {
		//(1,1)���� ����
		Queue<Pair> q = new LinkedList<>();
		_chk[1][1] = true; //BFS�� ����ϱ� ������, �ڴʰ� ���� ���� �湮�ϴ°� �ǹ̰� �����Ƿ� üũ.
		q.add(new Pair(1,1,1));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			int row = p.r;
			int col = p.c;
			int cnt = p.cnt;
			if(row==N && col==M) return cnt; //���Ṯ
			
			for(int i=0; i<4; i++) {
				int nr = row + mr[i];
				int nc = col + mc[i];
				if(nr>=1 && nr<=N && nc>=1 && nc<=M) {
					if(_map[nr][nc]==1 && !_chk[nr][nc]) {	
						_chk[nr][nc] = true;
						q.add(new Pair(nr,nc, cnt+1));
					}
				}
			}//for
		}//while
		
		return 0;
	}//bfs

}
