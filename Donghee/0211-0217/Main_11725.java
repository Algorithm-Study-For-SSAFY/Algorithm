package feb_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 트리의 부모찾기
 * Arraylist 활용하기.크기가 가변적으로 변하는 선형리스트
 */
public class Main_11725 {
	
	static int N;
	static ArrayList<Integer> []tree;
	static boolean visit[];
	static int parent[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		//Arraylist 를 사용해서 연결되어있음을 표현 , 
		visit=new boolean[N+1];
		tree=new ArrayList[N+1]; //arraylist가 1~N개 노드필요
		parent=new int[N+1];
		for(int i=1; i<=N; i++) {
			tree[i]=new ArrayList<>(); //i 노드에 대한 연결리스트 생성
		}
		StringTokenizer st;
		for(int i=1; i<=N-1; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a); //연결 표시,
		}
		DFS(1);
		for(int i=2; i<=N; i++)
			System.out.println(parent[i]);
	}//end of main
	private static void DFS(int x) { //x 노드를 탐색
		visit[x]=true;
		//x 노드와 연결되어있는 노드들을 탐색함, 연결되어있는 노드가 false면 해당 노드의 부모는 x
		for(int i: tree[x]) { //tree x에 있는 원소들 탐색
			if(!visit[i]) {
				parent[i]=x;
				DFS(i);
			}
		}
		
	}
}//end of input
