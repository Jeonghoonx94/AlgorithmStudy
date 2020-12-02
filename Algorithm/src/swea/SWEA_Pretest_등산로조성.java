package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_Pretest_등산로조성 {
	static int N, K, map[][], Ans, maxV, maxVcnt, di[] = { -1, 1, 0, 0 }, dj[] = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			maxV = Integer.MIN_VALUE;
			maxVcnt = 0;
			Ans = 0;
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (maxV < map[i][j]) {
						maxV = map[i][j];
						maxVcnt = 1;
					} else if (maxV == map[i][j]) {
						++maxVcnt;
					}
				}
			}

			solve();

			sb.append("#").append(t).append(" ").append(Ans).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void solve() {
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (map[i][j] == maxV) {
					visited = new boolean[N][N];
					
					visited[i][j] = true;
					dfs(i, j, maxV, 1, false);
					visited[i][j] = false;
					
					if (maxVcnt == 1) {
						return;
					}
				}
			}
		}
	}

	private static void dfs(int ci, int cj, int cv, int clen, boolean cracked) {
		if (Ans < clen) {
			Ans = clen;
		}
		// 현재 위치에서 처리
		for (int d = 0; d < 4; ++d) {
			int ni = ci + di[d];
			int nj = cj + dj[d];

			if (ni < 0 || ni >= N || nj < 0 || nj >= N || visited[ni][nj]) {
				continue;
			}
			if (cv > map[ni][nj]) {
				visited[ni][nj] = true;
				dfs(ni, nj, map[ni][nj], clen + 1, cracked);
				visited[ni][nj] = false;
			} else if (cv > map[ni][nj] - K && !cracked) {
				visited[ni][nj] = true;
				dfs(ni, nj, cv - 1, clen + 1, true);
				visited[ni][nj] = false;
			}
		}
	}
}
