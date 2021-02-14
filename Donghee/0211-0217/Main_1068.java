package feb_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1068 {
	static int N, deleteNode, answer;
	static boolean visit[];
	static ArrayList<Integer> []tree;
	static Queue <Integer> q=new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		tree=new ArrayList[N];
		visit=new boolean[N];
		for(int i=0; i<N; i++) {
			tree[i]=new ArrayList<>();
		}
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			int a=Integer.parseInt(st.nextToken());
			if(a==-1) { //루트노드라면
				q.offer(i);
			}else {
				tree[a].add(i);
				tree[i].add(a);
			}
		}//end of input
		deleteNode=Integer.parseInt(br.readLine());
		while(!q.isEmpty()) {
			DFS(q.poll());
		}
		System.out.println(answer);
		
	}
	private static void DFS(int node) {
		if(node==deleteNode)
			return;
		visit[node]=true;
		int cnt=0;
		for(int idx: tree[node]) {
			if(!visit[idx] && idx!=deleteNode) {
				visit[idx]=true;
				cnt++;
				DFS(idx);
			}
		}
		if(cnt==0) {
			answer++;
		}
	}
	
}

//확인 
