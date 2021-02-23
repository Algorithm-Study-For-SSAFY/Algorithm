package al_4주차;

import java.util.Scanner;

public class Main_백준_10830_행렬제곱 {
	
	  static int MOD = 1000, N;
	    static int[][] unitMatrix;

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        N = sc.nextInt(); //행렬의 크기
	        long B = sc.nextLong(); //A의B제곱

	        int[][] matrix = new int[N][N]; //행렬 만들기
	        unitMatrix = new int[N][N];

	        for (int i = 0; i < N; i++)
	            for (int j = 0; j < N; j++)
	                matrix[i][j] = sc.nextInt() % MOD;//1000으로 나누기

	        for (int i = 0; i < N; i++)
	            unitMatrix[i][i] = 1;

	        matrix = powMatrix(B, matrix); //B의Matrix제곱

	        for (int[] m : matrix) {//출력
	            for (int i : m)
	                System.out.print(i + " ");
	            System.out.println();
	        }
	    }

	    static int[][] powMatrix(long n, int[][] matrix) {
	        if (n == 0)
	            return unitMatrix; // 0이면 1반환
	        if (n == 1)
	            return matrix;

	        int[][] nMatrix = powMatrix(n / 2, matrix);
	        nMatrix = multipleMatrix(nMatrix, nMatrix);

	        return n % 2 == 0 ? nMatrix : multipleMatrix(nMatrix, matrix);
	    }

	    static int[][] multipleMatrix(int[][] m1, int[][] m2) { // A의 i열의 곱과 B의 j행의 곱을 순차적으로 더해 구함
	        int[][] matrix = new int[N][N];

	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	                for (int k = 0; k < N; k++) //A의 i열 곱 + B j행 곱 
	                    matrix[i][j] += (m1[i][k] * m2[k][j]) % MOD;
	                matrix[i][j] %= MOD;
	            }
	        }

	        return matrix;
	    }
}

/////맞긴 했지만 아직 애매......////
