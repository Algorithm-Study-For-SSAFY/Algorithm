import java.io.*;
import java.util.*;

public class 백준_1780_종이의개수 {
	public static int size;

	public static int[] cnt;
	public static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());

		cnt = new int[3];
		arr = new int[size][size];

		StringTokenizer st = null;
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) + 1;
			}
		}

		divideAndConquer(0, 0, size);

		System.out.println(cnt[0] + "\n" + cnt[1] + "\n" + cnt[2]);

	}

	public static boolean isAble(int r, int c, int len) {
		int t = arr[r][c];

		for (int i = r; i < r + len; i++) {
			for (int j = c; j < c + len; j++) {
				if (t != arr[i][j])
					return false;
			}
		}
		return true;
	}

	public static void divideAndConquer(int r, int c, int len) {
		if (isAble(r, c, len)) {
			cnt[arr[r][c]] += 1;
		} else {
			int newLen = len / 3;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					divideAndConquer(r + newLen * i, c + newLen * j, newLen);
				}
			}
		}
	}
}
