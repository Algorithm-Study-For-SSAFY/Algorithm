import java.io.*;
import java.util.*;

public class 백준_5567_결혼식 {
	private static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		boolean[][] friends = new boolean[n][n];
		int a, b;
		for (int i = 0; i < m; i++) {  
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			friends[a - 1][b - 1] = true;
			friends[b - 1][a - 1] = true;
		}
		boolean[] visit = new boolean[n];
		System.out.println(solution(friends, visit));
	}

	private static int solution(boolean[][] friends, boolean[] visit) {
		int count = 0;
		for (int i = 1; i < n; i++) {
			if (friends[0][i]) {
				if (!visit[i]) {
					visit[i] = true;
					count++;
				}
				for (int j = 1; j < n; j++) {
					if (friends[i][j] && !visit[j]) {
						visit[j] = true;
						count++;
					}
				}
			}
		}
		return count;
	}
}
