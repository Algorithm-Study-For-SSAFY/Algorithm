package al_3주차;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_백준_11725_트리의부모찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// 노드의 개수

		ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();
		int parents[] = new int[N + 1];

		for (int i = 0; i <= N+1; i++) {
			tree.add(new ArrayList<Integer>());
		} // 리스트 

		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			tree.get(node1).add(node2);
			tree.get(node2).add(node1);
		} // 부모 자식 연결

		// bfs 사용
		int start = 1;
		BFS(start, tree, parents, N);
		printParents(parents); // 결과 출력
	}

	static void BFS(int start, ArrayList<ArrayList<Integer>> tree, int[] parents, int n) {
		LinkedList<Integer> link = new LinkedList<Integer>();
		link.offer(start);
		parents[start] = 1; // 루트는 1
		while (!link.isEmpty()) {
			int parent2 = link.poll();

			for (int num : tree.get(parent2)) {
				if (parents[num] == 0) {
					parents[num] = parent2;
					link.offer(num);
				}
			}
			}
		}

	 static void printParents(int[] parents) {
		for (int i = 2; i < parents.length; i++) {
			System.out.println(parents[i]);
		}
	}

}
/////////////////////////
////////관흠 리뷰///////////
/////////////////////////
/*
* BFS개념으로 노드 하나씩 저장후 탐색하는 코드 깔끔하고 좋네요~
*/

