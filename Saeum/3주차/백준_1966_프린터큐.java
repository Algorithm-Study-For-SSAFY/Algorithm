package week3;
import java.util.*;
 
public class 백준_1966_프린터큐 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int T = in.nextInt();	 
 
		while (T-- > 0) {
			
			int N = in.nextInt();
			int M = in.nextInt();
			
			LinkedList<int[]> q = new LinkedList<>();	// Queue로 활용 할 연결리스트
 
			for (int i = 0; i < N; i++) {
				// {초기 위치, 중요도}
				q.offer(new int[] { i, in.nextInt() });
			}
 
			int count = 0;
			
			Loop: while (!q.isEmpty()) {	// 한 케이스에 대한 반복문
				
				int[] front = q.poll();	// 가장 첫 원소

				// 큐에 남아있는 원소들과 중요도를 비교 
				for(int i = 0; i < q.size(); i++) {
					
					// 처음 뽑은 원소보다 큐에 있는 i번째 원소가 중요도가 클 경우 
					if(front[1] < q.get(i)[1]) {
						
						// 뽑은 원소 및 i 이전의 원소들을 뒤로 보낸다.
						q.offer(front);
						for(int j = 0; j < i; j++) {
							q.offer(q.poll());
						}
						continue Loop;
					}
				}

				// front 원소가 가장 큰 원소였으므로 해당 원소 출력 
				count++;
				if(front[0] == M) {	// 찾고자 하는 문서라면 해당 테스트케이스 종료
					break;
				}
 
			}
 
			sb.append(count).append('\n');

		}
		System.out.println(sb);
	}
 
}
