package March_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1759 {
	private static int L, C;
	private static int cnt[];
	private static boolean visit[];
	private static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		sb=new StringBuilder();
		L=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		cnt=new int[26];
		visit=new boolean[26];
		for(int i=0; i<C; i++) {
			char c=st.nextToken().charAt(0);
			//모음이면 1, 자음이면 2로 표시
			if(c=='a' || c=='e'||c=='i'||c=='o'||c=='u') {
				cnt[c-'a']=1;
			}else {
				cnt[c-'a']=2;
			}
		}
		comb(0,0,0);
		System.out.println(sb.toString());
	}
	//a는 모음 뽑은 갯수, b는 자음 뽑은 갯수
	private static void comb(int idx, int a, int b) {
		//제거해야할 조건, a는 최소1개 b는 최소2개 
		if(b==L || a>=L-1) {
			return;
		}
		if(a+b==L) {
			for(int i=0; i<26; i++)
				if(visit[i]) {
					sb.append((char)('a'+i));
				}
			sb.append("\n");
			return;
		}
		
		for(int i=idx; i<26; i++) {
			if(cnt[i]==1) {
				visit[i]=true;
				comb(i+1, a+1, b);
				visit[i]=false;
			}else if(cnt[i]==2) {
				visit[i]=true;
				comb(i+1, a,b+1);
				visit[i]=false;
			}
		
		
		}//end of comb
	}
}
