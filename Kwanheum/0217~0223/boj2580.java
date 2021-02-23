import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj2580 {
	private static int[][] board;
	private static ArrayList<pos> arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		board = new int[9][9];
		arr = new ArrayList<pos>();
		for(int i=0; i<9; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				board[i][j] = Integer.parseInt(stk.nextToken());
				if(board[i][j] == 0) arr.add(new pos(i,j));
			}
		}
		//input end
		func(0);
	}
	
	static class pos{
		int row;
		int col;
		public pos(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
	
	static void func(int cnt) {
		if(cnt == arr.size()) {
			print();
			System.exit(0);
		} //기저조건
		
		pos now = arr.get(cnt);
		
		for(int i=1; i<=9; i++) {
			board[now.row][now.col] = i;
			if(row_chk(now.row) && col_chk(now.col) && box_chk(now.row , now.col)) {
				func(cnt+1);
			}
			board[now.row][now.col] = 0;
		}
	}
	
	static boolean row_chk(int row) {
		boolean flag[] = new boolean[10];
		for(int i=0; i<9; i++) {
			int num = board[row][i];
			if(num != 0) {
				if(!flag[num]) flag[num] = true;
				else return false; //값이 중복.
			}
		}
		return true; //중복된 값 X
	}
	static boolean col_chk(int col) {
		boolean flag[] = new boolean[10];
		for(int i=0; i<9; i++) {
			int num = board[i][col];
			if(num != 0) {
				if(!flag[num]) flag[num] = true;
				else return false; //값이 중복.
			}
		}
		return true; //중복된 값 X
	}
	static boolean box_chk(int row, int col) {
		boolean flag[] = new boolean[10];
		while(row%3!=0) row--;
		while(col%3!=0) col--;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				int num = board[row+i][col+j];
				if(num != 0) {
					if(!flag[num]) flag[num] = true;
					else return false; //값이 중복.
				}
			}
		}
		return true; // 중복된값 X
	}
	
	static void print() {
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}
