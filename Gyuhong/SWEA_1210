import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int test = 1; test <= 10; test++) {
			
			int T = Integer.parseInt(br.readLine());
			int[][] data = new int[100][100];
			List<Integer> pole = new ArrayList<Integer>();
			
			int arriveX = -1;
			
			for (int y = 0; y < 100; y++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int x = 0; x < 100; x++) {
					data[x][y] = Integer.parseInt(st.nextToken());
					if(data[x][y] == 2) {
						arriveX = x;
					}
				}
			}
			
			for (int x = 0; x < 100; x++) {
				if(data[x][0] == 1) pole.add(x);
			}
			
			// =============여기까지 입력 및 데이터 구축==================
			
			int x = arriveX;
			
			// 도착 지점에서 위로 한 칸씩 올라간다.
			// 좌우 중 하나가 1인 지점에서는 1인 지점 쪽 가장 가까운 pole로 x값을 바꾼다.
			for (int y=99; y>=0; y--) {
				int left = x-1 < 0 ? 0 :data[x-1][y];
				int right = x + 1 > 99 ? 0 : data[x+1][y];
								
				if((left | right) > 0) {
					x = crossLeft( left > right ? true :false, x, pole);
				}
				
			}
			sb.append("#").append(T).append(" ").append(x).append("\n");
			
		}
		

		System.out.println(sb.toString());

	}
	
	static int crossLeft(boolean isLeft, int x, List<Integer> pole) {
		return isLeft ? pole.get(pole.indexOf(x) - 1) : pole.get(pole.indexOf(x) + 1);
	}
	
}
