import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj3584 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer stk;
		for(int t=0; t<T; t++) {
			int N  = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N+1];
			boolean chk[] = new boolean[N+1];
			for(int n=0; n<N-1; n++) {
				stk = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(stk.nextToken());
				int b = Integer.parseInt(stk.nextToken());
				arr[b] = a; //b index에 a인 부모 저장.
				chk[b] = true; //b가 부모를 가지니까 루트가 아니다.
			}
			int target_a, target_b;
			stk = new StringTokenizer(br.readLine());
			target_a = Integer.parseInt(stk.nextToken());
			target_b = Integer.parseInt(stk.nextToken());
			
			//루트 찾기
			int root = 0;
			for(int n=1; n<=N; n++) {
				if(!chk[n]) root = n;
			}
			List<Integer> a = new LinkedList<>();
			List<Integer> b = new LinkedList<>();
			
			// target a , target b의 root까지의 모든 노드 들을 list에 저장
			int now = target_a;
			while(true) {
				if(now == root) {
					a.add(now);
					break;
				}
				a.add(now);
				now = arr[now];
			}
			now = target_b;
			while(true) {
				if(now == root) {
					b.add(now);
					break;
				}
				b.add(now);
				now = arr[now];
			}
			
			int a_size = a.size();
			int b_size = b.size();
			int answer = 0;
			
			// 각각의 list를 역순으로 확인하면서 다른 값이 나올 때, 바로 직전값이 가장 깊은 공통 조상
			while(true) {
				if(a_size<=0 || b_size<=0 || !(a.get(a_size-1).equals(b.get(b_size-1))) ) {//가장마지막원소 = root
					answer = a.get(a_size);
					break;
				}
				a_size--;
				b_size--;
				
			}
			System.out.println(answer);
			
		}//test case
	}
}

//집단 지성의 힘,,, !!! 감사합니다 허허
