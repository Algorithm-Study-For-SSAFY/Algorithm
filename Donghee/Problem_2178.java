package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//makepair 기능 x , 따로 class 선언
class pair{
	int x;
	int y;
	
	pair(int x,int y){
		this.x=x;
		this.y=y;
	}
}
public class Problem_2178 {
	static int [][] map;
	static boolean [][] visit;
	static int N,M;
	static int [] dx= {1,-1,0,0};
	static int [] dy= {0,0,1,-1};
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		map = new int [N][M];
		visit=new boolean [N][M];
		//입력받기
		for(int i=0; i<N; i++) {
			//수가 붙어서 입력되므로,
			String s=sc.next();
			for(int j=0; j<M; j++) {
				map[i][j]=Character.getNumericValue(s.charAt(j));
				visit[i][j]=false;
				//아스키코드 이용
//				map[i][j]=(int)s.charAt(j)-48;
			}
		}
		bfs();
		System.out.println(map[N-1][M-1]);
	}
	

	public static void bfs() {
		//(0,0)부터 탐색 시작, queue 이용
		//queue이용방법
		Queue <pair> q=new LinkedList<pair>();
		q.add(new pair(0,0));
		while(!q.isEmpty()) {
			pair p=q.poll(); //poll(): 나갈때 리턴,
			int x=p.x;
			int y=p.y;
			visit[x][y]=true;
			for(int i=0; i<4; i++) {
				int nx=x+dx[i];
				int ny=y+dy[i];
				
				if(nx>=0 && ny>=0 && nx<N && ny<M) {
					if(!visit[nx][ny] && (map[nx][ny]==1)) {
						visit[nx][ny]=true;
						q.add(new pair(nx,ny));
						map[nx][ny]+=map[x][y]; //결과값 도출을 위해, 
						if((nx==N-1) && (ny==M-1))//도착하면 더이상 탐색할 필요x
							return;
					}
				}
			}
		}
	
	}

}
