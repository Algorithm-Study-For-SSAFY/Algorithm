import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = N;
		for (int i = 0; i < N; i++) {
			
			Set<Character> set = new HashSet<Character>();
			
			String str = br.readLine();
			char lastChar = ' ';
			
			for (Character c : str.toCharArray()) {
				if(!set.add(c) && c != lastChar) {
					cnt--;
					break;
				}
				lastChar = c;
			}
		}
		
		System.out.println(cnt);
		
	}
	
	
}
