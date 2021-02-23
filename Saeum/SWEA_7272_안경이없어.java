
import java.util.*;

public class SWEA_7272_안경이없어 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			String one = "CEFGHIJKLMNSTUVWXYZ";
			String two = "ADOPQR";
			String three = "B";

			String a = sc.next();
			String b = sc.next();
			int index = 0;
			boolean goal = true;
			char[] aArr = a.toCharArray();
			char[] bArr = b.toCharArray();
			if (aArr.length != bArr.length) {
				goal = false;
			} else {
				for (int i = 0; i < aArr.length; i++) {
					if (one.contains(Character.toString(aArr[i])) && one.contains(Character.toString(bArr[i]))) {
					} else if (two.contains(Character.toString(aArr[i])) && two.contains(Character.toString(bArr[i]))) {
					} else if (aArr[i] == 'B' && bArr[i] == 'B') {
					} else
						goal = false;
				}
			}
			System.out.println("#" + t + " " + (goal ? "SAME" : "DIFF"));
		}
	}

}