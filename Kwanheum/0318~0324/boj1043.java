package algo_study_8w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj1043 {
	private static int N;
	private static int M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		parents = new int[N+1]; //사람의 번호는 1~N까지
		make();
		
		stk = new StringTokenizer(br.readLine());
		int known_n = Integer.parseInt(stk.nextToken());
		int knowns[] = new int[known_n];
		for(int i=0; i<known_n; i++) {
			knowns[i] = Integer.parseInt(stk.nextToken());
			if(i!=0) {
				//진실을 아는 사람들을 하나의 union으로 합침
				union(knowns[i], knowns[i-1]);
			}
		}
		int party[][] = new int[M][51];
		for(int m=0; m<M; m++) {
			stk = new StringTokenizer(br.readLine());
			int party_n = Integer.parseInt(stk.nextToken());
			party[m][0] = party_n;
			for(int x=1; x<=party_n; x++) {
				party[m][x] = Integer.parseInt(stk.nextToken());
				if(x!=1) {
					//해당 파티의 사람들을 합침
					//진실을 아는 사람이 포함되어 있다면 진실을 아는 그룹에 포함됨
					union(party[m][x], party[m][x-1]);
				}
			}
		}
		/*for(int i=1; i<=N; i++) {
			System.out.println(parents[i]);
		}*/
		int answer = 0;
		if(known_n == 0) answer = M;
		else {
			int known_union = find_p(knowns[0]);
			for(int m=0; m<M; m++) {
				int party_n = party[m][0];
				boolean flag = false;
				for(int x=1; x<=party_n; x++) {
					if(find_p(party[m][x]) == known_union) {
						flag = true;
						break;
					}
				}
				if(!flag) answer++;
			}
		}
		System.out.println(answer);
		
	}
	static int[] parents;
	static void make() {
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
	}
	
	static int find_p(int x) {
		if(parents[x] == x) return x;
		else {
			return parents[x] = find_p(parents[x]);
		}
	}
	
	static void union(int x, int y) {
		int p_x = find_p(x);
		int p_y = find_p(y);
		if(p_x == p_y) return;
		else {
			parents[p_y] = p_x;
		}
	}
	
	
	
	
	
	
	
	
	
	
}	
