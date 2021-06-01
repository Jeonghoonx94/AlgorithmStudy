package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16637_괄호_추가하기 {
    static int N, Ans = Integer.MIN_VALUE;
    static int[] nums;
    static char[] opers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        nums = new int[N / 2 + 1];
        opers = new char[N / 2];

        char[] chars = br.readLine().toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            if (i % 2 == 0) { // num
                nums[i / 2] = chars[i] - '0';
            } else { // oper
                opers[i / 2] = chars[i];
            }
        }

        solve(nums[0], 0);

        System.out.println(Ans);
        br.close();
    }

    static void solve(int sum, int opIdx) {
        if (opIdx >= opers.length) {
            if (Ans < sum) {
                Ans = sum;
            }
            return;
        }
        // calculate now
        solve(calc(sum, nums[opIdx + 1], opers[opIdx]), opIdx + 1);
        // calculate next
        if (opIdx + 1 < opers.length) {
            solve(calc(sum, calc(nums[opIdx + 1], nums[opIdx + 2], opers[opIdx + 1]), opers[opIdx] ), opIdx + 2);
        }
    }

    private static int calc(int sum, int num, char oper) {
        if (oper == '+') {
            return sum + num;
        }
        if (oper == '-') {
            return sum - num;
        }
        return sum * num;
    }
}
