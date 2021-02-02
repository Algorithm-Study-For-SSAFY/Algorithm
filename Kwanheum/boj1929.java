import java.util.Scanner;

public class boj1929 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		boolean[] chk = new boolean[N+1]; //default false
		
		for(int i=2; i<=N; i++) {
			if(i>=M && !chk[i]) System.out.println(i);
			for(int j=i; j<=N; j+=i) {
				chk[j] = true;
			}
		}
	}//main
}
