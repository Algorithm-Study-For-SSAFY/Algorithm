package May_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//계란으로 계란치기
public class Main_16987 {
	private static int N; //계란 수
	private static int s[], w[]; //내구도+무게,
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		s=new int[N];
		w=new int[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			s[i]=Integer.parseInt(st.nextToken());
			w[i]=Integer.parseInt(st.nextToken());
		}
		visit=new boolean[N]; //깨졌으면 true로바꾸기
		answer=0;
		comb(0,0);
		System.out.println(answer);
	}
	private static int answer;
	private static boolean visit[];
	private static void comb(int cnt, int ans) {
		if(cnt==N) {
			//모든 계란을 깬 상태라면,
			answer=Math.max(answer, ans);
			return;
		}
		//만약, 자기빼고 다 깨진상태면 더이상 깨질게 없다.
		if(ans==N-1) {
			answer=Math.max(answer, N-1);
			return;
		}
		if(visit[cnt]) {
			comb(cnt+1,ans); //이미 해당 계란 깨진 상태라면, pass
		}
		
		for(int i=0; i<N; i++) {
			if(visit[i] || i==cnt || visit[cnt]) continue; //안깬 계란 상대로
			
			//i번째 계란과 부딪혔을 때
			int w1=w[cnt]; int w2=w[i];
			s[cnt]-=w2; s[i]-=w1;
			int tmp=0;
			if(s[i]<=0) {
				tmp+=1;
				visit[i]=true;
			}
			if(s[cnt]<=0) {
				tmp+=1;
				visit[cnt]=true;
			}
			comb(cnt+1, ans+tmp);
			visit[i]=false;
			visit[cnt]=false;
			s[cnt]+=w2; s[i]+=w1;
		}
	}
}
