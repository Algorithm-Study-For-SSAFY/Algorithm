import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

//
public class boj1966 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//중요도가 높은 문서 순서대로 출력된다.
		//중요도가 같은 문서가 있기에, pq만 쓰면 안될거같음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer stk;
		for(int t=1; t<=T; t++) {
			
			stk = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(stk.nextToken());
			int M = Integer.parseInt(stk.nextToken());
			Queue<word> q = new LinkedList<>();
			PriorityQueue<word> pq = new PriorityQueue<>();
			stk = new StringTokenizer(br.readLine()); //중요도 읽어들이는 라인.
			
			for(int i=0; i<N; i++) {
				int imp = Integer.parseInt(stk.nextToken());
				pq.offer(new word(i, imp));
				q.offer(new word(i, imp));
			}
			int cnt = 0;
			while(q.size() > 0) {
				word tmp;
				if(q.peek().imp == pq.peek().imp) {
					tmp = q.poll();
					pq.poll();
					cnt++;
					if(tmp.idx == M) {
						System.out.println(cnt);
					}
				}
				else {//최고 중요도보다 낮다는 의미
					tmp = q.poll();
					q.offer(tmp);
				}
			}
		
		
		}//test case
		
	}
}

class word implements Comparable<word>{
	int idx;
	int imp; // importance
	public word() {
		// TODO Auto-generated constructor stub
	}
	
	
	public word(int idx, int imp) {
		super();
		this.idx = idx;
		this.imp = imp;
	}


	@Override
	public int compareTo(word o) {
		// TODO Auto-generated method stub
		return -(this.imp - o.imp); // 내림차순
	}
}
