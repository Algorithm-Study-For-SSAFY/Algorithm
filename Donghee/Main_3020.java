package feb_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 개똥벌레, 파괴해야할 장애물의 최솟값과 그러한 구간의 수.
 * 시간초과가 발생할 줄 알았는데 안나는 이유,,,,,,,.....N,H 범위 참고..
 */
public class Main_3020 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int H=Integer.parseInt(st.nextToken());
		int []cnt= new int[N+1];
		
		for(int i=1; i<=N; i++) {
			int a=Integer.parseInt(br.readLine());
			if(i%2==1) { //석순이라면, cnt를 ++
				for(int j=1; j<=a; j++) {
					cnt[j]++;
				}
			}else { //종유석이라면, 
				for(int j=H; j>H-a; j--) {
					cnt[j]++;
				}
			}
		} //높이 입력받기, 시간 초과 발생?
		int answer=Integer.MAX_VALUE;
		int count=0; //answer와 같은 값 count로 계산하기
		//높이 1일 때 부터 살펴보기,
		for(int h=1; h<=H; h++) {
			if(answer>cnt[h]) { //더 작은 값이 answer로 들어온다면,
				count=1;
				answer=cnt[h]; //answer 값 갱신
			}else if(answer==cnt[h]) count++;
			
			
			//높이가 h일 때 , cnt[h]의 갯수가 answer
			answer=Math.min(answer, cnt[h]);
			
			
		}
		System.out.println(answer + " "+ count);
	}//end of main
}

// 저는 메모리 초과를 해결했더니 시간 초과가 발생해서 결국 반복하다가 포기했어요ㅠㅠㅠ
// 어떻게 해야 해결할 수 있는 걸까요,
