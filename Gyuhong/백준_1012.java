//Main_백준_1012_유기농배추_조규홍

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 

public class Main {
	
	static int M;
	static int N;
	static int[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
		
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int answer = 0;
			map = new int[N][M];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if(map[y][x] == 0) continue;
					move(y,x);
					answer++;
				}
			}
			System.out.println(answer);
		}
	}
	
	static int[] mX = {0,0,-1,1};
	static int[] mY = {-1,1,0,0};
	
	static void move(int y, int x){
		map[y][x] = 0;
		for (int i = 0; i < 4; i++) {
			if( y+mY[i] >= 0 && y+mY[i] < N && x+mX[i] >= 0 && x+mX[i] < M) {
				if(map[y+mY[i]][x+mX[i]] == 1) move(y+mY[i], x+mX[i]);
			}
		}
	}
	
}



