import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			String target = br.readLine();
			
			int toggle = 0;
			int cnt = 0;
			for (int i = 0; i < target.length(); i++) {
				if(target.charAt(i) - '0' == toggle) {
					continue;
				}
				else {
					cnt++;
					toggle = toggle == 0 ? 1 : 0;
				}
			}
			sb.append("#" + test + " " + cnt + "\n");
		}
		
		System.out.println(sb.toString());
		
	}

}

//Solution_SWEA_1289_원재의 메모리 복구하기
