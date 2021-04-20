package April_04;

import java.util.Scanner;
import java.util.Stack;

public class Main_1918 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		String answer="";
		Stack<Character> stack=new Stack<>(); //연산자 넣을 스택
		for(int i=0; i<s.length(); i++) {
			char c=s.charAt(i);
			//알파벳이면
			if(c>=65 && c<=97) {
				answer+=c;
			}else {
				/////연산자/////
				if(c=='(') stack.push(c);
				else if(c==')') {
					//(만날때까지 계속 pop
					while(!stack.isEmpty()) {
						char tmp=stack.pop();
						if(tmp=='(') break;
						answer+=tmp;
					}
				}else {
					//자기보다 우선순위가 낮을 때까지 pop
					while(!stack.isEmpty() && prior(stack.peek())>=prior(c)) {
						answer+=stack.pop();
					}
					stack.push(c);
				}
			}
		}
		while(!stack.isEmpty()) answer+=stack.pop(); //남은거 처리
		System.out.println(answer);
	}
	
	/* 우선순위 */
	private static int prior(char op) {
		if(op=='(') return 0;
		if(op=='+' || op=='-') return 1;
		if(op=='*' || op=='/') return 2;
		return 0;
	}
}
