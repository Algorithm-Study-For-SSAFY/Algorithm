package March_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//영역구하기
public class Main_2583 {
	private static int N,M,K;
	private static int map[][];
	private static boolean[][] visit;
	private static int dr[]= {1,-1,0,0};
	private static int dc[]= {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		for(int k=0; k<K; k++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			for(int i=a; i<x; i++) {
				for(int j=b; j<y; j++) {
					map[i][j]=1;
				}
			}
		}//end of input

		visit=new boolean[N][M];
		ArrayList<Integer> list=new ArrayList<>();
		int answer=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0 && !visit[i][j]) {
					//bfs돌기
					int result=bfs(i,j);
					list.add(result);
					answer++;
				}
			}
		}
		
		//list 오름차순 정렬후 answer과 함께 출력하기
		Collections.sort(list);
		StringBuilder sb=new StringBuilder();
		sb.append(answer).append("\n");
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb.toString());
		
	}
	private static int bfs(int x, int y) {
		Queue<int[]> q=new LinkedList<>();
		q.offer(new int[] {x,y});
		visit[x][y]=true;
		int cnt=1;
		while(!q.isEmpty()) {
			int[] p=q.poll();
			int r=p[0];
			int c=p[1];
			for(int i=0; i<4; i++) {
				int nr=r+dr[i];
				int nc=c+dc[i];
				if(nr>=0 && nc>=0 && nr<N && nc<M && map[nr][nc]==0 && !visit[nr][nc]) {
					visit[nr][nc]=true;
					q.offer(new int[] {nr,nc});
					cnt++;
				}
			}
		}
		return cnt;
	}
}
