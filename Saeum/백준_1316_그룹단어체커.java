import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 백준_1316_그룹단어체커 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		int result = count;
		
		for (int i = 0; i < count; i++) {
			String words = br.readLine();
			String prev = String.valueOf(words.charAt(0));
			ArrayList<String> list = new ArrayList<String>();
			
		
			for (int k = 0; k < words.length(); k++) {
				String w = String.valueOf(words.charAt(k));
				
				if (!prev.equals(w) && list.contains(w)) {
					result--;
					break;
				}
				prev = String.valueOf(words.charAt(k));
				list.add(w);
			}
		}
		System.out.println(result);
		br.close();
	}
}