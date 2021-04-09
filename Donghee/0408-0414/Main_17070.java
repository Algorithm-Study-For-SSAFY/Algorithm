package April_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//파이프 옮기기
public class Main_17070 {
	private static int N, map[][];
	private static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}//end of input
		dfs(0,1,1);
		System.out.println(answer);
	}
	//어떤점에 도착했을 때, 그 점에서 가능한 점들 다 돌기
	//dfs일 거 같은,,데?
	private static int dr[]= {0,1,1};
	private static int dc[]= {1,0,1};
	
	private static void dfs(int r, int c, int line) {
		//종료조건
		if(r==N-1 && c==N-1) {
			answer++;
			return;
		}
		
		//line이 1일때
		switch(line) {
		case 1: //가로로 눕혀져 있는 경우!
			//1.옆에가 가능한지
			if(isPossible(r+dr[0], c+dc[0])) {
				dfs(r+dr[0], c+dc[0], 1);
			}
			//2.대각선 놓기 가능한지
			if(isPossible2(r+dr[2],c+dc[2])) {
				dfs(r+dr[2], c+dc[2],3);
			}
			break;
		case 2: //세로로 있는 경우
			if(isPossible(r+dr[1], c+dc[1])) {
				dfs(r+dr[1], c+dc[1], 2);
			}
			if(isPossible2(r+dr[2],c+dc[2])) {
				dfs(r+dr[2], c+dc[2],3);
			}
			break;
		case 3:
			if(isPossible(r+dr[0], c+dc[0])) {
				dfs(r+dr[0], c+dc[0], 1);
			}
			if(isPossible(r+dr[1], c+dc[1])) {
				dfs(r+dr[1], c+dc[1], 2);
			}
			if(isPossible2(r+dr[2],c+dc[2])) {
				dfs(r+dr[2], c+dc[2],3);
			}
			break;
			
		}
	}
	private static boolean isPossible2(int r, int c) {
		//입력받은 점 뿐만 아니라, 왼쪽, 위쪽 까지 확인하기
		if(r<0 || c<0 || r>=N || c>=N || map[r][c]==1)
			return false;
		if(r-1<0 || map[r-1][c]==1) return false;
		if(c-1<0 || map[r][c-1]==1) return false;
		return true;
	}
	private static boolean isPossible(int r, int c) {
		//해당 점에 벽이 없는지!
		if(r>=0 && c>=0 && r<N && c<N && map[r][c]!=1) {
			return true;
		}
		return false;
	}
	
	
}






