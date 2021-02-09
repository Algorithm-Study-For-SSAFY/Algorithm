import java.util.*;
 
public class 백준_14889_스타트와링크 {

//조합 뽑기 
//능력 계산 (스타트), 능력 계산 (링크)
//대소 관계 비교 

	static int N, start = 0, link = 0;
	static int[][] map;
	static int[] arr;
	static boolean[] visit;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N + 1][N + 1];
		arr = new int[N / 2];
		visit = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		dfs(1, 0);
		System.out.println(min);
	}

	public static void dfs(int num, int idx) {
		// 종료조건 한 팀이꾸려졌는지?
		if (idx == N / 2) {
			start = 0;
			link = 0;
			
			// 링크팀 경우의 수 계산
			int[] arr2 = new int[N / 2];
			int n = 0; 
			for (int i = 1; i < visit.length; i++) {
				if (!visit[i])
					arr2[n++] = i;
			}

			// 스타트팀 능력
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if (arr[i] != arr[j])
						start += map[arr[i]][arr[j]];
				}
			}
			
			// 링크팀 능력
			for (int i = 0; i < arr2.length; i++) {
				for (int j = 0; j < arr2.length; j++) {
					if (arr2[i] != arr2[j])
						link += map[arr2[i]][arr2[j]];
				}
			}
			
			// 대소비교
			min = Math.min(min, Math.abs(start - link));
			return;
		}

		// N/2개만큼 뽑기
		for (int i = num; i <= N; i++) {
			if (visit[i])
				continue;

			visit[i] = true;
			arr[idx] = i;
			dfs(i, idx + 1);
			visit[i] = false;

		}
	}

}