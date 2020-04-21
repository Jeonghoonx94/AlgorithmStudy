/*
 * BOJ 2579 - Going Up Stairs (DP)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2579 {
	static int[] step_score;
	static int[] max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int steps = Integer.parseInt(br.readLine());
		step_score = new int[steps+1];
		max = new int[steps+1];
		for(int i=1; i<=steps; ++i)
			step_score[i] = Integer.parseInt(br.readLine());
		br.close();
		System.out.println(solve(steps));
	}
	static int solve(int n) {
		max[1] = step_score[1];
		if(n>1)
			max[2] = step_score[1] + step_score[2];
	
		for(int i=3; i<=n; ++i)
			max[i] = Math.max( max[i-3] + step_score[i-1], max[i-2]) + step_score[i];
		return max[n];
	}
}
