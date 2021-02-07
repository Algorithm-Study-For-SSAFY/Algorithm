import java.util.Scanner;
import java.util.Stack;

public class boj1254 {
	public static void main(String[] args) {
		//팰린드롬? abba, abcba처럼 대칭을 이뤄야함
		Scanner sc = new Scanner(System.in);
		String x = sc.next();
		int len = x.length();

		/* Solution1. index로 처리해보기
		 * if(len % 2 ==0) {
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
			
		}*/
		/////////////////////////////////////////////////
		// Solution2. isPal 함수 활용하기
		/////////////////////////////////////////////////
		
		if(len % 2 == 0) {
			//bbaa
			//중간선 기준 대칭 먼저 , 중간값 기준 대칭
			for(int i=len/2; i<len; i++) {
				// 중간선 기준.
				String left = x.substring(i - (len-i), i);
				String right = x.substring(i);
				if(isPal(left,right)) {
					System.out.println(len + len-2*(left.length()));
					return;
				}
				// 중간값 기준.
				//len-1 -i
				int gap = len-1-i;
				left = x.substring(i-gap);
				if(isPal(left, left)) {
					System.out.println(len + len-(left.length()));
					return;
				}
			}
		}
		else {
			//bbaaa
			//중간값 기준 대칭 먼저, 중간선 기준 대칭
			for(int i=len/2; i<len; i++) {
				String left;
				String right;
				//중간선 기준. i=len/2일때 한번은 생략하게 조건문 설정
				if(i > len/2) {
					left = x.substring(i - (len-i), i);
					right = x.substring(i);
					if(isPal(left,right)) {
						System.out.println(len + len-2*(left.length()));
						return;
					}
				}
				// 중간값 기준.
				//len-1 -i
				int gap = len-1-i;
				left = x.substring(i-gap);
				if(isPal(left, left)) {
					System.out.println(len + len-(left.length()));
					return;
				}
				
			}
		}
		
		
	} // main
	static boolean isPal(String a, String b) {
		//b 문자열을 stack에 넣어서, a와 비교
		Stack<Character> s = new Stack<>();
		for(int i=0; i<a.length(); i++) {
			s.push(b.charAt(i));
		}
		
		for(int i=0; i<a.length(); i++) {
			if(a.charAt(i) != s.pop()) {
				return false;
			}
		}
		return true;
	}
}
