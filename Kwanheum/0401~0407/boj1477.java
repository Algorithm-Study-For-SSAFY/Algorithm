package algo_study_10w;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj1477 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		int l = Integer.parseInt(stk.nextToken());
		
		ArrayList<Integer> arr = new ArrayList<>();
		stk = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr.add( Integer.parseInt(stk.nextToken()) );
		}
		// 0  82 201 411 555  622 755  800
		//  82  119 210 144  67  133  45
		
		arr.sort( (a, b) -> {return a - b; });
		//PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		ArrayList<Integer> pq = new ArrayList<>();
		pq.add(arr.get(0)); //시작점~첫번째
		pq.add(l - arr.get(n-1)); //마지막 ~ 도로끝
		for(int i=1; i<n; i++) {
			int gap = arr.get(i) - arr.get(i-1);
			pq.add(gap);
		}
		int start = 1;
		int end = l;
		int mid = 0;
		while(start <= end) {
			mid = (start+end)/2;
			int cnt = 0;
			for(int i=0; i<pq.size(); i++) {
				int now = pq.get(i);
				cnt += Math.ceil((double)now/mid)-1;
			}
			//System.out.println(start+ " "+mid+" "+end+ " " + cnt);
			if(cnt <= m) {
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		System.out.println(start);
		
			
	}
}
