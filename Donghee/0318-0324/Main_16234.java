package March_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234 {
	private static class Pair{
		int x,y;
		public Pair(int x, int y) {
			this.x=x; this.y=y;
		}
	}
	private static int N, L, R;
	private static int dr[]= {1,-1,0,0};
	private static int dc[]= {0,0,1,-1};
	private static boolean visit[][];
	private static ArrayList<Pair> list;
	private static int map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		
		map=new int[N][N];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0 ;j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int answer=0;
		while(true) {
			boolean flag=false;
			//visit 초기화
			visit=new boolean[N][N];
			
			//bfs로 인구이동 시작,

			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visit[i][j]) {
						visit[i][j]=true;
						if(bfs(i,j)) flag=true;
					}
				}
			}
			//인구이동한게 없다면 
			if(!flag) break;
			else answer+=1;
		}
		System.out.println(answer);
		
	}//end of main
	
	private static boolean bfs(int x, int y) {
		
		Queue<Pair> q=new LinkedList<>();
		list=new ArrayList<>();
		q.add(new Pair(x,y));
		list.add(new Pair(x,y));
		int cnt=1;
		int total=map[x][y]; int number=0;
		while(!q.isEmpty()) {
			Pair p=q.poll();
			int r=p.x;
			int c=p.y;
			for(int i=0; i<4; i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				if(nr>=0 && nc>=0 && nr<N && nc<N && !visit[nr][nc]) {
					//차이 조건 만족할 때
					if(Math.abs(map[nr][nc]-map[r][c])>=L && Math.abs(map[nr][nc]-map[r][c])<=R) {
						visit[nr][nc]=true;
						cnt++;
						total+=map[nr][nc];
						list.add(new Pair(nr,nc));
						q.add(new Pair(nr,nc));
					}
					
				}
			}
		}
		//map돌면서 값 갱신
		number=total/cnt;
		for(int i=0; i<cnt; i++) {
			map[list.get(i).x][list.get(i).y]=number;
		}
		if(cnt>1) return true;
		return false;
	}
	
	private static void copyMap(int map[][], int map2[][]) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j]=map2[i][j];
			}
		}
	}
}
