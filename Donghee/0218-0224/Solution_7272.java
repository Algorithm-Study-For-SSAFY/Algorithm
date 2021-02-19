package feb_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7272 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			st=new StringTokenizer(br.readLine());
			String str1=st.nextToken();
			String str2=st.nextToken();
			
			if(str1.length()!=str2.length()) { //문자열 길이가 다르면 바로 diff 출력,
				sb.append("#").append(tc).append(" ").append("DIFF").append("\n");
				continue;
			}
			boolean flag=false;
			//str1의 처음부터 끝까지 비교하기, 같은 문자로 취급하는 것 끼리 같은 값으로 치환해놓기
			for(int i=0; i<str1.length(); i++) {
				if(makeSame(str1.charAt(i))!=makeSame(str2.charAt(i)))
					break;
				//마지막 단어까지 똑같다면 !
				if(i==str1.length()-1) flag=true;
			}
			if(flag) sb.append("#").append(tc).append(" ").append("SAME").append("\n");
			else sb.append("#").append(tc).append(" ").append("DIFF").append("\n");
		}//end of tc
		System.out.println(sb.toString());
	}
	private static char makeSame(char c) {
		switch(c) {
		case 'A':
		case 'D': 
		case 'O':
		case 'P':
		case 'Q':
		case 'R': return 'A';
		case 'B': return 'B';
		default : return 'C';
		}
	}
}
