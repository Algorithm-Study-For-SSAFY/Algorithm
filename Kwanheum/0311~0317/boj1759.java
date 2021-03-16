package algo_study_7w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class boj1759 {
	private static int L;
	private static int C;
	private static char[] arr;
	private static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		L = Integer.parseInt(stk.nextToken());
		C  = Integer.parseInt(stk.nextToken());
		stk = new StringTokenizer(br.readLine());
		arr = new char[C];
		for(int i=0; i<C; i++) {
			arr[i] = stk.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		sb = new StringBuilder();
		func(0, 0, 0, "");
		System.out.println(sb);
	}//main
	
	static void func(int cnt, int m, int j, String pw) {
		if( m+j == L) {
			if(m>=1 && j>=2) {
				sb.append(pw).append("\n");
			}
			return;
		}
		
		for(int i=cnt; i<C; i++) {
			char x = arr[i];
			if( "aeiou".contains(x+"")) {
				func(i+1, m+1, j, pw+x);
			}
			else {
				func(i+1, m, j+1, pw+x);
			}
		}
	}
}
