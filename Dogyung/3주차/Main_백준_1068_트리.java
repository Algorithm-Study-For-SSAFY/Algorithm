package al_3주차;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_백준_1068_트리 {
	static boolean[] check;
	static int sum=0, deleteNode;
	static ArrayList<Integer>[] tree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 노드의 개수
		tree = new ArrayList[N];
		check = new boolean[N];
		int root = 0;

		for (int i = 0; i < N; i++) {
			tree[i] = new ArrayList(); // 각 노드의 연결리스트 생성
		}
		for (int i = 0; i < N; i++) {
			int parent = sc.nextInt(); // 부모노드 입력
			if (parent != -1) {
				tree[i].add(parent);
				tree[parent].add(i);
			} else // 부모가 -1이면
			root = i;
		}
		deleteNode = sc.nextInt(); // 삭제할 노드
		if (deleteNode == root) { // 삭제할 노드가 루트면 무조건 0출력
			System.out.println(0);
		} else { // 아니면
			DFS(root);
			System.out.println(sum);
		}
	}

	static void DFS(int node) {
		check[node] = true;
		int child = 0; // 자식노드 수
		for (int i = 0; i < tree[node].size(); i++) {
			int chnode = tree[node].get(i); // 자식 노드의 자식
			if (check[chnode] == false && chnode != deleteNode) {
				child++;
				DFS(chnode); //그 아래 자식 노드 검사 
			}
		}
		if (child == 0) {
			sum++;
		}
	}
}// end of class

/////////////////////////
////////관흠 리뷰///////////
/////////////////////////
/*
 * 저는 케이스 별로 조건을 처리해준다고 조금 머리아팠는데
 * 트리를 구성해서 DFS로 탐색을 하니 훨씬 깔끔하게 되네요!
 * goodgood!!
 * 
 * */

