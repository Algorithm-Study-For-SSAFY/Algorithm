package feb_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_가장가까운조상 {
	static int T, N;
	
	static ArrayList<Integer> ad1; //구하려는 node1, node2 각각의 조상들을 모아놓은 arraylist.
	static ArrayList<Integer> ad2;
	
	static int tree[];
	static int node1, node2;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1; tc<=T; tc++) {
			N=Integer.parseInt(br.readLine());
			tree=new int[N+1]; //트리 1번~N번,
			tree[0]=-1; //노드 0번은 없으니까
			
			for(int i=0; i<N-1; i++) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken()); //a가 b의 부모다.
				tree[b]=a; //자식노드 idx에 부모노드 값 집어넣기.
			}//루트 노드 : 값이 0인 노드,기본값 0
			
			st=new StringTokenizer(br.readLine());
			node1=Integer.parseInt(st.nextToken());
			node2=Integer.parseInt(st.nextToken()); //조상이 궁금한 노드 1, 2
			
			//자기 자신이 조상이 될 수 있으므로 노드 집어넣기
			ad1=new ArrayList<Integer>();
			ad2=new ArrayList<Integer>();
			//end of input
			ad1.add(node1); //자기 자신 노드 넣기
			ad2.add(node2); //자기 자신 노드 넣기
			
			searchParent(node1, ad1);
			searchParent(node2, ad2);
			
			//ad1과 ad2의 마지막 원소는 무조건 루트노드,
			int i=ad1.size()-1; int j=ad2.size()-1;
			
			while(ad1.get(i).equals(ad2.get(j))) { //같을 때 동안 반복
				i--; j--;
				if(i<0 || j<0)
					break;
			}
			
			if(i<0) System.out.println(node1); //적어도 ad1의 0과 ad2의 어떤것은 같은 노드였다는 것.
			else if(j<0) System.out.println(node2);
			else System.out.println(ad1.get(i+1));
		}//end of tc
	}//end of main
	
	private static void searchParent(int node, ArrayList<Integer> list) {
		
		//전달받은 node의 부모로 올라가기
		if(tree[node]==0)
			return; //얘가 루트노드란 뜻 (부모가 없으니까)
		list.add(tree[node]);
		searchParent(tree[node], list);
	}
}
