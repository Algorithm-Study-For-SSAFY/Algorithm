package April_01;

import java.util.Scanner;

//LCS

public class Main_9251 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str1=sc.next(); 
		String str2=sc.next();
		
		int dp[][]=new int[str1.length()+1][str2.length()+1];
		for(int i=1; i<=str1.length(); i++) {
			for(int j=1; j<=str2.length(); j++) {
				//만약 문자가 같다면
				if(str1.charAt(i-1)==str2.charAt(j-1)) {
					dp[i][j]=dp[i-1][j-1]+1;
				}
				//문자가 다르다면 왼쪽과 위에 것 중에서 큰 값
				else{
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[str1.length()][str2.length()]);
	}
}
