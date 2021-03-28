package algo_study_9w_special;

import java.util.Scanner;

public class boj12871 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String t = sc.next();
		
		int s_idx = 0;
		int t_idx = 0;
		int s_len = s.length();
		int t_len = t.length();
		boolean flag =false;
		for(int i=0; i<s_len * t_len; i++) {
			if(s.charAt(s_idx) != t.charAt(t_idx)) {
				flag = true;
				break;
			}
			s_idx = (s_idx+1)%s_len;
			t_idx = (t_idx+1)%t_len;
		}
		
		if(flag) System.out.println(0);
		else System.out.println(1);
	}
}
