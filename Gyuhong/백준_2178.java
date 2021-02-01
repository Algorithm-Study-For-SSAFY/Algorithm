import java.util.*;

public class Main {


static boolean[][] map;
static boolean[][] visited;

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
	
		int N = sc.nextInt();
		int M = sc.nextInt();
	
		map = new boolean[N][M];
		visited = new boolean[N][M];
	
		for (int y = 0; y < N; y++) {
			String s = sc.next();
			for (int x = 0; x < M; x++) {
				map[y][x] = s.charAt(x) - '0' == 1 ? true : false;
			}
		}
	
		Queue<Position> q = new LinkedList<Position>();
	
		q.add(new Position(0, 0, 1));
	
		while (true) {
	
			Position p = q.poll();
			if (p.y == N - 1 && p.x == M - 1) {
				System.out.println(p.distance);
				break;
			}
	
			travel(q, p, N, M);
		}
	
		sc.close();
	}

	public static void travel(Queue<Position> q, Position p, int N, int M) {
	
		
		if (p.y + 1 < N) {
			if (!visited[p.y + 1][p.x] && map[p.y+1][p.x]) {
				q.add(new Position(p.y + 1, p.x, p.distance + 1));
				visited[p.y+1][p.x] = true;
			}
				
		}
	
		if (p.y - 1 >= 0) {
			if (!visited[p.y - 1][p.x] && map[p.y-1][p.x]) {
				q.add(new Position(p.y - 1, p.x, p.distance + 1));
				visited[p.y-1][p.x] = true;
			}			
		}
	
		if (p.x + 1 < M) {
			if (!visited[p.y][p.x + 1] && map[p.y][p.x+1]) {
				q.add(new Position(p.y, p.x + 1, p.distance + 1));
				visited[p.y][p.x+1] = true;
			}	
		}
	
		if (p.x - 1 >= 0) {
			if (!visited[p.y][p.x - 1] && map[p.y][p.x-1]) {
				q.add(new Position(p.y, p.x - 1, p.distance + 1));
				visited[p.y][p.x-1] = true;
			}
				
		}
	
	}



}

class Position {
int y;
int x;
int distance;

	public Position(int y, int x, int distance) {
		super();
		this.y = y;
		this.x = x;
		this.distance = distance;
	}

}