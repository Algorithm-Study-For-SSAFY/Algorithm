package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_1946_신입사원 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <=T; test_case++) {
			int N = Integer.parseInt(br.readLine()); //지원자 수 
			int arr[ ] =new int[N+1];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int x =Integer.parseInt(st.nextToken()); //서류 등수
				int y = Integer.parseInt(st.nextToken()); //면접 점수 
				arr[x]=y;
			} //입력받기 완료 
			
			int cnt =1 ; //제일 잘한사람이 최소 1 1 이므로 1로 초기화
			int start = arr[1];
			for (int i = 2; i <=N; i++) {
				if(start>arr[i]) { //기준보다 y가 작으면
					cnt++;
					start = arr[i]; //기준 변경
				}
			}
			System.out.println(cnt);
			
		}// end of tc
	}// end of main
}// end of class

/////////////////////////
////////관흠 리뷰///////////
/////////////////////////
/*
 * 깔끔합니다.
 */