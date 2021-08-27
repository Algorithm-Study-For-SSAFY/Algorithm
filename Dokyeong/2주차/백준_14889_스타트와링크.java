package al_2주차;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_백준_14889_스타트와링크 {
	// n명중 2명 뽑기 조합으로 풀기 
	
	 static int store(String s) { 
		 return Integer.parseInt(s);
		 }
	 
	 
	    static int N; // 총인원수
	    static boolean[] visited; //중복 제어
	    static int[][] arr; // 표 배열
	    static int min = Integer.MAX_VALUE; //최소 차이 값 
	 
	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        N = store(br.readLine());
	        visited = new boolean[N+1];
	        arr = new int[N+1][N+1]; //총인원보다 행렬 한줄씩 더 있어야함
	 
	        for(int i=1; i<N+1; i++) {
	        	StringTokenizer st = new StringTokenizer(br.readLine()," ");
	            for(int j=1; j<N+1; j++) {
	                arr[i][j] = store(st.nextToken()); //배열에 입력받기
	            }
	        }
	 
	        combination(1, 0); //조합만들기
	        System.out.println(min); // 최소값 출력
	    }
	 
	    // 모든 팀의 조합 구하기
	    static void combination(int start, int depth) {
	        if(depth == N/2) {
	            min = Math.min(min, Difference()); // 최소값과 비교해서 작은거 넣어줌
	            return;
	        }
	 
	        for(int i=start; i<N+1; i++) {
	            if(visited[i] != true) {
	                visited[i] = true;
	                combination(i+1, depth+1);
	                visited[i] = false;
	            }
	        }
	    }
	 
	    // 팀의 능력치 차이를 구하기
	    static int Difference() {
	        int sumStart = 0; //스타트팀
	        int sumLink = 0; //링크팀
	 
	        for(int i=1; i<N+1; i++) {
	            for(int j=1; j<N+1; j++) {
	                // true 면 스타트팀
	                if(visited[i] && visited[j])
	                    sumStart += arr[i][j];
	 
	                // false 면 링크팀
	                if(visited[i] != true && visited[j] != true)
	                    sumLink += arr[i][j];
	            }
	        }
	 
	        return Math.abs(sumStart - sumLink);
	    }

}

//////////////////////////////
////////관흠 코드 리뷰/////////////
//////////////////////////////
/*
* store 메서드 통해서 파싱하는부분 줄여주는거 좋네요!
* 그리고 combination , Difference 분리되어있어서 코드가 깔끔하게 읽기 편한거같아요.
*/
