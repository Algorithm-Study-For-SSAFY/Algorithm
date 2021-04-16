package April_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//ACM CRAFT, 위상정렬 이용
public class Main_1005 {
	private static int N, K, W;
	private static int cost[]; //건물 n을 건설하기 위한 비용
	private static ArrayList<Integer> list[];
	private static int count[]; //몇번 나왔는지
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
		
			N=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			cost=new int[N+1];
			st=new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				cost[i]=Integer.parseInt(st.nextToken());
			}
			list=new ArrayList[N+1];
			for(int i=0; i<=N; i++) {
				list[i]=new ArrayList<>();
			}
			count=new int[N+1];
//			visit=new boolean[N+1];
			for(int k=0; k<K ; k++ ) {
				st=new StringTokenizer(br.readLine());
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				//x다음 y니까 list[y]에 x를 넣기
				list[x].add(y);
				count[y]++;
			}
			W=Integer.parseInt(br.readLine());
			System.out.println(solve());
		}
	}
	private static int solve() {
		//처음에 0인점들 다 넣기
		Queue<Integer> q=new LinkedList<>();
		int result[]=new int[N+1];
		for(int i=1; i<=N; i++) {
			result[i]=cost[i]; //기본 값, 자기자신 건설 비용, result가 max가 되도록
		}
		for(int i=1; i<=N; i++)
			if(count[i]==0) {
				q.add(i);
			}
		
		while(!q.isEmpty()) {
			int p=q.poll();
			for(int i=0; i<list[p].size(); i++) {
				int newNode=list[p].get(i);
				//도착하는 newNode의 result는
				//원래 자기값 or p를 사용한 result값 비교
				result[newNode]=Math.max(result[newNode], result[p]+cost[newNode]);
				if(--count[newNode]==0) {
					q.add(newNode);
				}
			}
		}
		return result[W];
	}
	
	
	
	
}
