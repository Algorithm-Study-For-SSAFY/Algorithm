import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1068 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		boolean[] childChk = new boolean[N];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		
		int leaf_num = 0;
		int root = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
			if(arr[i] == -1) root = i;
			else if(arr[i] != -1) {//부모노드가 -1이 아니라면
				childChk[arr[i]] = true; //자식이 있음을 표시
			}
		}
		for(int i=0; i<N; i++) {
			if(!childChk[i]) leaf_num++;
		}
		
		int target = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		q.offer(target);
		while(!q.isEmpty()) {//삭제하는 노드 밑의 자식노드들 제거
			int now = q.poll();
			if(!childChk[now]) {//false : 자식이 없다 = leaf다
				leaf_num--;
				continue;
			}
			//leaf가 아니라면
			for(int i=0; i<N; i++) {
				if(arr[i] == now) {//now를 부모로 갖는 자식들을 모두 q에 삽입
					q.offer(i);
				}
			}
		}//while
		int cnt = 0;
		for(int i=0; i<N; i++) {
			if(i!= target && arr[i] == arr[target]) {
				cnt++;
				break;
			}
		}
		//target의 부모가 leaf가 될수있음
		//자식이 하나일 때 부모가 leaf가 되는 경우
		if(target!= root && cnt==0) leaf_num++; 
		
		System.out.println(leaf_num);
		
	}
}


//조건을 잘 처리해준 것 같아요~!
