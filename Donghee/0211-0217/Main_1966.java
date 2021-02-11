package feb_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 프린터 큐
 * 1. 현재 큐의 가장 앞에있는 문서의 중요도 확인,
 * 2. 나머지 문서들중 현재문서보다 중요도가 높은 문서가 하나라도 있다면 Queue의 가장 뒤에 재배치
 *
 */
public class Main_1966 {

	static int cnt[]; //1~9까지 중요도를 넣어놓을 카운팅 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int T=Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int N=Integer.parseInt(st.nextToken()); //문서의 갯수
			int M=Integer.parseInt(st.nextToken()); //궁금한 문서가 현재 몇번째 위치
			
			int answer=0; //프린터기 지운 횟수
			cnt=new int[10];
			//문서가 들어올 때 중요도에 해당하는 idx 카운트하기
			Queue <Integer> q=new LinkedList<Integer>();
			st=new StringTokenizer(br.readLine());
			for(int n=1; n<=N; n++) {
				int a=Integer.parseInt(st.nextToken());
				cnt[a]++;
				q.offer(a);
			}//end of input
			while(!q.isEmpty()) {
				int a=q.poll();
				boolean flag=true; //맨 앞에 위치한 프린터를 제거했는지, 뒤로 보냈는지 알기위한 변수
				//a보다 우선순위 높은게 있는지 check
				for(int i=a+1; i<=9; i++) {
					if(cnt[i]>0) {
						//더이상 볼필요 없고, 뒤로 돌려
						q.offer(a);
						M=(M==0)?(N-1-answer):(M-1);
						flag=false;
						break;
					}
				}
				if(flag) {
					answer++;
					//for문 끝나고나면 얘는 우선순위가 더 높은게 없다는 뜻 
					if(M==0) { //우리가 찾던아이면
						System.out.println(answer);
						break;
					}else {
						cnt[a]--;
						M=(M==0)?(N-1-answer):(M-1);
					}
				}
			}//end of while
			
		}//end of tc
	
	}

}
