package feb_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 개똥벌레, 파괴해야할 장애물의 최솟값과 그러한 구간의 수.
 */
public class Main_3020 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int H=Integer.parseInt(st.nextToken());
		int []map1=new int[H+1];
		int []map2=new int[H+1];
		
		for(int i=1; i<=N; i++) {
			int a=Integer.parseInt(br.readLine());
			if(i%2==1) { //석순이라면, cnt를 ++
				map1[a]++;
			}else { //종유석이라면, 
				map2[H-a+1]++;
			}
		}//end of input
		
		//입력받은 높이에 따라, 값 주기
		//석순인 경우, 위->아래
		for(int i=H; i>=2; i--) {
			map1[i-1]+=map1[i];
		}
		
		//종유석인경우 아래->위
		for(int i=2; i<=H; i++) {
			map2[i]+=map2[i-1];
		}
		//최솟값 찾기
		int answer=Integer.MAX_VALUE;
		int count=0;
		for(int h=1; h<=H; h++) {
			if(answer==map1[h]+map2[h]) {
				count++;
			}else if(answer>=(map1[h]+map2[h])) {
				count=1;
				answer=map1[h]+map2[h];
			}
		}
		System.out.println(answer+" "+count);
	}//end of main
}


// 저는 메모리 초과를 해결했더니 시간 초과가 발생해서 결국 반복하다가 포기했어요ㅠㅠㅠ
// 어떻게 해야 해결할 수 있는 걸까요,

// 저도 다시 해보니 시간초과가 나왔다고 떠서 다시 제출했습니다.. ㅠ 
