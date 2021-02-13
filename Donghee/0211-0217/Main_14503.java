package feb_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14503 {
	static int M, N;
	static int dir;
	static int[][] map;
	static int dx[]= {-1,0,1,0}; //북, 동, 남, 서
	static int dy[]= {0,1,0,-1};
		
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		st=new StringTokenizer(br.readLine());
		int r=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		dir=Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
				map[i][j]=Integer.parseInt(st.nextToken());
		}//end of input

		//현재 위치를 넣은 상태에서 탐색 시작.
		int answer=1;
		Queue <Pair> q=new LinkedList<Pair>();
		q.offer(new Pair(r,c,dir));
		while(!q.isEmpty()) {
			Pair p=q.poll();
			int x=p.x; int y=p.y; int d=p.dir;
			map[x][y]=2; //청소함표시
      
			int idx=0;
			boolean flag=false;
			while(idx<4) {
				d=(d>0)?(d-1):3; //방향 왼쪽으로 전환,
				int nx=x+dx[d]; int ny=y+dy[d];
				if(map[nx][ny]==0) {//빈칸인 경우, 둘레가 1로 쌓여있어서 범위체크를 할 필요는 없다
					q.offer(new Pair(nx,ny,d));
					answer++;
					flag=true;
					break;
				}else { //빈칸이 아니라면, 다시 방향돌려서 검색해야한다. idx올리기,
					idx++;
				}
			}
			//2-b)경우로 빠져나왔다면 c를 확인하기. 앞의 while문에서 break 된경우에서는 실행하면 안됨.
			if(!flag) { //후진, 위치가 아직 x,y고 방향이 d인상태
				int newd;
				newd=(d<2)?(d+2):(d-2); //후진 방향 정함
				int nx=x+dx[newd]; int ny=y+dy[newd];
				if(map[nx][ny]!=1) { //벽이 아니면
					q.offer(new Pair(nx,ny,d)); //이때는 이미 청소한 곳이므로 answer을 올려주지는 x
				}else{ //후진방향까지 벽이라면
					break;
				}
			}
		}
		System.out.println(answer);
		
		
	}//end of main
	
	static private class Pair{
		int x; int y;
		int dir;
		private Pair(int x, int y, int dir) {
			this.x=x; this.y=y; this.dir=dir;
		}
	}
}//end of class
