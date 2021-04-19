package algo_study_12w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2174 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(stk.nextToken());
		int B = Integer.parseInt(stk.nextToken());
		int map[][] = new int[B+1][A+1]; //A가 가로, B가 세로
		for(int i=1; i<=B; i++) {
			Arrays.fill(map[i], -1);
		}
		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		ArrayList<robot> l = new ArrayList<>();
		for(int i=0; i<N; i++) {
			stk = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(stk.nextToken());
			int r = Integer.parseInt(stk.nextToken());
			String tmp = stk.nextToken();
			int dir = dir_func(tmp);
			map[r][c] = dir;
			l.add(new robot(r, c, dir));
		}
		
		int answer = 0;
		int X=0 , Y=0;
		ArrayList<inst> instlist = new ArrayList<>();
		for(int i=0; i<M; i++) {
			stk = new StringTokenizer(br.readLine());
			int rNumber = Integer.parseInt(stk.nextToken());
			String instType = stk.nextToken();
			int instCnt = Integer.parseInt(stk.nextToken());
			instlist.add(new inst(rNumber , instCnt, instType));
		}
		//input End
		for(int i=0; i<M; i++) {
			inst tmp = instlist.get(i);
			int rNumber = tmp.rNumber;
			String instType = tmp.instType;
			int instCnt = tmp.instCnt;
			//명령을 수행하는 로봇
			robot now = l.get(rNumber-1);
			//명령의 종류
			while(instCnt > 0) {
				if(instType.equals("L")) {
					now.dir = (now.dir+3)%4;
					map[now.r][now.c] = now.dir;
				}else if(instType.equals("R")) {
					now.dir = (now.dir+1)%4;
					map[now.r][now.c] = now.dir;
				}else {
					int nr = now.r + dr[now.dir];
					int nc = now.c + dc[now.dir];
					if( !(nr>=1&&nr<=B&&nc>=1&&nc<=A)) {
						X = rNumber;
						answer = 1;
						break;
					}else {
						if(map[nr][nc] != -1) {
							answer = 2;
							X = rNumber;
							for(int j=0, len=l.size(); j<len; j++) {
								if(l.get(j).r == nr &&l.get(j).c ==nc) {
									Y = j+1;
								}
							}
							break;
						}else {
							map[nr][nc] = now.dir;
							map[now.r][now.c] = -1;
							now.r = nr;
							now.c = nc;
						}
					}
				}
				instCnt--;
			}
			if(answer !=0) break;
			/*for(int r=B; r>0; r--) {
				for(int c=1; c<=A; c++) {
					System.out.print(map[r][c]+" ");
				}
				System.out.println();
			}
			System.out.println();*/
		}
		
		
		if(answer == 1) {
			System.out.println("Robot "+X+" crashes into the wall");
		}else if(answer == 2) {
			System.out.println("Robot "+X+" crashes into robot "+Y);
		}else {
			System.out.println("OK");
		}
	}
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static class inst{
		int rNumber, instCnt;
		String instType;
		public inst(int rNumber, int instCnt, String instType) {
			super();
			this.rNumber = rNumber;
			this.instCnt = instCnt;
			this.instType = instType;
		}
		
	}
	static class robot{
		int r, c, dir;

		public robot(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
		
	}
	
	static int dir_func(String tmp) {
		int dir = -1;
		switch(tmp) {
		case "N" :
			dir = 0;
			break;
		case "E" :
			dir = 1;
			break;
		case "S" :
			dir = 2;
			break;
		case "W" :
			dir = 3;
			break;
		}
		return dir;
	}
}
