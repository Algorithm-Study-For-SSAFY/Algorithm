
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_1946 {
	static private class Grade implements Comparable<Grade>{
		int test1; int test2;

		public Grade(int test1, int test2) {
			super();
			this.test1 = test1;
			this.test2 = test2;
		}

		@Override
		public int compareTo(Grade o) {
			return this.test1-o.test1;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		

		for(int tc=1; tc<=T; tc++) {
			int answer=1;
			int N=Integer.parseInt(br.readLine());
			Grade g[]=new Grade[N];
			StringTokenizer st;
			for(int i=0; i<N; i++) {
				st=new StringTokenizer(br.readLine());
				g[i]=new Grade(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}//end of input
			Arrays.sort(g); //test1 순서대로 input 정렬하기,
			
			//1등인애의 2차 시험보다 낮은 순위애들은 무조건 통과안됨
			//그 후로 추가할 점수들의 2차 점수들을 비교하면서보기
			int max=g[0].test2;
			for(int i=1; i<N; i++) {
				if(max>g[i].test2) {//순위가 작으면
					answer++; max=g[i].test2;
				}
			}
			System.out.println(answer);
		}
	}
}
