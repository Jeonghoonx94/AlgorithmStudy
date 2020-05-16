/*
 * BOJ 1260 - DFS and BFS
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class boj1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int V = Integer.parseInt(s[2]);

        int[][] graph = new int[N+1][N+1];

        for(int i=0; i<M; ++i) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]), b = Integer.parseInt(s[1]);
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(graph, V);
        bfs(graph, V);
    }
    static void dfs(int[][] graph, int startV) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[graph.length];

        System.out.print(startV + " ");
        stack.push(startV);
        visited[startV] = true;

        while(!stack.isEmpty()) {
            int tmp = stack.peek();
            boolean flag = false;
            for(int i = 1; i < graph.length; ++i) {
                if (!visited[i] && graph[tmp][i] == 1) {
                    System.out.print(i + " ");
                    stack.push(i);
                    visited[i] = true;
                    flag = true;
                    break;
                }
            }
            if(!flag) stack.pop();
        }
        System.out.println();
    }

    static void bfs(int[][] graph, int startV) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];

        System.out.print(startV + " ");
        queue.add(startV);
        visited[startV] = true;
        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            for(int i = 1; i < graph.length; ++i) {
                if(graph[tmp][i] == 1 && !visited[i]) {
                    System.out.print(i+" ");
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }
}