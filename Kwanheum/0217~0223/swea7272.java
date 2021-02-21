import java.util.Scanner;

public class swea7272 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String cmp[] = new String[3];
		cmp[0] = "B";
		cmp[1] = "ADOPQR";
		cmp[2] = "CEFGHIJKLMNSTUVWXYZ";
		StringBuilder sb = new StringBuilder();		
		for( int t=1; t<=T; t++) {
			sb.append("#").append(t).append(" ");
			boolean flag = false;
			String a = sc.next();
			String b = sc.next();
			if(a.length() != b.length()) {
				flag = true;
			}
			else {
bp :			for(int i=0, size=a.length(); i<size; i++) {
					String a_char = a.charAt(i)+"";
					String b_char = b.charAt(i)+"";
					if(a_char.equals(b_char)) continue;
					else {
						for(int j=0; j<3; j++) {
							if(cmp[j].contains(a_char) && cmp[j].contains(b_char)) {
								break;
							}
							if(j==2) {
								flag = true;
								break bp;
							}
						}
						
					}
				}
			}//else
			if(flag) sb.append("DIFF");
			else sb.append("SAME");
			sb.append("\n");
			
		}//test case
		System.out.println(sb);
	}
}
