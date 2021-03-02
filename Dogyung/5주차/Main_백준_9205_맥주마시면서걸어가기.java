package al_5주차;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_백준_9205_맥주마시면서걸어가기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt(); // 편의점 개수
			int[][] location = new int[2][N + 2];
			int[][] map = new int[N + 2][N + 2];

			for (int i = 0; i < N + 2; i++) {
				location[0][i] = sc.nextInt(); //편의점 x
				location[1][i] = sc.nextInt(); //편의점 y
			}

			int cnt = 0;
			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					cnt = 0;
					cnt += Math.abs(location[0][i] - location[0][j]);
					cnt += Math.abs(location[1][i] - location[1][j]);
					if (cnt <= 1000) { //거리가 1000이하면 map에 1저장 
						map[i][j] = 1;
						map[j][i] = 1;
					}
				}
			}
			boolean[] visited = new boolean[N + 2]; // 방문했는지 체크 
			visited[0] = true;
			Queue<Integer> q = new LinkedList();
			q.add(0);//q에 0 저장
			while (!q.isEmpty()) {
				int check = q.poll();// 하나씩 꺼내봄
				for (int i = 0; i < N + 2; i++) { // 0~N+1까지 연결되어있는지 확인
					if (map[check][i] == 1) {// 가능
						if (!visited[i]) {
							visited[i] = true;
							q.add(i);// 확인되면 넣기 
						}
					}
				}
			}

			if (visited[N + 1]) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}

		} // end of tc
	}// end of main
} // end of class
