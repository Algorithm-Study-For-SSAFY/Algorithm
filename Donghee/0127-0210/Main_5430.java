package feb_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * AC
 * R(뒤집기) D(버리기)
 * deque 사용 안할시 시간초과 발생, deque 사용후 syso 사용하면 시간초과 발생, stringBuilder 사용시 통과.
 */
public class Main_5430 {
	static int T;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());

		StringBuilder sb=new StringBuilder();
		for(int tc=1; tc<=T; tc++) {
			String str=br.readLine();
			N=Integer.parseInt(br.readLine());
			//[ 와 ]를 없애준뒤, tokenizer를 사용하여 숫자만 추출
			String s=br.readLine().replace("[", "").replace("]", "");
			StringTokenizer st=new StringTokenizer(s,",");
			//덱 사용
			Deque<Integer> d=new ArrayDeque<>();
			for(int i=0; i<N; i++) {
				//덱에 순서대로 push
				d.addLast(Integer.parseInt(st.nextToken()));
			}
			//함수의 값을 적용시키기
			//뒤집기는 방향을 바꾸기로 적용 ==>
			//dir이 1이면 왼->오른쪽으로 읽고 dir=-1이면 오른쪽->왼쪽으로 읽기
			int dir=1;
			boolean flag=true; //정상적으로 완료되었는지 확인하는 flag
ex:			for(int i=0; i<str.length(); i++) {
				char a=str.charAt(i);
				switch(a) {
				//뒤집기
				case 'R':
					dir=(dir==-1)?1:(-1);
					break;
				case 'D':
					//지울게 없으면 
					if(d.isEmpty()) {
						flag=false; break ex;
					}
					if(dir==1) { //방향이 왼쪽->오른쪽이면, 왼쪽 제일 첫번째꺼 삭제.
						d.pollFirst();
					}else d.pollLast();
					break;
				default:
					break;
				}
			}
			
			if(!flag) sb.append("error").append("\n");
			else if(dir==-1) {
				sb.append("[");
				if(!d.isEmpty()) sb.append(d.pollLast());
				while(!d.isEmpty())
					sb.append(",").append(d.pollLast());
				sb.append("]").append("\n");
			}else if(dir==1) {
				sb.append("[");
				if(!d.isEmpty()) sb.append(d.pollFirst());
				while(!d.isEmpty())
					sb.append(",").append(d.pollFirst());
				sb.append("]").append("\n");
			}
		}//end of tc
		System.out.println(sb.toString());
	}//end of main
}

// replace 메서드를 사용한게 인상적이에요 ! 저도 다음에 사용해봐야겠어요 ㅎㅎ 
