import java.util.*;

public class SWEA_1486_장훈이의높은선반 {

	static int TC;
	static int N;
	static int B;
	static int[] p;
	static int min;
	//static boolean []v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TC = sc.nextInt();
		for (int t = 1; t <= TC; t++) {
			N = sc.nextInt();
			B = sc.nextInt();
			p = new int[N];
			//v = new boolean[N];

			for (int i = 0; i < N; i++) {
				p[i] = sc.nextInt();
			}

			min = Integer.MAX_VALUE / 1000;
			subset(0, 0);
			System.out.println("#" + t + " " + (min-B));
		}

	}

	static void subset(int cnt, int sum) {
		if (cnt == N) {
			if (sum >= B) {
				min = Math.min(sum, min);
			}
			return;
		}

		subset(cnt + 1, sum + p[cnt]);
		subset(cnt + 1, sum);
	}

}
