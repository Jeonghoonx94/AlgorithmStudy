import java.util.ArrayList;

public class Codility_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution(1073741825));
    }
    public static int solution(int N) {
        int max = 0;
        int count = 0;
        ArrayList<Integer> tmpList = new ArrayList<>();

        while (N > 0) {
            tmpList.add(0, N % 2);
            N /= 2;
        }
        for (int i = 0; i < tmpList.size(); ++i)
            if (tmpList.get(i) == 1) {
                if (max < count) max = count;
                count = 0;
            } else {
                ++count;
            }
        return max;
	}

}
