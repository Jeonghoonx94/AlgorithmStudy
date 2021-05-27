package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ7662_이중_우선순위_큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		// test count
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			PriorityQueue<int[]> ascQ = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[1] < o2[1]) {
						return -1;
					}
					return 1;
				}
			});
			PriorityQueue<int[]> descQ = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[1] < o2[1]) {
						return 1;
					}
					return -1;
				}
			});
			boolean[] visited = new boolean[1000000];

			int K = Integer.parseInt(br.readLine());
			for(int k=0; k<K; ++k) {
				st = new StringTokenizer(br.readLine());
				char op = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				
				// insert
				if (op == 'I') {
					ascQ.add(new int[] {k, num});
					descQ.add(new int[] {k, num});
					visited[k] = true;
				}
				// delete
				else {
					// delete max value
					if (num == 1) {
						while(!descQ.isEmpty() && !visited[descQ.peek()[0]]) {
							descQ.poll();
						}
						if (!descQ.isEmpty()) {
							visited[descQ.peek()[0]] = false;
							descQ.poll();
						}
					}
					// delete min value
					else {
						while(!ascQ.isEmpty() && !visited[ascQ.peek()[0]]) {
							ascQ.poll();
						}
						if (!ascQ.isEmpty()) {
							visited[ascQ.peek()[0]] = false;
							ascQ.poll();
						}
					}
				}
			}

			while(!descQ.isEmpty() && !visited[descQ.peek()[0]]) {
				descQ.poll();
			}
			while(!ascQ.isEmpty() && !visited[ascQ.peek()[0]]) {
				ascQ.poll();
			}
			
			if (ascQ.isEmpty() && descQ.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				sb.append(descQ.peek()[1] + " " + ascQ.peek()[1] + "\n");
			}

		}
		System.out.println(sb);
		br.close();
	}

}
