import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class boj5430 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=0; t<T; t++) {
			StringBuilder sb = new StringBuilder();
			String p = sc.next(); // 수행할 함수
			int n = sc.nextInt();
			String input = sc.next();
			String x = input.substring(1,input.length()-1); // [ ] 제외 하기 위함
			StringTokenizer stk = new StringTokenizer(x, ",");
			
			ArrayList<Integer> q = new ArrayList<>();
			for(int i=0; i<n; i++) {
				q.add(Integer.parseInt(stk.nextToken()));
			}
			
			boolean flag = false; // flag : false 정방향 // true 역방향
			boolean error_chk = false;
			for(int i=0; i<p.length(); i++) {
				char inst = p.charAt(i);
				if(inst == 'R') flag = !flag;
				else if(inst == 'D') {
					if(q.size() == 0) {
						error_chk = !error_chk;
						break;
					}
					if(flag) {
						q.remove(q.size()-1);
					}
					else {
						q.remove(0);
					}
				}
			}
			//출력문
			if(!error_chk) {
				sb.append("[");
				if(flag) {
					for(int i=q.size()-1; i>=0; i--) {
						sb.append(q.get(i)).append(",");
					}
				}
				else {
					for(int i=0; i<q.size(); i++) {
						sb.append(q.get(i)).append(",");
					}	
				}
				if(sb.length() >=2 ) sb.setLength(sb.length()-1); // 출력이 []가 나와야하는경우 ]만 나올수도있었다..
				sb.append("]\n");
			}
			else {
				sb.append("error\n");
			}
			
			System.out.print(sb); 
		}//test case
		// testcase를 다 돌린후에 sb에 전체를 저장해서 출력하니 50퍼에서 오답... why..?
	}
}

/**
55번째 줄은 마지막 원소출력에서 콤마 없애기위한 거죠?!?
16번째 줄에서 [,] 없애기 위해 substring 사용한 방법 좋은 것 같아요!
저는 substring은 알았는데 아이디어가 생각이 안났어서 검색해보다가 String에 있는 replace 메서드 사용해서 
String s=br.readLine().replace("[", "").replace("]", ""); 이런식으로 해결했어요.
혹시 모르시면 알아두시라고 남겨놔요~!
/
