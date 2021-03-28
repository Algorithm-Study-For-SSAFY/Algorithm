package algo_study_9w_special;

import java.util.Scanner;

public class boj12904 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		String T = sc.next();
		
		//모든 경우의 수 완탐 : 2^1000
		//행위 두가지 모두 A or B를 뒤에 추가한다는 행위
		String tmp = T;
		int s_len = S.length();
		for(int i=T.length()-1; i>=0; i--) {
			if(i == s_len-1) {
				if(tmp.substring(0, s_len).equals(S)) {
					System.out.println(1);
				}
				else {
					System.out.println(0);
				}
				break;
			}
			
			if(tmp.charAt(i)=='A') {
				
			}
			else { // B
				String new_tmp = "";
				for(int j=i-1; j>=0; j--) {
					new_tmp += tmp.charAt(j);
				}
				tmp = new_tmp;
			}
		}
	}
}
