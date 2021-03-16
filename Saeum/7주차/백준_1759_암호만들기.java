import java.io.*;
import java.util.*;

public class 백준_1759_암호만들기 {
	private static int L, C;
	private static char[] password, arr;
	private static StringBuilder sb;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[C];
		password = new char[L];

		StringTokenizer s = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = s.nextToken().charAt(0);
		}

		Arrays.sort(arr);
		dfs(0, 0, 0, 0);
		System.out.println(sb);

	}

	public static void dfs(int start, int cnt, int v, int c) {

		if (cnt == L) {// N까지 도달 및 모음 1개이상 , 자음 2개이상 종료
			if (v >= 1 && c >= 2) {
				for (int i = 0; i < L; i++) {
					sb.append(password[i]);
				}
				sb.append("\n");
				return;
			}
			return;

		}

		for (int i = start; i < C; i++) {
			char alpha = arr[i];
			password[cnt] = alpha;// 넣어줌
			if (alpha == 'a' || alpha == 'e' || alpha == 'i' || alpha == 'o' || alpha == 'u') {
				dfs(i + 1, cnt + 1, v + 1, c);// 모음
			} else {
				dfs(i + 1, cnt + 1, v, c + 1);// 자음
			}

		}
	}

}