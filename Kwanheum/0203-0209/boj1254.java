import java.util.Scanner;

public class boj1254 {
	public static void main(String[] args) {
		//팰린드롬? abba, abcba처럼 대칭을 이뤄야함
		Scanner sc = new Scanner(System.in);
		String x = sc.next();
		int len = x.length();
		if(len % 2 ==0) {
			for(int i=len/2; i<len; i++) {
				//중간선 기준 대칭 bbaa
				for(int j=0; j<len-i; j++) {
					if(x.charAt(i-1-j) != x.charAt(i+j) ) break;
					if(j==len-1-i) {
						System.out.println(len + len-2*(j+1) );
						return;}
				}
				//중간값 기준 대칭
				for(int j=1; j<len-i; j++) {
					if(x.charAt(i-j) != x.charAt(i+j) ) break;
					if(j==len-i-1) {
						System.out.println(len+ i - j);
						return;}
				}//i가 끝에 도달했을땐 위의 for문에 안들어가서 따로처리
				if(i == len-1) {
					System.out.println(len + len-1);
					return;
				}
			}
		}
		else {
			
			for(int i=len/2; i<len; i++) {
				//중간값 기준 대칭
				for(int j=1; j<len-i; j++) {
					if(x.charAt(i-j) != x.charAt(i+j) ) break;
					if(j==len-i-1) {
						System.out.println(len+ i - j);
						return;}
				}
				if(i == len-1) {
					System.out.println(len+ len-1);
					return;
				}
				//중간선 기준 대칭 bbbaa
				for(int j=0; j<len-1-i; j++) {
					if(x.charAt(i-j) != x.charAt(i+1+j) ) break;
					if(j==len-1-i -1) {
						System.out.println(len + len-2*(j+1) );
						return;}
				}
				
			}
			
		}
	}
}
