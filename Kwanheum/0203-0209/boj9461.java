import java.util.Scanner;

public class boj9461 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long [] P = new long[101]; // 0 => dummy
		P[1] = 1;
		P[2] = 1;
		P[3] = 1;
		P[4] = 2;
		P[5] = 2;
		for(int i=6; i<=100; i++) {
			P[i] = P[i-1] + P[i-5];
		}
		for(int t=0; t<T; t++) {
			int input = sc.nextInt();
			System.out.println(P[input]);
		}
	}//main
}


/**
깔끔하고 좋습니다 !
*/
