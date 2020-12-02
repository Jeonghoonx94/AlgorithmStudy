package codility;
import java.util.ArrayList;

// OddOccurrencesInArray
public class Codility_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {4, 5, 6, 3, 8, 5, 6, 3, 10, 53, 53, 10, 4};
//		System.out.println(solution(A));
		System.out.println(solution2(A));

	}
	
	// time complexity: O(N^2)
    public static int solution(int[] A) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(Integer i:A) {	// 객체로 지정해줘야 인덱스 값으로 받지 않음.
    		if(list.contains(i))
    			list.remove(i);
    		else list.add(i);
        }
//        return list.get(0);
		return list.iterator().next();
    }

    // time complexity : O(N) or O(N*log(N))
    public static int solution2(int[] A) {
        int tmp = 0;
        for(int i:A) {	
        	tmp ^= i;
        }
		return tmp;
    }
}