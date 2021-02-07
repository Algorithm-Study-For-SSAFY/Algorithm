import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 백준_9461_파도반수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long[] P = new long[101];
		P[1] = 1;
		P[2] = 1;
		P[3] = 1;

		for (int i = 4; i <= 100; i++) {
			P[i] = P[i - 2] + P[i - 3];
		}

		int TestCase = Integer.parseInt(br.readLine());
		for (int i = 0; i < TestCase; i++) {
			int N = Integer.parseInt(br.readLine());
			bw.write(P[N] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();

	}
}