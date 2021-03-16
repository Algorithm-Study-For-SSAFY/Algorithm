import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Solution {
     
    static int map[][];
    static boolean visited[][]; 
    static int[] dirX = {1, -1, 0, 0};
    static int[] dirY = {0, 0, 1, -1};
    static boolean flag;
     
    public static void main(String[] args) throws NumberFormatException, IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        for (int testCase = 1; testCase <= 10; testCase++) {
            br.readLine();
             
            map = new int[100][100];
            visited = new boolean[100][100];
             
            int startR = 0, startC = 0;
            int endR = 0, endC = 0;
            flag = false;
             
            for (int r = 0; r < 100; r++) {
                String temp = br.readLine();
                for (int c = 0; c < 100; c++) {
                    map[r][c] = temp.charAt(c) - '0';
                    if(map[r][c] == 2){
                        startR = r; startC = c;
                    } else if(map[r][c] == 3) {
                        endR = r; endC = c;
                    }
                }
            }
             
            DFS(startR, startC, endR, endC);
             
            sb.append("#").append(testCase).append(" ").append(flag?1:0).append("\n");
 
        }
 
        System.out.println(sb);
    }
     
    static void DFS(int startR, int startC, int endR, int endC){
         
        visited[startR][startC] = true;
         
        if(startR == endR && startC == endC) {
            flag=true;
        }
         
        if(flag) return;
         
        for (int dir = 0; dir < 4; dir++) {
            try {
                if(!visited[startR + dirY[dir]][startC + dirX[dir]] && map[startR + dirY[dir]][startC + dirX[dir]] != 1) {
                    DFS(startR + dirY[dir], startC + dirX[dir], endR, endC);
                }               
            } catch (Exception e) {
                // TODO: handle exception
            }
             
        }
         
    }
     
     
     
     
}
