
public class Codility_02 {
	public static void main(String[] args) throws Exception {
		int[] A = {999, 500, 0, -1000, 76};
		int[] B = new int[A.length];
		
		System.out.print("Before: ");
		for(int i : A) 
			System.out.print(i+" ");
		System.out.println("");
		
		B = solution(A, 2);
		
		System.out.print("After : ");
		for(int i : B)
			System.out.print(i+" ");
	}

    public static int[] solution(int[] A, int K) {
    	int N = A.length;
    	int tmp;
    	if(N <= 0) {
    	}
    	else { 
	        for(int i = 0; i<K; ++i) {
	             tmp = A[N-1];
	            for(int j=N-1; j>0; --j)
	                A[j] = A[j-1];
	            A[0] = tmp;
	        }
    	}
        return A;
    }
}
