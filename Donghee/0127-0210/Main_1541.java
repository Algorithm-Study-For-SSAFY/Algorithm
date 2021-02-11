package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1541 {
	public static void main(String[] args) throws IOException {
		//최대한 -를 붙여서 여러번 해줘야 최솟값을 만들수 있다.
		//이때 stringtokenizer이용해서 -로 토큰들 나눠주기
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine(),"-");
		//token이 없을 때 까지 진행하기
		int sum=Integer.MAX_VALUE;
		while(st.hasMoreTokens()) {
			int answer=0;
//			st.nextToken() 여기에 값이 저장되어있으니까 , 다시 +로 쪼개기.
			StringTokenizer st2=new StringTokenizer(st.nextToken(),"+");
			while(st2.hasMoreTokens()) {
				answer+=Integer.parseInt(st2.nextToken());
			}
			if(sum==Integer.MAX_VALUE)
				sum=answer;
			else {
				sum-=answer;
			}
			
		}
		System.out.println(sum);
	}
}
