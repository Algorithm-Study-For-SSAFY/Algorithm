import java.io.*;

public class 백준_10830_행렬제곱 {
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        long B = Long.parseLong(str[1]);
        int[][] A = new int[N][N];

        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                A[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] res = sol(A, B);

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++)
                System.out.print(res[i][j]%1000+" ");
            System.out.println();
        }
    }

    static int[][] square(int[][] a, int[][] A) {
        int[][] temp = new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int sum = 0;
                for(int k=0; k<N; k++) {
                    sum += a[i][k]*A[k][j];
                }
                temp[i][j] = sum%1000;
            }
        }

        return temp;
    }

    static int[][] sol(int[][] a, long b) {
        if(b==1)
            return a;
        else if(b%2==0) {
            int[][] temp = sol(a, b/2);
            return square(temp, temp);
        }
        else {
            return square(sol(a, b-1), a);
        }
    }
}