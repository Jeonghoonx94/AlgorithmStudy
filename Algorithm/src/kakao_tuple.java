/*
 * 2019 kakao winter internship
 * 01 : tuple
 */
import java.util.HashSet;
import java.util.Iterator;

public class kakao_tuple {
	public static void main(String[] args) {
		String s = 
				"{{2},{2,1},{2,1,3},{2,1,3,4}}";
//				"{{1,2,3},{2,1},{1,2,4,3},{2}";
//				"{{20,111},{111}}";
//				"{{123}}";
//				"{{4,2,3},{3},{2,3,4,1},{2,3}}";
		for(int e : solution(s))
		System.out.print(e+" ");
		// result = 2, 1, 3, 4
		// result = 2, 1, 3, 4
		// result = 111, 20
		// result = 123
		// result = 3, 2, 4, 1
	}
    public static int[] solution(String s) {
        int[] answer = {};
        
        String[] tmp = s.split("\\}");
        int[][] arr = new int[tmp.length][];
        int max = 0;
        // 문자열을 2차원 int 배열로
        for(int i = 0; i < tmp.length; ++i) {
        	// { 다음의 숫자부터 ','로 나누기
        	String[] tmp2 = tmp[i].substring(tmp[i].lastIndexOf("{") + 1).split("\\,");
        	arr[i] = new int[tmp2.length];
        	max = Math.max(max, arr[i].length);
        	for(int j=0; j<tmp2.length; ++j)
        		arr[i][j] = Integer.parseInt(tmp2[j]);
//        	for(int k: arr[i])
//        		System.out.print(k+" ");
//        	System.out.println();
        }
        answer = new int[max];
        for(int i = 0; i<max; ++i) {
        	HashSet<Integer> hs1 = new HashSet<Integer>();
        	HashSet<Integer> hs2 = new HashSet<Integer>();
        	int t = 0;
        	for(int j=0; j<i+1; ++j)
        		hs1.add(answer[j]);
        	for(int j = 0; j<max; ++j) {
        		if(arr[j].length == i+1) {
        			t = j;
        		}
        	}
        	for(int j = 0; j<arr[t].length; ++j) {
        		hs2.add(arr[t][j]);
        	}
    		hs2.removeAll(hs1);
    		Iterator<Integer> it = hs2.iterator();
			answer[i] = it.next();
        }
        return answer;
    }
}
