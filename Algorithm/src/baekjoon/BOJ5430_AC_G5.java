package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ5430_AC_G5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        while (t-- > 0) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String xs = br.readLine();

            if (n > 0) {
                for (String x : xs.substring(1, xs.length() - 1).split(",")) {
                    list.add(Integer.parseInt(x));
                }
            }

            boolean er = false;
            boolean reverse = false;

            for (char op : p.toCharArray()) {
                if (op == 'R') {
                    reverse = !reverse;
                } else if (op == 'D') {
                    if (!drop(list, reverse) || n == 0) {
                        er = true;
                        break;
                    }
                }
            }

            if (er) {
                sb.append("error\n");
            } else {
                sb.append('[');
                if (!list.isEmpty()) {
                    if (reverse) {
                        for (int i = list.size() - 1; i > 0; i--) {
                            sb.append(list.get(i)).append(',');
                        }
                        sb.append(list.get(0));
                    } else {
                        for (int i = 0; i < list.size() - 1; i++) {
                            sb.append(list.get(i)).append(',');
                        }
                        sb.append(list.get(list.size() - 1));
                    }
                    sb.append("]\n");
                } else {
                    sb.append("]\n");
                }
            }

            list.clear();
        }

        System.out.println(sb);
    }

    private static boolean drop(List<Integer> list, boolean reverse) {
        if (list.isEmpty()) {
            return false;
        }

        if (reverse) {
            list.remove(list.size() - 1);
        } else {
            list.remove(0);
        }

        return true;
    }
}
