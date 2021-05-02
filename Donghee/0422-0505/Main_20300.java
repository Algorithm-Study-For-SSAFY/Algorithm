package April_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//서강근육맨
public class Main_20300 {
	private static int N;
	private static long map[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		map=new long[N];
		for(int i=0; i<N; i++) {
			map[i]=Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(map);
		long answer=map[0];
		//짝수/ 홀수
		if(N==1) {
			answer=map[0];
		}else if(N%2==0) {
			//짝
			for(int i=0; i<N/2; i++) {
				answer=Math.max(answer, map[i]+map[N-i-1]);
			}
		}else {
			//홀
			for(int i=0; i<(N-1)/2; i++) {
				answer=Math.max(answer, map[i]+map[N-1-i-1]);
			}
			answer=Math.max(answer, map[N-1]);
		}
		System.out.println(answer);
	}
}
