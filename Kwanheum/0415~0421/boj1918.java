import java.util.Scanner;
import java.util.Stack;

public class boj1918 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		String input = sc.next();
		int len =input.length();
		Stack<Character> s = new Stack<>();
		StringBuilder sb = new StringBuilder();
		String com = "+-*/()";
		for(int i=0; i<len; i++) {
			char now = input.charAt(i);
			if(!com.contains(now+"")) {
				sb.append(now);
			}else {
				if(now=='(') {
					s.push(now);
				}else if(now==')') {
					while(s.peek()!='(') {
						sb.append(s.pop());
					}
					//'('발견
					s.pop();
				}else if(now=='+'||now=='-') {
					while(!s.isEmpty() && s.peek()!='(') {
						sb.append(s.pop());						
					}
					s.push(now);
				}else if(now=='*'||now=='/') {
					if(!s.isEmpty() && s.peek()!='(') {
						if(s.peek()=='*'||s.peek()=='/') {
							sb.append(s.pop());													
						}
					}
					s.push(now);
				}
			}
		}
		while(!s.isEmpty()) {
			sb.append(s.pop());
		}
		System.out.println(sb);
	}
}
