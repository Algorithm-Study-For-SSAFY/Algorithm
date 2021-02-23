import java.io.*;

public class 백준_15787_기어하 { //비트마스킹
	
	
	static int arr[];
	static int N, M;
	static boolean visited[] = new boolean[1 << 21];
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] t = br.readLine().split(" ");
		N = Integer.parseInt(t[0]); // 기차의 개수
		M = Integer.parseInt(t[1]); // 명령의 개수
		arr = new int[N + 1];

		for (int i = 0; i < M; i++) {
			String[] str = br.readLine().split(" ");
			int order = Integer.parseInt(str[0]);
			int train = Integer.parseInt(str[1]);

			if (order == 1) {
				int seat = Integer.parseInt(str[2]);
				arr[train] = (arr[train] | (1 << seat));
			}
			if (order == 2) {
				int seat = Integer.parseInt(str[2]);
				arr[train] = arr[train] & ~(1 << seat);
			}
			if (order == 3) {
				arr[train] = arr[train] << 1;
				arr[train] = arr[train] & ((1 << 21) - 1);
			}
			if (order == 4) {
				arr[train] = arr[train] >> 1;
				arr[train] = arr[train] & ~1;
			}
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[arr[i]]) {
				answer++;
				visited[arr[i]] = true;
			}
		}

		System.out.println(answer);
	}
}