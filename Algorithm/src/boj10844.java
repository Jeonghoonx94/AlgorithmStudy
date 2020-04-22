/*
 * BOJ 10844 - Easy Stairs (DP) 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        long[][] stair_num = new long[n][12];
        long ans=0;
        
        for(int i=2; i<=10; ++i)
            stair_num[0][i] = 1;
        for(int i=1; i<n; ++i)
            for(int j=1; j<=10; ++j)
                stair_num[i][j] = (stair_num[i-1][j-1] + stair_num[i-1][j+1]) % 1000000000;
        for(int i=0; i<12; ++i)
            ans = (ans + stair_num[n-1][i]) % 1000000000;
        
        System.out.println(ans);
    }
}
