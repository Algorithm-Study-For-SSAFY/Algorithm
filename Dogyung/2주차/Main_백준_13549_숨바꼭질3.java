package al_2주차;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_13549_숨바꼭질3 {
	  static int so(String s) {
	        return Integer.parseInt(s);
	    }

	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());

	        int N = so(st.nextToken()); //수빈이가 있는 위치
	        int K = so(st.nextToken()); // 동생의 위치 

	        if(N >= K)
	            System.out.println(N-K);
	        else
	            System.out.println(BFS(N, K));
	    }

	    static int BFS(int N, int K) {
	        Queue <Integer>queue = new LinkedList<Integer>();
	        int[] subin = new int[100001]; // 수빈의 범위 <100000
	        Arrays.fill(subin, -1); // 배열에 저장

	        queue.offer(N); //큐에 저장
	        subin[N] = 0;

	        while(!queue.isEmpty()) { //다 뺄때까지 반복
	            int now = queue.poll();

	            // 동생을 만나면 끝
	            if(now == K)
	                return subin[now];

	            // *2 인 거리 중 방문하지 않은 곳 전부 체크
	            int temp = now * 2;
	            while(temp <= 100000 && subin[temp] == -1) {
	                subin[temp] = subin[now];
	                queue.offer(temp);
	                temp *= 2;
	            }

	            for(int i=0; i<2; i++) {
	                int next;
	                
	                if(i == 0)
	                    next = now - 1;
	                else
	                    next = now + 1;

	                if(0 <= next && next <= 100000) {
	                    if(subin[next] == -1) {
	                        queue.offer(next);
	                        subin[next] = subin[now] + 1;
	                    }
	                }
	            }
	        }

	        return 0;
	    }
}

//////////////////////////////
////////관흠 코드 리뷰/////////////
//////////////////////////////
/* 
* Queue를 이용한 BFS 방법 깔끔합니다!
*  
*/
