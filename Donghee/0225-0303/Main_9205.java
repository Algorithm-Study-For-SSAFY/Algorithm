
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205 {
	private static boolean visit[]; //n번째 편의점을 방문했는지
	private static class Pair{
		int x, y, idx;
		public Pair(int x, int y, int idx) {
			this.x=x; this.y=y;
			this.idx=idx;
		}
	}
	private static int T, N, x, y, z, w;
	private static Queue<Pair> q;
	private static Pair p[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			N=Integer.parseInt(br.readLine()); //편의점의 갯수
			p=new Pair[N];
			q=new LinkedList<>();
			visit=new boolean[N];
			st=new StringTokenizer(br.readLine());
			x=Integer.parseInt(st.nextToken());
			y=Integer.parseInt(st.nextToken()); //상근이의 집
			q.offer(new Pair(x,y,-1)); //집 좌표
			for(int i=0; i<N; i++) { //편의점 입력받기
				st=new StringTokenizer(br.readLine());
				p[i]=new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),i);
			}
			st=new StringTokenizer(br.readLine());
			z=Integer.parseInt(st.nextToken()); //페스티벌 
			w=Integer.parseInt(st.nextToken());
			
			if(BFS()) sb.append("happy").append("\n");
			else sb.append("sad").append("\n");
		}
		System.out.println(sb.toString());
	}
	
	//(x,y)에서 시작해서 1000거리가 안되도록 계속 이어갔을 때 (z,w)에 도착할수 있으면 happy, 불가면 sad
	private static boolean BFS() {
		while(!q.isEmpty()) {
			Pair pair=q.poll();
			int x=pair.x;
			int y=pair.y;
			//꺼냈더니 페스티벌 까지의 거리가 1000이하면 종료
			if(Math.abs(x-z)+Math.abs(y-w)<=1000) {
				return true;
			}
			
			//아니라면, (x,y)에서 갈 수 있는 모든 좌표 다가기
			for(int i=0; i<N; i++) {
				if(visit[p[i].idx]) continue; 
				
				//방문했던 애가 아니라면, 방문할수 있는지 check
				int a=p[i].x; int b=p[i].y;
				if(Math.abs(a-x)+Math.abs(b-y)<=1000) {
					visit[p[i].idx]=true;
					q.offer(new Pair(a,b,p[i].idx));
				}
			}
		}
		return false;
	}
	
}
