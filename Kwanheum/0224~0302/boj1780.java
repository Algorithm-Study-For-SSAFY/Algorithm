import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1780 {
	private static int[][] paper;
	private static int N;
	private static int[] answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		paper = new int[N][N];
		StringTokenizer stk;
		for(int i=0; i<N; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				paper[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		answer = new int[3];
		func(0, 0, N);
		for(int i=0; i<3; i++) {
			System.out.println(answer[i]);
		}
		
	}//main
	
	static void func(int row, int col, int size) {
		if(check(row, col, size)) {
			answer[ paper[row][col]+1 ]++;
		}
		else {
			divide(row, col, size);
		}
	}
	
	//9개의 종이로 자른다? 가로 3 , 세로 3
	static void divide(int row, int col, int size) {
		
		func(row, col, size/3);
		func(row, col+size/3, size/3);
		func(row, col+size*2/3, size/3);
		func(row+size/3, col, size/3);
		func(row+size/3, col+size/3, size/3);
		func(row+size/3, col+size*2/3, size/3);
		func(row+size*2/3, col, size/3);
		func(row+size*2/3, col+size/3, size/3);
		func(row+size*2/3, col+size*2/3, size/3);
		
	}
	
	static boolean check(int row, int col, int size) {
		if(size==1) return true;
		
		int tmp = paper[row][col];
		for(int i=row; i<row+size; i++) {
			for(int j=col; j<col+size; j++) {
				if(paper[i][j] != tmp){
					return false;
				}
			}
		}
		return true;
	}
}
