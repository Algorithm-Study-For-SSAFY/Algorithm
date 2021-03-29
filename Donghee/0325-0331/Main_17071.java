package March_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//수빈이는 현재 N, 동생은 현재 K
//수빈이가 X일 때 걷는다면 X-1, X+1로 이동
//순간이동하면 1초후에 2*X로 이동

public class Main_17071 {
	private static int N;
	private static int M;
	private static int time;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		if(N==M) System.out.println(0);
		else {
			BFS();
			System.out.println(time);
		}
		
	}
	//bfs 시간초과 발생 --> 줄일수 있는 방법은???
	
	private static void BFS() {
		Queue<Integer> q=new LinkedList<>();
		q.offer(N);
		int visit[][]=new int[2][500001];
		Arrays.fill(visit[0], -1);
		Arrays.fill(visit[1], -1);
		while(!q.isEmpty()) {
			int qsize=q.size();
			time++;
			int tmp=time%2;
			while(qsize-->0) {
				int n=q.poll();
				//-1,+1,*2 시키기
				if(n-1>=0 && visit[tmp][n-1]==-1) {
					visit[tmp][n-1]=time;
					q.offer(n-1);
				}
				if(n+1<=500000 && visit[tmp][n+1]==-1) {
					visit[tmp][n+1]=time;
					q.offer(n+1);
				}
				if(2*n<=500000 && visit[tmp][n*2]==-1) {
					visit[tmp][n*2]=time;
					q.offer(n*2);
				}
			}
			//모든 점들을 넣은 후에, 이미 걔가 도달한 애면
			M+=time;
			if(M>500000) break;
			if(visit[tmp][M]!=-1) return;
		}
		time=-1;
	}

}
