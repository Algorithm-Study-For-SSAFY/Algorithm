import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Solution {
     
    static int N;
    static int M;
    static int landNum;
    static int answer;
    static int[][] map;
    static int[][] memo;
    static Queue<Position> queue;
    static int[] dirX = {1,0,-1,0};
    static int[] dirY = {0,-1,0,1};
     
    public static void main(String[] args) throws NumberFormatException, IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
         
        int T =Integer.parseInt(br.readLine()); 
         
        for (int testCase = 1; testCase <= T; testCase++) {
            st = new StringTokenizer(br.readLine());
             
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            landNum = 0;
            map = new int[N][M];
            memo = new int[N][M];
             
            queue = new LinkedList<Position>();
             
            for (int r = 0; r < N; r++) {
                String str = br.readLine();
                for (int c = 0; c < M; c++) {
                    map[r][c] = str.charAt(c) == 'W' ? 0 : 1;
                    if(map[r][c] == 0) {
                        queue.offer(new Position(r,c,0));                   
                    } else {
                        landNum++;
                        memo[r][c] = Integer.MAX_VALUE;
                    }
                }
            }
             
            answer = 0;
            while(landNum > 0) {
                move(queue.poll());
            }
             
            sb.append("#").append(testCase).append(" ").append(answer).append("\n");
             
        }
        System.out.println(sb);
    }
     
    static void move(Position p){
         
        for (int dir = 0; dir < 4; dir++) {
            if(p.r + dirY[dir] < 0 || p.r + dirY[dir] >= N || p.c + dirX[dir] < 0 ||p.c + dirX[dir] >= M) {
                continue;
            }
             
            if(map[p.r + dirY[dir]][p.c + dirX[dir]] == 0) {
                continue;
            }
             
            if(memo[p.r + dirY[dir]][p.c + dirX[dir]] != Integer.MAX_VALUE) {
                continue;
            }
             
            queue.add(new Position(p.r + dirY[dir], p.c + dirX[dir], p.d+1));
            memo[p.r + dirY[dir]][p.c + dirX[dir]] = p.d + 1;
            landNum--;
            answer += p.d + 1;
        }
         
    }
     
     
}
 
class Position{
    int r;
    int c;
    int d;
    public Position(int r, int c, int d) {
        super();
        this.r = r;
        this.c = c;
        this.d = d;
    }
}
