package algo_study_10w;

import java.util.Scanner;

public class boj9251 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		
		int a_len = a.length();
		int b_len = b.length();
		int[][] lcs = new int[a_len+1][b_len+1];
		for(int i=0; i<a_len; i++) {
			if(a.charAt(i) == b.charAt(0)) {
				lcs[1][i+1] = 1;
				continue;
			}
			lcs[1][i+1] = lcs[1][i];
		}
		for(int i=0; i<b_len; i++) {
			if(b.charAt(i) == a.charAt(0)) {
				lcs[i+1][1] = 1;
				continue;
			}
			lcs[i+1][1] = lcs[i][1];
		}
		for(int i=1; i<b_len; i++) {
			for(int j=1; j<a_len; j++) {
				if(b.charAt(i) == a.charAt(j)) {
					lcs[i+1][j+1] = lcs[i][j] +1;
				}else {
					lcs[i+1][j+1] = Math.max(lcs[i+1][j], lcs[i][j+1]);
				}
			}
		}
		/*String result = "";
		int row = b_len;
		int col = a_len;
		while(true) {
			if(row ==0 || col ==0) break;
			if(lcs[row][col] == lcs[row-1][col]) {
				row = row-1;
				continue;
			}else if(lcs[row][col] == lcs[row][col-1]) {
				col = col-1;
				continue;
			}else {
				result = a.charAt(col-1) + result;
				row = row-1;
				col = col-1;
			}
		}
		for(int i=0; i<=b_len; i++) {
			for(int j=0; j<=a_len; j++) {
				System.out.print(lcs[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(result);*/
		
		System.out.println(lcs[a_len][b_len]);
		
		
		
		
		
	}
}
