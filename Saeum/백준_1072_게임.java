import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_1072_게임 {
	static long x, y, z, changeZ;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		z = y * 100 / x;

		if (z >= 99)
			System.out.println(-1);
		else
			binarySearch();
	}

// 1. changeZ와 z 차이가 1이 될 떄까지의 최소 게임 횟수
// 2. mid가 최소 게임 횟수이므로, changeZ = (y + mid) / (x + mid) * 100이 됨
// 2-1. 그래서 changeZ와 z의 차이가 1이면 뽑아내고, 아니면 다시 돌리는거임
// 2-2. 만약 changeZ와 z의 차이가 0보다 크면 ed = mid - 1 하고 작거나 같으면 st = mid + 1; 해야함
	public static void binarySearch() {
		long st, ed, mid;
		st = 1;
		ed = x;
		while (st <= ed) {
			changeZ = 0;
			mid = (st + ed) / 2;
			changeZ = ((y + mid) * 100 / (x + mid));
			if (changeZ - z > 0) {
				ed = mid - 1;
			} else
				st = mid + 1;
		}
		System.out.println(st);
	}
}