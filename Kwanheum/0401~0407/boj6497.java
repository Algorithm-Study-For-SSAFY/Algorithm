package algo_study_10w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj6497 {
	private static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		while(true) {
			stk= new StringTokenizer(br.readLine());
			int m = Integer.parseInt(stk.nextToken());
			int n = Integer.parseInt(stk.nextToken());
			if(m==0 && n==0) break;
			int totalDist = 0;
			PriorityQueue<Node> pq = new PriorityQueue<>();
			for(int i=0; i<n; i++) {
				stk = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(stk.nextToken());
				int y = Integer.parseInt(stk.nextToken());
				int z = Integer.parseInt(stk.nextToken());
				pq.add(new Node(x, y, z));
				totalDist += z;
			}
			
			parents = new int[m];
			for(int i=0; i<m; i++) {
				parents[i] = i;
			}
			int nowDist = 0;
			while(!pq.isEmpty()) {
				Node min = pq.poll();
				if(union(min.x, min.y)) {
					//true = union success
					nowDist+= min.z;
				}
			}
			System.out.println(totalDist - nowDist);
			
		}
		
	}
	static class Node implements Comparable<Node> {
		int x, y, z;

		public Node(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public int compareTo(Node o) {
			return this.z - o.z;
		}
		
	}
	static int findParent(int x) {
		if(parents[x] == x) return x;
		return( parents[x] = findParent(parents[x]));
	}
	
	static boolean union(int x, int y) {
		int pX = findParent(x);
		int pY = findParent(y);
		if(pX == pY) return false;
		/*if(pX < pY) {
			parents[pY] = pX;
		}else {
			parents[pX] = pY;
		}*/
		parents[pY]= pX;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
