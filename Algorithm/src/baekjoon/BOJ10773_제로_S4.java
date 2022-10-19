package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ10773_제로_S4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        while (K-- > 0) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                list.remove(list.size() - 1);
            } else {
                list.add(n);
            }
        }

        int sum = 0;
        for (int i : list) {
            sum += i;
        }

        System.out.println(sum);
    }
}
