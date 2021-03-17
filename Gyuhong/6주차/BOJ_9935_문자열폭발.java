import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String str = br.readLine();
		String bomb = br.readLine();
		
		char lastBomb = bomb.charAt(bomb.length()-1);
		
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < str.length(); i++) {
			stack.push(str.charAt(i));
			
			if(str.charAt(i) == lastBomb) {
				Stack<Character> temp = new Stack<Character>();
				for (int j = bomb.length()-1; j >= 0; j--) {
					if(!stack.isEmpty()&&stack.peek() == bomb.charAt(j)) {
						temp.push(stack.pop());
					} else {
						while(!temp.isEmpty()) {
							stack.push(temp.pop());
						}
						break;
					}
				}
			}
			
		}
		
		for (Character character : stack) {
			sb.append(character);
		}
		
		if(stack.isEmpty()) {
			sb.append("FRULA");
		}
		
		System.out.println(sb);
	}
	
	
	
	
}

