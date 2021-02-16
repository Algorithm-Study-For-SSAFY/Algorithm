package week3;

import java.util.*;

public class 백준_1068_트리 {

//	단일노드인데 제거할 노드가 루트노드 인 경우
//	단일노드인데 노드를 제거 안하는 경우
//	루트노드가 0번 노드가 아닌경우
//	루트노드가 제거될때 

	static int n;
	static int[][] graph;
	static boolean[] visit;
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 트리의 노드 개수
		graph = new int[n][n];
		visit = new boolean[n];
		int root = 0;

		for (int i = 0; i < n; i++) {
			int parent = sc.nextInt();
			if (parent == -1) {
				root = i;
				continue;
			}
			graph[i][parent] = graph[parent][i] = 1; // 양방향 그래프 생성
		}

		int delete = sc.nextInt();
		if (n == 1 && delete == 0) {// 단일노드인데 제거할 경우
			System.out.println(0);
			return;
		} else if (n == 1 && delete != 0) { // 단일노드인데 제거 안할 경우
			System.out.println(1);
			return;
		}
		deleteNode(delete);
		if (!visit[root]) {// 루트가 제거되면 탐색할 필요 없음
			dfs(root);
		}
		System.out.println(cnt);
	}

	public static void dfs(int v) {
		boolean isLeaf = true;
		visit[v] = true;
		for (int i = 0; i < n; i++) {
			if (!visit[i] && graph[v][i] == 1) {
				isLeaf = false; // if문에 걸리면 리프노드 아님
				dfs(i);
			}
		}
		if (isLeaf) {// 리프노드이면 카운트++
			cnt++;
		}
	}

	public static void deleteNode(int target) {
		for (int i = 0; i < n; i++) {
			graph[target][i] = graph[i][target] = 0;
		}
		visit[target] = true;// 루트가 제거될 경우 대비
	}

}
