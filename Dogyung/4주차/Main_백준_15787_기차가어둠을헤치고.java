package al_4주차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_백준_15787_기차가어둠을헤치고 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.valueOf(st.nextToken()); // 기차의 수
		int M = Integer.valueOf(st.nextToken()); // 명령의 수
		boolean train[][] = new boolean[N + 1][21]; // 기차 중복 판단

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine()); // 명령
			int doit = Integer.valueOf(st.nextToken()); // (1~4)
			int iii = 0; // i번째..
			int x = 0; // x번째 좌석 등
			if (doit == 1 || doit == 2) {
				iii = Integer.valueOf(st.nextToken());
				x = Integer.valueOf(st.nextToken());
			} else {// 3,4번 고르면 x는 선언 되지 않
				iii = Integer.valueOf(st.nextToken());
			}

			if (doit == 1) { // 1번일때
				train[iii][x] = true;
			} else if (doit == 2) { // 2번일때
				train[iii][x] = false;
			} else if (doit == 3) { // 3번일때
				for (int j = 20; j >= 2; j--) {
					train[iii][j] = train[iii][j - 1];
				}
				train[iii][1] = false;
			} else if (doit == 4) { // 4번일때
				for (int j = 1; j <= 19; j++) {
					train[iii][j] = train[iii][j + 1];
				}
				train[iii][20] = false;
			}
		}
		Set<String> set = new HashSet<>(); // hashset으로 중복 판단
		for (int i = 1; i <= N; i++) {
			String tmp = "";
			for (int j = 1; j <= 20; j++) {
				if (train[i][j]) {
					tmp += '1';
				} else {
					tmp += '0';
				}
			}
			set.add(tmp);
		}
		System.out.println(set.size());
	}
}
