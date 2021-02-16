package week3;

import java.io.*;
import java.util.*;

public class 백준_11725_트리의부모찾기 {
    static int N;
    static int[] parent;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>>list;

    public static void main(String[] args) throws NumberFormatException, IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         StringTokenizer st;

         N = Integer.parseInt(br.readLine());
         parent = new int[N+1];
         visit = new boolean[N+1];
         list = new ArrayList<>();

         for(int i = 0; i <= N; i++) {
             list.add(new ArrayList<Integer>());
         }

         for(int i = 1; i < N; i++) {
             st = new StringTokenizer(br.readLine());

             int index1 = Integer.parseInt(st.nextToken());
             int index2 = Integer.parseInt(st.nextToken());

             list.get(index1).add(index2);
             list.get(index2).add(index1);
         }

         dfs(1);

         for(int i = 2; i < N+1; i++) {
             bw.write(parent[i] + "\n");
         }

         bw.flush();
         bw.close();
         br.close();

    }

    public static void dfs(int node) {  //이미 방문한 적 있으면 부모로 봄 

        if(!visit[node]) {
            visit[node] = true;

            for(int n : list.get(node)) { 
                if(visit[n]) parent[node] = n;
                dfs(n);
            }
        }
    }
}