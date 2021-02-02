import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] costs = new int[N][3];
		
		for (int i = 0; i < costs.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			costs[i][0] = Integer.parseInt(st.nextToken());
			costs[i][1] = Integer.parseInt(st.nextToken());
			costs[i][2] = Integer.parseInt(st.nextToken());
		}
		
//---------------------------------입력 끝------------------------------------------------
		
		// 마지막으로 칠한 색에 따라 3칸 짜리 배열 생성  0: R , 1: G, 2: B
		// 각 배열에 저장되는 값은 0번째 index부터 i번째 까지 칠한 페인트 비용의 최솟값
		int[] best = new int[3];
		best[0] = costs[0][0];
		best[1] = costs[0][1];
		best[2] = costs[0][2];
		
		for (int i = 1; i < N; i++) {
			
			int tempR = Math.min(costs[i][0] + best[1], costs[i][0] + best[2]);
			int tempG = Math.min(costs[i][1] + best[0], costs[i][1] + best[2]);
			int tempB = Math.min(costs[i][2] + best[0], costs[i][2] + best[1]);
			
			best[0] = tempR;
			best[1] = tempG;
			best[2] = tempB;
		}
		
		System.out.println(Math.min(Math.min(best[0], best[1]), best[2]));
		
	}
}

