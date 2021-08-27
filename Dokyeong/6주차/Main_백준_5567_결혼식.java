package al_6주차;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*문제 요약
 * 
 * 아이디어 
 * 그래프 -상근이와 친구들 양방향 그래프
 * 인접리스트 
 * BFS탐색
 * */
public class Main_백준_5567_결혼식 {
	static int N, M, friend1, friend2, cnt;
	static int[] check;
	static ArrayList<Integer>[] v = new ArrayList[501];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 상근이 동기수 : N-1명
		M = sc.nextInt(); // 리스트 길이
		for (int i = 1; i <= N; i++) {
			v[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) { // 양방향 그래프 연결
			friend1 = sc.nextInt();
			friend2 = sc.nextInt();
			v[friend1].add(friend2);
			v[friend2].add(friend1);
		}
		check = new int[N + 1];
		check[1] = 1;
		bfs(1);
		cnt = 0;
		for (int i = 2; i <= N; i++) {
			if (check[i] == 2 || check[i] == 3) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}// end of main
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);

		while (!q.isEmpty()) {
			int node = q.poll();

			for (int next : v[node]) {// bfs 탐색
				if (check[next] == 0) {
					check[next] = check[node] + 1;
					q.offer(next);
				}
			}
		}
	}
} // end of class
