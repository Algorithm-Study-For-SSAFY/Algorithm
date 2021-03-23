package algo_study_8w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class boj18870 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//압축 = 좌표보다 값이 작은 서로다른 좌표의 개수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		Map<Integer ,Integer> m = new HashMap<>();
		int arr[] = new int[N];
		int origin[] = new int[N];
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(stk.nextToken());
			arr[i] = x;
			origin[i] = x;
		}
		
		Arrays.sort(arr);
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(! m.containsKey( arr[i] )) {
				m.put(arr[i], cnt++);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N; i++) {
			sb.append(m.get(origin[i])).append(" ");
		}
		System.out.println(sb);

	}//main
}
