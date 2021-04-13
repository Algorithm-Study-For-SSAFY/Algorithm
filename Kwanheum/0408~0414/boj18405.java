package algo_study_11w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj18405 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());
		int map[][] = new int[N+1][N+1];
		ArrayList<Node> list = new ArrayList<>();
		for(int i=1; i<=N; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
				if(map[i][j]!=0) {
					list.add(new Node(map[i][j], i, j));
				}
			}
		}
		list.sort((a, b) -> {return a.number-b.number;});
		Queue<Node> q = new LinkedList<>();
		for(int i=0 , len =list.size(); i<len; i++) {
			q.add(list.get(i));
		}
	
		stk = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(stk.nextToken());
		int X = Integer.parseInt(stk.nextToken());
		int Y = Integer.parseInt(stk.nextToken());
		//input end
		int time = 0;
		int dr[] = {-1, 0, 1, 0};
		int dc[] = {0, 1, 0, -1};
		while(time < S) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				Node tmp = q.poll();
				for(int j=0; j<4; j++) {
					int nr = tmp.r + dr[j];
					int nc = tmp.c + dc[j];
					if(nr>=1&&nr<=N &&nc>=1&&nc<=N) {
						if(map[nr][nc] ==0) {
							map[nr][nc] = tmp.number;
							q.add(new Node(tmp.number, nr, nc));
						}
					}
				}
			}
			time++;
			/*if(time == S) {
				break;
			}*/
		}//while
		
		System.out.println(map[X][Y]);
	}
	static class Node{
		int number , r, c;

		public Node(int number, int r, int c) {
			super();
			this.number = number;
			this.r = r;
			this.c = c;
		}

		
	}
}
