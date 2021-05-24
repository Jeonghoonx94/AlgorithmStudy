package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12886_돌그룹 {
	static int A, B, C, D;
	// 반복 처리 제거용
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = A + B + C;	// 합 고정값

		visited = new boolean[1501][1501];

		if (D % 3 != 0) {
			System.out.println(0);
		} else {
			find();
		}

		br.close();
	}

	private static void find() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { A, B });
		visited[A][B] = true;

		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			q.poll();
			int z = D - x - y;
			if (x == y && y == z) {
				System.out.println(1);
				return;
			}

			int next[][] = { { x, y }, { x, z }, { y, z } };
			for (int i = 0; i < next.length; ++i) {
				int nx = next[i][0];
				int ny = next[i][1];

				if (nx < ny) {
					ny -= nx;
					nx += nx;
				} else if (nx > ny) {
					nx -= ny;
					ny += ny;
				} else
					continue;

				int nz = D - nx - ny;

				int X = Math.min(nx, Math.min(ny, nz));
				int Y = Math.max(nx, Math.max(ny, nz));
				if (!visited[X][Y]) {
					visited[X][Y] = true;
					q.add(new int[] { X, Y });
				}
			}
		}

		System.out.println(0);
	}

}
