import java.util.*;
 
class KnightPoint {
    int x;
    int y;
 
    public KnightPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
 
public class 백준_7562_나이트의이동 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int tc = sc.nextInt();
        for(int i=0; i<tc; i++) {
            int size = sc.nextInt();
            KnightPoint startPoint = new KnightPoint(sc.nextInt(), sc.nextInt());
            KnightPoint endPoint = new KnightPoint(sc.nextInt(), sc.nextInt());
            
            System.out.println(bfs(startPoint, endPoint, size));
        }
        
        sc.close();
    }
    public static int bfs(KnightPoint start, KnightPoint end, int size) {
        final int[] xDir = { -2, 2, -1, 1, -2, 2, -1, 1 };      // 나이트의 이동 가능 경우의 수, x좌표값들
        final int[] yDir = { -1, 1, -2, 2, 1, -1, 2, -2 };      // 나이트의 이동 가능 경우의 수, y좌표값들
        boolean[][] isVisited = new boolean[size][size];
        boolean hasGoal = false;
        
        int cnt = 0;
        
        Queue<KnightPoint> queue = new LinkedList<>();
        queue.offer(start);
        isVisited[start.x][start.y] = true;
        
        // bfs 작업
        while(!queue.isEmpty() && !hasGoal) {
            for(int i=0, qSize=queue.size(); i<qSize; i++) {
                KnightPoint current = queue.poll();
                if(current.x == end.x && current.y == end.y) {
                    // 현재 위치가 도착지점일때
                    hasGoal = true;
                    break;
                }
                
                for(int diff=0; diff<xDir.length; diff++) {
                    // 나이트 위치이동 경우의 수만큼 반복
                    int nextX = current.x + xDir[diff];
                    int nextY = current.y + yDir[diff];
                    
                    if(nextX<0 || nextX>size-1 || nextY<0 || nextY>size-1)  continue;
                    if(isVisited[nextX][nextY])   continue;
                    
                    queue.offer(new KnightPoint(nextX, nextY));
                    isVisited[nextX][nextY] = true;
                }
            }
            if(hasGoal) break;
            cnt++;
        }
        return cnt;
    }
}
 
