package feb_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_3584 {
	static int T, N;
	static ArrayList<Integer> tree[];
	static ArrayList<Integer> ad1; //주어진 하나의 노드의 부모, 조상노드를 모아놀 배열
	static ArrayList<Integer> ad2;
	static int node1, node2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1; tc<=T; tc++) {
			N=Integer.parseInt(br.readLine());
			tree=new ArrayList[N+1]; //트리 1번~N번,
			for(int i=0; i<=N; i++) {
				tree[i]=new ArrayList<>();
			}
			for(int i=0; i<N-1; i++) {
				st=new StringTokenizer(br.readLine());
				int a=Integer.parseInt(st.nextToken());
				int b=Integer.parseInt(st.nextToken()); //a가 b의 부모다.
				//자식의 tree 배열에 부모 노드 집어넣기
				tree[b].add(a);
			}//간선정보 입력받기

			st=new StringTokenizer(br.readLine());
			node1=Integer.parseInt(st.nextToken());
			node2=Integer.parseInt(st.nextToken()); //조상이 궁금한 노드 1, 2
			ad1=new ArrayList<>();
			ad2=new ArrayList<>();
			//end of input
			ad1.add(node1); //자기 자신 노드 넣기
			ad2.add(node2); //자기 자신 노드 넣기
			searchParent(1, node1, ad1);
			searchParent(1,node2, ad2);
			//ad1과 ad2가 같은게 나올 때 까지 진행 루트 노드부터보자.
//			for(int i=0; i<ad1.size(); i++)
//				System.out.println(ad1.get(i));
//			System.out.println("****");
//			for(int i=0; i<ad2.size(); i++)
//				System.out.println(ad2.get(i));
			
			int i=ad1.size()-1; int j=ad2.size()-1;
			System.out.println(i+" "+j);
			//처음엔 root노드라서 무조건 같음. 
			while(ad1.get(i)==ad2.get(j)) {
				i--; j--;
				if(i<0 || j<0)
					break;
			}
			if(i<0) System.out.println(ad1.get(0));
			else if(j<0) System.out.println(ad2.get(0));
			else System.out.println(ad1.get(i+1));
			
		}//end of tc
	}//end of main
	//arraylist에 연속적인 부모노드 집어넣기,
	//ex. 1번노드의 부모 2번, 2번노드의 부모노드 3번,,,,,
	private static void searchParent(int idx, int node, ArrayList<Integer> arr) {
		if(tree[node].isEmpty()) 
			return; //루트 노드면 종료
		arr.add(tree[node].get(0)); //node의 부모노드 넣는 작업
		searchParent(idx+1, arr.get(idx), arr);
	}
}//end of class
