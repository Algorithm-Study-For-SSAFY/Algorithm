package March_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

//string replace 메소드 -> 실패 

public class Main_9935 {
	private static String val, str;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		str=br.readLine();
		val=br.readLine(); //폭발 문자열
		Stack <Character> stack=new Stack<>();
		for(int i=0; i<str.length(); i++) {
			//stack이 폭발물 이상으로 차면 끝에서부터 len만큼 검사하고 같으면 pop하기
			stack.push(str.charAt(i));
			boolean flag=true;
			if(stack.size()>=val.length()) {
				for(int j=0; j<val.length(); j++) {
					//str의 j번째 문자와 stack 문자 비교 
					if(val.charAt(j)!=stack.get(stack.size()-val.length()+j)) {
						flag=false; break;
					}
				}
				
				if(flag) for(int j=0; j<val.length(); j++) stack.pop();
			}
			
		}
		StringBuilder sb=new StringBuilder();
		if(stack.size()==0) System.out.println("FRULA");
		else {
			for(int i=0; i<stack.size(); i++) {
				sb.append(stack.get(i));
			}
			System.out.println(sb.toString());
		}
	}//end of main
}//end of class
