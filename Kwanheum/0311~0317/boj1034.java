package algo_study_7w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1034 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		
		String[] s_arr = new String[N];
		int arr[][] = new int[N][M];
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			s_arr[i] = input;
			for(int j=0; j<M; j++) {
				arr[i][j] = input.charAt(j) - '0';
			}
		}//for
		//input end
		int K = Integer.parseInt(br.readLine());
		boolean flag[] = new boolean[N];
		for(int i=0; i<N; i++) {
			int cnt = 0;
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 0 )	cnt++;
			}
			
			if(cnt <=K && (cnt%2 == K%2)) {
				flag[i] = true; // K번해서 1로 채울수 있는 row
			}
		}
		// 버튼을 누르면 열이 모두 바뀌기 때문에 K번 눌러서 1로 모두 채워지는 row들 중, 숫자 구성이 동일해야 동시에 1로채우기가능
		int answer = 0;
		for(int i=0; i<N; i++) {
			int tmp =1;
			if(flag[i]) {
				for(int j=i+1; j<N; j++) {
					if(s_arr[i].equals(s_arr[j])) {
						flag[i] = false;
						tmp++;
					}
				}
                answer = Math.max(tmp, answer);
			}
		}
		
		System.out.println(answer);
	}//main
}
