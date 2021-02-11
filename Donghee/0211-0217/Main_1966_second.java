package feb_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//프린터 큐를 class로 정의해서?
//(현재 위치, 중요도, 내가 찾을 애인지 flag) 로 관리하면 ? 쉬울듯

public class Main_1966_second {
	static private class Priority{
		int idx; //현재 위치
		int prior; //중요도
		private Priority(int idx, int prior) {
			super();
			this.idx = idx;
			this.prior = prior;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			Queue<Priority> q=new LinkedList<>();
			st=new StringTokenizer(br.readLine());
			int answer=0;
			for(int n=0; n<N; n++) {
				int a=Integer.parseInt(st.nextToken());
				q.offer(new Priority(n,a)); //현재 들어온 순서 , 중요도 q에 넣기
			}//end of input
			
			while(!q.isEmpty()) {
				Priority now=q.poll();
				boolean flag=true;
				//중요도 비교하기
				for(Priority p:q) {
					if(p.prior>now.prior) { //현재꺼보다 큰 우선순위가 나오면,
						flag=false;
						q.offer(now);
						break;
					}
				}
				if(flag) {
					answer++;
					//제거하려는 프린터가 찾던 것인지,
					if(now.idx==M) {
						System.out.println(answer);
						break;
					}
				}
			}//end of while
		}//end of tc
	}
}
