/*
 * BOJ 2156 - Wine Tasting (DP)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2156 {
    static int[] wine;
    static int[] max;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        wine = new int[n+1];
        max = new int[n+1];
        
        for(int i=1; i<=n; ++i)
            wine[i] = Integer.parseInt(br.readLine());
        br.close();
        System.out.println(solve(n));
    }
    static int solve(int n) {
        max[1] = wine[1];
        
        if(n>1)
            max[2] = wine[1] + wine[2];
        
        for(int i=3; i<=n; ++i) {
            max[i] = Math.max( max[i-3] + wine[i-1] + wine[i], max[i-2] + wine[i] );
            max[i] = Math.max(max[i], max[i-1]);
        }
        
        return max[n];
    }
}