package March_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1486 {
	private static int N, B, result;
	private static int arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			B=Integer.parseInt(st.nextToken());
			st=new StringTokenizer(br.readLine());
			arr=new int[N];
			for(int i=0; i<N; i++)
				arr[i]=Integer.parseInt(st.nextToken());
			result=Integer.MAX_VALUE;
			subset(0,0);
			sb.append("#").append(tc).append(" ").append(result-B).append("\n");
			
		}//end of tc
		System.out.println(sb.toString());
	}//end of main
	
	private static void subset(int cnt, int ans) {
		if(cnt==N) {
			//선택이 모두 결정되면
			if(ans>=B) {
				result=Math.min(result, ans);
			}
			return;
		}
		if(result<ans) return;
		//순서 상관 x
		subset(cnt+1, ans+arr[cnt]);
		subset(cnt+1, ans);
	}
}
