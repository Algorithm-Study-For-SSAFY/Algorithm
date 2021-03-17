package algo_study_6w;

import java.util.Scanner;
import java.util.Stack;

public class boj9935 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String exp = sc.next();
		char last = exp.charAt(exp.length()-1);
		int exp_len = exp.length();
		
		boolean flag;
		Stack<Character> s = new Stack<>();
		String answer = "";
		for(int i=0; i<input.length(); i++) {
			flag = false;
			char x = input.charAt(i);
			s.add(input.charAt(i));
			int stack_len = s.size();
			if(x == last && stack_len>=exp_len) {
				for(int j=0;j<exp_len; j++) {
					if(s.get(stack_len-1-j) == exp.charAt(exp_len-1-j)) {
						//동일한지
					}
					else {
						flag = true;
					}
				}
				if(!flag) { //폭발문자열이 스택에 존재
					for(int k=0; k<exp_len; k++) {
						s.pop();
					}
				}
			}//if x last
		}
		/* String 에 그냥 붙이는 식으로 하니까 메모리초과..
		while(!s.isEmpty()) {
			answer = s.pop() + answer;
		}*/
		
		StringBuilder sb = new StringBuilder();
		if(s.size()==0) {
			System.out.println("FRULA");
		}
		else {
			for(int i=0; i<s.size(); i++) {
				sb.append(s.get(i));
			}
		
		System.out.println(sb);
		}
	}//main
}
