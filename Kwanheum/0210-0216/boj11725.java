import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj11725 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List [] arr = new LinkedList[N+1];//0 is dummy
		for(int i=1; i<=N; i++) {
			arr[i] = new LinkedList<Integer>();
		}
		StringTokenizer stk;
		for(int i=0; i<N-1; i++) { //N-1개의 줄
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		boolean chk[] = new boolean [N+1];
		int answer[] = new int[N+1];
		while(!q.isEmpty()) {
			int now = q.poll();
			//System.out.println(now);
			chk[now] = true;
			for(int i=0; i<arr[now].size(); i++) {
				int tmp = (int) arr[now].get(i);
				if(!chk[tmp]) {
					chk[tmp] = true; //부모노드로 다시 가는것을 막기 위해 방문 체크
					q.offer(tmp);
					answer[tmp] = now;
				}
			}//for
		}
		StringBuilder sb = new StringBuilder();
		for(int i=2; i<=N; i++) {
			sb.append(answer[i]).append("\n");
		}
		System.out.println(sb);
	}
}
