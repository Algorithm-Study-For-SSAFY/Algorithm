package Greedy;

import java.io.*;
import java.util.*;

public class 백준_16953_AB {

	static class Pair {
		long x;
		int cnt;

		public Pair(long x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Integer.parseInt(st.nextToken());
		long target = Integer.parseInt(st.nextToken());

		bfs(a, target);
	}

	private static void bfs(long a, long target) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(a, 0));

		while (!q.isEmpty()) {
			Pair p = q.poll();

			if (p.x == target) {
				System.out.println(p.cnt + 1);
				return;
			}
			
			long first = p.x * 10 + 1;
			long second = p.x * 2;
			
			if (first <= target) {
				q.offer(new Pair(first, p.cnt + 1));
			}
			
			if (second <= target) {
				q.offer(new Pair(second, p.cnt + 1));
			}
		}
		System.out.println(-1);
	}
}
