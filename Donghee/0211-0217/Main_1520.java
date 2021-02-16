package feb_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 내리막길
 *
 */
public class Main_1520 {
	static int map[][];
	static int dx[]= {1,-1,0,0};
	static int dy[]= {0,0,1,-1}; 
	static int M,N, answer;
	static int dp[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		dp=new int[M][N];
		map=new int[M][N];
		for(int i=0; i<M; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				dp[i][j]=-1;
			}
		}//end of input

		DFS(0,0);
		System.out.println(dp[0][0]);
		
	}//end of main
	

	private static int DFS(int x, int y) {
		if(x==M-1 && y==N-1)
			return 1; //탐색 다 한것
		if(dp[x][y]!=-1)
			return dp[x][y]; //이미 탐색했던 애라면, 
		//처음 탐색하는 애면
		dp[x][y]=0;
		//4방 탐색
		for(int i=0; i<4; i++) {
			int nx=x+dx[i]; int ny=y+dy[i];
			if(nx<0 || ny<0 || nx>=M || ny>=N)
				continue;
			
			if(map[nx][ny]<map[x][y]) {
				dp[x][y]+=DFS(nx,ny); //(x,y)에 올수 있는 총 경우의수는 (nx,ny)까지 올수있는 경우의 수들까지의 합
			}
		}
		//이동할 곳 없으면
		return dp[x][y];
	}
	

	
}//end of class
