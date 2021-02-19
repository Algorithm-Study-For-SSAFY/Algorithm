package Feb_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15787 {
	static private int N, M;
	static private int train[];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		train=new int[N+1];
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			switch(a) {
			case 1:
				in(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
				break;
			case 2:
				out(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
				break;
			case 3:
				back(Integer.parseInt(st.nextToken()));
				break;
			case 4:
				front(Integer.parseInt(st.nextToken()));
				break;
			}
		}//end of input
		int ans=1; //무조건 1번 기차는 떠날수 있다,
		for(int i=2; i<=N; i++) {
			boolean flag=true;
			for(int j=1; j<i; j++) {
				if(train[i]==train[j]) { //같은게 발견되는 순간, 
					flag=false;
					break;
				}
			}
			if(flag) ans++;
		}
		System.out.println(ans);
	}//end of main

	private static void front(int x) {
		//앞으로 한칸씩 이동
		train[x]=(train[x]>>>1); //비는 부호는 0으로 채우기,0번쨰 비트는 무조건 0이 되어야함
		train[x]=(train[x] & ~1);
	}

	private static void back(int x) {
		// TODO Auto-generated method stub
		train[x]=(train[x]<<1); //21번쨰에는 0으로 채워야함
		train[x]=(train[x] & ~(1<<21));
	}

	private static void out(int x, int y) {
		// TODO Auto-generated method stub
		train[x]=(train[x]&~(1<<y));
	}

	private static void in(int x, int y) {
		//x번째 기차에 y자리에 넣기
		train[x]=(train[x] | (1<<y));
	}
}
