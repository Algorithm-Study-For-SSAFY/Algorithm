package March_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//직사각형 탈출
public class Main_16973 {
	private static class Pair{
		int r, c,cnt;
		public Pair(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt=cnt;
		}
		
	}
	private static int N,M,start_r, start_c, end_r, end_c;
	private static int H,W;
	private static int map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
				map[i][j]=Integer.parseInt(st.nextToken());
		}
		
		st=new StringTokenizer(br.readLine());
		H=Integer.parseInt(st.nextToken());
		W=Integer.parseInt(st.nextToken());
		start_r=Integer.parseInt(st.nextToken())-1;
		start_c=Integer.parseInt(st.nextToken())-1;
		end_r=Integer.parseInt(st.nextToken())-1;
		end_c=Integer.parseInt(st.nextToken())-1;
		
		System.out.println(bfs());
		
	}
	
	private static int bfs() {
		boolean visit[][]=new boolean[N][M];
		Queue<Pair> q=new LinkedList<>();
		q.offer(new Pair(start_r, start_c,0));
		visit[start_r][start_c]=true;
		while(!q.isEmpty()) {
			int qsize=q.size();
			while(qsize-->0) {
				Pair p=q.poll();
				int r=p.r; int c=p.c; int cnt=p.cnt;
				//종료조건확인
				if(r==end_r && c==end_c) return cnt;
				//위로이동
				boolean flag=true;
				if(r-1>=0 && !visit[r-1][c]) {
					for(int i=0; i<W; i++) {
						if(map[r-1][c+i]==1) {
							flag= false; break;
						}
					}
					if(flag) {visit[r-1][c]=true; q.offer(new Pair(r-1,c,cnt+1));}
				}
				//아래이동
				flag=true;
				if(r+H<N && !visit[r+1][c]) {
					for(int i=0; i<W; i++) {
						if(map[r+H][c+i]==1) {
							flag=false; break;
						}
					}
					if(flag) {visit[r+1][c]=true; q.offer(new Pair(r+1,c,cnt+1));}
				}
				//오른쪽이동
				flag=true;
				if(c+W<M && !visit[r][c+1]) {
					for(int i=0; i<H; i++) {
						if(map[r+i][c+W]==1) {
							flag=false; break;
						}
					}
					if(flag) {visit[r][c+1]=true; q.offer(new Pair(r,c+1,cnt+1));}
				}
				//왼쪽이동
				flag=true;
				if(c-1>=0 && !visit[r][c-1]) {
					for(int i=0; i<H; i++) {
						if(map[r+i][c-1]==1) {
							flag=false; break;
						}
					}
					if(flag) {visit[r][c-1]=true; q.offer(new Pair(r,c-1,cnt+1));}
				}
				
				
			}
		}
		
		return -1; //이동할 수 없는경우
	}
}
