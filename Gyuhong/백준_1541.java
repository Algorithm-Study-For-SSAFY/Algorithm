import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer num = new StringBuffer();
		String str = br.readLine();
		
		int minusIdx = str.indexOf('-');
		
		if(minusIdx == -1) minusIdx = Integer.MAX_VALUE;
		
		int answer = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '-' || str.charAt(i) == '+') {
				answer += i-1 < minusIdx ? Integer.parseInt(num.toString()) : -Integer.parseInt(num.toString());
				num.delete(0, num.length());
			}
			else {
				num.append(str.charAt(i));
			}
		}
		
		answer += str.length() < minusIdx ? Integer.parseInt(num.toString()) : -Integer.parseInt(num.toString());
		System.out.println(answer);
		
	}
	
	
}
