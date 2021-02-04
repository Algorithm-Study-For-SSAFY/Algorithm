package al_1주차;

import java.util.Scanner;

public class Main_백준_1541_잃어버린괄호 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String exp = sc.next(); // 문자열로 입력받기
		sc.close();

		String[] str = exp.split("-");
		// '-' 기호 기준으로 배열에 담기 
		
		// 처음 '-'전까지 모두 더하기
		String[] tmp = str[0].split("\\+"); //  + 연산자 쓰고싶으면 앞에 \\붙여야한다

		int fis = 0;
		for (String hi : tmp)
			fis += Integer.parseInt(hi);
		// 처음 '-' 이후 숫자 더하기

		int sum = 0;
		for (int i = 1; i < str.length; i++) {
			String[] temp = str[i].split("\\+");
			for (String t : temp)
				sum += Integer.parseInt(t);
		}
		System.out.println(fis - sum);

	}

}
