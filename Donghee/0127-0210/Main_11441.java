package feb_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 합구하기
 * N 개의 수 입력으로 들어옴, 
 */
public class Main_11441 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int []map=new int[N+1];
		StringTokenizer st=new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		
		for(int i=1; i<=N; i++) {
			map[i]=Integer.parseInt(st.nextToken());
		}
		int T=Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int sum=0;
			for(int j=a; j<=b; j++) {
				sum+=map[j];
			}
			sb.append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}
}
