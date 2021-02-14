import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
 
public class 백준_1929_소수구하기 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Boolean> primeList;
 
        primeList = new ArrayList<Boolean>(N + 1);
 
        // 0과 1은 소수도, 합성수도 아님.
        primeList.add(false);
        primeList.add(false);
 
        // 2이상의 수는 전부 소수라고 가정.
        for (int i = 2; i <= N; i++) {
            primeList.add(i, true);
        }
 
        for (int i = 2; (i * i) <= N; i++) {
            if (primeList.get(i)) { // i가 소수일 경우, i를 제외한 i의 배수를 모두 합성수로 초기화.
                for (int j = i * i; j <= N; j += i)
                    primeList.set(j, false);
            }
        }
 
        // 소수인 것만 출력.
        for (int i = M; i <= N; i++) {
            if (primeList.get(i)) {
                bw.write(i + "\n");
            }
        }
 
        bw.flush();
        br.close();
        bw.close();
    }
 
}
