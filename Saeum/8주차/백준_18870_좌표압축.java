import java.io.*;
import java.util.*;

public class 백준_18870_좌표압축 { // hashmap 사용하기

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		int arr[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int sortarr[] = arr.clone(); //복사 
		Arrays.sort(sortarr); // -10,-9,4,4,2

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int index = 0;
		for (int nums : sortarr) // arr값들을 nums에 넣고
			if (!map.containsKey(nums)) {
				map.put(nums, index++);
			}

		for (int nums : arr)
			sb.append(map.get(nums)).append(" "); //기존배열의 좌표값 얻어오기 
		System.out.println(sb.toString());
	}
}