package March_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780 {
	private static int N;
	private static int ans[];
	private static int map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N=Integer.parseInt(br.readLine());
		
		map=new int[N][N];
		ans=new int[3]; //-1은 0, 0은 1, 1은  2 index에 저장하기,
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}//end of input.
		divide(0,0,N);
		System.out.println(ans[0]);
		System.out.println(ans[1]);
		System.out.println(ans[2]);
	}
	
	//9개로 나누거나, 유지하거나 
	private static boolean check(int r, int c, int n) { //시작점은 (r,c)에서시작해서 길이가n인 정사각형
		int a=map[r][c];
		for(int i=r; i<r+n; i++) {
			for(int j=c; j<c+n; j++) {
				if(a!=map[i][j]) { //다른 숫자가 발견되는 시점이라면, 9개로 나누는 작업이 필요하다.
					return false; 
				}
			}
		}
		return true;
	}
	private static void divide(int r, int c, int n) {
		if(check(r,c,n)) {
			ans[map[r][c]+1]++;
			return;
		}
		//불가능한 애였다면, 9조각을 내서 다시 시작
		int nn=n/3;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				divide(r+i*nn, c+j*nn, nn);
			}
		}
	}
}
