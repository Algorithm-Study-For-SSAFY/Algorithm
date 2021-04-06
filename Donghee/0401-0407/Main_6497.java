package April_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//전력난
public class Main_6497 {
	
	private static int M, N; //집의 수, 길의 수
	private static ArrayList<Info> list[];
	public static void main(String[] args) throws IOException {
		//불이 켜진 길 만으로 서로 왕래할 수 있게끔
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		while(true) {
			st=new StringTokenizer(br.readLine());
			M=Integer.parseInt(st.nextToken()); //집의 수
			N=Integer.parseInt(st.nextToken()); //길이의 수
			if(M==0 && N==0) break;
			list=new ArrayList[M];
			for(int i=0; i<M; i++)
				list[i]=new ArrayList<>();
			int tmp=0;
			for(int i=0; i<N;i++) {
				st=new StringTokenizer(br.readLine());
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				int z=Integer.parseInt(st.nextToken());
				list[x].add(new Info(y,z));				
				list[y].add(new Info(x,z));	
				tmp+=z;
			}//end of input
			
			//최소비용으로 가로등 세우기
			sb.append(tmp-prim()).append("\n");
		}//end of while
		System.out.println(sb.toString());
	}//end of main
	private static int prim() {
		PriorityQueue<Info> pq=new PriorityQueue<>();
		pq.offer(new Info(0,0)); //0번째 부터 시작
		boolean visit[]=new boolean[M];

		int dist[]=new int[M];
		int result=0;
		for(int i=0; i<M; i++)
			dist[i]=Integer.MAX_VALUE;
		dist[0]=0;
		while(!pq.isEmpty()) {
			Info p=pq.poll();
			int node=p.node;
			int w=p.w;
			if(visit[node]) continue;
			visit[node]=true;
			result+=w;
			//연결되어있는 거 확인하기
			for(Info next:list[node]) {
				if(!visit[next.node] && next.w<dist[next.node]) {
					dist[next.node]=next.w;
					pq.add(new Info(next.node, next.w));
				}
			}
		}
		return result;
	}
	private static class Info implements Comparable<Info>{
		int node, w;
		public Info(int node, int w) {
			super();
			this.node = node;
			this.w = w;
		}
		@Override
		public int compareTo(Info o) {
			return this.w-o.w;
		}
		
	}
}
