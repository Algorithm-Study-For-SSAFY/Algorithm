package April_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2667 {
	private static int map[][];
	private static int N;
	private static ArrayList<Integer> answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		for(int i=0; i<N; i++) {
			String str=br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}
		visit=new boolean[N][N];
		answer=new ArrayList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visit[i][j]) continue;
				visit[i][j]=true;
				if(map[i][j]==1) bfs(i,j);
			}
		}
		Collections.sort(answer);
		System.out.println(answer.size());
		for(int i=0; i<answer.size(); i++) {
			System.out.println(answer.get(i));
		}
	}
	private static void bfs(int x, int y) {
		Queue<int[]>q=new LinkedList<>();
		q.add(new int[] {x,y});
		int cnt=1;
		while(!q.isEmpty()) {
			int[]p=q.poll();
			int r=p[0]; int c=p[1];
			for(int i=0; i<4; i++) {
				int nr=r+dr[i]; int nc=c+dc[i];
				if(nr>=0 && nc>=0 && nr<N && nc<N && !visit[nr][nc] && map[nr][nc]==1) {
					visit[nr][nc]=true;
					cnt++;
					q.add(new int[] {nr,nc});
				}
			}
		}
		answer.add(cnt);
	}
	private static boolean visit[][];
	private static int dr[]= {1,-1,0,0};
	private static int dc[]= {0,0,1,-1};
}
