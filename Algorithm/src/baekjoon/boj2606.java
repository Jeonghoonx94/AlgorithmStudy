package baekjoon;
/*
 * BOJ 2606 - Virus
 * DFS
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 컴퓨터의 수 ( 100이하)
        int nV = Integer.parseInt(br.readLine());
        // 연결되어 있는 컴퓨터 쌍의 수
        int nE = Integer.parseInt(br.readLine());
        int[][] graph = new int[nV+1][nV+1];

        for(int i=0; i<nE; ++i) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]);
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(graph, 1);
    }
    static void dfs(int[][] graph, int startV) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.length];
        int count = 0;

        stack.push(startV);
        visited[startV] = true;

        while(!stack.isEmpty()) {
            int tmp = stack.peek();
            boolean flag = false;
            for(int i = 1; i < graph.length; ++i) {
                if (!visited[i] && graph[tmp][i] == 1) {
                    stack.push(i);
                    ++count;
                    visited[i] = true;
                    flag = true;
                    break;
                }
            }
            if(!flag) stack.pop();
        }
        System.out.println(count);
    }
}
