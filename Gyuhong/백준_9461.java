
//Main_백준_9461_파도반수열_조규홍

import java.io.IOException;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int N[] = new int[T];
		
		int max = 0;
		
		for (int i = 0; i < N.length; i++) {
			N[i] = sc.nextInt();
			max = Math.max(max, N[i]);
		}
		
		long P[] = new long[max+1];
		P[1] = 1;
		P[2] = 1;
		P[3] = 1;
		P[4] = 2;
		P[5] = 2;
		
		for(int i=6; i<=max; i++) {
			P[i] = P[i-5] + P[i-1];
		}
		
		for (int i = 0; i < N.length; i++) {
			System.out.println(P[N[i]]);
		}
		
		
		sc.close();
	}
}
//[1] 1 
//[2] 1 
//[3] 1 
//[4] 2  k-1 k-3
//[5] 2  k-1
//[6] 3  k-1 k-5
//[7] 4  k-1 k-5
//[8] 5  k-1 k-5
//[9] 7 
//[10] 9 

