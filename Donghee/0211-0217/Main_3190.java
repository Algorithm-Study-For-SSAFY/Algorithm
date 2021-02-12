package feb_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/** 뱀
 * 처음 방향은 오른쪽, 방향 전환 정보가 나오면 그때 방향을 회전한다.
 */
public class Main_3190 {
	static private class Pair{
		int x; int y; //현재 뱀의 위치 쌍.
		public Pair(int x, int y) {
			this.x=x; this.y=y;
		}
	}
	static int N, K, L;
	static int [][]map; //아무것도 없을 때 : 0, 사과 : 1, 뱀이 위치하면 2 (종료조건)
	static int[]dx= {0,1,0,-1};
	static int[]dy= {1,0,-1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int K=Integer.parseInt(br.readLine());
		map=new int[N+1][N+1]; //0행, 0열 비워두기
		StringTokenizer st;
		for(int k=0; k<K; k++) {
			st=new StringTokenizer(br.readLine()," ");
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			map[a][b]=1;
		}//end of input
		L=Integer.parseInt(br.readLine());
		int dir=0; //처음 dir은 0
		int time=0; //현재 시간
		Deque<Pair> d=new LinkedList<Pair>(); //뱀을 관리해 줄 덱 선언
		Queue <int []> q=new LinkedList<>();
		d.offer(new Pair(1,1)); //뱀의 첫 위치
		for(int l=0; l<L; l++) {
			st=new StringTokenizer(br.readLine());
			int t=Integer.parseInt(st.nextToken());
			char c=st.nextToken().charAt(0);
			if(c=='D') q.offer(new int[] {t,1}); //오
			else q.offer(new int[] {t,2}); //왼
		} //방향정보
		
		int []p=q.poll();
		while(true) {
			//현재 시간이 time 됐으면 방향을 바꿔주기!
			if(time==p[0]) {
				if(p[1]==1) dir=(dir<3)?(dir+1):0;
				else dir=(dir>0)?(dir-1):3;
				
				if(!q.isEmpty()) p=q.poll();
				else p[0]=0;
			}
			time++;
			Pair pair=d.getFirst(); //덱에서 현재 뱀 위치 얻기
			int x=pair.x; int y=pair.y;
			
			int nx=x+dx[dir]; int ny=y+dy[dir];
			
			if(nx<1 || ny<1 || nx>N || ny>N || map[nx][ny]==2) { //종료조건
				System.out.println(time);
				break; 
			}
			//종료조건이 아니라면, 사과가 있는 경우와 사과가 없는경우
			if(map[nx][ny]==1) { //사과가 있는경우면
				d.addFirst(new Pair(nx,ny));
				map[nx][ny]=2; //꼬리는 움직이지 x 길이가 늘어나는 것
			}else { //사과가 없는경우 에는 덱에 하나 넣고. 덱의 맨 뒤 빼기
				d.addFirst(new Pair(nx,ny));
				map[nx][ny]=2;
				map[d.getLast().x][d.getLast().y]=0;
				d.pollLast(); //꼬리 하나 빼기
			}
//			System.out.println(nx+" "+ny+" "+time);
		}//end of while
		
	}//end of main
}//end of class
