package algo_study_9w_special;

import java.math.BigInteger;
import java.util.Scanner;

public class boj13706 {
	public static void main(String[] args) {
		// 800자리..? 값이 엄청나게 크다
		// long 64bit 2^64
		
		Scanner sc = new Scanner(System.in);
		BigInteger origin = new BigInteger(sc.next());
		BigInteger end = origin;
		BigInteger start = new BigInteger("0");
		BigInteger answer = new BigInteger("0");
		
		while(start.compareTo(end) <= 0) { //start가 더 작아야 -1
			BigInteger mid = end.add(start).divide(new BigInteger("2"));
			BigInteger x = mid.multiply(mid);
			if( x.compareTo(origin) < 0) {
				start = mid.add(new BigInteger("1"));
			}
			else if(x.compareTo(origin)>0){
				end = mid.subtract(new BigInteger("1"));
			}
			else {
				answer = mid;
				break;
			}
		}
		
		System.out.println(answer);
	}
}
