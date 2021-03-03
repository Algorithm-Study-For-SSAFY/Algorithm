package March_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_5567 {
	private static int N, m, answer;
	private static int map[][];
	private static boolean visit[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N=Integer.parseInt(br.readLine());
		m=Integer.parseInt(br.readLine());
		map=new int[N+1][N+1];
		visit=new boolean[N+1];
		for(int i=0; i<m; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			map[a][b]=1; map[b][a]=1;
			if(a==1) {
				answer++; visit[b]=true;
			}else if(b==1) {
				answer++; visit[a]=true;
			}
		}
		ArrayList<Integer>list=new ArrayList<>();
		for(int i=2; i<=N; i++) {
			if(visit[i]) {
				list.add(i);
			}
		}
		for(int i=0; i<list.size(); i++) {
			findChild(list.get(i));
		}
		System.out.println(answer);
	}
	private static void findChild(int x) {
		//x의 child구하기
		for(int i=2; i<=N; i++) {
			if(map[x][i]==1 && !visit[i]) {
				answer++;
				visit[i]=true;
			}
		}
	}
}
