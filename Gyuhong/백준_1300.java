
//Main_백준_1300_K번째 수_조규홍

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		
		Scanner sc=  new Scanner(System.in);
		
		int N = sc.nextInt();
		int k = sc.nextInt();
		
		int l = 1;
		int r = Integer.MAX_VALUE;

		
		while(l<r) {
			int mid = (l-r-1)/2+r;
			// mid 이하의 수의 갯수가 k보다 적다면 정답은 mid보다 크다는 의미이다.
			if(getNumber(mid,N) < k) {
				l = mid+1;
			}
			else {
				r = mid;
			}
		}
		
		System.out.println(r);
		sc.close();
	}
	
	// n 이하의 숫자 갯수
	static long getNumber(int n, int N) {
		long ret=0;
		for(int i=1; i<=N; i++) {
			ret += Math.min(N, n/i);
		}
		return ret;
	}

}



