
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * B를 double 형으로 안받아서 numberformat exception? 발생,
 * 시간초과 --> dp 메모이제이션 필요.
 *
 */
public class Main_10830 {
	private static int N;
	private static long B;
	private static int A[][]; //2<=N<=5
	private static int result[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		B=Long.parseLong(st.nextToken());
		A=new int[N][N];
		result=new int[N][N];
		for(int i=0; i<N; i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				A[i][j]=Integer.parseInt(st.nextToken());
			}
		}//end of input

		A=matrix(B);
		//결과는 1000을 나눈 것으로,
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(A[i][j]%1000+" ");
			}
			System.out.println();
		}
	}
	
	private static int[][] matrix(long n){
		if(n==1) {
			return A;
		}
		int [][]tmp=matrix(n/2);
		if(n%2==0) return calculate(tmp,tmp);
		else return(calculate(calculate(tmp,tmp),A));
	}
	
//	private static double[][] recur(double b2) {
//		if(b2==1) //1이면,
//			return result=A;
//		
//		return result=calculate(recur(Math.round(b2/2)),recur(b2-Math.round(b2/2)));
//	}
//	
	//행렬 곱하기 연산 함수, 한번 할때 N세제곱, N=5이면 125번의 연산이 필요하다.
	private static int[][] calculate(int[][]arr1, int[][]arr2) {
		//1행 -> 1열, 2열,,,,N열
		//2행->1열, 2열, ,,, N열
		int [][]tmp=new int[arr1.length][arr1[0].length];
		for(int i=0; i<N; i++) 
			for(int j=0; j<N; j++) 
				for(int k=0; k<N; k++) { 
					tmp[i][j]+=arr1[i][k]*arr2[k][j];
					tmp[i][j]%=1000;
				}
		return tmp;
		
	}

}
