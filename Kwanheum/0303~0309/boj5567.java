package algo_study_6w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj5567 {
	static List< List<Integer>> l;
	private static boolean[] chk;
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		l = new LinkedList<>();
		for(int i=0; i<=n; i++) { //0 is dummy;
			l.add(new LinkedList<>());
		}
		StringTokenizer stk;
		for(int i=0; i<m; i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			l.get(a).add(b);
			l.get(b).add(a);
		}
		
		// BFS개념으로 1부터의 거리가 한칸, 두칸인 번호들만 체크 후 답 +1 하는 작업
		chk = new boolean[n+1];
		Queue<Integer> q = new LinkedList<>();
		chk[1] = true;
		answer = 0;
		int cnt = 2; // 친구와 , 친구의친구 까지만.
		q.offer(1);
		while(!q.isEmpty() && cnt>0) {
			int q_size = q.size();
			while(q_size>0) {
				int from = q.poll();
				int size = l.get(from).size();
				for(int i=0; i<size; i++) {
					int idx = l.get(from).get(i);
					if(!chk[idx]) {
						chk[idx] = !chk[idx];
						answer++;
						q.offer(idx);
					}
				}
				q_size--;
			}
			cnt--;
		}//while
		
		System.out.println(answer);
		
		
	}//main
	
}
