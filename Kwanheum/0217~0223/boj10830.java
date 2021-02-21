import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10830 {
	private static int[][] matrix;
	private static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		long B = Long.parseLong(stk.nextToken());
		
		matrix= new int[N][N];
		for(int i=0; i<N; i++) {
			stk = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				matrix[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		//Input end
		//matrix를 B제곱.. B는 최대 100,000,000,000 분할하는 방법 생각!
		int[][] answer = new int[N][N];
		answer = divide(B);
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				//matrix 곱에 한번도 안들어가고 input값이 그대로 나오는 경우
				//1000이하의 값이기 때문에 1000이 나올수도 있음
				//출력값은 0~999여야함
				System.out.print(answer[i][j]%1000+" ");
			}
			System.out.println();
		}
		
		
	}//main
	static int[][] divide(long cnt) {
		if(cnt==1)
			return matrix;
		int[][] tmp = divide(cnt/2);
		if(cnt%2 ==0 ) {
			return mul_mat(tmp, tmp);
		}
		else {
			return mul_mat( mul_mat(tmp, tmp)   , matrix);
		}
	}
	
	static int[][] mul_mat(int[][] arr1, int[][]arr2){
		int[][] result = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					result[i][j] += arr1[i][k] * arr2[k][j];
				}
				result[i][j] %= 1000;
			}//for j
		}//for i
		return result;
	}
	
}
