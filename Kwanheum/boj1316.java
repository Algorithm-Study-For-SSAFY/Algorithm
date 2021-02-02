import java.util.Scanner;

public class boj1316 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int answer = 0;
		String input;
		for(int i=0;i<N;i++) {
			boolean[] chk = new boolean[26];
			input = sc.next();
			int s = 0;
			char before = '^';
			boolean flag = false;
			
			while(s<input.length()) {
				char x = input.charAt(s);
				if(before == x) {
					//아무것도안함.
				}
				else{
					if( !chk[x-'a']) {
						chk[x-'a'] = true;
						before = x;
					}
					else { //그룹단어가 아니다!
						flag = true;
					}
				}
				s++;
			}//while
			if(!flag) answer ++;	
		}//test case
		System.out.println(answer);
	}
}
