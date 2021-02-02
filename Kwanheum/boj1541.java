import java.util.Scanner;

public class boj1541 {
	public static void main(String[] args) {
		//값을 최소로. 음수도가능
		//-를 만나면 괄호열고 또 만나면 닫자.
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String tmp = "";
		int total = 0;
		int tmp_int = 0;
		boolean flag = false; //true면 괄호가 열린걸 의미.
		for(int i=0; i<input.length(); i++) {
			char x = input.charAt(i);
			if( x != '+' && x !='-') {
				//숫자를 의미
				tmp += x;
			}
			else { //연산기호 만남
				tmp_int = Integer.parseInt(tmp);
				tmp = "";
				if( x == '+') {
					if(flag) total -= tmp_int;
					else total += tmp_int;
				}
				else {//연산기호 -를 만났을때
					if(flag) {
						total -= tmp_int;
					}
					else {
						total += tmp_int;
						flag = true;
					}
				}
			}
		}//for
		tmp_int = Integer.parseInt(tmp);
		if(flag) total -= tmp_int;
		else total += tmp_int;
		System.out.println(total);
	}//main
}
