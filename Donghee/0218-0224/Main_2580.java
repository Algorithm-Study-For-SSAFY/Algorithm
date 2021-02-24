package Feb_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main_2580 {
	private static int map[][]=new int[9][9];
	private static boolean row[][]=new boolean[9][9]; //i번째 row에 j+1라는 숫자가 존재한다,
	private static boolean col[][]=new boolean[9][9]; //i번째 col에 j라는 숫자가 존재한다,
	private static boolean square[][]=new boolean[9][9]; //i번째 사각형에 j 숫자 존재,
	private static ArrayList<int[]> list=new ArrayList<>();
	private static int cnt=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for(int i=0; i<9; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0; j<9; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				//만약 0이아니라면, 2차원배열에 입력 넣어주기,
				if(map[i][j]!=0) {
					row[i][map[i][j]-1]=true;
					col[j][map[i][j]-1]=true;
					square[3*(i/3)+j/3][map[i][j]-1]=true;
				}else {
					list.add(new int[] {i,j}); //0인 인덱스들 다 집어넣기, 
				}
			}
		}//end of input

		recur(0);
		
	}
	private static void recur(int cnt) {
		if(cnt==list.size()) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++)
					System.out.print(map[i][j]+" ");
				System.out.println();
			}
			System.exit(0);
			return;
		}

		int[] a=list.get(cnt);
		if(map[a[0]][a[1]]==0) { //빈칸이라면 채우기,
			for(int x=0; x<9; x++) {
				if(!row[a[0]][x] && !col[a[1]][x] && !square[3*(a[0]/3)+a[1]/3][x]) { //스도쿠에 넣을수 있는 모든 조건을 만족하면
					map[a[0]][a[1]]=x+1;
					row[a[0]][x]=true; col[a[1]][x]=true; square[3*(a[0]/3)+a[1]/3][x]=true;
					recur(cnt+1);
					map[a[0]][a[1]]=0;
					row[a[0]][x]=false; col[a[1]][x]=false; square[3*(a[0]/3)+a[1]/3][x]=false;
				}
			}
			
		}
	}
}
