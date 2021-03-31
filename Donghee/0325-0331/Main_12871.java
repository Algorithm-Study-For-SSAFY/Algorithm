package March_04;

import java.util.Scanner;

//무한문자열
public class Main_12871 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		String str2=sc.next();

		int len1=str.length();
		int len2=str2.length();
		int len=len1*len2;
		String tmp1=str; String tmp2=str2;
		while(str.length()!=len) {
			str+=tmp1;
		}
		while(str2.length()!=len) {
			str2+=tmp2;
		}
		if(str.equals(str2)) System.out.println(1);
		else System.out.println(0);
	}

}
