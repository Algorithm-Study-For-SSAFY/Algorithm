package March_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17103_골드바흐파티션 {
	private static boolean flag[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		flag=new boolean[1000001];
		flag[1]=true;
		for(int i=2; i<=Math.sqrt(1000000); i++) {
			for(int j=2; i*j<=1000000; j++) {
				flag[i*j]=true;
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			int n=Integer.parseInt(br.readLine());
			//자기보다 n/2까지만 확인하면 됨,
			int answer=0; 
			int val=0;
			for(int i=2; i<=n/2; i++) {
				if(!flag[i] && !flag[n-i]) answer++;
			}
			sb.append(answer).append("\n");
		}//end of input
		System.out.println(sb.toString());
	}
}
