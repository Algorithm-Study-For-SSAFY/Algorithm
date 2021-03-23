import java.util.*;
 
public class 백준_1504_특정한최단경로 {    
    
	
	//최단거리(1 ~ V1) + 최단거리(V1 ~ V2) + 최단거리(V2 ~ N)
	//최단거리(1 ~ V2) + 최단거리(V2 ~ V1) + 최단거리(V1 ~ N)
	//중에 더 작은 경로 출력,  다익스트라 사용 각각의 최단거리 구ㅎㅐ주기
	
    static ArrayList<Node>[] list;
    static int n;
    static int max = 987374824;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        n = sc.nextInt();
        int e = sc.nextInt();
        
        list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < e; i++) {
            int f = sc.nextInt();
            int t = sc.nextInt();
            int cost = sc.nextInt();
            list[f].add(new Node(t, cost));
            list[t].add(new Node(f, cost));
        }
        
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        
        int len1 = dijkstra(1, n1) + dijkstra(n1, n2) + dijkstra(n2, n);
        int len2 = dijkstra(1, n2) + dijkstra(n2, n1) + dijkstra(n1, n);
        
        int min = 0;
        if(len1 >= max && len2 >= max) min = -1; //유효하지 않은 경로
        else min = Math.min(len1, len2);
        System.out.println(min);
    }
    
    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start, 0));
        
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dist, max);
        dist[start] = 0;
        
        while(!q.isEmpty()) {
            Node current = q.poll();
            
            if(visited[current.x] == false) visited[current.x] = true;
            else continue;
            
            for(int i = 0; i < list[current.x].size(); i++) {
                Node next = list[current.x].get(i);
                if(visited[next.x] == false && dist[next.x] > dist[current.x] + next.cost) {
                    dist[next.x] = dist[current.x] + next.cost;
                    q.offer(new Node(next.x, dist[next.x]));
                }
            }
        }
        
        return dist[end];
    }
    
    public static class Node implements Comparable<Node> {
        int x;
        int cost;
        
        public Node(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }
}
