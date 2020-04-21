/*
 * BOJ 1463 - Make it 1 (DP)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1463 {
	static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        arr = new int[n+1];
        System.out.println(make_1(n));
    }
    static int make_1(int n) {
    	for(int i=2; i<=n; ++i) {
			if( i%6 == 0)
				arr[i] = Math.min( Math.min(arr[i/2], arr[i/3]), arr[i-1] ) + 1;
			else if( i%3 == 0)
                arr[i] = Math.min(arr[i/3], arr[i-1]) + 1;
            else if(i%2 == 0)
            	arr[i] = Math.min(arr[i/2], arr[i-1]) + 1;
            else if(i%2 == 1)
                arr[i] = arr[i-1] + 1;
        }
        return arr[n];
    }
}