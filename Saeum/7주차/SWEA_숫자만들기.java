import java.io.*;
import java.util.*;
 
public class SWEA_숫자만들기 {
 
    public static int tc, N, min, max;
    public static int[] operator, operand;
    public static int[] dx = new int[] { 0, 0, 1, -1 }; // 동서남북
    public static int[] dy = new int[] { 1, -1, 0, 0 };
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        tc = Integer.parseInt(br.readLine());
 
        for (int t = 1; t <= tc; t++) {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            N = Integer.parseInt(br.readLine());
            operator = new int[4];
            operand = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            
            for (int i = 0; i < 4; i++)
                operator[i] = Integer.parseInt(st.nextToken());
 
            st = new StringTokenizer(br.readLine());
            
            
            for (int i = 0; i < N; i++)
                operand[i] = Integer.parseInt(st.nextToken());
 
            dfs(1, operand[0]);
            System.out.println("#" + t + " " + (max - min));
        }
    }
 
    public static void dfs(int depth, int totalVal) {
 
        if (depth >= N) {
            max = Math.max(max, totalVal);
            min = Math.min(min, totalVal);
            return;
        }
 
        for (int i = 0; i < 4; i++) {
 
            if (operator[i] > 0) {
                operator[i] -= 1;
                switch (i) {
                case 0:
                    dfs(depth + 1, totalVal + operand[depth]);
                    break;
                case 1:
                    dfs(depth + 1, totalVal - operand[depth]);
                    break;
                case 2:
                    dfs(depth + 1, totalVal * operand[depth]);
                    break;
                case 3:
                    dfs(depth + 1, totalVal / operand[depth]);
                    break;
                }
                operator[i] += 1;
            }
        }
    }
}