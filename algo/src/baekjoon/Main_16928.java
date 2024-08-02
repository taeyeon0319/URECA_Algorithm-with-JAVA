package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16928 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사다리의 수
        int M = Integer.parseInt(st.nextToken()); // 뱀의 수

        List<Integer>[] graph = new ArrayList[101];
        for (int i = 0; i < 101; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
        }

        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
        }

        boolean[] visited = new boolean[101];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;

        int[] result = new int[101];
        Arrays.fill(result, -1);
        result[1] = 0;

        while (!q.isEmpty()) {
            int n = q.poll();
            for (int i = 1; i <= 6; i++) {
                int newn = n + i;
                if (newn <= 100 && !visited[newn]) {
                    if (!graph[newn].isEmpty()) {
                        newn = graph[newn].get(0);
                    }
                    if (!visited[newn]) {
                        q.offer(newn);
                        result[newn] = result[n] + 1;
                        visited[newn] = true;
                    }
                }
            }
        }
        System.out.println(result[100]);
    }
}
